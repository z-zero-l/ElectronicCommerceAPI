package com.shopping.shoppingApi.service.impl;

import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.row.Db;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.enums.OrderItemCloseTypeEnum;
import com.shopping.shoppingApi.common.enums.OrderStatusEnum;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.*;
import com.shopping.shoppingApi.mapper.*;
import com.shopping.shoppingApi.query.OrderQuery;
import com.shopping.shoppingApi.service.OrderService;
import com.shopping.shoppingApi.vo.OrderItemVO;
import com.shopping.shoppingApi.vo.OrderListVO;
import com.shopping.shoppingApi.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static com.shopping.shoppingApi.entity.table.AddressTableDef.ADDRESS;
import static com.shopping.shoppingApi.entity.table.CartTableDef.CART;
import static com.shopping.shoppingApi.entity.table.OrderItemTableDef.ORDER_ITEM;
import static com.shopping.shoppingApi.entity.table.OrderTableDef.ORDER;
import static com.shopping.shoppingApi.entity.table.ProductSpecTableDef.PRODUCT_SPEC;

/**
 * 订单 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSpecMapper productSpecMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private AddressMapper addressMapper;
    private ScheduledFuture<?> cancelTask;

    /**
     * 获取用户订单列表
     *
     * @param userId 用户ID
     * @return 订单列表
     */
    @Override
    public List<OrderListVO> getOrderList(Integer userId, Integer status) {
        ArrayList<OrderListVO> orderListVOS = new ArrayList<>();
        if (status != null && !ArrayUtil.contains(new Integer[]{0, 1, 2, 3, 4, 5}, status)) {
            throw new ServerException("订单状态不合法");
        }
        list(QueryChain.create().where(ORDER.USER_ID.eq(userId)).orderBy(ORDER.CREATE_TIME.desc()))
                .forEach(order -> {
                    QueryWrapper queryWrapper = QueryChain.create().where(ORDER_ITEM.ORDER_ID.eq(order.getId()));
                    if (status != null) {
                        queryWrapper.and(ORDER_ITEM.STATUS.eq(status));
                    }
                    orderItemMapper.selectListByQuery(queryWrapper.orderBy(ORDER_ITEM.CREATE_TIME.desc()))
                            .forEach(orderItem -> {
                                Business business = businessMapper.selectOneById(productMapper.selectOneById(orderItem.getProductId()).getBusinessId());
                                orderListVOS.add(OrderListVO.create()
                                        .setId(orderItem.getId())
                                        .setOrderId(orderItem.getOrderId())
                                        .setProductId(orderItem.getProductId())
                                        .setProductName(orderItem.getProductName())
                                        .setBusinessId(business.getId())
                                        .setBusinessName(business.getBusinessName())
                                        .setSpecName(orderItem.getSpecName())
                                        .setSpecImage(orderItem.getProductImage())
                                        .setAmount(orderItem.getAmount())
                                        .setPrice(orderItem.getPrice())
                                        .setStatus(orderItem.getStatus()));
                            });
                });
        return orderListVOS;
    }

    /**
     * 获取订单详情
     *
     * @param userId  用户id
     * @param orderId 订单号
     * @return 订单详情
     */
    @Override
    public OrderVO getOrderDetail(Integer userId, String orderId) {
        if (orderId.isEmpty()) {
            throw new ServerException("订单号不能为空");
        }
        QueryWrapper queryWrapper = QueryChain.create().where(ORDER.ORDER_ID.eq(orderId)).and(ORDER.USER_ID.eq(userId));
        if (!exists(queryWrapper)) {
            throw new ServerException("订单不存在");
        }
        Order order = getOne(queryWrapper);
        OrderVO orderVO = OrderVO.create()
                .setPayLatestTime(order.getCreateTime().plusMinutes(15))
                .setPayment(order.getPayment())
                .setReceiver(order.getConsignee())
                .setContact(order.getPhone())
                .setProvinceCode(order.getProvinceCode())
                .setCityCode(order.getCityCode())
                .setDistrictCode(order.getDistrictCode())
                .setAddress(order.getAddress());
        ArrayList<OrderItemVO> orderItemVOS = new ArrayList<>();
        orderItemMapper.selectListByQuery(QueryChain.create().where(ORDER_ITEM.ORDER_ID.eq(order.getId())))
                .forEach(orderItem -> {
                    orderItemVOS.add(OrderItemVO.create()
                            .setProductName(orderItem.getProductName())
                            .setSpecName(orderItem.getSpecName())
                            .setSpecImage(orderItem.getProductImage())
                            .setAmount(orderItem.getAmount())
                            .setPrice(orderItem.getPrice())
                            .setFreight(orderItem.getFreight())
                            .setRemark(orderItem.getRemark()));
                });
        orderVO.setOrderItemVOList(orderItemVOS);
        return orderVO;
    }

    @Async
    public void scheduleOrderCancel(Order order) {
        cancelTask = executorService.schedule(() -> {
            orderItemMapper.selectListByQuery(QueryChain.create().where(ORDER_ITEM.ORDER_ID.eq(order.getId())))
                    .forEach(orderItem -> {
                        if (Objects.equals(orderItem.getStatus(), OrderStatusEnum.WAITING_FOR_PAYMENT.getValue())) {
                            orderItem.setStatus(OrderStatusEnum.CANCELLED.getValue());
                            orderItem.setCloseType(OrderItemCloseTypeEnum.TIMEOUT_UNPAID.getValue());
                            orderItemMapper.update(orderItem);
                        }
                    });
        }, 15, TimeUnit.MINUTES);
    }

    public void cancelScheduledTask() {
        if (cancelTask != null && !cancelTask.isDone()) {
            cancelTask.cancel(true);
        }
    }

    /**
     * 提交订单
     *
     * @param userId         用户id
     * @param addressId      地址id
     * @param orderQueryList 订单信息
     * @return 订单id
     */
    @Override
    public String submitOrder(Integer userId, Integer addressId, List<OrderQuery> orderQueryList) {
        List<Cart> cartList = cartMapper.selectListByQuery(QueryChain.create().where(CART.USER_ID.eq(userId)).and(CART.SELECTED.eq(1)));
        if (cartList.isEmpty()) {
            throw new ServerException("请先选择商品");
        }
        Address address = addressMapper.selectOneByQuery(QueryChain.create().where(ADDRESS.ID.eq(addressId)).and(ADDRESS.USER_ID.eq(userId)));
        if (address == null) {
            throw new ServerException("地址不存在");
        }
        Map<Integer, String> orderRemarkMap = CollStreamUtil.toMap(orderQueryList, OrderQuery::getCartId, OrderQuery::getRemark);
        BigDecimal payment = new BigDecimal(0);
        Order order = Order.create()
                .setUserId(userId)
                .setOrderId(IdUtil.simpleUUID())
                .setConsignee(address.getReceiver())
                .setPhone(address.getContact())
                .setProvinceCode(address.getProvinceCode())
                .setCityCode(address.getCityCode())
                .setDistrictCode(address.getDistrictCode())
                .setAddress(address.getAddress())
                .setPayment(payment);
        if (!order.save()) {
            throw new ServerException("订单提交失败");
        }
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for (Cart cart : cartList) {
            Product product = productMapper.selectOneById(cart.getProductId());
            ProductSpec productSpec = productSpecMapper.selectOneById(cart.getSpecId());
            BigDecimal price = BigDecimal.valueOf(productSpec.getSellPrice()).multiply(BigDecimal.valueOf(cart.getQuantity()));
            orderItems.add(OrderItem.create()
                    .setOrderId(order.getId())
                    .setProductId(product.getProductId())
                    .setAmount(cart.getQuantity())
                    .setProductName(product.getProductName())
                    .setSpecName(productSpec.getSpecName())
                    .setProductImage(productSpec.getSpecImg())
                    .setFreight(product.getFreight())
                    .setPrice(price)
                    .setRemark(orderRemarkMap.get(cart.getCartId()))
                    .setStatus(OrderStatusEnum.WAITING_FOR_PAYMENT.getValue()));
            productSpec.setStock(productSpec.getStock() - cart.getQuantity());
            productSpecMapper.update(productSpec);
            payment = payment.add(price).add(BigDecimal.valueOf(product.getFreight()));
        }
        order.setPayment(payment);
        Db.tx(() -> {
            updateById(order);
            cartMapper.deleteBatchByIds(CollStreamUtil.toList(cartList, Cart::getCartId));
            orderItemMapper.insertBatch(orderItems);
            scheduleOrderCancel(order);
            return true;
        });
        return order.getOrderId();
    }

    /**
     * 模拟支付
     *
     * @param userId      用户id
     * @param orderId     订单id
     * @param orderItemId 订单项id
     */
    @Override
    public Void pay(Integer userId, String orderId, Integer orderItemId) {
        List<OrderItem> orderItems = new ArrayList<>();
        if (orderId != null && orderItemId == null) {
            QueryWrapper queryWrapper = QueryChain.create().where(ORDER.ORDER_ID.eq(orderId)).where(ORDER.USER_ID.eq(userId));
            if (!exists(queryWrapper)) {
                throw new ServerException("订单不存在");
            }
            orderItems = orderItemMapper.selectListByQuery(QueryChain.create().where(ORDER_ITEM.ORDER_ID.eq(getOne(queryWrapper).getId())));
        }
        if (orderId == null && orderItemId != null) {
            OrderItem orderItem = orderItemMapper.selectOneById(orderItemId);
            if (!exists(QueryChain.create().where(ORDER.ID.eq(orderItem.getOrderId())).where(ORDER.USER_ID.eq(userId)))) {
                throw new ServerException("订单不存在");
            }
            orderItems.add(orderItem);
        }
        if (orderId == null && orderItemId == null) {
            throw new ServerException("订单不存在");
        }
        orderItems.forEach(orderItem -> {
            if (Objects.equals(orderItem.getStatus(), OrderStatusEnum.WAITING_FOR_PAYMENT.getValue())) {
                orderItem.setStatus(OrderStatusEnum.WAITING_FOR_SHIPMENT.getValue());
                orderItem.setPayTime(LocalDateTime.now());
            }
        });
        List<OrderItem> finalOrderItems = orderItems;
        Db.tx(() -> {
            finalOrderItems.forEach(orderItem -> orderItemMapper.update(orderItem));
            return true;
        });
        return null;
    }

    /**
     * 取消订单
     *
     * @param userId       用户id
     * @param orderId      订单id
     * @param orderItemId  订单项id
     * @param cancelReason 取消原因
     */
    @Override
    public Void cancel(Integer userId, String orderId, Integer orderItemId, String cancelReason) {
        List<OrderItem> orderItems = new ArrayList<>();
        if (orderId != null && orderItemId == null) {
            QueryWrapper queryWrapper = QueryChain.create().where(ORDER.ORDER_ID.eq(orderId)).where(ORDER.USER_ID.eq(userId));
            if (!exists(queryWrapper)) {
                throw new ServerException("订单不存在");
            }
            orderItems = orderItemMapper.selectListByQuery(QueryChain.create().where(ORDER_ITEM.ORDER_ID.eq(getOne(queryWrapper).getId())));
        }
        if (orderId == null && orderItemId != null) {
            OrderItem orderItem = orderItemMapper.selectOneById(orderItemId);
            if (!exists(QueryChain.create().where(ORDER.ID.eq(orderItem.getOrderId())).where(ORDER.USER_ID.eq(userId)))) {
                throw new ServerException("订单不存在");
            }
            orderItems.add(orderItem);
        }
        if (orderId == null && orderItemId == null) {
            throw new ServerException("订单不存在");
        }
        orderItems.forEach(orderItem -> {
            ProductSpec productSpec = productSpecMapper.selectOneByQuery(QueryChain.create().where(PRODUCT_SPEC.PRODUCT_ID.eq(orderItem.getProductId())).where(PRODUCT_SPEC.SPEC_NAME.eq(orderItem.getSpecName())));
            productSpec.setStock(productSpec.getStock() + orderItem.getAmount());
            productSpecMapper.update(productSpec);
            if (Objects.equals(orderItem.getStatus(), OrderStatusEnum.WAITING_FOR_PAYMENT.getValue())) {
                orderItem.setStatus(OrderStatusEnum.CANCELLED.getValue());
                orderItem.setCancelReason(cancelReason);
                orderItem.setCancelTime(LocalDateTime.now());
                orderItem.setCloseType(OrderItemCloseTypeEnum.BUYER_CANCEL.getValue());
            } else {
                throw new ServerException("订单状态不合法");
            }
        });
        List<OrderItem> finalOrderItems = orderItems;
        Db.tx(() -> {
            finalOrderItems.forEach(orderItem -> orderItemMapper.update(orderItem));
            return true;
        });
        return null;
    }


}
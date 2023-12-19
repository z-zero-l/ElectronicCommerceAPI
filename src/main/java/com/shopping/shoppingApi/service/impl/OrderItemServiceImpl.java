package com.shopping.shoppingApi.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.enums.OrderStatusEnum;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.entity.Order;
import com.shopping.shoppingApi.entity.OrderItem;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.mapper.BusinessMapper;
import com.shopping.shoppingApi.mapper.OrderItemMapper;
import com.shopping.shoppingApi.mapper.OrderMapper;
import com.shopping.shoppingApi.mapper.ProductMapper;
import com.shopping.shoppingApi.service.OrderItemService;
import com.shopping.shoppingApi.vo.OrderItemDetailVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.mybatisflex.core.row.Db.deleteById;
import static com.shopping.shoppingApi.entity.table.OrderItemTableDef.ORDER_ITEM;
import static com.shopping.shoppingApi.entity.table.OrderTableDef.ORDER;

/**
 * 订单详情 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
    private OrderMapper orderMapper;
    private ProductMapper productMapper;
    private BusinessMapper businessMapper;

    /**
     * 获取订单项详情
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     * @return 订单详情
     */
    @Override
    public OrderItemDetailVO getOrderItemDetail(Integer userId, Integer orderItemId) {
        OrderItem orderItem = getById(orderItemId);
        if (!QueryChain.of(orderMapper).where(ORDER.ID.eq(orderItem.getOrderId())).and(ORDER.USER_ID.eq(userId)).exists()) {
            throw new ServerException("订单不存在");
        }
        Order order = orderMapper.selectOneById(orderItem.getOrderId());
        OrderItemDetailVO orderItemDetailVO = OrderItemDetailVO.create()
                .setId(orderItemId)
                .setOrderId(order.getOrderId());
        Product product = productMapper.selectOneById(orderItem.getProductId());
        if (product == null) {
            orderItemDetailVO.setProductId(null);
        } else {
            Business business = businessMapper.selectOneById(product.getBusinessId());
            if (business == null) {
                orderItemDetailVO.setBusinessId(null);
                orderItemDetailVO.setBusinessName("店铺已关闭");
            } else {
                orderItemDetailVO.setBusinessId(business.getId())
                        .setBusinessName(business.getBusinessName());
            }
        }
        orderItemDetailVO.setProductName(orderItem.getProductName())
                .setSpecName(orderItem.getSpecName())
                .setSpecImage(orderItem.getProductImage())
                .setAmount(orderItem.getAmount())
                .setPrice(orderItem.getPrice())
                .setFreight(orderItem.getFreight())
                .setRemark(orderItem.getRemark())
                .setConsignee(order.getConsignee())
                .setPhone(order.getPhone())
                .setProvinceCode(order.getProvinceCode())
                .setCityCode(order.getCityCode())
                .setDistrictCode(order.getDistrictCode())
                .setAddress(order.getAddress())
                .setCancelReason(orderItem.getCancelReason())
                .setStatus(orderItem.getStatus())
                .setCreateTime(orderItem.getCreateTime())
                .setPayTime(orderItem.getPayTime())
                .setSendTime(orderItem.getSendTime())
                .setReceiptTime(orderItem.getReceiptTime())
                .setFinishTime(orderItem.getFinishTime());

        orderItemDetailVO.setPayLatestTime(orderItem.getCreateTime().plusMinutes(15));

        if (orderItemDetailVO.getPayLatestTime().isAfter(LocalDateTime.now())) {
            Duration duration = LocalDateTimeUtil.between(LocalDateTime.now(), orderItemDetailVO.getPayLatestTime());
            orderItemDetailVO.setCountdown(Math.toIntExact(duration.toSeconds()));
        }
        return orderItemDetailVO;
    }

    /**
     * 模拟发货
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     */
    @Override
    public Void simulateDelivery(Integer userId, Integer orderItemId) {
        OrderItem orderItem = getById(orderItemId);
        if (!QueryChain.of(orderMapper).where(ORDER.ID.eq(orderItem.getOrderId())).and(ORDER.USER_ID.eq(userId)).exists()) {
            throw new ServerException("订单不存在");
        }
        if (!orderItem.getStatus().equals(OrderStatusEnum.WAITING_FOR_SHIPMENT.getValue())) {
            throw new ServerException("订单状态不正确");
        }else {
            orderItem.setStatus(OrderStatusEnum.WAITING_FOR_DELIVERY.getValue());
            orderItem.setSendTime(LocalDateTime.now());
            updateById(orderItem);
        }
        return null;
    }

    /**
     * 确认收货
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     */
    @Override
    public Void confirmReceipt(Integer userId, Integer orderItemId) {
        OrderItem orderItem = getById(orderItemId);
        if (!QueryChain.of(orderMapper).where(ORDER.ID.eq(orderItem.getOrderId())).and(ORDER.USER_ID.eq(userId)).exists()) {
            throw new ServerException("订单不存在");
        }
        if (!orderItem.getStatus().equals(OrderStatusEnum.WAITING_FOR_DELIVERY.getValue())) {
            throw new ServerException("订单状态不正确");
        }else {
            orderItem.setStatus(OrderStatusEnum.WAITING_FOR_REVIEW.getValue());
            orderItem.setReceiptTime(LocalDateTime.now());
            updateById(orderItem);
        }
        return null;
    }

    /**
     * 删除订单
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     */
    @Override
    public Void deleteOrder(Integer userId, Integer orderItemId) {
        OrderItem orderItem = getById(orderItemId);
        if (!QueryChain.of(orderMapper).where(ORDER.ID.eq(orderItem.getOrderId())).and(ORDER.USER_ID.eq(userId)).exists()) {
            throw new ServerException("订单不存在");
        }
        if (!orderItem.getStatus().equals(OrderStatusEnum.COMPLETED.getValue())||!orderItem.getStatus().equals(OrderStatusEnum.CANCELLED.getValue())) {
            throw new ServerException("订单状态不正确");
        }else {
            removeById(orderItem);
        }
        return null;
    }
}

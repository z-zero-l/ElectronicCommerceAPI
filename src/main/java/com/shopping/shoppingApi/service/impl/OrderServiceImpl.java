package com.shopping.shoppingApi.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.entity.Order;
import com.shopping.shoppingApi.entity.OrderItem;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.mapper.*;
import com.shopping.shoppingApi.service.OrderService;
import com.shopping.shoppingApi.vo.OrderDetailVO;
import com.shopping.shoppingApi.vo.OrderItemVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.shopping.shoppingApi.entity.table.OrderItemTableDef.ORDER_ITEM;
import static com.shopping.shoppingApi.entity.table.OrderTableDef.ORDER;

/**
 * 订单 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private OrderItemMapper orderItemMapper;
    private BusinessMapper businessMapper;
    private ProductMapper productMapper;
    private ProductSpecMapper productSpecMapper;

    /**
     * 获取用户订单列表
     *
     * @param userId 用户ID
     * @return 订单列表
     */
    @Override
    public List<OrderItemVO> getOrderList(Integer userId, Integer status) {
        ArrayList<OrderItemVO> orderItemVOS = new ArrayList<>();
        if (status != null && !ArrayUtil.contains(new Integer[]{0, 1, 2, 3, 4, 5}, status)) {
            throw new ServerException("订单状态不合法");
        }
        list(QueryChain.create().where(ORDER.USER_ID.eq(userId)))
                .forEach(order -> {
                    QueryWrapper queryWrapper = QueryChain.create().where(ORDER_ITEM.ORDER_ID.eq(order.getId()));
                    if (status != null) {
                        queryWrapper.and(ORDER_ITEM.STATUS.eq(status));
                    }
                    orderItemMapper.selectListByQuery(queryWrapper.orderBy(ORDER_ITEM.CREATE_TIME.desc()))
                            .forEach(orderItem -> {
                                Business business = businessMapper.selectOneById(productMapper.selectOneById(orderItem.getProductId()).getBusinessId());
                                orderItemVOS.add(OrderItemVO.create()
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
        return orderItemVOS;
    }

    /**
     * 获取订单详情
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     * @return 订单详情
     */
    @Override
    public OrderDetailVO getOrderDetail(Integer userId, Integer orderItemId) {
        OrderItem orderItem = orderItemMapper.selectOneById(orderItemId);
        if (!exists(QueryChain.create().where(ORDER.ID.eq(orderItem.getOrderId())).and(ORDER.USER_ID.eq(userId)))) {
            throw new ServerException("订单不存在");
        }
        Order order = getById(orderItem.getOrderId());
        OrderDetailVO orderDetailVO = OrderDetailVO.create()
                .setId(orderItemId)
                .setOrderId(order.getOrderId());
        Product product = productMapper.selectOneById(orderItem.getProductId());
        if (product == null) {
            orderDetailVO.setProductId(null);
        } else {
            Business business = businessMapper.selectOneById(product.getBusinessId());
            if (business == null) {
                orderDetailVO.setBusinessId(null);
                orderDetailVO.setBusinessName("店铺已关闭");
            } else {
                orderDetailVO.setBusinessId(business.getId())
                       .setBusinessName(business.getBusinessName());
            }
        }
        orderDetailVO.setProductName(orderItem.getProductName())
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
        return orderDetailVO;
    }
}

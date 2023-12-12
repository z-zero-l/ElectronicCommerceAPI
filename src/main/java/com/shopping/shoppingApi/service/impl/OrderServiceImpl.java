package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.entity.Order;
import com.shopping.shoppingApi.mapper.BusinessMapper;
import com.shopping.shoppingApi.mapper.OrderItemMapper;
import com.shopping.shoppingApi.mapper.OrderMapper;
import com.shopping.shoppingApi.mapper.ProductMapper;
import com.shopping.shoppingApi.service.OrderService;
import com.shopping.shoppingApi.vo.OrderItemVO;
import com.shopping.shoppingApi.vo.OrderVO;
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

    /**
     * 获取用户订单列表
     *
     * @param userId 用户ID
     * @return 订单列表
     */
    @Override
    public List<OrderItemVO> getOrderList(Integer userId) {
        ArrayList<OrderVO> orderVOS = new ArrayList<>();
        list(QueryChain.create().where(ORDER.USER_ID.eq(userId))).forEach(order -> {
            orderVOS.add(OrderVO.create()
                    .setId(order.getId())
                    .setOrderId(order.getOrderId()));
        });
        ArrayList<OrderItemVO> orderItemVOS = new ArrayList<>();
        orderVOS.forEach(orderVO -> {
            orderItemMapper.selectListByQuery(QueryChain.create().where(ORDER_ITEM.ORDER_ID.eq(orderVO.getId())).orderBy(ORDER_ITEM.CREATE_TIME.desc()))
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
            orderVO.setOrderDetail(orderItemVOS);
        });
        return orderItemVOS;
    }
}

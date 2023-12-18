package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Order;
import com.shopping.shoppingApi.vo.OrderDetailVO;
import com.shopping.shoppingApi.vo.OrderItemVO;

import java.util.List;

/**
 * 订单 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface OrderService extends IService<Order> {

    /**
     * 获取用户订单列表
     * @param userId 用户ID
     * @param status 订单状态
     * @return 订单列表
     */
    List<OrderItemVO> getOrderList(Integer userId,Integer status);

    /**
     * 获取订单详情
     * @param userId 用户ID
     * @param orderItemId 订单项ID
     * @return 订单详情
     */
    OrderDetailVO getOrderDetail(Integer userId, Integer orderItemId);
}

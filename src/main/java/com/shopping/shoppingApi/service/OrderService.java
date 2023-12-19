package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Order;
import com.shopping.shoppingApi.query.OrderQuery;
import com.shopping.shoppingApi.vo.OrderListVO;
import com.shopping.shoppingApi.vo.OrderVO;

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
     *
     * @param userId 用户ID
     * @param status 订单状态
     * @return 订单列表
     */
    List<OrderListVO> getOrderList(Integer userId, Integer status);

    /**
     * 获取订单详情
     *
     * @param userId  用户id
     * @param orderId 订单号
     * @return 订单详情
     */
    OrderVO getOrderDetail(Integer userId, String orderId);

    /**
     * 提交订单
     *
     * @param userId         用户id
     * @param addressId      地址id
     * @param orderQueryList 订单信息
     * @return 订单id
     */
    String submitOrder(Integer userId, Integer addressId, List<OrderQuery> orderQueryList);
}

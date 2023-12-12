package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Order;
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
     * @param userId 用户ID
     * @return 订单列表
     */
    List<OrderVO> getOrderList(Integer userId);
}

package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.OrderItem;
import com.shopping.shoppingApi.vo.OrderItemDetailVO;

/**
 * 订单详情 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface OrderItemService extends IService<OrderItem> {

    /**
     * 获取订单项详情
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     * @return 订单详情
     */
    OrderItemDetailVO getOrderItemDetail(Integer userId, Integer orderItemId);

    /**
     * 模拟发货
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     */
    Void simulateDelivery(Integer userId, Integer orderItemId);

    /**
     * 确认收货
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     */
    Void confirmReceipt(Integer userId, Integer orderItemId);
}

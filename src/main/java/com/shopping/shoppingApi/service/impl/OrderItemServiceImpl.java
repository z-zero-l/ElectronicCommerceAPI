package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.OrderItem;
import com.shopping.shoppingApi.mapper.OrderItemMapper;
import com.shopping.shoppingApi.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * 订单详情 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}

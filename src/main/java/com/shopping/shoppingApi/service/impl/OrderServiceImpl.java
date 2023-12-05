package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Order;
import com.shopping.shoppingApi.mapper.OrderMapper;
import com.shopping.shoppingApi.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 订单 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}

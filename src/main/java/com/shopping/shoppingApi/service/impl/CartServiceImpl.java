package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Cart;
import com.shopping.shoppingApi.mapper.CartMapper;
import com.shopping.shoppingApi.service.CartService;
import org.springframework.stereotype.Service;

/**
 * 购物车 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

}

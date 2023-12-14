package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Cart;
import com.shopping.shoppingApi.vo.CartVO;

import java.util.List;

/**
 * 购物车 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface CartService extends IService<Cart> {

    /**
     * 获取购物车列表
     *
     * @param userId 用户id
     * @return 购物车列表
     */
    List<CartVO> getCartList(Integer userId);

    /**
     * 修改购物车
     *
     * @param userId     用户id
     * @param cartVO     购物车
     */
    Void updateCart(Integer userId, CartVO cartVO);
}

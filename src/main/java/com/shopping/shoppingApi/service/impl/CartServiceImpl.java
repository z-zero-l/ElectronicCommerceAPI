package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Cart;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.entity.ProductSpec;
import com.shopping.shoppingApi.mapper.CartMapper;
import com.shopping.shoppingApi.mapper.ProductMapper;
import com.shopping.shoppingApi.mapper.ProductSpecMapper;
import com.shopping.shoppingApi.mapper.UserMapper;
import com.shopping.shoppingApi.service.CartService;
import com.shopping.shoppingApi.vo.CartVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    private UserMapper userMapper;
    private ProductMapper productMapper;
    private ProductSpecMapper productSpecMapper;

    /**
     * 获取购物车列表
     *
     * @param userId 用户id
     * @return 购物车列表
     */
    @Override
    public List<CartVO> getCartList(Integer userId) {
        if (!QueryChain.of(userMapper).eq("user_id", userId).exists()) {
            throw new ServerException("用户不存在");
        }
        ArrayList<CartVO> cartVOS = new ArrayList<>();
        List<Cart> carts = list(QueryChain.create().eq("user_id", userId));
        for (Cart cart : carts) {
            Product product = productMapper.selectOneById(cart.getProductId());
            ProductSpec productSpec = productSpecMapper.selectOneById(cart.getProductId());
            if (product == null || productSpec == null) {
                removeById(cart.getCartId());
                continue;
            }
            CartVO cartVO = CartVO.create()
                    .setCartId(cart.getCartId())
                    .setProductId(product.getProductId())
                    .setProductName(product.getProductName())
                    .setSpecId(productSpec.getId())
                    .setSpecName(productSpec.getSpecName())
                    .setSpecImg(productSpec.getSpecImg())
                    .setQuantity(cart.getQuantity())
                    .setJoinPrice(cart.getJoinPrice())
                    .setSellPrice(productSpec.getSellPrice())
                    .setProductStatus(product.getProductStatus())
                    .setSelected(cart.getSelected());
            cartVOS.add(cartVO);
        }
        return cartVOS;
    }
}

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

import static com.shopping.shoppingApi.entity.table.CartTableDef.CART;
import static com.shopping.shoppingApi.entity.table.ProductSpecTableDef.PRODUCT_SPEC;

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
            Integer stock = (Integer) QueryChain.of(productSpecMapper).select(PRODUCT_SPEC.STOCK).where(PRODUCT_SPEC.ID.eq(cart.getSpecId())).obj();
            CartVO cartVO = CartVO.create()
                    .setCartId(cart.getCartId())
                    .setProductId(product.getProductId())
                    .setProductName(product.getProductName())
                    .setSpecId(productSpec.getId())
                    .setSpecName(productSpec.getSpecName())
                    .setSpecImg(productSpec.getSpecImg())
                    .setQuantity(cart.getQuantity())
                    .setStock(stock)
                    .setJoinPrice(cart.getJoinPrice())
                    .setSellPrice(productSpec.getSellPrice())
                    .setProductStatus(product.getProductStatus())
                    .setSelected(cart.getSelected());
            cartVOS.add(cartVO);
        }
        return cartVOS;
    }

    /**
     * 修改购物车
     *
     * @param userId 用户id
     * @param cartVO 购物车
     */
    @Override
    public Void updateCart(Integer userId, CartVO cartVO) {
        if (cartVO.getCartId() == null) {
            throw new ServerException("购物车id不能为空");
        }
        if (!exists(QueryChain.create().where(CART.USER_ID.eq(userId)).where(CART.CART_ID.eq(cartVO.getCartId())))) {
            throw new ServerException("您的购物车不存在此商品");
        }
        Cart cart = getById(cartVO.getCartId());
        if (cartVO.getSelected() != null) {
            if (cartVO.getSelected() == 1 || cartVO.getSelected() == 0) {
                cart.setSelected(cartVO.getSelected());
            }
        }
        if (cartVO.getQuantity() != null && cartVO.getQuantity() > 0) {
            Integer productStock = (Integer) QueryChain.of(productSpecMapper).select(PRODUCT_SPEC.STOCK).where(PRODUCT_SPEC.ID.eq(cart.getProductId())).obj();
            if (cartVO.getQuantity() > productStock) {
                throw new ServerException("库存不足");
            } else {
                cart.setQuantity(cartVO.getQuantity());
            }
        }
        System.err.println(cart);
        if (!updateById(cart)) {
            throw new ServerException("修改购物车失败");
        }
        return null;
    }

    /**
     * 删除购物车商品
     *
     * @param userId 用户id
     * @param cartId 购物车id
     */
    @Override
    public Void deleteCartItem(Integer userId, Integer cartId) {
        if (!exists(QueryChain.create().where(CART.USER_ID.eq(userId)).where(CART.CART_ID.eq(cartId)))) {
            throw new ServerException("您的购物车不存在此商品");
        }
        if (!removeById(cartId)) {
            throw new ServerException("删除购物车失败");
        }
        return null;
    }
}

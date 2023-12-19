package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Cart;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.entity.ProductSpec;
import com.shopping.shoppingApi.mapper.CartMapper;
import com.shopping.shoppingApi.mapper.ProductMapper;
import com.shopping.shoppingApi.mapper.ProductSpecMapper;
import com.shopping.shoppingApi.mapper.UserMapper;
import com.shopping.shoppingApi.query.CartQuery;
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
    public List<CartVO> getCartList(Integer userId, Integer selected) {
        if (!QueryChain.of(userMapper).eq("user_id", userId).exists()) {
            throw new ServerException("用户不存在");
        }
        ArrayList<CartVO> cartVOS = new ArrayList<>();
        QueryWrapper queryWrapper = QueryChain.create().eq("user_id", userId).orderBy(CART.CREATE_TIME.desc());
        if (selected != null && selected == 1) {
            queryWrapper.eq("selected", selected);
        }
        List<Cart> carts = list(queryWrapper);
        for (Cart cart : carts) {
            Product product = productMapper.selectOneById(cart.getProductId());
            ProductSpec productSpec = productSpecMapper.selectOneById(cart.getSpecId());
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
                    .setFreight(product.getFreight())
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

    /**
     * 添加购物车
     *
     * @param userId    用户id
     * @param cartQuery 添加商品信息
     */
    @Override
    public Void addCart(Integer userId, CartQuery cartQuery) {
        Cart cart = getOne(QueryChain.create().where(CART.USER_ID.eq(userId)).where(CART.SPEC_ID.eq(cartQuery.getId())));
        Integer productStock = (Integer) QueryChain.of(productSpecMapper).select(PRODUCT_SPEC.STOCK).where(PRODUCT_SPEC.ID.eq(cartQuery.getId())).obj();
        if (cart == null) {
            if (cartQuery.getCount() > 0) {
                ProductSpec productSpec = productSpecMapper.selectOneById(cartQuery.getId());
                Product product = productMapper.selectOneById(productSpec.getProductId());
                if (product == null || productSpec == null) {
                    throw new ServerException("商品不存在");
                }
                if (cartQuery.getCount() < 1) {
                    throw new ServerException("数量不能小于1");
                }
                if (productStock < cartQuery.getCount()) {
                    throw new ServerException("库存不足");
                }

                cart = Cart.create()
                        .setUserId(userId)
                        .setProductId(productSpec.getProductId())
                        .setSpecId(productSpec.getId())
                        .setQuantity(cartQuery.getCount())
                        .setJoinPrice(productSpec.getSellPrice())
                        .setSelected(1);
            }
        } else {
            if (cartQuery.getCount() < 1) {
                throw new ServerException("数量不能小于1");
            }
            if (productStock < cart.getQuantity() + cartQuery.getCount()) {
                throw new ServerException("库存不足");
            }
            cart.setQuantity(cart.getQuantity() + cartQuery.getCount());
        }
        if (!saveOrUpdate(cart)) {
            throw new ServerException("添加购物车失败");
        }
        return null;
    }
}

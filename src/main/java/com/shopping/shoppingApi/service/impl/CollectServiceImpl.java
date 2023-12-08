package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Collect;
import com.shopping.shoppingApi.mapper.CollectMapper;
import com.shopping.shoppingApi.service.CollectService;
import org.springframework.stereotype.Service;

/**
 * 收藏 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    /**
     * 添加收藏
     *
     * @param userId    用户ID
     * @param productId 商品ID
     */
    @Override
    public Void addCollect(Integer userId, Integer productId) {
        if (userId == null) {
            throw new ServerException("用户ID不能为空");
        }
        if (productId == null) {
            throw new ServerException("商品ID不能为空");
        }
        if (this.count(new QueryWrapper().eq("user_id", userId).eq("product_id", productId)) > 0) {
            throw new ServerException("已收藏");
        }
        save(Collect.create().setUserId(userId).setProductId(productId));
        return null;
    }

    /**
     * 取消收藏
     *
     * @param userId    用户ID
     * @param productId 商品ID
     */
    @Override
    public Void cancelCollect(Integer userId, Integer productId) {
        if (userId == null) {
            throw new ServerException("用户ID不能为空");
        }
        if (productId == null) {
            throw new ServerException("商品ID不能为空");
        }
        if (this.count(new QueryWrapper().eq("user_id", userId).eq("product_id", productId)) == 0) {
            throw new ServerException("未收藏");
        }
        remove(new QueryWrapper().eq("user_id", userId).eq("product_id", productId));
        return null;
    }
}

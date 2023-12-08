package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Collect;

/**
 * 收藏 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface CollectService extends IService<Collect> {

    /**
     * 添加收藏
     *
     * @param userId    用户ID
     * @param productId 商品ID
     */
    Void addCollect(Integer userId, Integer productId);

    /**
     * 取消收藏
     *
     * @param userId    用户ID
     * @param productId 商品ID
     */
    Void cancelCollect(Integer userId, Integer productId);

}

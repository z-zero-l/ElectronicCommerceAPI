package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.entity.Category;
import com.shopping.shoppingApi.entity.Collect;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.mapper.*;
import com.shopping.shoppingApi.service.CollectService;
import com.shopping.shoppingApi.vo.CategoryChildVO;
import com.shopping.shoppingApi.vo.CategoryVO;
import com.shopping.shoppingApi.vo.CollectVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mybatisflex.core.query.QueryMethods.min;
import static com.shopping.shoppingApi.entity.table.CategoryTableDef.CATEGORY;
import static com.shopping.shoppingApi.entity.table.CollectTableDef.COLLECT;
import static com.shopping.shoppingApi.entity.table.ProductSpecTableDef.PRODUCT_SPEC;
import static com.shopping.shoppingApi.entity.table.ProductTableDef.PRODUCT;

/**
 * 收藏 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    private ProductMapper productMapper;
    private BusinessMapper businessMapper;
    private ProductSpecMapper productSpecMapper;
    private CategoryMapper categoryMapper;

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

    /**
     * 获取收藏列表
     *
     * @param userId     用户ID
     * @param categoryId 分类ID
     * @return 收藏列表
     */
    @Override
    public List<CollectVO> getCollectList(Integer userId, Integer categoryId) {
        List<Collect> collects;
        if (categoryId != null) {
            collects = list(QueryChain.create()
                    .join(PRODUCT).on(PRODUCT.PRODUCT_ID.eq(COLLECT.PRODUCT_ID))
                    .where(COLLECT.USER_ID.eq(userId))
                    .where(PRODUCT.CATE_SEC_ID.eq(categoryId))
                    .orderBy(PRODUCT.CREATE_TIME.desc()));
        } else {
            collects = list(QueryChain.create().eq("user_id", userId).orderBy(COLLECT.CREATE_TIME.desc()));
        }
        List<CollectVO> collectVOS = new ArrayList<>();
        for (Collect collect : collects) {
            Product product = productMapper.selectOneById(collect.getProductId());
            if (product == null) {
                remove(new QueryWrapper().eq("user_id", userId).eq("product_id", collect.getProductId()));
                continue;
            }
            Business business = businessMapper.selectOneById(product.getBusinessId());
            if (business == null) {
                remove(new QueryWrapper().eq("user_id", userId).eq("product_id", collect.getProductId()));
                continue;
            }
            CollectVO collectVO = CollectVO.create()
                    .setId(collect.getId())
                    .setProductId(product.getProductId())
                    .setProductName(product.getProductName())
                    .setBusinessId(business.getId())
                    .setBusinessName(business.getBusinessName())
                    .setProductProfile(product.getProductProfile())
                    .setProductCover(product.getProductCover())
                    .setPrice((Double) QueryChain.of(productSpecMapper).select(min(PRODUCT_SPEC.SELL_PRICE)).where(PRODUCT_SPEC.PRODUCT_ID.eq(product.getProductId())).obj())
                    .setCollectCount(count(new QueryWrapper().eq("product_id", collect.getProductId())));
            collectVOS.add(collectVO);
        }
        return collectVOS;
    }

    /**
     * 获取收藏的分类列表
     *
     * @param userId 用户ID
     * @return 分类列表
     */
    @Override
    public List<CategoryVO> getCategoryList(Integer userId) {
        ArrayList<CategoryVO> categoryVOS = new ArrayList<>();
        categoryMapper.selectListByQuery(QueryChain.create().where(CATEGORY.PARENT_ID.eq(0)))
                .forEach(category -> {
                    List<Category> list = categoryMapper.selectListByQuery(QueryChain.create()
                            .join(PRODUCT).on(PRODUCT.CATE_SEC_ID.eq(CATEGORY.CATEGORY_ID))
                            .join(COLLECT).on(COLLECT.PRODUCT_ID.eq(PRODUCT.PRODUCT_ID))
                            .where(CATEGORY.PARENT_ID.eq(category.getCategoryId()))
                            .where(COLLECT.USER_ID.eq(userId))
                            .orderBy(CATEGORY.CATEGORY_ID.asc()));
                    if (!list.isEmpty()) {
                        ArrayList<CategoryChildVO> categoryChildVOS = new ArrayList<>();
                        list.forEach(categoryChild -> {
                            List<CollectVO> collectList = getCollectList(userId, categoryChild.getCategoryId());
                            if (!collectList.isEmpty()) {
                                categoryChildVOS.add(CategoryChildVO.create()
                                        .setCategoryId(categoryChild.getCategoryId())
                                        .setCateName(categoryChild.getCateName())
                                        .setCateIcon(categoryChild.getCateIcon())
                                        .setCateColor(categoryChild.getCateColor()));
                            }
                        });
                        categoryVOS.add(CategoryVO.create()
                                .setCategoryId(category.getCategoryId())
                                .setCateName(category.getCateName())
                                .setCateIcon(category.getCateIcon())
                                .setCateColor(category.getCateColor())
                                .setChildCate(categoryChildVOS));
                    }
                });
        return categoryVOS;
    }
}

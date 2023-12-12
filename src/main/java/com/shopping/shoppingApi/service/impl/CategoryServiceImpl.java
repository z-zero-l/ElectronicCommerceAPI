package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.CacheableServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Category;
import com.shopping.shoppingApi.mapper.*;
import com.shopping.shoppingApi.service.CategoryService;
import com.shopping.shoppingApi.vo.CategoryChildVO;
import com.shopping.shoppingApi.vo.CategoryVO;
import com.shopping.shoppingApi.vo.IndexProductVO;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mybatisflex.core.query.QueryMethods.sum;
import static com.shopping.shoppingApi.entity.table.BusinessTableDef.BUSINESS;
import static com.shopping.shoppingApi.entity.table.OrderItemTableDef.ORDER_ITEM;
import static com.shopping.shoppingApi.entity.table.ProductSpecTableDef.PRODUCT_SPEC;
import static com.shopping.shoppingApi.entity.table.ProductTableDef.PRODUCT;

/**
 * 分类 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "category")
public class CategoryServiceImpl extends CacheableServiceImpl<CategoryMapper, Category> implements CategoryService {

    private OrderItemMapper orderItemMapper;
    private ProductMapper productMapper;
    private ProductSpecMapper productSpecMapper;
    private BusinessMapper businessMapper;

    /**
     * 获取所有分类列表。
     *
     * @return 所有分类列表。
     */
    @Override
    public List<CategoryVO> getCategoryList() {
        List<Category> list = list(new QueryWrapper().eq("parent_id", 0));
        ArrayList<CategoryVO> categoryVOS = new ArrayList<>();
        for (Category category : list) {
            categoryVOS.add(CategoryVO.create()
                    .setCategoryId(category.getCategoryId())
                    .setCateName(category.getCateName())
                    .setCateIcon(category.getCateIcon())
                    .setCateColor(category.getCateColor())
                    .setChildCate(getChildCategoryList(category.getCategoryId())));
        }
        return categoryVOS;
    }

    /**
     * 获取一级分类列表。
     *
     * @return 一级分类列表。
     */
    @Override
    public List<CategoryVO> getParentCategoryList() {
        List<Category> list = super.list(new QueryWrapper().eq("parent_id", 0));
        ArrayList<CategoryVO> categoryVOS = new ArrayList<>();
        for (Category category : list) {
            categoryVOS.add(CategoryVO.create()
                    .setCategoryId(category.getCategoryId())
                    .setCateName(category.getCateName())
                    .setCateIcon(category.getCateIcon())
                    .setCateColor(category.getCateColor()));
        }
        return categoryVOS;
    }

    /**
     * 获取子分类列表。
     *
     * @param parentId 父分类id。
     * @return 子分类列表。
     */
    @Override
    public List<CategoryChildVO> getChildCategoryList(Integer parentId) {
        if (parentId == null) {
            throw new ServerException("父分类id不能为空");
        }
        List<Category> list = super.list(new QueryWrapper().eq("parent_id", parentId));
        if (list.isEmpty()) {
            throw new ServerException("没有子分类");
        }
        List<CategoryChildVO> categoryVOS = new ArrayList<>();
        for (Category category : list) {
            ArrayList<IndexProductVO> indexProductVOS = new ArrayList<>();
            productMapper.selectListByQuery(new QueryWrapper().where(PRODUCT.PRODUCT_STATUS.eq(1)).where(PRODUCT.CATE_SEC_ID.eq(category.getCategoryId())).orderBy(QueryMethods.rand().asc()).limit(4))
                    .forEach(product -> {
                        BigDecimal isHot = ((BigDecimal) QueryChain.of(orderItemMapper)
                                .select(sum(ORDER_ITEM.AMOUNT))
                                .where(ORDER_ITEM.PRODUCT_ID.eq(product.getProductId()))
                                .obj());
                        indexProductVOS.add(IndexProductVO.create()
                                .setProductId(product.getProductId()) // 主键
                                .setProductName(product.getProductName()) // 商品名称
                                .setBusinessId(product.getBusinessId())
                                .setBusiness((String) businessMapper.selectObjectByQuery(
                                        new QueryWrapper().select(BUSINESS.BUSINESS_NAME).where(BUSINESS.ID.eq(product.getBusinessId())))) // 所属店铺
                                .setFreight(product.getFreight()) // 运费
                                .setPrice((Double) QueryChain.of(productSpecMapper).select(QueryMethods.min(PRODUCT_SPEC.SELL_PRICE)).where(PRODUCT_SPEC.PRODUCT_ID.eq(product.getProductId())).obj()) // 商品价格
                                .setProductCover(product.getProductCover()) // 商品封面图片
                                .setIsHot(isHot != null && (isHot.intValue() > 10)) // 是否热门
                                .setIsNew(
                                        QueryChain.of(productSpecMapper)
                                                .where(PRODUCT_SPEC.PRODUCT_ID.eq(product.getProductId()))
                                                .where(PRODUCT_SPEC.CREATE_TIME.between(LocalDateTime.now().minusDays(7), LocalDateTime.now()))
                                                .count() > 0
                                ) // 是否新品
                                .setIsSale(
                                        QueryChain.of(productSpecMapper)
                                                .where(PRODUCT_SPEC.PRODUCT_ID.eq(product.getProductId()))
                                                .where(PRODUCT_SPEC.SELL_PRICE.lt(PRODUCT_SPEC.LIST_PRICE.multiply(0.7)))
                                                .count() > 0
                                ) // 是否促销
                        );
                    });

            categoryVOS.add(CategoryChildVO.create()
                    .setCategoryId(category.getCategoryId())
                    .setCateName(category.getCateName())
                    .setCateIcon(category.getCateIcon())
                    .setCateColor(category.getCateColor())
                    .setProductList(indexProductVOS));
        }
        return categoryVOS;
    }
}

package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Category;
import com.shopping.shoppingApi.entity.OrderItem;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.mapper.*;
import com.shopping.shoppingApi.service.ProductService;
import com.shopping.shoppingApi.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mybatisflex.core.query.QueryMethods.sum;
import static com.shopping.shoppingApi.entity.table.BusinessTableDef.BUSINESS;
import static com.shopping.shoppingApi.entity.table.CategoryTableDef.CATEGORY;
import static com.shopping.shoppingApi.entity.table.CollectTableDef.COLLECT;
import static com.shopping.shoppingApi.entity.table.CommentTableDef.COMMENT;
import static com.shopping.shoppingApi.entity.table.OrderItemTableDef.ORDER_ITEM;
import static com.shopping.shoppingApi.entity.table.OrderTableDef.ORDER;
import static com.shopping.shoppingApi.entity.table.ProductSpecTableDef.PRODUCT_SPEC;
import static com.shopping.shoppingApi.entity.table.ProductTableDef.PRODUCT;

/**
 * 商品表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    private BusinessMapper businessMapper;
    private CategoryMapper categoryMapper;
    private ProductSpecMapper productSpecMapper;
    private ProductCarouselImageMapper productCarouselImageMapper;
    private ProductDetailImageMapper productDetailImageMapper;
    private OrderItemMapper orderItemMapper;
    private CollectMapper collectMapper;
    private CommentMapper commentMapper;

    /**
     * 获取商品详情
     *
     * @param id     商品id
     * @param userId 用户id
     * @return 商品详情
     */
    // todo: 商品评论,商品收藏
    @Override
    public ProductVO getProductInfo(Integer id, Integer userId) {
        if (id == null) {
            throw new ServerException("商品id不能为空");
        }
        Product product = this.getById(id);
        if (product == null) {
            throw new ServerException("商品不存在");
        }
        ProductVO productVO = ProductVO.create()
                .setProductId(product.getProductId()) // 主键
                .setProductName(product.getProductName()) // 商品名称
                .setBusiness((String) businessMapper.selectObjectByQuery(
                        new QueryWrapper().select(BUSINESS.BUSINESS_NAME).where(BUSINESS.ID.eq(product.getBusinessId())))); // 所属店铺

        // 二级分类
        CategoryChildVO categoryChildVO = CategoryChildVO.create();
        Category categoryChild = categoryMapper.selectOneById(product.getCateSecId());
        categoryChildVO.setCategoryId(categoryChild.getCategoryId())
                .setCateName(categoryChild.getCateName())
                .setCateIcon(categoryChild.getCateIcon())
                .setCateColor(categoryChild.getCateColor());
        ArrayList<CategoryChildVO> categoryChildVOS = new ArrayList<>();
        categoryChildVOS.add(categoryChildVO);

        // 一级分类
        CategoryVO categoryVO = CategoryVO.create();
        Category category = categoryMapper.selectOneById(categoryChild.getParentId());
        categoryVO.setCategoryId(category.getCategoryId())
                .setCateName(category.getCateName())
                .setCateIcon(category.getCateIcon())
                .setCateColor(category.getCateColor())
                .setChildCate(categoryChildVOS);

        productVO.setCate(categoryVO);

        productVO.setProductProfile(product.getProductProfile()); // 商品简介
        productVO.setFreight(product.getFreight()); // 运费
        productVO.setProductStatus(product.getProductStatus()); //  商品状态

        // 收藏数
        productVO.setCollectCount(
                (int) QueryChain.of(collectMapper)
                        .where(COLLECT.PRODUCT_ID.eq(product.getProductId()))
                        .count()
        );

        // 是否收藏
        productVO.setIsCollect(
                QueryChain.of(collectMapper)
                        .where(COLLECT.PRODUCT_ID.eq(product.getProductId()))
                        .where(COLLECT.USER_ID.eq(userId))
                        .exists()
        );

        // 评论数
        productVO.setCommentCount(
                (int) QueryChain.of(commentMapper)
                        .where(COMMENT.PRODUCT_ID.eq(product.getProductId()))
                        .count()
        );

        if (product.getProductStatus() == 1) {
            // 商品规格
            ArrayList<ProductSpecVO> productSpecVOS = new ArrayList<>();
            productSpecMapper.selectListByQuery(
                            new QueryWrapper().select("id", "spec_name", "list_price", "sell_price", "stock", "spec_img").eq("product_id", product.getProductId()))
                    .forEach(productSpec -> productSpecVOS.add(ProductSpecVO.create()
                            .setId(productSpec.getId())
                            .setSpecName(productSpec.getSpecName())
                            .setListPrice(productSpec.getListPrice())
                            .setSellPrice(productSpec.getSellPrice())
                            .setStock(productSpec.getStock())
                            .setSpecImg(productSpec.getSpecImg())));
            productVO.setProductSpec(productSpecVOS);

            // 商品详情图片
            ArrayList<ProductImageVO> productDetailImageVOS = new ArrayList<>();
            productDetailImageMapper.selectListByQuery(
                            new QueryWrapper().select("sort", "img_url").eq("product_id", product.getProductId()).orderBy("sort"))
                    .forEach(productDetailImage -> productDetailImageVOS.add(ProductImageVO.create()
                            .setIndex(productDetailImage.getSort())
                            .setImgUrl(productDetailImage.getImgUrl())));
            productVO.setProductDetailImg(productDetailImageVOS);

            // 商品轮播图片
            ArrayList<ProductImageVO> productCarouselImageVOS = new ArrayList<>();
            productCarouselImageMapper.selectListByQuery(
                            new QueryWrapper().select("sort", "img_url").eq("product_id", product.getProductId()).orderBy("sort"))
                    .forEach(productCarouselImage -> productCarouselImageVOS.add(ProductImageVO.create()
                            .setIndex(productCarouselImage.getSort())
                            .setImgUrl(productCarouselImage.getImgUrl())));
            productVO.setProductCarouselImg(productCarouselImageVOS);
        }
        return productVO;
    }

    /**
     * 获取商品列表
     *
     * @return 首页列表
     */
    @Override
    public List<IndexProductVO> getProductList(Integer cateId) {
        QueryWrapper productQueryWrapper = new QueryWrapper().where(PRODUCT.PRODUCT_STATUS.eq(1)).orderBy(QueryMethods.rand().asc());
        if (cateId != null) {
            if (!QueryChain.of(categoryMapper).where(CATEGORY.CATEGORY_ID.eq(cateId)).exists()) {
                throw new ServerException("分类不存在");
            }
            if (QueryChain.of(categoryMapper).where(CATEGORY.CATEGORY_ID.eq(cateId)).where(CATEGORY.PARENT_ID.eq(0)).exists()) {
                throw new ServerException("请选择子分类");
            }
            productQueryWrapper.where(PRODUCT.CATE_SEC_ID.eq(cateId));
        }
        ArrayList<IndexProductVO> indexProductVOS = new ArrayList<>();
        list(productQueryWrapper.limit(48))
                .forEach(product -> {
                    QueryChain<OrderItem> sellAmountQuery = QueryChain.of(orderItemMapper)
                            .select(sum(ORDER_ITEM.AMOUNT))
                            .where(ORDER_ITEM.PRODUCT_ID.eq(product.getProductId()))
                            .join(ORDER).on(ORDER_ITEM.ORDER_ID.eq(ORDER.ID))
                            .where(ORDER_ITEM.STATUS.notIn(List.of(5)));
                    BigDecimal weekSellAmount = (BigDecimal) sellAmountQuery
                            .where(ORDER_ITEM.CREATE_TIME.between(LocalDateTime.now().minusDays(7), LocalDateTime.now()))
                            .obj();
                    BigDecimal totalSellAmount = (BigDecimal) sellAmountQuery.obj();
                    indexProductVOS.add(IndexProductVO.create()
                            .setProductId(product.getProductId()) // 主键
                            .setProductName(product.getProductName()) // 商品名称
                            .setBusinessId(product.getBusinessId())
                            .setBusiness((String) businessMapper.selectObjectByQuery(
                                    new QueryWrapper().select(BUSINESS.BUSINESS_NAME).where(BUSINESS.ID.eq(product.getBusinessId())))) // 所属店铺
                            .setFreight(product.getFreight()) // 运费
                            .setPrice((Double) QueryChain.of(productSpecMapper).select(QueryMethods.min(PRODUCT_SPEC.SELL_PRICE)).where(PRODUCT_SPEC.PRODUCT_ID.eq(product.getProductId())).obj()) // 商品价格
                            .setProductCover(product.getProductCover()) // 商品封面图片
                            .setIsHot(weekSellAmount != null && (weekSellAmount.intValue() > 10)) // 是否热门
                            .setTotalSaleAmount(totalSellAmount)
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
        return indexProductVOS;
    }
}

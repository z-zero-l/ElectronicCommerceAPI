package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.mapper.BusinessMapper;
import com.shopping.shoppingApi.mapper.OrderItemMapper;
import com.shopping.shoppingApi.mapper.ProductMapper;
import com.shopping.shoppingApi.mapper.ProductSpecMapper;
import com.shopping.shoppingApi.service.BusinessService;
import com.shopping.shoppingApi.vo.BusinessListVO;
import com.shopping.shoppingApi.vo.BusinessVO;
import com.shopping.shoppingApi.vo.ProductListVO;
import lombok.AllArgsConstructor;
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
 * 店铺信息表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    private ProductMapper productMapper;
    private OrderItemMapper orderItemMapper;
    private ProductSpecMapper productSpecMapper;

    /**
     * 获取店铺信息
     *
     * @param businessId 店铺id
     * @return 店铺信息
     */
    @Override
    public BusinessVO getBusinessInfo(Integer businessId) {
        ArrayList<ProductListVO> productListVOS = new ArrayList<>();
        productMapper.selectListByQuery(QueryChain.create().where(PRODUCT.BUSINESS_ID.eq(businessId)))
                .forEach(product -> {
                    BigDecimal isHot = ((BigDecimal) QueryChain.of(orderItemMapper)
                            .select(sum(ORDER_ITEM.AMOUNT))
                            .where(ORDER_ITEM.PRODUCT_ID.eq(product.getProductId()))
                            .obj());
                    productListVOS.add(ProductListVO.create()
                            .setProductId(product.getProductId()) // 主键
                            .setProductName(product.getProductName()) // 商品名称
                            .setBusinessId(product.getBusinessId())
                            .setBusiness((String) getObj(
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
        Business business = getOne(QueryChain.create().where(BUSINESS.ID.eq(businessId)));
        return BusinessVO.create()
                .setId(business.getId())
                .setBusinessName(business.getBusinessName())
                .setBusinessPhone(business.getBusinessPhone())
                .setBusinessProfile(business.getBusinessProfile())
                .setBusinessAvatar(business.getBusinessAvatar())
                .setProductList(productListVOS);

    }

    /**
     * 搜索店铺
     *
     * @param keyword 关键字
     * @return 店铺信息列表
     */
    @Override
    public List<BusinessListVO> searchBusiness(String keyword) {
        ArrayList<BusinessListVO> businessListVOS = new ArrayList<>();
        list(QueryChain.create().where(BUSINESS.BUSINESS_NAME.like("%" + keyword + "%").or(BUSINESS.BUSINESS_PROFILE.like("%" + keyword + "%"))).limit(48))
                .forEach(business -> {
                    businessListVOS.add(BusinessListVO.create()
                            .setId(business.getId())
                            .setBusinessName(business.getBusinessName())
                            .setBusinessAvatar(business.getBusinessAvatar())
                            .setBusinessProfile(business.getBusinessProfile())
                            .setBusinessYears(business.getCreateTime().toLocalDate().until(LocalDateTime.now().toLocalDate()).getYears()));
                });
        return businessListVOS;
    }
}

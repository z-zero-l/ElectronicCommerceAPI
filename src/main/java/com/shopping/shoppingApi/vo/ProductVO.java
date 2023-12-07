package com.shopping.shoppingApi.vo;

import com.shopping.shoppingApi.entity.ProductCarouselImage;
import com.shopping.shoppingApi.entity.ProductDetailImage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    @Schema(description = "主键")
    private Integer productId;

    /**
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String productName;

    /**
     * 所属店铺
     */
    @Schema(description = "所属店铺")
    private Integer businessId;

    /**
     * 二级分类id
     */
    @Schema(description = "二级分类id")
    private Integer cateSecId;

    /**
     * 商品简介
     */
    @Schema(description = "商品简介")
    private String productProfile;

    /**
     * 商品轮播图片
     */
    @Schema(description = "商品轮播图片")
    private List<ProductCarouselImage> productCarouselImages;

    /**
     * 运费
     */
    @Schema(description = "运费")
    private Double freight;

    /**
     * 商品详情图片
     */
    @Schema(description = "商品详情图片")
    private List<ProductDetailImage> productDetailImages;


}

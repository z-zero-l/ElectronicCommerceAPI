package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Accessors(chain = true)
@Data(staticConstructor = "create")
public class ProductVO implements Serializable {
    @Schema(description = "主键")
    private Integer productId;
    @Schema(description = "商品名称")
    private String productName;
    @Schema(description = "所属店铺")
    private String business;
    @Schema(description = "分类")
    private CategoryVO cate;
    @Schema(description = "商品简介")
    private String productProfile;
    @Schema(description = "商品封面图片")
    private String productCover;
    @Schema(description = "运费")
    private Double freight;
    @Schema(description = "商品状态(1-已上架 2-已下架)")
    private Integer productStatus;
    @Schema(description = "收藏数")
    private Integer collectCount;
    @Schema(description = "是否收藏")
    private Boolean isCollect;
    @Schema(description = "评论数")
    private Integer commentCount;
    @Schema(description = "商品规格")
    private List<ProductSpecVO> productSpec;
    @Schema(description = "商品详情图片")
    private List<ProductImageVO> productDetailImg;
    @Schema(description = "商品轮播图片")
    private List<ProductImageVO> productCarouselImg;
}

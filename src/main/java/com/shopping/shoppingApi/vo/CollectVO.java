package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class CollectVO implements Serializable {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "商品ID")
    private Integer productId;
    @Schema(description = "商品名称")
    private String productName;
    @Schema(description = "店铺ID")
    private Integer businessId;
    @Schema(description = "店铺名称")
    private String businessName;
    @Schema(description = "商品简介")
    private String productProfile;
    @Schema(description = "商品封面图片")
    private String productCover;
    @Schema(description = "商品价格")
    private Double price;
    @Schema(description = "收藏数")
    private Long collectCount;
}

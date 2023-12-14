package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Accessors(chain = true)
@Data(staticConstructor = "create")
public class IndexProductVO implements Serializable {
    @Schema(description = "主键")
    private Integer productId;
    @Schema(description = "商品名称")
    private String productName;
    @Schema(description = "店铺ID")
    private Integer businessId;
    @Schema(description = "所属店铺")
    private String business;
    @Schema(description = "商品封面图片")
    private String productCover;
    @Schema(description = "运费")
    private Double freight;
    @Schema(description = "商品价格")
    private Double price;
    @Schema(description = "是否热门")
    private Boolean isHot;
    @Schema(description = "总销量")
    private Integer totalSaleAmount;
    @Schema(description = "是否新品")
    private Boolean isNew;
    @Schema(description = "是否促销")
    private Boolean isSale;
}

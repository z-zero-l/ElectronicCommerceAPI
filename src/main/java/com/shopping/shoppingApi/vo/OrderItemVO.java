package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class OrderItemVO {
    @Schema(description = "商品规格图片")
    private String specImage;
    @Schema(description = "商品名称")
    private String productName;
    @Schema(description = "商品规格名称")
    private String specName;
    @Schema(description = "数量")
    private Integer amount;
    @Schema(description = "实付款")
    private BigDecimal price;
    @Schema(description = "运费")
    private Double freight;
    @Schema(description = "备注")
    private String remark;
}

package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data(staticConstructor = "create")
public class CartVO implements Serializable {
    @Schema(description = "商品id")
    private Integer productId;
    @Schema(description = "商品规格id")
    private Integer specId;
    @Schema(description = "商品规格名称")
    private String specName;
    @Schema(description = "商品规格图片")
    private String specImg;
    @Schema(description = "数量")
    private Integer quantity;
    @Schema(description = "加入时商品价格")
    private Double joinPrice;
    @Schema(description = "当前售价")
    private Double sellPrice;
    @Schema(description = "商品状态(1-已上架 2-已下架)")
    private Integer productStatus;
    @Schema(description = "是否选中(0-未选中 1-已选中)")
    private Integer selected;
}

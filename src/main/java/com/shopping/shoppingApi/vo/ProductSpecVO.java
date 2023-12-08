package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data(staticConstructor = "create")
public class ProductSpecVO implements Serializable {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "商品规格名称")
    private String specName;
    @Schema(description = "标价")
    private Double listPrice;
    @Schema(description = "售价")
    private Double sellPrice;
    @Schema(description = "库存")
    private Integer stock;
    @Schema(description = "商品规格图片")
    private String specImg;
}

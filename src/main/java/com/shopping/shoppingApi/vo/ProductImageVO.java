package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data(staticConstructor = "create")
public class ProductImageVO {
    @Schema(description = "排序(越小越靠前)")
    private Integer index;
    @Schema(description = "图片地址")
    private String imgUrl;

}

package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data(staticConstructor = "create")
public class CategoryChildVO implements Serializable {
    @Schema(description = "主键")
    private Integer categoryId;
    @Schema(description = "分类名称")
    private String cateName;
    @Schema(description = "分类图标")
    private String cateIcon;
    @Schema(description = "颜色标识")
    private String cateColor;
}

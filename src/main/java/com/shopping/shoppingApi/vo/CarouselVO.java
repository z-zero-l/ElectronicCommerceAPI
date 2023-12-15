package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class CarouselVO {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "图片地址")
    private String imgUrl;
    @Schema(description = "链接地址")
    private String hrefUrl;
}

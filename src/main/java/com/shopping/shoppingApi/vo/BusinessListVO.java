package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class BusinessListVO {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "店铺名称")
    private String businessName;
    @Schema(description = "店铺简介")
    private String businessProfile;
    @Schema(description = "店铺头像")
    private String businessAvatar;
    @Schema(description = "开店年数")
    private Integer businessYears;
}

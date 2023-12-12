package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class BusinessVO {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "店铺名称")
    private String businessName;
    @Schema(description = "店铺联系方式")
    private String businessPhone;
    @Schema(description = "店铺简介")
    private String businessProfile;
    @Schema(description = "店铺头像")
    private String businessAvatar;
    @Schema(description = "商品列表")
    private List<IndexProductVO> productList;
}

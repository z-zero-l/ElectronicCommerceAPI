package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class AddressVO {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "收件人")
    private String receiver;
    @Schema(description = "联系方式")
    private String contact;
    @Schema(description = "省份编码")
    private Integer provinceCode;
    @Schema(description = "城市编码")
    private Integer cityCode;
    @Schema(description = "区县编码")
    private Integer districtCode;
    @Schema(description = "详细地址")
    private String address;
    @Schema(description = "默认地址(0-非默认 1-是默认)")
    private Integer isDefault;
}

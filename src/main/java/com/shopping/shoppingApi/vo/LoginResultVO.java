package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginResultVO {
    @Schema(description = "登录token")
    private String token;
    @Schema(description = "头像")
    private String avatar;

}
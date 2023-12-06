package com.shopping.shoppingApi.vo;

import com.mybatisflex.annotation.ColumnMask;
import com.mybatisflex.core.mask.Masks;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginResultVO {
    @Schema(description = "用户id")
    private Integer id;
    @Schema(description = "用户名")
    private String userName;
    @Schema(description = "账号")
    private String account;
    @Schema(description = "手机号")
    private String mobile;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "登录token")
    private String token;
    @Schema(description = "头像")
    private String avatar;

}
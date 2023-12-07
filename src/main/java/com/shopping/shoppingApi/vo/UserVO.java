package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserVO {
    @Schema(description = "登录token")
    private String token;
    @Schema(description = "用户名")
    private String userName;
    @Schema(description = "账号")
    private String account;
    @Schema(description = "性别(0-男 1-女)")
    private Integer gender;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "联系方式")
    private String phone;
    @Schema(description = "生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthday;
    @Schema(description = "个人简介")
    private String profile;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "省份编码")
    private Integer provinceCode;
    @Schema(description = "城市编码")
    private Integer cityCode;
    @Schema(description = "区县编码")
    private Integer districtCode;
    @Schema(description = "注册天数")
    private Integer registerDays;
}

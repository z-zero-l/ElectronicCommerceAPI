package com.shopping.shoppingApi.vo;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
    /**
     * 登录token
     */
    @Schema(description = "登录token")
    private String token;

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Long userId;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String userName;

    /**
     * 账号
     */
    @Schema(description = "账号")
    private String account;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

    @Schema(description = "确认密码")
    private String confirmPassword;

    /**
     * 性别(0-男 1-女)
     */
    @Schema(description = "性别(0-男 1-女)")
    private Integer gender;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 联系方式
     */
    @Schema(description = "联系方式")
    private String phone;

    /**
     * 生日
     */
    @Schema(description = "生日")
    private LocalDateTime birthday;

    /**
     * 个人简介
     */
    @Schema(description = "个人简介")
    private String profile;

    /**
     * 头像
     */
    @Schema(description = "头像")
    private String avatar;

    /**
     * 省份编码
     */
    @Schema(description = "省份编码")
    private Integer provinceCode;

    /**
     * 城市编码
     */
    @Schema(description = "城市编码")
    private Integer cityCode;

    /**
     * 区县编码
     */
    @Schema(description = "区县编码")
    private Integer districtCode;
}

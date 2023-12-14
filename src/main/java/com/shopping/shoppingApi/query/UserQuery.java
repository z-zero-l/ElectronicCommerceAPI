package com.shopping.shoppingApi.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class UserQuery {
    @Null(message = "用户名不能为空")
    private String userName;
    @Null(message = "账号不能为空")
    private String account;
    private Integer gender;
    private String email;
    private String phone;
    private String birthday;
    private String profile;
    private String avatar;
    private Integer provinceCode;
    private Integer cityCode;
    private Integer districtCode;
    private Integer registerDays;
}

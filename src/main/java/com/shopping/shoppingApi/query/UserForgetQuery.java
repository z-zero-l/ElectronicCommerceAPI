package com.shopping.shoppingApi.query;

import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class UserForgetQuery {
    @Null(message = "账号不能为空")
    private String account;
    @Null(message = "用户名不能为空")
    private String userName;
    @Null(message = "密码不能为空")
    private String password;
    @Null(message = "确认密码不能为空")
    private String confirmPassword;
}

package com.shopping.shoppingApi.query;

import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class UserLoginQuery {
    @Null(message = "账号不能为空")
    private String account;
    @Null(message = "密码不能为空")
    private String password;
}

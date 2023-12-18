package com.shopping.shoppingApi.query;

import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class OrderQuery {
    @Null(message = "购物车id不能为空")
    private Integer cartId;
    private String remark;
}

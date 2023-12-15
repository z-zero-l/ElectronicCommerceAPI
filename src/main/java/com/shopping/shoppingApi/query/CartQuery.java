package com.shopping.shoppingApi.query;

import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CartQuery {
    @Null(message = "商品规格id不能为空")
    private Integer id;
    @Null(message = "加入购物车数量不能为空")
    private Integer count;
}

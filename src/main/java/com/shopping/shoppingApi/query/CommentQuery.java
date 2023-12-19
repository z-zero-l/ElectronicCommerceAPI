package com.shopping.shoppingApi.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CommentQuery {
    @Schema(description = "订单项ID")
    @Null(message = "订单项ID不能为空")
    private Integer orderItemId;
    @Schema(description = "评价内容")
    @Null(message = "评价内容不能为空")
    private String commentContent;
}

package com.shopping.shoppingApi.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CommentQuery {
    @Schema(description = "商品ID")
    @Null(message = "商品ID不能为空")
    private Integer productId;
    @Schema(description = "评论内容")
    @Null(message = "评论内容不能为空")
    private String commentContent;
    @Schema(description = "回复评论id(0-非回复)")
    private Integer toCommentId;
}

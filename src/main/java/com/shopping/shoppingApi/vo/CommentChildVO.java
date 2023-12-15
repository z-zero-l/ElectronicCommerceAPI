package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class CommentChildVO {
    @Schema(description = "主键")
    private Integer commentId;
    @Schema(description = "用户名")
    private String userName;
    @Schema(description = "用户头像")
    private String avatar;
    @Schema(description = "评论内容")
    private String commentContent;
    @Schema(description = "评论时间")
    private String createTime;
}

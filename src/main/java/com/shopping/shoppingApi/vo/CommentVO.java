package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class CommentVO {
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
    @Schema(description = "回复列表")
    private List<CommentChildVO> replyList;
}

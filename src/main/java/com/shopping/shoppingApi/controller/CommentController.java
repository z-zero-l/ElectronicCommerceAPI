package com.shopping.shoppingApi.controller;

import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.service.CommentService;
import com.shopping.shoppingApi.vo.CommentVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 评论 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "评论接口")
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;

    /**
     * 获取评论列表
     *
     * @param productId 商品id
     * @return 评论列表
     */
    @GetMapping("/list")
    @Operation(summary = "获取评论列表",description = "获取评论列表")
    public ResponseEntity<Result<List<CommentVO>>> list(@Parameter(description = "商品id") Integer productId) {
        return Result.ok(commentService.getCommentList(productId)).responseEntity();
    }
}

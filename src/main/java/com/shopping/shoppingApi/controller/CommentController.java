package com.shopping.shoppingApi.controller;

import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.query.CommentQuery;
import com.shopping.shoppingApi.service.CommentService;
import com.shopping.shoppingApi.vo.CommentVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shopping.shoppingApi.common.utils.ObtainUserIdUtils.getUserId;

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

    @Resource
    private HttpServletRequest request;

    /**
     * 获取评论列表
     *
     * @param productId 商品id
     * @return 评论列表
     */
    @GetMapping("/list")
    @Operation(summary = "获取评论列表", description = "获取评论列表")
    public ResponseEntity<Result<List<CommentVO>>> list(@Parameter(description = "商品id") Integer productId) {
        return Result.ok(commentService.getCommentList(productId)).responseEntity();
    }

    /**
     * 添加评论
     *
     * @param commentQuery 评论信息
     */
    @PostMapping("/add")
    @Operation(summary = "添加评论", description = "添加评论")
    public ResponseEntity<Result<Void>> add(@RequestBody CommentQuery commentQuery) {
        return Result.ok(commentService.addComment(getUserId(request), commentQuery)).responseEntity();
    }
}

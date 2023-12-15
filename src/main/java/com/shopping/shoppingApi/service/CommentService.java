package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Comment;
import com.shopping.shoppingApi.query.CommentQuery;
import com.shopping.shoppingApi.vo.CommentVO;

import java.util.List;

import static com.shopping.shoppingApi.entity.table.CommentTableDef.COMMENT;

/**
 * 评论 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface CommentService extends IService<Comment> {

    /**
     * 获取评论列表
     *
     * @param productId 商品id
     * @return 评论列表
     */
    List<CommentVO> getCommentList(Integer productId);

    /**
     * 添加评论
     *
     * @param userId 用户id
     * @param commentQuery 评论信息
     */
    Void addComment(Integer userId, CommentQuery commentQuery);
}

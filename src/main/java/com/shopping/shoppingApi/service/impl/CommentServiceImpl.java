package com.shopping.shoppingApi.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Comment;
import com.shopping.shoppingApi.entity.User;
import com.shopping.shoppingApi.mapper.CommentMapper;
import com.shopping.shoppingApi.mapper.UserMapper;
import com.shopping.shoppingApi.query.CommentQuery;
import com.shopping.shoppingApi.service.CommentService;
import com.shopping.shoppingApi.vo.CommentChildVO;
import com.shopping.shoppingApi.vo.CommentVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.shopping.shoppingApi.entity.table.CommentTableDef.COMMENT;

/**
 * 评论 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    private UserMapper userMapper;

    /**
     * 获取评论列表
     *
     * @param productId 商品id
     * @return 评论列表
     */
    @Override
    public List<CommentVO> getCommentList(Integer productId) {
        if (productId == null) {
            throw new ServerException("商品id不能为空");
        }
        ArrayList<CommentVO> commentVOS = new ArrayList<>();
        list(QueryChain.create().where(COMMENT.PRODUCT_ID.eq(productId)).where(COMMENT.TO_COMMENT_ID.eq(0)).orderBy(COMMENT.CREATE_TIME.desc()))
                .forEach(comment -> {
                    ArrayList<CommentChildVO> commentChildVOS = new ArrayList<>();
                    list(QueryChain.create().where(COMMENT.TO_COMMENT_ID.eq(comment.getCommentId())).orderBy(COMMENT.CREATE_TIME.desc()))
                            .forEach(commentChild -> {
                                User user = userMapper.selectOneById(commentChild.getUserId());
                                commentChildVOS.add(CommentChildVO.create()
                                        .setCommentId(commentChild.getCommentId())
                                        .setUserName(user.getUserName())
                                        .setAvatar(user.getAvatar())
                                        .setCommentContent(commentChild.getCommentContent())
                                        .setCreateTime(LocalDateTimeUtil.format(commentChild.getCreateTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME) + " " + LocalDateTimeUtil.format(comment.getCreateTime(), DateTimeFormatter.ISO_LOCAL_TIME)));
                            });
                    User user = userMapper.selectOneById(comment.getUserId());
                    commentVOS.add(CommentVO.create()
                            .setCommentId(comment.getCommentId())
                            .setUserName(user.getUserName())
                            .setAvatar(user.getAvatar())
                            .setCommentContent(comment.getCommentContent())
                            .setCreateTime(LocalDateTimeUtil.format(comment.getCreateTime(), DateTimeFormatter.ISO_LOCAL_DATE) + " " + LocalDateTimeUtil.format(comment.getCreateTime(), DateTimeFormatter.ISO_LOCAL_TIME))
                            .setReplyList(commentChildVOS));
                });
        return commentVOS;
    }
}

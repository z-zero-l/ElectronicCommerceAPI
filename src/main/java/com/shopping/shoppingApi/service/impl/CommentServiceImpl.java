package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Comment;
import com.shopping.shoppingApi.mapper.CommentMapper;
import com.shopping.shoppingApi.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * 评论 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}

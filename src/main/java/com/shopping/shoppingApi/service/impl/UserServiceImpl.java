package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.User;
import com.shopping.shoppingApi.mapper.UserMapper;
import com.shopping.shoppingApi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.User;
import com.shopping.shoppingApi.query.UserLoginQuery;
import com.shopping.shoppingApi.query.UserRegisterQuery;
import com.shopping.shoppingApi.vo.LoginResultVO;
import com.shopping.shoppingApi.vo.UserVO;

/**
 * 用户信息表 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface UserService extends IService<User> {
    /**
     * 注册
     *
     * @param userRegisterQuery
     * @return
     */
    Integer register(UserRegisterQuery userRegisterQuery);

    /**
     * 登录
     * @param userLoginQuery
     * @return
     */
    LoginResultVO login(UserLoginQuery userLoginQuery);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserVO getUserInfo(Integer userId);
}

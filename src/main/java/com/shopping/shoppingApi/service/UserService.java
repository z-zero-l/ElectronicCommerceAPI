package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.User;
import com.shopping.shoppingApi.query.UserLoginQuery;
import com.shopping.shoppingApi.query.UserQuery;
import com.shopping.shoppingApi.query.UserRegisterQuery;
import com.shopping.shoppingApi.vo.LoginResultVO;
import com.shopping.shoppingApi.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

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
     * @param userRegisterQuery 用户注册信息
     */
    Void register(UserRegisterQuery userRegisterQuery);

    /**
     * 登录
     *
     * @param userLoginQuery 用户登录信息
     * @return 用户授权和头像信息
     */
    LoginResultVO login(UserLoginQuery userLoginQuery);

    /**
     * 获取用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    UserVO getUserInfo(Integer userId);

    /**
     * 获取用户头像
     *
     * @param userId 用户ID
     * @return 用户头像地址
     */
    String getUserAvatar(Integer userId);

    /**
     * 编辑用户信息
     *
     * @param userQuery 用户信息
     * @return 用户信息
     */
    Void editUserInfo(Integer userId, UserQuery userQuery);

    /**
     * 编辑用户头像
     *
     * @param userId 用户ID
     * @param file   头像文件
     * @return 用户头像地址
     */
    String editUserAvatar(Integer userId, MultipartFile file);
}

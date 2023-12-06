package com.shopping.shoppingApi.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SmUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.common.utils.JWTUtils;
import com.shopping.shoppingApi.constant.APIConstant;
import com.shopping.shoppingApi.entity.User;
import com.shopping.shoppingApi.mapper.UserMapper;
import com.shopping.shoppingApi.query.UserLoginQuery;
import com.shopping.shoppingApi.query.UserRegisterQuery;
import com.shopping.shoppingApi.service.RedisService;
import com.shopping.shoppingApi.service.UserService;
import com.shopping.shoppingApi.vo.LoginResultVO;
import com.shopping.shoppingApi.vo.UserTokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.shopping.shoppingApi.constant.APIConstant.*;
import static com.shopping.shoppingApi.entity.table.UserTableDef.USER;

/**
 * 用户信息表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    /**
     * 注册
     *
     * @param userRegisterQuery
     * @return
     */
    @Override
    public Integer register(UserRegisterQuery userRegisterQuery) {
        System.out.println(userRegisterQuery);
        if (userRegisterQuery != null) {
            User user = User.create();
            if (exists(new QueryWrapper().eq("account", userRegisterQuery.getAccount()))) {
                throw new ServerException("账号已存在");
            }
            if (userRegisterQuery.getAccount().isEmpty()) {
                throw new ServerException("账号不能为空");
            } else {
                user.setAccount(userRegisterQuery.getAccount());
            }
            if (userRegisterQuery.getPassword().isEmpty()) {
                throw new ServerException("密码不能为空");
            }
            if (userRegisterQuery.getConfirmPassword().isEmpty()) {
                throw new ServerException("确认密码不能为空");
            }
            if (!userRegisterQuery.getPassword().equals(userRegisterQuery.getConfirmPassword())) {
                throw new ServerException("两次密码不一致");
            } else {
                // 加密密码
                user.setPassword(SmUtil.sm3(PASSWORD_SALT + userRegisterQuery.getPassword()));
            }
            user.setUserName("用户" + RandomUtil.randomNumbers(5));
            user.setAvatar(APIConstant.DEFAULT_AVATAR);
            super.save(user);
            return user.getUserId();
        }
        return null;
    }

    /**
     * 登录
     * @param userLoginQuery
     * @return
     */
    @Override
    public LoginResultVO login(UserLoginQuery userLoginQuery) {
        // 加密密码
        String password = SmUtil.sm3(PASSWORD_SALT + userLoginQuery.getPassword());
        // 查询用户
        User user = userMapper.selectOneByQuery(QueryWrapper.create().select(USER.USER_ID, USER.PASSWORD).eq("account", userLoginQuery.getAccount()).eq("password", password));
        if (user == null) {
            throw new ServerException("账号或密码错误");
        }
        LoginResultVO userVO = new LoginResultVO();
        userVO.setId(user.getUserId());
        userVO.setMobile(user.getPhone());
        userVO.setAvatar(user.getAvatar());
        userVO.setAccount(user.getAccount());
        UserTokenVO tokenVO = new UserTokenVO(userVO.getId());
        // 生成token
        String token = JWTUtils.generateToken(JWT_SECRET, tokenVO.toMap());
        // 保存token
        redisService.set(APP_NAME+userVO.getId(), token, TOKEN_EXPIRE_TIME);
        userVO.setToken(token);
        return userVO;

    }
}

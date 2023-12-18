package com.shopping.shoppingApi.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SmUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.mybatisflex.core.mask.MaskManager;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.common.utils.AliyunResource;
import com.shopping.shoppingApi.common.utils.FileResource;
import com.shopping.shoppingApi.common.utils.JWTUtils;
import com.shopping.shoppingApi.constant.APIConstant;
import com.shopping.shoppingApi.entity.User;
import com.shopping.shoppingApi.mapper.UserMapper;
import com.shopping.shoppingApi.query.UserForgetQuery;
import com.shopping.shoppingApi.query.UserLoginQuery;
import com.shopping.shoppingApi.query.UserRegisterQuery;
import com.shopping.shoppingApi.service.RedisService;
import com.shopping.shoppingApi.service.UserService;
import com.shopping.shoppingApi.vo.LoginResultVO;
import com.shopping.shoppingApi.vo.UserTokenVO;
import com.shopping.shoppingApi.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;

import static com.shopping.shoppingApi.constant.APIConstant.*;
import static com.shopping.shoppingApi.entity.table.UserTableDef.USER;

/**
 * 用户信息表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final RedisService redisService;
    private final AliyunResource aliyunResource;
    private final FileResource fileResource;

    /**
     * 注册
     *
     * @param userRegisterQuery 用户注册信息
     */
    @Override
    public Void register(UserRegisterQuery userRegisterQuery) {
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
        }
        return null;
    }

    /**
     * 登录
     *
     * @param userLoginQuery 用户登录信息
     * @return 用户授权和头像信息
     */
    @Override
    public LoginResultVO login(UserLoginQuery userLoginQuery) {
        // 加密密码
        String password = SmUtil.sm3(PASSWORD_SALT + userLoginQuery.getPassword());
        // 查询用户
        if (!exists(new QueryWrapper().eq("account", userLoginQuery.getAccount()).eq("password", password))) {
            throw new ServerException("账号或密码错误");
        }
        User user = super.getOne(QueryWrapper.create().eq("account", userLoginQuery.getAccount()).eq("password", password));
        LoginResultVO userVO = new LoginResultVO();
        userVO.setAvatar(user.getAvatar());
        UserTokenVO tokenVO = new UserTokenVO(user.getUserId());
        // 生成token
        String token = JWTUtils.generateToken(JWT_SECRET, tokenVO.toMap());
        // 保存token
        redisService.set(APP_NAME + user.getUserId(), token, TOKEN_EXPIRE_TIME);
        userVO.setToken(token);
        return userVO;

    }

    /**
     * 忘记密码
     *
     * @param userForgetQuery 用户忘记密码信息
     */
    @Override
    public Void forgetPassword(UserForgetQuery userForgetQuery) {
        User user = getOne(QueryChain.create().where(USER.ACCOUNT.eq(userForgetQuery.getAccount())).where(USER.USER_NAME.eq(userForgetQuery.getUserName())));
        if (user == null) {
            throw new ServerException("账号或用户名错误");
        }
        if (!userForgetQuery.getPassword().equals(userForgetQuery.getConfirmPassword())) {
            throw new ServerException("两次密码不一致");
        }
        user.setPassword(SmUtil.sm3(PASSWORD_SALT + userForgetQuery.getPassword()));
        if (!updateById(user)) {
            throw new ServerException("修改密码失败");
        }
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    @Override
    public UserVO getUserInfo(Integer userId) {
        User user;
        try {
            MaskManager.skipMask();
            //此处查询到的数据不会进行脱敏处理
            user = super.getById(userId);
        } finally {
            MaskManager.restoreMask();
        }

        if (user != null) {
            UserVO userVO = UserVO.create();
            userVO.setUserName(user.getUserName());
            userVO.setAccount(user.getAccount());
            userVO.setEmail(user.getEmail());
            userVO.setPhone(user.getPhone());
            userVO.setGender(user.getGender());
            userVO.setProfile(user.getProfile());
            userVO.setAvatar(user.getAvatar());
            userVO.setBirthday(LocalDateTimeUtil.format(user.getBirthday(), DateTimeFormatter.ISO_LOCAL_DATE));
            userVO.setRegisterDays(user.getCreateTime().toLocalDate().until(user.getUpdateTime().toLocalDate()).getDays());
            return userVO;
        } else {
            throw new ServerException("用户不存在");
        }
    }

    /**
     * 获取用户头像
     *
     * @param userId 用户ID
     * @return 用户头像地址
     */
    @Override
    public String getUserAvatar(Integer userId) {
        if (exists(new QueryWrapper().eq("user_id", userId))) {
            return (String) super.getObj(new QueryWrapper().select("avatar").eq("user_id", userId));
        } else {
            throw new ServerException("用户不存在");
        }
    }

    /**
     * 编辑用户信息
     *
     * @param userVO 用户信息
     * @return 用户信息
     */
    @Override
    public Void editUserInfo(Integer userId, UserVO userVO) {
        if (!exists(new QueryWrapper().eq("user_id", userId))) {
            throw new ServerException("用户不存在");
        }
        User user = User.create().setUserId(userId);
        if (userVO.getUserName() != null) {
            user.setUserName(userVO.getUserName());
        }
        if (userVO.getAccount() != null) {
            user.setAccount(userVO.getAccount());
        }
        if (userVO.getGender() != null) {
            user.setGender(userVO.getGender());
        }
        if (userVO.getEmail() != null) {
            user.setEmail(userVO.getEmail());
        }
        if (userVO.getPhone() != null) {
            user.setPhone(userVO.getPhone());
        }
        if (userVO.getBirthday() != null) {
            user.setBirthday(LocalDateTimeUtil.parse(userVO.getBirthday()+"T00:00:00"));
        }
        if (userVO.getProfile() != null) {
            user.setProfile(userVO.getProfile());
        }
        if (userVO.getProvinceCode() != null && userVO.getCityCode() != null && userVO.getDistrictCode() != null) {
            user.setProvinceCode(userVO.getProvinceCode()).setCityCode(userVO.getCityCode()).setDistrictCode(userVO.getDistrictCode());
        }
        if (!updateById(user)) {
            throw new ServerException("修改失败");
        }
        return null;
    }

    /**
     * 编辑用户头像
     *
     * @param userId 用户ID
     * @param file   头像文件
     * @return 用户头像地址
     */
    @Override
    public String editUserAvatar(Integer userId, MultipartFile file) {
        if (!exists(new QueryWrapper().eq("user_id", userId))) {
            throw new ServerException("用户不存在");
        }
        String endpoint = fileResource.getEndpoint();
        String accessKeyId = aliyunResource.getAccessKeyId();
        String accessKeySecret = aliyunResource.getAccessKeySecret();

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String filename = file.getOriginalFilename();
        assert filename != null;
        String[] fileNameArr = filename.split("\\.");
        String suffix = fileNameArr[fileNameArr.length - 1];
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new ServerException("文件上传失败");
        }
        String uploadFileName = "avatar/" + SmUtil.sm3(inputStream) + "." + suffix;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new ServerException("文件上传失败");
        }
        ossClient.putObject(fileResource.getBucketName(), uploadFileName, inputStream);
        ossClient.shutdown();
        User user = User.create().setUserId(userId);
        uploadFileName = fileResource.getOssHost() + uploadFileName;
        user.setAvatar(uploadFileName);
        updateById(user);
        return uploadFileName;
    }
}

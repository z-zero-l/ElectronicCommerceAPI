package com.shopping.shoppingApi.controller;

import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.query.UserForgetQuery;
import com.shopping.shoppingApi.query.UserLoginQuery;
import com.shopping.shoppingApi.query.UserRegisterQuery;
import com.shopping.shoppingApi.service.UserService;
import com.shopping.shoppingApi.vo.LoginResultVO;
import com.shopping.shoppingApi.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.shopping.shoppingApi.common.utils.ObtainUserIdUtils.getUserId;

/**
 * 用户信息表 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "用户模块")
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @Resource
    private HttpServletRequest request;

    /**
     * 注册
     *
     * @param user 用户注册信息
     * @return 用户id
     */
    @PostMapping("register")
    @Operation(summary = "注册", description = "注册")
    public ResponseEntity<Result<Void>> register(@RequestBody @Parameter(description = "用户信息表") UserRegisterQuery user) {
        return Result.ok(userService.register(user)).responseEntity();
    }

    /**
     * 登录
     *
     * @param user 用户登录信息
     * @return 用户授权和头像
     */
    @PostMapping("login")
    @Operation(summary = "登录", description = "登录")
    public ResponseEntity<Result<LoginResultVO>> login(@RequestBody @Parameter(description = "用户信息表") UserLoginQuery user) {
        return Result.ok(userService.login(user)).responseEntity();
    }

    /**
     * 忘记密码
     *
     * @param userForgetQuery 用户忘记密码信息
     */
    @PostMapping("forget")
    @Operation(summary = "忘记密码", description = "忘记密码")
    public ResponseEntity<Result<Void>> forget(@RequestBody @Parameter(description = "用户忘记密码信息") UserForgetQuery userForgetQuery) {
        return Result.ok(userService.forgetPassword(userForgetQuery)).responseEntity();
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/profile")
    @Operation(summary = "用户详情", description = "根据用户id获取用户信息")
    private ResponseEntity<Result<UserVO>> getUserInfo() {
        Integer userId = getUserId(request);
        UserVO userInfo = userService.getUserInfo(userId);
        return Result.ok(userInfo).responseEntity();
    }

    /**
     * 获取用户头像
     *
     * @return 用户头像
     */
    @GetMapping("/profile/avatar")
    @Operation(summary = "获取用户头像", description = "根据用户id获取用户头像")
    private ResponseEntity<Result<String>> getUserAvatar() {
        return Result.ok(userService.getUserAvatar(getUserId(request))).responseEntity();
    }

    /**
     * 修改用户信息
     *
     * @param userVO 用户信息
     * @return 用户信息
     */
    @PutMapping("/profile")
    @Operation(summary = "修改用户信息", description = "修改用户信息")
    private ResponseEntity<Result<Void>> editUserInfo(@RequestBody @Validated UserVO userVO) {
        Integer userId = getUserId(request);
        return Result.ok(userService.editUserInfo(userId, userVO)).responseEntity();
    }

    /**
     * 修改用户头像
     *
     * @param file 头像文件
     * @return 头像地址
     */
    @PostMapping("/profile/avatar")
    @Operation(summary = "修改用户头像", description = "修改用户头像")
    private ResponseEntity<Result<String>> editUserAvatar(MultipartFile file) {
        Integer userId = getUserId(request);
        String uploadFileName = userService.editUserAvatar(userId, file);
        return Result.ok(uploadFileName).responseEntity();
    }

}

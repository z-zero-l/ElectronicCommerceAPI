package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.User;
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

import java.io.Serializable;
import java.util.List;

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
    @Operation(summary = "注册接口", description = "注册接口")
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
    @Operation(summary = "登录接口", description = "登录接口")
    public ResponseEntity<Result<LoginResultVO>> login(@RequestBody @Parameter(description = "用户信息表") UserLoginQuery user) {
        return Result.ok(userService.login(user)).responseEntity();
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
    @Operation(summary = "修改用户信息")
    @PutMapping("/profile")
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
    @Operation(summary = "修改用户头像")
    @PostMapping("/profile/avatar")
    private ResponseEntity<Result<String>> editUserAvatar(MultipartFile file) {
        Integer userId = getUserId(request);
        String uploadFileName = userService.editUserAvatar(userId, file);
        return Result.ok(uploadFileName).responseEntity();
    }

    /**
     * 添加用户信息表。
     *
     * @param user 用户信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存用户信息表")
    public boolean save(@RequestBody @Parameter(description = "用户信息表") User user) {
        return userService.save(user);
    }

    /**
     * 根据主键删除用户信息表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description = "根据主键用户信息表")
    public boolean remove(@PathVariable @Parameter(description = "用户信息表主键") Serializable id) {
        return userService.removeById(id);
    }

    /**
     * 根据主键更新用户信息表。
     *
     * @param user 用户信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新用户信息表")
    public boolean update(@RequestBody @Parameter(description = "用户信息表主键") User user) {
        return userService.updateById(user);
    }

    /**
     * 查询所有用户信息表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description = "查询所有用户信息表")
    public List<User> list() {
        return userService.list();
    }

    /**
     * 根据用户信息表主键获取详细信息。
     *
     * @param id 用户信息表主键
     * @return 用户信息表详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description = "根据主键获取用户信息表")
    public User getInfo(@PathVariable Serializable id) {
        return userService.getById(id);
    }

    /**
     * 分页查询用户信息表。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询用户信息表")
    public Page<User> page(@Parameter(description = "分页信息") Page<User> page) {
        return userService.page(page);
    }

}

package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.query.UserLoginQuery;
import com.shopping.shoppingApi.query.UserRegisterQuery;
import com.shopping.shoppingApi.vo.LoginResultVO;
import com.shopping.shoppingApi.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopping.shoppingApi.entity.User;
import com.shopping.shoppingApi.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

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
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("register")
    @Operation(summary = "注册接口",description = "注册接口")
    public ResponseEntity<Result<Integer>> register(@RequestBody @Parameter(description = "用户信息表") UserRegisterQuery user) {
        return Result.ok(userService.register(user)).responseEntity();
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping("login")
    @Operation(summary = "登录接口",description = "登录接口")
    public ResponseEntity<Result<LoginResultVO>> login(@RequestBody @Parameter(description = "用户信息表") UserLoginQuery user) {
        return Result.ok(userService.login(user)).responseEntity();
    }

    @GetMapping("/profile")
    @Operation(summary = "用户详情",description = "根据用户id获取用户信息")
    private ResponseEntity<Result<UserVO>> getUserInfo(HttpServletRequest request) {
        Integer userId = getUserId(request);
        UserVO userInfo = userService.getUserInfo(userId);
        return Result.ok(userInfo).responseEntity();
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

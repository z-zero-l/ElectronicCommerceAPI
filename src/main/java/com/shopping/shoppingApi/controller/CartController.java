package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Cart;
import com.shopping.shoppingApi.service.CartService;
import com.shopping.shoppingApi.vo.CartVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static com.shopping.shoppingApi.common.utils.ObtainUserIdUtils.getUserId;

/**
 * 购物车 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "购物车模块")
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private CartService cartService;

    @Resource
    private HttpServletRequest request;

    /**
     * 获取购物车列表。
     *
     * @return 购物车列表
     */
    @GetMapping("list")
    @Operation(summary = "获取购物车列表", description = "根据用户id获取购物车列表")
    public ResponseEntity<Result<List<CartVO>>> getCartList() {
        return Result.ok(cartService.getCartList(getUserId(request))).responseEntity();
    }

    /**
     * 更新购物车物品
     *
     * @param cartVO 购物车信息
     * @return 更新结果
     */
    @PutMapping("update")
    @Operation(summary = "更新购物车物品", description = "根据购物车id更新购物车物品")
    public ResponseEntity<Result<Void>> updateCart(@RequestBody CartVO cartVO) {
        return Result.ok(cartService.updateCart(getUserId(request), cartVO)).responseEntity();
    }

    /**
     * 添加购物车。
     *
     * @param cart 购物车
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存购物车")
    public boolean save(@RequestBody @Parameter(description = "购物车") Cart cart) {
        return cartService.save(cart);
    }

    /**
     * 删除购物车商品。
     *
     * @param cartId 主键
     */
    @DeleteMapping("remove")
    @Operation(description = "删除购物车商品",summary = "根据购物车id删除购物车商品")
    public ResponseEntity<Result<Void>> remove(@RequestParam Integer cartId) {
        return Result.ok(cartService.deleteCartItem(getUserId(request),cartId)).responseEntity();
    }

//    /**
//     * 根据主键删除购物车。
//     *
//     * @param id 主键
//     * @return {@code true} 删除成功，{@code false} 删除失败
//     */
//    @DeleteMapping("remove/{id}")
//    @Operation(description = "根据主键购物车")
//    public boolean remove(@PathVariable @Parameter(description = "购物车主键") Serializable id) {
//        return cartService.removeById(id);
//    }

//    /**
//     * 根据主键更新购物车。
//     *
//     * @param cart 购物车
//     * @return {@code true} 更新成功，{@code false} 更新失败
//     */
//    @PutMapping("update")
//    @Operation(description = "根据主键更新购物车")
//    public boolean update(@RequestBody @Parameter(description = "购物车主键") Cart cart) {
//        return cartService.updateById(cart);
//    }

//    /**
//     * 查询所有购物车。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    @Operation(description = "查询所有购物车")
//    public List<Cart> list() {
//        return cartService.list();
//    }

    /**
     * 根据购物车主键获取详细信息。
     *
     * @param id 购物车主键
     * @return 购物车详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description = "根据主键获取购物车")
    public Cart getInfo(@PathVariable Serializable id) {
        return cartService.getById(id);
    }

    /**
     * 分页查询购物车。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询购物车")
    public Page<Cart> page(@Parameter(description = "分页信息") Page<Cart> page) {
        return cartService.page(page);
    }

}

package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Cart;
import com.shopping.shoppingApi.query.CartQuery;
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
    @Operation(summary = "获取购物车列表", description = "根据用户id和商品选中状态获取购物车列表")
    public ResponseEntity<Result<List<CartVO>>> getCartList(@RequestParam(required = false) Integer selected) {
        return Result.ok(cartService.getCartList(getUserId(request), selected)).responseEntity();
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
     * 删除购物车商品。
     *
     * @param cartId 主键
     */
    @DeleteMapping("remove")
    @Operation(description = "删除购物车商品",summary = "根据购物车id删除购物车商品")
    public ResponseEntity<Result<Void>> remove(@RequestParam Integer cartId) {
        return Result.ok(cartService.deleteCartItem(getUserId(request),cartId)).responseEntity();
    }

    /**
     * 添加购物车
     *
     * @param cartQuery 购物车信息
     */
    @PostMapping("add")
    @Operation(summary = "添加购物车", description = "添加购物车")
    public ResponseEntity<Result<Void>> addCart(@RequestBody CartQuery cartQuery) {
        return Result.ok(cartService.addCart(getUserId(request), cartQuery)).responseEntity();
    }
}

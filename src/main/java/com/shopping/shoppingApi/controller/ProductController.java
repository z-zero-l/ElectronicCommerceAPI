package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.service.ProductService;
import com.shopping.shoppingApi.vo.IndexProductVO;
import com.shopping.shoppingApi.vo.ProductVO;
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
 * 商品表 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "商品模块")
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @Resource
    private HttpServletRequest request;

    /**
     * 获取商品详情
     */
    @GetMapping("info/{id}")
    @Operation(description = "根据主键获取商品信息", summary = "获取商品信息")
    public ResponseEntity<Result<ProductVO>> getGoodsDetail(@PathVariable Integer id) {
        return Result.ok(productService.getProductInfo(id, getUserId(request))).responseEntity();
    }

    /**
     * 获取首页商品列表
     *
     * @return 首页商品列表
     */
    @GetMapping("indexList")
    @Operation(description = "首页商品列表", summary = "查询首页列表")
    public ResponseEntity<Result<List<IndexProductVO>>> getIndexProductList() {
        return Result.ok(productService.getProductList(null)).responseEntity();
    }

    /**
     * 根据二级分类获取商品列表
     *
     * @param categoryId 二级分类id
     * @return 商品列表
     */
    @GetMapping("category/{categoryId}")
    @Operation(summary = "根据二级分类获取商品列表", description = "根据二级分类获取商品列表")
    public ResponseEntity<Result<List<IndexProductVO>>> getProductListByCategoryId(@PathVariable Integer categoryId) {
        return Result.ok(productService.getProductList(categoryId)).responseEntity();
    }
}

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
    @Operation(description = "查询首页商品", summary = "查询首页商品")
    public ResponseEntity<Result<List<IndexProductVO>>> getIndexProductList() {
        return Result.ok(productService.getIndexProductList()).responseEntity();
    }

    /**
     * 添加商品表。
     *
     * @param product 商品表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存商品表")
    public boolean save(@RequestBody @Parameter(description = "商品表") Product product) {
        return productService.save(product);
    }

    /**
     * 根据主键删除商品表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description = "根据主键商品表")
    public boolean remove(@PathVariable @Parameter(description = "商品表主键") Serializable id) {
        return productService.removeById(id);
    }

    /**
     * 根据主键更新商品表。
     *
     * @param product 商品表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新商品表")
    public boolean update(@RequestBody @Parameter(description = "商品表主键") Product product) {
        return productService.updateById(product);
    }

    /**
     * 查询所有商品表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description = "查询所有商品表")
    public List<Product> list() {
        return productService.list();
    }

//    /**
//     * 根据商品表主键获取详细信息。
//     *
//     * @param id 商品表主键
//     * @return 商品表详情
//     */
//    @GetMapping("getInfo/{id}")
//    @Operation(description="根据主键获取商品表")
//    public Product getInfo(@PathVariable Serializable id) {
//        return productService.getById(id);
//    }

    /**
     * 分页查询商品表。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询商品表")
    public Page<Product> page(@Parameter(description = "分页信息") Page<Product> page) {
        return productService.page(page);
    }

}

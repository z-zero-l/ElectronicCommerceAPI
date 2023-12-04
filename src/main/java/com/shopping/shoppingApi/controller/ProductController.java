package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.service.ProductService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.Serializable;
import java.util.List;

/**
 * 商品表 控制层。
 *
 * @author 18851
 * @since 2023-12-04
 */
@RestController
@Tag(name = "商品表接口")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加商品表。
     *
     * @param product 商品表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description="保存商品表")
    public boolean save(@RequestBody @Parameter(description="商品表")Product product) {
        return productService.save(product);
    }

    /**
     * 根据主键删除商品表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description="根据主键商品表")
    public boolean remove(@PathVariable @Parameter(description="商品表主键")Serializable id) {
        return productService.removeById(id);
    }

    /**
     * 根据主键更新商品表。
     *
     * @param product 商品表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description="根据主键更新商品表")
    public boolean update(@RequestBody @Parameter(description="商品表主键")Product product) {
        return productService.updateById(product);
    }

    /**
     * 查询所有商品表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description="查询所有商品表")
    public List<Product> list() {
        return productService.list();
    }

    /**
     * 根据商品表主键获取详细信息。
     *
     * @param id 商品表主键
     * @return 商品表详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description="根据主键获取商品表")
    public Product getInfo(@PathVariable Serializable id) {
        return productService.getById(id);
    }

    /**
     * 分页查询商品表。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description="分页查询商品表")
    public Page<Product> page(@Parameter(description="分页信息")Page<Product> page) {
        return productService.page(page);
    }

}

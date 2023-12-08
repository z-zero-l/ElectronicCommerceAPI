package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.entity.ProductSpec;
import com.shopping.shoppingApi.service.ProductSpecService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品规格 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "商品规格接口")
@RequestMapping("/productSpec")
@AllArgsConstructor
public class ProductSpecController {
    private ProductSpecService productSpecService;

    /**
     * 添加商品规格。
     *
     * @param productSpec 商品规格
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存商品规格")
    public boolean save(@RequestBody @Parameter(description = "商品规格") ProductSpec productSpec) {
        return productSpecService.save(productSpec);
    }

    /**
     * 根据主键删除商品规格。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description = "根据主键商品规格")
    public boolean remove(@PathVariable @Parameter(description = "商品规格主键") Serializable id) {
        return productSpecService.removeById(id);
    }

    /**
     * 根据主键更新商品规格。
     *
     * @param productSpec 商品规格
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新商品规格")
    public boolean update(@RequestBody @Parameter(description = "商品规格主键") ProductSpec productSpec) {
        return productSpecService.updateById(productSpec);
    }

    /**
     * 查询所有商品规格。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description = "查询所有商品规格")
    public List<ProductSpec> list() {
        return productSpecService.list();
    }

    /**
     * 根据商品规格主键获取详细信息。
     *
     * @param id 商品规格主键
     * @return 商品规格详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description = "根据主键获取商品规格")
    public ProductSpec getInfo(@PathVariable Serializable id) {
        return productSpecService.getById(id);
    }

    /**
     * 分页查询商品规格。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询商品规格")
    public Page<ProductSpec> page(@Parameter(description = "分页信息") Page<ProductSpec> page) {
        return productSpecService.page(page);
    }

}

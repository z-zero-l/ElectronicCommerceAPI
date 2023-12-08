package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Category;
import com.shopping.shoppingApi.service.CategoryService;
import com.shopping.shoppingApi.vo.CategoryChildVO;
import com.shopping.shoppingApi.vo.CategoryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 分类 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "分类模块")
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    /**
     * 分类列表。
     *
     * @return 所有分类
     */
    @GetMapping("list")
    @Operation(summary = "分类列表", description = "查看所有分类列表")
    public ResponseEntity<Result<List<CategoryVO>>> getCategoryList() {
        return Result.ok(categoryService.getCategoryList()).responseEntity();
    }

    /**
     * 一级分类列表。
     *
     * @return 一级分类列表
     */
    @GetMapping("list/first")
    @Operation(summary = "一级分类", description = "查看一级分类列表")
    public ResponseEntity<Result<List<CategoryVO>>> listFirst() {
        return Result.ok(categoryService.getParentCategoryList()).responseEntity();
    }

    @GetMapping("list/second/{parentId}")
    @Operation(summary = "二级分类", description = "查看二级分类列表")
    public ResponseEntity<Result<List<CategoryChildVO>>> listSecond(@PathVariable @Parameter(description = "父级分类id") Integer parentId) {
        return Result.ok(categoryService.getChildCategoryList(parentId)).responseEntity();
    }

    /**
     * 添加分类。
     *
     * @param category 分类
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存分类")
    public boolean save(@RequestBody @Parameter(description = "分类") Category category) {
        return categoryService.save(category);
    }

    /**
     * 根据主键删除分类。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description = "根据主键分类")
    public boolean remove(@PathVariable @Parameter(description = "分类主键") Serializable id) {
        return categoryService.removeById(id);
    }

    /**
     * 根据主键更新分类。
     *
     * @param category 分类
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新分类")
    public boolean update(@RequestBody @Parameter(description = "分类主键") Category category) {
        return categoryService.updateById(category);
    }

//    /**
//     * 查询所有分类。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    @Operation(description = "查询所有分类")
//    public List<Category> list() {
//        return categoryService.list();
//    }

    /**
     * 根据分类主键获取详细信息。
     *
     * @param id 分类主键
     * @return 分类详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description = "根据主键获取分类")
    public Category getInfo(@PathVariable Serializable id) {
        return categoryService.getById(id);
    }

    /**
     * 分页查询分类。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询分类")
    public Page<Category> page(@Parameter(description = "分页信息") Page<Category> page) {
        return categoryService.page(page);
    }

}

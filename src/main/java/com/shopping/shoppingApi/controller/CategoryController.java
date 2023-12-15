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
}

package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Collect;
import com.shopping.shoppingApi.service.CollectService;
import com.shopping.shoppingApi.vo.CategoryVO;
import com.shopping.shoppingApi.vo.CollectVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shopping.shoppingApi.common.utils.ObtainUserIdUtils.getUserId;

/**
 * 收藏 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "收藏模块")
@RequestMapping("/collect")
@AllArgsConstructor
public class CollectController {
    private CollectService collectService;

    @Resource
    private HttpServletRequest request;

    /**
     * 添加收藏
     */
    @PostMapping("add")
    @Operation(description = "添加收藏", summary = "添加收藏")
    public ResponseEntity<Result<Void>> add(@RequestParam Integer productId) {
        return Result.ok(collectService.addCollect(getUserId(request), productId)).responseEntity();
    }

    /**
     * 取消收藏
     */
    @DeleteMapping("cancel")
    @Operation(description = "取消收藏", summary = "取消收藏")
    public ResponseEntity<Result<Void>> cancel(@RequestParam Integer productId) {
        return Result.ok(collectService.cancelCollect(getUserId(request), productId)).responseEntity();
    }

    /**
     * 获取收藏列表
     *
     * @param categoryId 分类id
     * @return 收藏列表
     */
    @GetMapping("list")
    @Operation(summary = "获取收藏列表", description = "根据用户id获取收藏列表")
    public ResponseEntity<Result<List<CollectVO>>> getCollectList(@RequestParam(required = false) Integer categoryId) {
        return Result.ok(collectService.getCollectList(getUserId(request), categoryId)).responseEntity();
    }

    /**
     * 获取收藏分类
     *
     * @return 收藏分类
     */
    @GetMapping("category")
    @Operation(summary = "获取收藏分类", description = "获取收藏分类")
    public ResponseEntity<Result<List<CategoryVO>>> getCategoryList() {
        return Result.ok(collectService.getCategoryList(getUserId(request))).responseEntity();
    }
}

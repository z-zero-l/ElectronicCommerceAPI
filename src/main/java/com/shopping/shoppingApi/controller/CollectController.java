package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Collect;
import com.shopping.shoppingApi.service.CollectService;
import com.shopping.shoppingApi.vo.CollectVO;
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
    @Operation(description = "添加收藏",summary = "添加收藏")
    public ResponseEntity<Result<Void>> add(@RequestParam Integer productId) {
        return Result.ok(collectService.addCollect(getUserId(request),productId)).responseEntity();
    }

    /**
     * 取消收藏
     */
    @PostMapping("cancel")
    @Operation(description = "取消收藏",summary = "取消收藏")
    public ResponseEntity<Result<Void>> cancel(@RequestParam Integer productId) {
        return Result.ok(collectService.cancelCollect(getUserId(request),productId)).responseEntity();
    }

    @GetMapping("list")
    @Operation(summary = "获取收藏列表", description = "根据用户id获取收藏列表")
    public ResponseEntity<Result<List<CollectVO>>> getCollectList(@RequestParam(required = false) Integer categoryId) {
        return Result.ok(collectService.getCollectList(getUserId(request),categoryId)).responseEntity();
    }

//    /**
//     * 添加收藏。
//     *
//     * @param collect 收藏
//     * @return {@code true} 添加成功，{@code false} 添加失败
//     */
//    @PostMapping("save")
//    @Operation(description = "保存收藏")
//    public boolean save(@RequestBody @Parameter(description = "收藏") Collect collect) {
//        return collectService.save(collect);
//    }
//
//    /**
//     * 根据主键删除收藏。
//     *
//     * @param id 主键
//     * @return {@code true} 删除成功，{@code false} 删除失败
//     */
//    @DeleteMapping("remove/{id}")
//    @Operation(description = "根据主键收藏")
//    public boolean remove(@PathVariable @Parameter(description = "收藏主键") Serializable id) {
//        return collectService.removeById(id);
//    }
//
//    /**
//     * 根据主键更新收藏。
//     *
//     * @param collect 收藏
//     * @return {@code true} 更新成功，{@code false} 更新失败
//     */
//    @PutMapping("update")
//    @Operation(description = "根据主键更新收藏")
//    public boolean update(@RequestBody @Parameter(description = "收藏主键") Collect collect) {
//        return collectService.updateById(collect);
//    }
//
//    /**
//     * 查询所有收藏。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    @Operation(description = "查询所有收藏")
//    public List<Collect> list() {
//        return collectService.list();
//    }
//
//    /**
//     * 根据收藏主键获取详细信息。
//     *
//     * @param id 收藏主键
//     * @return 收藏详情
//     */
//    @GetMapping("getInfo/{id}")
//    @Operation(description = "根据主键获取收藏")
//    public Collect getInfo(@PathVariable Serializable id) {
//        return collectService.getById(id);
//    }

    /**
     * 分页查询收藏。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询收藏")
    public Page<Collect> page(@Parameter(description = "分页信息") Page<Collect> page) {
        return collectService.page(page);
    }

}

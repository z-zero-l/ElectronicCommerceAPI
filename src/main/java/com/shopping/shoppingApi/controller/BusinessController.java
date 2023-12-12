package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.service.BusinessService;
import com.shopping.shoppingApi.vo.BusinessVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺信息表 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "店铺模块")
@RequestMapping("/business")
@AllArgsConstructor
public class BusinessController {
    private BusinessService businessService;

    /**
     * 获取店铺信息
     * @param id 店铺id
     * @return 店铺信息
     */
    @GetMapping("{id}")
    @Operation(description = "获取店铺信息表", summary = "获取店铺信息表")
    public ResponseEntity<Result<BusinessVO>> getBusinessInfo(@PathVariable("id") Integer id) {
        return Result.ok(businessService.getBusinessInfo(id)).responseEntity();
    }

    /**
     * 添加店铺信息表。
     *
     * @param business 店铺信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存店铺信息表")
    public boolean save(@RequestBody @Parameter(description = "店铺信息表") Business business) {
        return businessService.save(business);
    }

    /**
     * 根据主键删除店铺信息表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description = "根据主键店铺信息表")
    public boolean remove(@PathVariable @Parameter(description = "店铺信息表主键") Serializable id) {
        return businessService.removeById(id);
    }

    /**
     * 根据主键更新店铺信息表。
     *
     * @param business 店铺信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新店铺信息表")
    public boolean update(@RequestBody @Parameter(description = "店铺信息表主键") Business business) {
        return businessService.updateById(business);
    }

    /**
     * 查询所有店铺信息表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description = "查询所有店铺信息表")
    public List<Business> list() {
        return businessService.list();
    }

    /**
     * 根据店铺信息表主键获取详细信息。
     *
     * @param id 店铺信息表主键
     * @return 店铺信息表详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description = "根据主键获取店铺信息表")
    public Business getInfo(@PathVariable Serializable id) {
        return businessService.getById(id);
    }

    /**
     * 分页查询店铺信息表。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询店铺信息表")
    public Page<Business> page(@Parameter(description = "分页信息") Page<Business> page) {
        return businessService.page(page);
    }

}

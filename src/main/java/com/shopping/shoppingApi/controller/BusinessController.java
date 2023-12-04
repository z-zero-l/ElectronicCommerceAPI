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
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.service.BusinessService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.Serializable;
import java.util.List;

/**
 * 店铺信息表 控制层。
 *
 * @author 18851
 * @since 2023-12-04
 */
@RestController
@Tag(name = "店铺信息表接口")
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 添加店铺信息表。
     *
     * @param business 店铺信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description="保存店铺信息表")
    public boolean save(@RequestBody @Parameter(description="店铺信息表")Business business) {
        return businessService.save(business);
    }

    /**
     * 根据主键删除店铺信息表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description="根据主键店铺信息表")
    public boolean remove(@PathVariable @Parameter(description="店铺信息表主键")Serializable id) {
        return businessService.removeById(id);
    }

    /**
     * 根据主键更新店铺信息表。
     *
     * @param business 店铺信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description="根据主键更新店铺信息表")
    public boolean update(@RequestBody @Parameter(description="店铺信息表主键")Business business) {
        return businessService.updateById(business);
    }

    /**
     * 查询所有店铺信息表。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description="查询所有店铺信息表")
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
    @Operation(description="根据主键获取店铺信息表")
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
    @Operation(description="分页查询店铺信息表")
    public Page<Business> page(@Parameter(description="分页信息")Page<Business> page) {
        return businessService.page(page);
    }

}

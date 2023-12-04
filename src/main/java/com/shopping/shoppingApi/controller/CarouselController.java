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
import com.shopping.shoppingApi.entity.Carousel;
import com.shopping.shoppingApi.service.CarouselService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.Serializable;
import java.util.List;

/**
 * 轮播图 控制层。
 *
 * @author 18851
 * @since 2023-12-04
 */
@RestController
@Tag(name = "轮播图接口")
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    /**
     * 添加轮播图。
     *
     * @param carousel 轮播图
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description="保存轮播图")
    public boolean save(@RequestBody @Parameter(description="轮播图")Carousel carousel) {
        return carouselService.save(carousel);
    }

    /**
     * 根据主键删除轮播图。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description="根据主键轮播图")
    public boolean remove(@PathVariable @Parameter(description="轮播图主键")Serializable id) {
        return carouselService.removeById(id);
    }

    /**
     * 根据主键更新轮播图。
     *
     * @param carousel 轮播图
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description="根据主键更新轮播图")
    public boolean update(@RequestBody @Parameter(description="轮播图主键")Carousel carousel) {
        return carouselService.updateById(carousel);
    }

    /**
     * 查询所有轮播图。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description="查询所有轮播图")
    public List<Carousel> list() {
        return carouselService.list();
    }

    /**
     * 根据轮播图主键获取详细信息。
     *
     * @param id 轮播图主键
     * @return 轮播图详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description="根据主键获取轮播图")
    public Carousel getInfo(@PathVariable Serializable id) {
        return carouselService.getById(id);
    }

    /**
     * 分页查询轮播图。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description="分页查询轮播图")
    public Page<Carousel> page(@Parameter(description="分页信息")Page<Carousel> page) {
        return carouselService.page(page);
    }

}

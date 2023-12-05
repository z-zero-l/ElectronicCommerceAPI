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
import com.shopping.shoppingApi.entity.ProductDetailImage;
import com.shopping.shoppingApi.service.ProductDetailImageService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.Serializable;
import java.util.List;

/**
 * 商品详情图片 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "商品详情图片接口")
@RequestMapping("/productDetailImage")
public class ProductDetailImageController {

    @Autowired
    private ProductDetailImageService productDetailImageService;

    /**
     * 添加商品详情图片。
     *
     * @param productDetailImage 商品详情图片
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description="保存商品详情图片")
    public boolean save(@RequestBody @Parameter(description="商品详情图片")ProductDetailImage productDetailImage) {
        return productDetailImageService.save(productDetailImage);
    }

    /**
     * 根据主键删除商品详情图片。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description="根据主键商品详情图片")
    public boolean remove(@PathVariable @Parameter(description="商品详情图片主键")Serializable id) {
        return productDetailImageService.removeById(id);
    }

    /**
     * 根据主键更新商品详情图片。
     *
     * @param productDetailImage 商品详情图片
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description="根据主键更新商品详情图片")
    public boolean update(@RequestBody @Parameter(description="商品详情图片主键")ProductDetailImage productDetailImage) {
        return productDetailImageService.updateById(productDetailImage);
    }

    /**
     * 查询所有商品详情图片。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description="查询所有商品详情图片")
    public List<ProductDetailImage> list() {
        return productDetailImageService.list();
    }

    /**
     * 根据商品详情图片主键获取详细信息。
     *
     * @param id 商品详情图片主键
     * @return 商品详情图片详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description="根据主键获取商品详情图片")
    public ProductDetailImage getInfo(@PathVariable Serializable id) {
        return productDetailImageService.getById(id);
    }

    /**
     * 分页查询商品详情图片。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description="分页查询商品详情图片")
    public Page<ProductDetailImage> page(@Parameter(description="分页信息")Page<ProductDetailImage> page) {
        return productDetailImageService.page(page);
    }

}

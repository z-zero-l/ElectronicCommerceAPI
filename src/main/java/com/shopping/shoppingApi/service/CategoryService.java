package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Category;
import com.shopping.shoppingApi.vo.CategoryChildVO;
import com.shopping.shoppingApi.vo.CategoryVO;

import java.util.List;

/**
 * 分类 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface CategoryService extends IService<Category> {
    /**
     * 获取所有分类列表。
     *
     * @return 所有分类列表。
     */
    List<CategoryVO> getCategoryList();

    /**
     * 获取一级分类列表。
     *
     * @return 一级分类列表。
     */
    List<CategoryVO> getParentCategoryList();

    /**
     * 获取子分类列表。
     *
     * @param parentId 父分类id。
     * @return 子分类列表。
     */
    List<CategoryChildVO> getChildCategoryList(Integer parentId);
}
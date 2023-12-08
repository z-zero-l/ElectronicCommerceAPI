package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.CacheableServiceImpl;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.entity.Category;
import com.shopping.shoppingApi.mapper.CategoryMapper;
import com.shopping.shoppingApi.service.CategoryService;
import com.shopping.shoppingApi.vo.CategoryChildVO;
import com.shopping.shoppingApi.vo.CategoryVO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
@CacheConfig(cacheNames = "category")
public class CategoryServiceImpl extends CacheableServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * 获取所有分类列表。
     *
     * @return 所有分类列表。
     */
    @Override
    @Cacheable(key = "#root.methodName")
    public List<CategoryVO> getCategoryList() {
        List<Category> list = super.list(new QueryWrapper().eq("parent_id", 0));
        ArrayList<CategoryVO> categoryVOS = new ArrayList<>();
        for (Category category : list) {
            categoryVOS.add(CategoryVO.create()
                    .setCategoryId(category.getCategoryId())
                    .setCateName(category.getCateName())
                    .setCateIcon(category.getCateIcon())
                    .setCateColor(category.getCateColor())
                    .setChildCate(getChildCategoryList(category.getCategoryId())));
        }
        return categoryVOS;
    }

    /**
     * 获取一级分类列表。
     *
     * @return 一级分类列表。
     */
    @Override
    @Cacheable(key = "#root.methodName")
    public List<CategoryVO> getParentCategoryList() {
        List<Category> list = super.list(new QueryWrapper().eq("parent_id", 0));
        ArrayList<CategoryVO> categoryVOS = new ArrayList<>();
        for (Category category : list) {
            categoryVOS.add(CategoryVO.create()
                   .setCategoryId(category.getCategoryId())
                   .setCateName(category.getCateName())
                   .setCateIcon(category.getCateIcon())
                    .setCateColor(category.getCateColor()));
        }
        return categoryVOS;
    }

    /**
     * 获取子分类列表。
     *
     * @param parentId 父分类id。
     * @return 子分类列表。
     */
    @Override
    @Cacheable(key = "#root.methodName + ':' + #parentId")
    public List<CategoryChildVO> getChildCategoryList(Integer parentId) {
        if (parentId == null) {
            throw new ServerException("父分类id不能为空");
        }
        List<Category> list = super.list(new QueryWrapper().eq("parent_id", parentId));
        if (list.isEmpty()) {
            throw new ServerException("没有子分类");
        }
        List<CategoryChildVO> categoryVOS = new ArrayList<>();
        for (Category category : list) {
            categoryVOS.add(CategoryChildVO.create()
                   .setCategoryId(category.getCategoryId())
                   .setCateName(category.getCateName())
                   .setCateIcon(category.getCateIcon())
                   .setCateColor(category.getCateColor()));
        }
        return categoryVOS;
    }
}

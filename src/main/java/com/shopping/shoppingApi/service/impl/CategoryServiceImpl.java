package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Category;
import com.shopping.shoppingApi.mapper.CategoryMapper;
import com.shopping.shoppingApi.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 分类 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

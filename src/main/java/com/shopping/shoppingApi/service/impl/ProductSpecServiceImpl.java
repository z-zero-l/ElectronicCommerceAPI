package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.ProductSpec;
import com.shopping.shoppingApi.mapper.ProductSpecMapper;
import com.shopping.shoppingApi.service.ProductSpecService;
import org.springframework.stereotype.Service;

/**
 * 商品规格 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpec> implements ProductSpecService {

}

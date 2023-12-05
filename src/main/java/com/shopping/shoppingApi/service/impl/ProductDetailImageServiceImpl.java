package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.ProductDetailImage;
import com.shopping.shoppingApi.mapper.ProductDetailImageMapper;
import com.shopping.shoppingApi.service.ProductDetailImageService;
import org.springframework.stereotype.Service;

/**
 * 商品详情图片 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class ProductDetailImageServiceImpl extends ServiceImpl<ProductDetailImageMapper, ProductDetailImage> implements ProductDetailImageService {

}

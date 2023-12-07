package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.mapper.ProductMapper;
import com.shopping.shoppingApi.service.ProductService;
import com.shopping.shoppingApi.vo.ProductVO;
import org.springframework.stereotype.Service;

/**
 * 商品表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public ProductVO getProductDetail(Integer productId) {
        return null;
    }
}

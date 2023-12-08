package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.vo.IndexProductVO;
import com.shopping.shoppingApi.vo.ProductVO;

import java.util.List;

/**
 * 商品表 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface ProductService extends IService<Product> {
    /**
     * 获取商品详情
     *
     * @param id 商品id
     * @param userId 用户id
     * @return 商品详情
     */
    ProductVO getProductInfo(Integer id,Integer userId);

    /**
     * 获取首页商品列表
     *
     * @return 首页商品列表
     */
    List<IndexProductVO> getIndexProductList();

}

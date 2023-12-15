package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Carousel;
import com.shopping.shoppingApi.vo.CarouselVO;

import java.util.List;

/**
 * 轮播图 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface CarouselService extends IService<Carousel> {

    /**
     * 获取轮播图列表
     *
     * @return 轮播图列表
     */
    List<CarouselVO> getCarouselList();
}

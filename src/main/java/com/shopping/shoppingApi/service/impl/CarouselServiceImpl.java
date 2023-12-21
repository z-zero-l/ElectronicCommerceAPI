package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Carousel;
import com.shopping.shoppingApi.mapper.CarouselMapper;
import com.shopping.shoppingApi.service.CarouselService;
import com.shopping.shoppingApi.vo.CarouselVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.shopping.shoppingApi.entity.table.CarouselTableDef.CAROUSEL;

/**
 * 轮播图 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    /**
     * 获取首页轮播图列表
     *
     * @return 首页轮播图列表
     */
    @Override
    public List<CarouselVO> getCarouselList() {
        ArrayList<CarouselVO> carouselVOS = new ArrayList<>();
        list(QueryChain.create().where(CAROUSEL.LOCATION.eq(1)).orderBy(CAROUSEL.SORT.asc()))
                .forEach(carousel -> carouselVOS.add(CarouselVO.create()
                        .setId(carousel.getId())
                        .setImgUrl(carousel.getImgUrl())
                        .setHrefUrl(carousel.getHrefUrl())));
        return carouselVOS;
    }
}

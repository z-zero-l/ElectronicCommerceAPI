package com.shopping.shoppingApi.controller;

import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.service.CarouselService;
import com.shopping.shoppingApi.vo.CarouselVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 轮播图 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "轮播图模块")
@RequestMapping("/carousel")
@AllArgsConstructor
public class CarouselController {

    private CarouselService carouselService;


    /**
     * 获取轮播图列表
     *
     * @return 轮播图列表
     */
    @GetMapping("list")
    @Operation(summary = "轮播图列表", description = "查看所有轮播图列表")
    public ResponseEntity<Result<List<CarouselVO>>> list() {
        return Result.ok(carouselService.getCarouselList()).responseEntity();
    }
}

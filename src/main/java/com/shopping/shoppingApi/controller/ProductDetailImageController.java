package com.shopping.shoppingApi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品详情图片 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "商品详情图片接口")
@RequestMapping("/productDetailImage")
@AllArgsConstructor
public class ProductDetailImageController {
}

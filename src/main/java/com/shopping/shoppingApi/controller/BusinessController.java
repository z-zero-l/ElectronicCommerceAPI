package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.service.BusinessService;
import com.shopping.shoppingApi.vo.BusinessVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺信息表 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "店铺模块")
@RequestMapping("/business")
@AllArgsConstructor
public class BusinessController {
    private BusinessService businessService;

    /**
     * 获取店铺信息
     * @param id 店铺id
     * @return 店铺信息
     */
    @GetMapping("{id}")
    @Operation(description = "获取店铺信息表", summary = "获取店铺信息表")
    public ResponseEntity<Result<BusinessVO>> getBusinessInfo(@PathVariable("id") Integer id) {
        return Result.ok(businessService.getBusinessInfo(id)).responseEntity();
    }
}

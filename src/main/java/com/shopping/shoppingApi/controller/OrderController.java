package com.shopping.shoppingApi.controller;

import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.query.OrderQuery;
import com.shopping.shoppingApi.service.OrderService;
import com.shopping.shoppingApi.vo.OrderDetailVO;
import com.shopping.shoppingApi.vo.OrderItemVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shopping.shoppingApi.common.utils.ObtainUserIdUtils.getUserId;

/**
 * 订单 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "订单模块")
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @Resource
    private HttpServletRequest request;

    @GetMapping("list")
    @Operation(description = "查询所有订单", summary = "查询所有订单")
    public ResponseEntity<Result<List<OrderItemVO>>> getOrderList(@Parameter Integer status) {
        return Result.ok(orderService.getOrderList(getUserId(request), status)).responseEntity();
    }

    /**
     * 获取订单详情
     *
     * @param orderItemId 订单项id
     * @return 订单详情
     */
    @GetMapping("detail")
    @Operation(description = "获取订单详情", summary = "获取订单详情")
    public ResponseEntity<Result<OrderDetailVO>> getOrderDetail(@Parameter(required = true) Integer orderItemId) {
        return Result.ok(orderService.getOrderDetail(getUserId(request), orderItemId)).responseEntity();
    }

    /**
     * 提交订单
     *
     * @param addressId      地址id
     * @param orderQueryList 订单信息
     * @return 订单id
     */
    @PostMapping("submit")
    @Operation(description = "提交订单", summary = "提交订单")
    public ResponseEntity<Result<String>> submitOrder(@Parameter Integer addressId, @RequestBody List<OrderQuery> orderQueryList) {
        return Result.ok(orderService.submitOrder(getUserId(request),addressId, orderQueryList)).responseEntity();
    }
}

package com.shopping.shoppingApi.controller;

import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.query.OrderQuery;
import com.shopping.shoppingApi.service.OrderService;
import com.shopping.shoppingApi.vo.OrderListVO;
import com.shopping.shoppingApi.vo.OrderVO;
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
    public ResponseEntity<Result<List<OrderListVO>>> getOrderList(@Parameter Integer status) {
        return Result.ok(orderService.getOrderList(getUserId(request), status)).responseEntity();
    }

    /**
     * 获取订单详情
     *
     * @param orderId 订单id
     * @return 订单详情
     */
    @GetMapping("detail")
    @Operation(description = "获取订单详情", summary = "获取订单详情")
    public ResponseEntity<Result<OrderVO>> getOrderDetail(@Parameter(required = true) String orderId) {
        return Result.ok(orderService.getOrderDetail(getUserId(request), orderId)).responseEntity();
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
        return Result.ok(orderService.submitOrder(getUserId(request), addressId, orderQueryList)).responseEntity();
    }

    /**
     * 模拟支付
     *
     * @param orderId     订单id
     * @param orderItemId 订单项id
     */
    @PostMapping("pay")
    @Operation(description = "模拟支付", summary = "模拟支付")
    public ResponseEntity<Result<Void>> pay(@Parameter String orderId, @Parameter Integer orderItemId) {
        return Result.ok(orderService.pay(getUserId(request), orderId, orderItemId)).responseEntity();
    }

    /**
     * 取消订单
     *
     * @param orderId     订单id
     * @param orderItemId 订单项id
     * @param cancelReason 取消原因
     */
    @PostMapping("cancel")
    @Operation(description = "取消订单", summary = "取消订单")
    public ResponseEntity<Result<Void>> cancel(@Parameter String orderId, @Parameter Integer orderItemId, @Parameter String cancelReason) {
        return Result.ok(orderService.cancel(getUserId(request), orderId, orderItemId, cancelReason)).responseEntity();
    }
}

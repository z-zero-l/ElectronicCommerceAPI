package com.shopping.shoppingApi.controller;

import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.service.OrderItemService;
import com.shopping.shoppingApi.vo.OrderItemDetailVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.shopping.shoppingApi.common.utils.ObtainUserIdUtils.getUserId;

/**
 * 订单详情 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "订单项模块")
@RequestMapping("/orderItem")
@AllArgsConstructor
public class OrderItemController {
    private OrderItemService orderItemService;

    @Resource
    private HttpServletRequest request;

    /**
     * 获取订单项详情
     *
     * @param orderItemId 订单项id
     * @return 订单详情
     */
    @GetMapping("detail")
    @Operation(description = "获取订单项详情", summary = "获取订单项详情")
    public ResponseEntity<Result<OrderItemDetailVO>> getOrderDetail(@Parameter(required = true) Integer orderItemId) {
        return Result.ok(orderItemService.getOrderItemDetail(getUserId(request), orderItemId)).responseEntity();
    }

    /**
     * 模拟发货
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     */
    @GetMapping("deliver")
    @Operation(description = "模拟发货", summary = "模拟发货")
    public ResponseEntity<Result<Void>> deliver(@Parameter(required = true) Integer userId, @Parameter(required = true) Integer orderItemId) {
        return Result.ok(orderItemService.simulateDelivery(userId, orderItemId)).responseEntity();
    }

    /**
     * 确认收货
     *
     * @param userId      用户ID
     * @param orderItemId 订单项ID
     */
    @GetMapping("confirm")
    @Operation(description = "确认收货", summary = "确认收货")
    public ResponseEntity<Result<Void>> confirm(@Parameter(required = true) Integer userId, @Parameter(required = true) Integer orderItemId) {
        return Result.ok(orderItemService.confirmReceipt(userId, orderItemId)).responseEntity();
    }

    /**
     * 删除订单
     *
     * @param orderItemId 订单项ID
     */
    @DeleteMapping("delete")
    @Operation(description = "删除订单", summary = "删除订单")
    public ResponseEntity<Result<Void>> delete(@Parameter(required = true) Integer orderItemId) {
        return Result.ok(orderItemService.deleteOrder(getUserId(request),orderItemId)).responseEntity();
    }
    
}

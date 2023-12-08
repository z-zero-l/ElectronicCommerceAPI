package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.entity.Order;
import com.shopping.shoppingApi.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 订单 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "订单接口")
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    /**
     * 添加订单。
     *
     * @param order 订单
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存订单")
    public boolean save(@RequestBody @Parameter(description = "订单") Order order) {
        return orderService.save(order);
    }

    /**
     * 根据主键删除订单。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description = "根据主键订单")
    public boolean remove(@PathVariable @Parameter(description = "订单主键") Serializable id) {
        return orderService.removeById(id);
    }

    /**
     * 根据主键更新订单。
     *
     * @param order 订单
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新订单")
    public boolean update(@RequestBody @Parameter(description = "订单主键") Order order) {
        return orderService.updateById(order);
    }

    /**
     * 查询所有订单。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description = "查询所有订单")
    public List<Order> list() {
        return orderService.list();
    }

    /**
     * 根据订单主键获取详细信息。
     *
     * @param id 订单主键
     * @return 订单详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description = "根据主键获取订单")
    public Order getInfo(@PathVariable Serializable id) {
        return orderService.getById(id);
    }

    /**
     * 分页查询订单。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询订单")
    public Page<Order> page(@Parameter(description = "分页信息") Page<Order> page) {
        return orderService.page(page);
    }

}

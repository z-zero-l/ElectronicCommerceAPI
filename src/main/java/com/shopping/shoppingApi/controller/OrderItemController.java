package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopping.shoppingApi.entity.OrderItem;
import com.shopping.shoppingApi.service.OrderItemService;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.Serializable;
import java.util.List;

/**
 * 订单详情 控制层。
 *
 * @author 18851
 * @since 2023-12-04
 */
@RestController
@Tag(name = "订单详情接口")
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    /**
     * 添加订单详情。
     *
     * @param orderItem 订单详情
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description="保存订单详情")
    public boolean save(@RequestBody @Parameter(description="订单详情")OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }

    /**
     * 根据主键删除订单详情。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description="根据主键订单详情")
    public boolean remove(@PathVariable @Parameter(description="订单详情主键")Serializable id) {
        return orderItemService.removeById(id);
    }

    /**
     * 根据主键更新订单详情。
     *
     * @param orderItem 订单详情
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description="根据主键更新订单详情")
    public boolean update(@RequestBody @Parameter(description="订单详情主键")OrderItem orderItem) {
        return orderItemService.updateById(orderItem);
    }

    /**
     * 查询所有订单详情。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    @Operation(description="查询所有订单详情")
    public List<OrderItem> list() {
        return orderItemService.list();
    }

    /**
     * 根据订单详情主键获取详细信息。
     *
     * @param id 订单详情主键
     * @return 订单详情详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description="根据主键获取订单详情")
    public OrderItem getInfo(@PathVariable Serializable id) {
        return orderItemService.getById(id);
    }

    /**
     * 分页查询订单详情。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description="分页查询订单详情")
    public Page<OrderItem> page(@Parameter(description="分页信息")Page<OrderItem> page) {
        return orderItemService.page(page);
    }

}

package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class OrderVO {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "订单号")
    private String orderId;
    @Schema(description = "订单详情")
    private List<OrderItemVO> orderDetail;
}

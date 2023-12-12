package com.shopping.shoppingApi.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class OrderItemVO {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "订单id")
    private Integer orderId;
    @Schema(description = "商品id")
    private Integer productId;
    @Schema(description = "商品名称")
    private String productName;
    @Schema(description = "店铺ID")
    private Integer businessId;
    @Schema(description = "店铺名称")
    private String businessName;
    @Schema(description = "商品规格名称")
    private String specName;
    @Schema(description = "商品规格图片")
    private String specImage;
    @Schema(description = "数量")
    private Integer amount;
    @Schema(description = "实付款")
    private BigDecimal price;
    @Schema(description = "订单项状态(0-待付款 1-待发货 2-待收货 3-待评价 4-已完成 5-已取消)")
    private Integer status;
}

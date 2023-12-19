package com.shopping.shoppingApi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class OrderItemDetailVO {
    @Schema(description = "主键")
    private Integer id;
    @Schema(description = "订单号")
    private String orderId;
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
    @Schema(description = "运费")
    private Double freight;
    @Schema(description = "备注")
    private String remark;
    @Schema(description = "收货人")
    private String consignee;
    @Schema(description = "收货人联系方式")
    private String phone;
    @Schema(description = "收货省份编码")
    private Integer provinceCode;
    @Schema(description = "收货城市编码")
    private Integer cityCode;
    @Schema(description = "收货区县编码")
    private Integer districtCode;
    @Schema(description = "收货详细地址")
    private String address;
    @Schema(description = "订单取消原因")
    private String cancelReason;
    @Schema(description = "订单项状态(0-待付款 1-待发货 2-待收货 3-待评价 4-已完成 5-已取消)")
    private Integer status;
    @Schema(description = "付款截止时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime payLatestTime;
    @Schema(description = "倒计时--剩余的秒数 -1 表示已经超时，正数表示倒计时未结束")
    private Integer countdown = -1;
    @Schema(description = "下单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @Schema(description = "付款时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime payTime;
    @Schema(description = "发货时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendTime;
    @Schema(description = "收货时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime receiptTime;
    @Schema(description = "完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finishTime;
}

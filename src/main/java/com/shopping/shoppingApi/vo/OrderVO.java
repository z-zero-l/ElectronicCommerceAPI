package com.shopping.shoppingApi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data(staticConstructor = "create")
@Accessors(chain = true)
public class OrderVO {
    @Schema(description = "付款截止时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime payLatestTime;
    @Schema(description = "倒计时--剩余的秒数 -1 表示已经超时，正数表示倒计时未结束")
    private Integer countdown = -1;
    @Schema(description = "收件人")
    private String receiver;
    @Schema(description = "联系方式")
    private String contact;
    @Schema(description = "省份编码")
    private Integer provinceCode;
    @Schema(description = "城市编码")
    private Integer cityCode;
    @Schema(description = "区县编码")
    private Integer districtCode;
    @Schema(description = "详细地址")
    private String address;
    @Schema(description = "订单项列表")
    List<OrderItemVO> orderItemVOList;
    @Schema(description = "实付金额")
    private BigDecimal payment;
}

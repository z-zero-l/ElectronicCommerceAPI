package com.shopping.shoppingApi.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderItemCloseTypeEnum {
    TIMEOUT_UNPAID(0, "超时未支付"),
    BUYER_CANCEL(1, "买家取消"),
    REFUND_CLOSE(2, "退款关闭");
    private final Integer value;
    private final String name;
}

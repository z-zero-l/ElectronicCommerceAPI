package com.shopping.shoppingApi.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    WAITING_FOR_PAYMENT(0, "待付款"),
    WAITING_FOR_SHIPMENT(1, "待发货"),
    WAITING_FOR_DELIVERY(2, "待收货"),
    WAITING_FOR_REVIEW(3, "待评价"),
    COMPLETED(4, "已完成"),
    CANCELLED(5, "已取消");

    private final Integer value;
    private final String name;

}
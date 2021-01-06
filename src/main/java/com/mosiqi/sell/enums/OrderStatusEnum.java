package com.mosiqi.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(0, "new order"),
    FINISHED(1, "finished"),
    CANCEL(2, "canceled");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

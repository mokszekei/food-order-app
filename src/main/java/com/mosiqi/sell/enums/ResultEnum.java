package com.mosiqi.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "This product doesn't exist in database"),
    PRODUCT_STOCK_ERROR(11,"Stock goes wrong"),
    ORDER_NOT_EXIST(12,"This order doesn't exist"),
    ORDER_DETAIL_NOT_EXIST(13,"Order detail doesn't exist"),
    ;


    private  Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

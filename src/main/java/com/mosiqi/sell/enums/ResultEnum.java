package com.mosiqi.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "This product doesn't exist in database"),
    PRODUCT_STOCK_ERROR(11,"Stock goes wrong"),
    ;


    private  Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

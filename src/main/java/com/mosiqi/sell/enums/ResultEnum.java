package com.mosiqi.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"parameter not correct"),
    PRODUCT_NOT_EXIST(10, "This product doesn't exist in database"),
    PRODUCT_STOCK_ERROR(11,"Stock goes wrong"),
    ORDER_NOT_EXIST(12,"This order doesn't exist"),
    ORDER_DETAIL_NOT_EXIST(13,"Order detail doesn't exist"),
    ORDER_STATUS_ERROR(14,"order status goes wrong"),
    ORDER_UPDATE_FAIL(15,"order updating failed"),
    ORDER_DETAIL_EMPTY(16,"The order is empty"),
    ORDER_PAY_STATUS_ERROR(17,"Pay status is not correct"),
    CART_EMPTY(18,"Cart is empty"),
    ORDER_OWNER_ERROR(19,"order doesn't belong to current user"),
    ;


    private  Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

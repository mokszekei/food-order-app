package com.mosiqi.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"succeed!"),
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
    WECHAT_MP_ERROR(20,"Wechat Mp account error"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"payment from wechat async notification is different from order "),
    ORDER_CANCEL_SUCCESS(22,"Order has been canceled successfully!"),
    ORDER_FINISH_SUCCESS(23,"Order has been finished successfully"),
    PRODUCT_STATUS_ERROR(24, "product status not correct"),
    LOGIN_FAIL(25, "login fail"),
    LOGOUT_SUCCESS(26, "Already log out"),
    ;


    private  Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

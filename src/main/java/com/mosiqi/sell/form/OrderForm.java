package com.mosiqi.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "Buyer name must be filled")
    private String name;

    @NotEmpty(message = "Buyer phone must be filled")
    private String phone;


    @NotEmpty(message = "Buyer address must be filled")
    private String address;


    @NotEmpty(message = "Buyer wechat openid must be filled")
    private String openid;


    @NotEmpty(message = "cart cannot be empty")
    private String items;
}

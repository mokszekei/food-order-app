package com.mosiqi.sell.service;

import com.mosiqi.sell.dto.OrderDTO;

public interface BuyerService {

    //check one order
    OrderDTO findOrderOne(String openid, String orderId);

    //cancel order
    OrderDTO cancelOrder(String openid, String orderId);
}

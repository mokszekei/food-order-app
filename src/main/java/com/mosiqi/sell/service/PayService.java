package com.mosiqi.sell.service;


import com.mosiqi.sell.dto.OrderDTO;

public interface PayService {

    void create(OrderDTO orderDTO);
}

package com.mosiqi.sell.service;


import com.lly835.bestpay.model.PayResponse;
import com.mosiqi.sell.dto.OrderDTO;

public interface PayService {

    PayResponse create(OrderDTO orderDTO);
}

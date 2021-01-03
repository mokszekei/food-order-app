package com.mosiqi.sell.service.impl;

import com.mosiqi.sell.dto.OrderDTO;
import com.mosiqi.sell.service.PayService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest extends TestCase {

    @Autowired
    private PayService payService;

    @Test
    public void create() throws Exception{

        OrderDTO orderDTO = new OrderDTO();
        payService.create(orderDTO);
    }
}
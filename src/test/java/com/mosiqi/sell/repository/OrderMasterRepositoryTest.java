package com.mosiqi.sell.repository;

import com.mosiqi.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "112211";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("Jo");
        orderMaster.setBuyerPhone("123456789143");
        orderMaster.setBuyerAddress("904 lambda street");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.4));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception{
        PageRequest request = PageRequest.of(0,1);
        Page<OrderMaster> results = repository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,results.getTotalElements());
    }



}
package com.mosiqi.sell.service.impl;

import com.mosiqi.sell.dataobject.ProductInfo;
import com.mosiqi.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("1001");
        Assert.assertEquals("1001", productInfo.getProductId());
    }

    /**
     * Search for all available item
     */
    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<ProductInfo> productInfos = productService.findAll(pageRequest);
        System.out.println(productInfos.getTotalElements());
        System.out.println(productInfos.getTotalPages());
        Assert.assertNotEquals(0, productInfos.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1004");
        productInfo.setProductName("Chicken rice");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("Good lunch");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(5);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}
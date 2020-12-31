package com.mosiqi.sell.repository;

import com.mosiqi.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1001");
        productInfo.setProductName("Shanghai Dumplings");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("Famous Chinese food");
        productInfo.setProductIcon("http://xxxxx1.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = repository.save(productInfo);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }

}
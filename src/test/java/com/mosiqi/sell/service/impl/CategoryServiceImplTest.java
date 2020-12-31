package com.mosiqi.sell.service.impl;

import com.mosiqi.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService; //Introduce service class

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
        Assert.assertNotEquals(0, productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0, categoryTypeIn.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Bread");
        productCategory.setCategoryType(13);
        ProductCategory category = categoryService.save(productCategory);
        Assert.assertNotNull(category);
    }
}
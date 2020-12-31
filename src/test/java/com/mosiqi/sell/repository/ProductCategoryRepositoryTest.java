package com.mosiqi.sell.repository;

import com.mosiqi.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(1).get();;
        System.out.println(productCategory);
    }

    @Test
    @Transactional //Testing object would not be stored in db.
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Latest");
        productCategory.setCategoryType(6);
        ProductCategory save = repository.save(productCategory);
        System.out.println(save);
        Assert.assertNotEquals(null, save); //first:unexpected, second:expected
    }

    @Test
    public void findAllTest() {
        List<ProductCategory> repositoryAll = repository.findAll();
        System.out.println(repositoryAll);
    }

    @Test
    public void findByCategoryTypeTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> results = repository.findByCategoryTypeIn(list);
        System.out.println(results);
        System.out.println(results.size());
        Assert.assertNotEquals(0, results.size()); //regard as successful if one data is found
    }

}
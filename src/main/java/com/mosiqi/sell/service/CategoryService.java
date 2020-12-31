package com.mosiqi.sell.service;

import com.mosiqi.sell.dataobject.ProductCategory;
import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryID);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}

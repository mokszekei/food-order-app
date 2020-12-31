package com.mosiqi.sell.service;

import com.mosiqi.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
}
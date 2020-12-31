package com.mosiqi.sell.service.impl;

import com.mosiqi.sell.dataobject.ProductInfo;
import com.mosiqi.sell.enums.ProductStatusEnum;
import com.mosiqi.sell.repository.ProductInfoRepository;
import com.mosiqi.sell.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = repository.findById(productId).orElse(null);
        return productInfo;
    }

    /*数字0用枚举来解决*/
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

}


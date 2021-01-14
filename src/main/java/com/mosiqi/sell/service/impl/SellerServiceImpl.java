package com.mosiqi.sell.service.impl;

import com.mosiqi.sell.dataobject.SellerInfo;
import com.mosiqi.sell.repository.SellerInfoRepository;
import com.mosiqi.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid){
        return repository.findByOpenid(openid);
    }

}

package com.mosiqi.sell.service;

import com.mosiqi.sell.dataobject.SellerInfo;

public interface SellerService {

    SellerInfo findSellerInfoByOpenid (String openid);
}

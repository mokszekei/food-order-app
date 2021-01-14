package com.mosiqi.sell.config;

import me.chanjar.weixin.open.api.WxOpenConfigStorage;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.api.impl.WxOpenInMemoryConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WechatOpenConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public WxOpenService wxOpenService(WxOpenConfigStorage wxOpenConfigStorage) {
        WxOpenService wxOpenService = new WxOpenServiceImpl();
        wxOpenService.setWxOpenConfigStorage(wxOpenConfigStorage);
        return wxOpenService;
    }

    @Bean
    public WxOpenConfigStorage wxOpenConfigStorage() {
        WxOpenInMemoryConfigStorage wxOpenConfigStorage = new WxOpenInMemoryConfigStorage();
        wxOpenConfigStorage.setComponentAppId(accountConfig.getOpenAppId());
        wxOpenConfigStorage.setComponentAppSecret(accountConfig.getOpenAppSecret());
        return wxOpenConfigStorage;
    }
}

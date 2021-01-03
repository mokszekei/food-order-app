package com.mosiqi.sell.config;


import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public BestPayServiceImpl bestPayService() {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();

        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(accountConfig.getMpAppId());
        wxPayH5Config.setAppSecret(accountConfig.getMpAppSecret());
        wxPayH5Config.setMchId(accountConfig.getMchId());
        wxPayH5Config.setMchKey(accountConfig.getMchKey());
        wxPayH5Config.setKeyPath(accountConfig.getKeyPath());

        bestPayService.setWxPayH5Config(wxPayH5Config);
        return bestPayService;
    }

//    @Bean
//    public WxPayConfig wxPayConfig() {
//        WxPayConfig wxPayConfig = new WxPayConfig();
//        wxPayConfig.setAppId(accountConfig.getMpAppId());
//        wxPayConfig.setAppSecret(accountConfig.getMpAppSecret());
//        wxPayConfig.setMchId(accountConfig.getMchId());
//        wxPayConfig.setMchKey(accountConfig.getMchKey());
//        wxPayConfig.setKeyPath(accountConfig.getKeyPath());
////        wxPayConfig.setNotifyUrl(accountConfig.getNotifyUrl());
//        return wxPayConfig;
//    }
}
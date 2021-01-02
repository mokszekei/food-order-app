package com.mosiqi.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
//
//    @Autowired
//    private WeChatAccountConfig weChatAccountConfig;

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法...");
        // 用户同意授权，获取code
        log.info("code={}", code);
        // 通过code换取网页授权access_token
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + weChatAccountConfig.getMpAppId() + "&secret=" + weChatAccountConfig.getMpSecret() + "&code=" + code + "&grant_type=authorization_code";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);
//        log.info("response={}", response);
    }
}

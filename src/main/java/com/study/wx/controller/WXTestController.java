package com.study.wx.controller;

import com.study.wx.domain.AccessToken;
import com.study.wx.domain.WxConfig;
import com.tfd.base.utils.HttpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author TangFD@HF 2018/8/27
 */
@RestController
public class WXTestController {

    @Resource
    private WxConfig config;

    @RequestMapping("/refreshAccessToken")
    public String refreshAccessToken() {
        String tokenUrl = config.getTokenUrl();
        String appId = config.getAppId();
        String secret = config.getSecret();
        try {
            AccessToken token = HttpUtils.doGetAsObject(tokenUrl.replace("APP_ID", appId).replace("APP_SECRET", secret), AccessToken.class);
            WxConfig.token = token.getAccess_token();
            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "URL: ----> " + config.getTokenUrl() + "<br><br><br>" + "TOKEN: ----> " + WxConfig.token;
    }

    @RequestMapping("/getAccessToken")
    public String getAccessToken() {
        return "URL: ----> " + config.getTokenUrl() + "<br><br><br>" + "TOKEN: ----> " + WxConfig.token;
    }

    @RequestMapping("/createMenu")
    public String createMenu(@RequestParam String content) {
        try {
            String menuUrl = config.getMenuUrl();
            String result = HttpUtils.doPostAsString(menuUrl.replace("ACCESS_TOKEN", WxConfig.token), content);
            return "URL: ----> " + menuUrl + "<br><br><br>" + "result: ----> " + result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping("/getMenu")
    public String getMenu() {
        try {
            String getMenuUrl = config.getGetMenuUrl();
            String result = HttpUtils.doGetAsString(getMenuUrl.replace("ACCESS_TOKEN", WxConfig.token));
            return "URL: ----> " + getMenuUrl + "<br><br><br>" + "result: ----> " + result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping("/deleteMenu")
    public String deleteMenu() {
        try {
            String deleteMenuUrl = config.getDeleteMenuUrl();
            String result = HttpUtils.doGetAsString(deleteMenuUrl.replace("ACCESS_TOKEN", WxConfig.token));
            return "URL: ----> " + deleteMenuUrl + "<br><br><br>" + "result: ----> " + result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

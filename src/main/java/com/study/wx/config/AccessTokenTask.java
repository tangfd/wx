package com.study.wx.config;

import com.study.wx.domain.AccessToken;
import com.study.wx.domain.WxConfig;
import com.tfd.base.utils.HttpUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author TangFD@HF 2018/8/30
 */
@Component
public class AccessTokenTask {
    @Resource
    private WxConfig wxConfig;

    @Scheduled(fixedRate = 110 * 60 * 1000)
    public void getAccessToken() {
        String tokenUrl = wxConfig.getTokenUrl();
        String appId = wxConfig.getAppId();
        String secret = wxConfig.getSecret();
        try {
            AccessToken token = HttpUtils.doGetAsObject(tokenUrl.replace("APP_ID", appId).replace("APP_SECRET", secret), AccessToken.class);
            WxConfig.token = token.getAccess_token();
            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

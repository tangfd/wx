package com.study.wx.config;

import com.study.wx.domain.AccessToken;
import com.study.wx.domain.WxConfig;
import com.study.wx.domain.WxConstants;
import com.tfd.base.utils.HttpUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author TangFD@HF 2018/8/30
 */
@Component
public class AccessTokenTask {
    private static final Log LOG = LogFactory.getLog(AccessToken.class);
    @Resource
    private WxConfig wxConfig;
    @Resource
    private RedisService redisService;


    @Scheduled(fixedRate = 110 * 60 * 1000)
    public void getAccessToken() {
        if (redisService.exists(WxConstants.TOKEN_KEY)) {
            return;
        }

        String tokenUrl = wxConfig.getTokenUrl();
        String appId = wxConfig.getAppId();
        String secret = wxConfig.getSecret();
        try {
            AccessToken token = HttpUtils.doGetAsObject(tokenUrl.replace("APP_ID", appId).replace("APP_SECRET", secret), AccessToken.class);
            redisService.set(WxConstants.TOKEN_KEY, token.getAccess_token(), 110 * 60L);
            LOG.info("=====AccessToken====" + token);
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}

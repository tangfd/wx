package com.study.wx.domain;

import com.study.wx.config.RedisService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

/**
 * @author TangFD@HF 2018/8/30
 */
@Configuration
@ConfigurationProperties(prefix = "wx.app")
public class WxConfig {
    @Resource
    private RedisService redisService;

    @NotEmpty
    private String appId;
    @NotEmpty
    private String secret;
    @NotEmpty
    private String tokenUrl;
    @NotEmpty
    private String menuUrl;
    @NotEmpty
    private String getMenuUrl;
    @NotEmpty
    private String deleteMenuUrl;
    @NotEmpty
    private String baseUrl;
    @NotEmpty
    private String userListUrl;
    @NotEmpty
    private String userUrl;

    public String getUserListUrl() {
        return baseUrl + userListUrl;
    }

    public void setUserListUrl(String userListUrl) {
        this.userListUrl = userListUrl;
    }

    public String getUserUrl() {
        return baseUrl + userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getToken() {
        return (String) redisService.get(WxConstants.TOKEN_KEY);
    }

    public String getDeleteMenuUrl() {
        return baseUrl + deleteMenuUrl;
    }

    public void setDeleteMenuUrl(String deleteMenuUrl) {
        this.deleteMenuUrl = deleteMenuUrl;
    }

    public String getMenuUrl() {
        return baseUrl + menuUrl;
    }

    public String getGetMenuUrl() {
        return baseUrl + getMenuUrl;
    }

    public void setGetMenuUrl(String getMenuUrl) {
        this.getMenuUrl = getMenuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTokenUrl() {
        return baseUrl + tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }
}

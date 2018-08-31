package com.study.wx.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.study.wx.config.RedisService;
import com.study.wx.domain.AccessToken;
import com.study.wx.domain.WxConfig;
import com.study.wx.domain.WxConstants;
import com.tfd.base.utils.HttpUtils;
import com.tfd.base.utils.XmlJsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author TangFD@HF 2018/8/27
 */
@Controller
public class WxTestController {
    private static final Log LOG = LogFactory.getLog(WxTestController.class);
    @Resource
    private WxConfig config;
    @Resource
    private RedisService redisService;

    @RequestMapping("/tools")
    public String tools() {
        return "tools";
    }

    @RequestMapping("/refreshAccessToken")
    public String refreshAccessToken(Model model) {
        String tokenUrl = config.getTokenUrl();
        String appId = config.getAppId();
        String secret = config.getSecret();
        try {
            AccessToken token = HttpUtils.doGetAsObject(tokenUrl.replace("APP_ID", appId).replace("APP_SECRET", secret), AccessToken.class);
            redisService.set(WxConstants.TOKEN_KEY, token.getAccess_token(), 110 * 60L);
            LOG.info(token);
        } catch (IOException e) {
            LOG.error(e);
        }

        String message = "URL: ----> " + config.getTokenUrl() + "<br><br><br>" + "TOKEN: ----> " + config.getToken();
        model.addAttribute("message", message);
        return "tools";
    }

    @RequestMapping("/getAccessToken")
    public String getAccessToken(Model model) {
        String message = "URL: ----> " + config.getTokenUrl() + "<br><br><br>" + "TOKEN: ----> " + config.getToken();
        model.addAttribute("message", message);
        return "tools";
    }

    @RequestMapping("/createMenu")
    public String createMenu(@RequestParam String content, Model model) {
        try {
            String menuUrl = config.getMenuUrl();
            String result = HttpUtils.doPostByBodyAsString(menuUrl.replace("ACCESS_TOKEN", config.getToken()), content);
            String message = "URL: ----> " + menuUrl + "<br><br><br>" + "result: ----> " + result;
            model.addAttribute("message", message);
            return "tools";
        } catch (IOException e) {
            LOG.error(e);
        }

        return null;
    }

    @RequestMapping("/getMenu")
    public String getMenu(Model model) {
        try {
            String getMenuUrl = config.getGetMenuUrl();
            String result = HttpUtils.doGetAsString(getMenuUrl.replace("ACCESS_TOKEN", config.getToken()));
            String message = "URL: ----> " + getMenuUrl + "<br><br><br>" + "result: ----> " + result;
            model.addAttribute("message", message);
            return "tools";
        } catch (IOException e) {
            LOG.error(e);
        }

        return null;
    }

    @RequestMapping("/deleteMenu")
    public String deleteMenu(Model model) {
        try {
            String deleteMenuUrl = config.getDeleteMenuUrl();
            String result = HttpUtils.doGetAsString(deleteMenuUrl.replace("ACCESS_TOKEN", config.getToken()));
            String message = "URL: ----> " + deleteMenuUrl + "<br><br><br>" + "result: ----> " + result;
            model.addAttribute("message", message);
            return "tools";
        } catch (IOException e) {
            LOG.error(e);
        }

        return null;
    }

    @RequestMapping("/getUserList")
    public String getUserList(Model model) {
        try {
            String userListUrl = config.getUserListUrl();
            String result = HttpUtils.doGetAsString(userListUrl.replace("ACCESS_TOKEN", config.getToken()).replace("NEXT_OPENID", ""));
            String message = "URL: ----> " + userListUrl + "<br><br><br>" + "result: ----> ";
            JsonObject jsonObject = XmlJsonUtils.json2Object(result);
            JsonElement data = jsonObject.get("data");
            JsonArray jsonArray = ((JsonObject) data).get("openid").getAsJsonArray();
            for (JsonElement element : jsonArray) {
                message += getUser(element.getAsString());
            }

            model.addAttribute("message", message);
            return "tools";
        } catch (IOException e) {
            LOG.error(e);
        }

        return null;
    }

    private String getUser(String openId) {
        String userUrl = config.getUserUrl();
        try {
            return HttpUtils.doGetAsString(userUrl.replace("ACCESS_TOKEN", config.getToken()).replace("OPENID", openId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

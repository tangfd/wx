package com.study.wx.controller;

import com.study.wx.utils.SignUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TangFD@HF 2018/8/27
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String init(String signature, String timestamp, String echostr, String nonce) {
        System.out.println("--------" + signature);
        System.out.println("--------" + timestamp);
        System.out.println("--------" + echostr);
        System.out.println("--------" + nonce);
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }

        return "hello wx ......";
    }
}

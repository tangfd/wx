package com.study.wx.controller;

import com.study.wx.utils.SignUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author TangFD@HF 2018/8/27
 */
@Controller
public class IndexController {

    @RequestMapping("/tools")
    public String tools() {
        return "tools";
    }

    @GetMapping("/")
    @ResponseBody
    public String check(String signature, String timestamp, String echostr, String nonce) {
        System.out.println("---check-----signature : " + signature);
        System.out.println("---check-----timestamp : " + timestamp);
        System.out.println("---check-----echostr : " + echostr);
        System.out.println("---check-----nonce : " + nonce);
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }

        return "hello wx ......";
    }

    @PostMapping("/")
    @ResponseBody
    public void receive(String signature, String timestamp, String openid, String nonce, HttpServletRequest request) {
        System.out.println("---receive-----signature : " + signature);
        System.out.println("---receive-----timestamp : " + timestamp);
        System.out.println("---receive-----openid : " + openid);
        System.out.println("---receive-----nonce : " + nonce);
        if (!SignUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println("......check signature failed......");
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            System.out.print(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }
}

package com.study.wx.controller;

import com.study.wx.utils.SignUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author TangFD@HF 2018/8/27
 */
@RestController
public class IndexController {
    private static final Log LOG = LogFactory.getLog(IndexController.class);

    @GetMapping("/")
    public String check(String signature, String timestamp, String echostr, String nonce) {
        LOG.info("---check-----signature : " + signature);
        LOG.info("---check-----timestamp : " + timestamp);
        LOG.info("---check-----echostr : " + echostr);
        LOG.info("---check-----nonce : " + nonce);
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }

        return "hello wx ......";
    }

    @PostMapping("/")
    public void receive(String signature, String timestamp, String openid, String nonce, HttpServletRequest request) {
        LOG.info("---receive-----signature : " + signature);
        LOG.info("---receive-----timestamp : " + timestamp);
        LOG.info("---receive-----openid : " + openid);
        LOG.info("---receive-----nonce : " + nonce);
        if (!SignUtil.checkSignature(signature, timestamp, nonce)) {
            LOG.info("......check signature failed......");
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            LOG.info(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }
}

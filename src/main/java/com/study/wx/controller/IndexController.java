package com.study.wx.controller;

import com.study.wx.domain.EventMessage;
import com.study.wx.domain.WxConstants;
import com.study.wx.utils.SignUtil;
import com.tfd.base.utils.XmlJsonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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
    public void receive(String signature, String timestamp, String openid, String nonce,
                        HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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

            LOG.info(content);
            EventMessage message = XmlJsonUtils.xml2Object(content.toString(), EventMessage.class);
            LOG.info(message);
            String msgType = message.getMsgType();
            if (WxConstants.MSG_TYPE_EVENT.equals(msgType)) {
                String event = message.getEvent();
                switch (event) {
                    case WxConstants.MSG_EVENT_CLICK:
                        sendTextMessage(response, message, "你点击了按钮，哈哈哈哈哈");
                        break;
                    case WxConstants.MSG_EVENT_VIEW:
                        sendTextMessage(response, message, "你跳转了链接[" + message.getEventKey() + "]，哈哈哈哈哈");
                        break;
                    case WxConstants.MSG_EVENT_SCANCODE_PUSH:
                        sendTextMessage(response, message, "你跳转了链接[" + message.getEventKey() + "]，哈哈哈哈哈");
                        break;
                    default:
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    private void sendTextMessage(HttpServletResponse response, EventMessage message, String content) {
        EventMessage clickMessage = new EventMessage();
        clickMessage.setToUserName(message.getFromUserName());
        clickMessage.setFromUserName(message.getToUserName());
        clickMessage.setCreateTime(System.currentTimeMillis());
        clickMessage.setMsgType(WxConstants.MSG_TYPE_TEXT);
        clickMessage.setContent(content);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            String xml = XmlJsonUtils.object2Xml(clickMessage, "xml");
            LOG.info("===send xml===" + xml);
            writer.write(xml);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }
}

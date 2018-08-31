package com.study.wx.domain;

/**
 * @author TangFD@HF 2018/8/31
 */
public interface WxConstants {
    String TOKEN_KEY = "WX_ACCESS_TOKEN";
    /**
     * 菜单事件
     */
    String MSG_TYPE_EVENT = "event";
    /**
     * 文本消息
     */
    String MSG_TYPE_TEXT = "text";
    /**
     * 点击菜单拉取消息
     */
    String MSG_EVENT_CLICK = "CLICK";
    /**
     * 点击菜单跳转链接
     */
    String MSG_EVENT_VIEW = "VIEW";
    /**
     * 扫码推送事件
     */
    String MSG_EVENT_SCANCODE_PUSH = "scancode_push";
    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     */
    String MSG_EVENT_SCANCODE_WAITMSG = "scancode_waitmsg";
    /**
     * 弹出系统拍照发图
     */
    String MSG_EVENT_PIC_SYSPHOTO = "pic_sysphoto";
    /**
     * 弹出拍照或者相册发图
     */
    String MSG_EVENT_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    /**
     * 弹出微信相册发图器
     */
    String MSG_EVENT_PIC_WEIXIN = "pic_weixin";
    /**
     * 弹出地理位置选择器
     */
    String MSG_EVENT_LOCATION_SELECT = "location_select";

}

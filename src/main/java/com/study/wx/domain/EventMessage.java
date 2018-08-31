package com.study.wx.domain;

import com.tfd.base.utils.HttpUtils;

/**
 * 微信菜单事件推送消息类
 *
 * @author TangFD@HF 2018/8/31
 */
public class EventMessage {
    /**
     * 开发者 微信号
     */
    private String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long CreateTime;
    /**
     * 消息类型，event
     */
    private String MsgType;
    /**
     * 事件类型，location_select
     */
    private String Event;
    /**
     * 事件KEY值，由开发者在创建菜单时设定
     */
    private String EventKey;
    /**
     * 图片链接（由系统生成）
     */
    private String PicUrl;
    /**
     * 消息标题
     */
    private String Title;
    /**
     * 消息描述
     */
    private String Description;
    /**
     * 消息链接
     */
    private String Url;
    /**
     * 发送的位置信息
     */
    private String SendLocationInfo;
    /**
     * X坐标信息
     */
    private String Location_X;
    /**
     * Y坐标信息
     */
    private String Location_Y;
    /**
     * 精度，可理解为精度或者比例尺、越精细的话 scale越高
     */
    private String Scale;
    /**
     * 地理位置的字符串信息
     */
    private String Label;
    /**
     * 朋友圈POI的名字，可能为空
     */
    private String Poiname;
    /**
     * 发送的图片信息
     */
    private String SendPicsInfo;
    /**
     * 发送的图片数量
     */
    private String Count;
    /**
     * 图片列表
     */
    private String PicList;
    /**
     * 图片的MD5值，开发者若需要，可用于验证接收到图片
     */
    private String PicMd5Sum;
    /**
     * 扫描信息
     */
    private String ScanCodeInfo;
    /**
     * 扫描类型，一般是qrcode
     */
    private String ScanType;
    /**
     * 扫描结果，即二维码对应的字符串信息
     */
    private String ScanResult;
    /**
     * 消息内容
     */
    private String Content;
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String ThumbMediaId;
    /**
     * 消息id，64位整型
     */
    private String MsgId;
    /**
     * 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
     */
    private String MenuID;
    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String MediaId;
    /**
     * 语音格式，如amr，speex等
     */
    private String Format;
    /**
     * 消息id，64位整型
     */
    private String MsgID;
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String Ticket;
    /**
     * 地理位置纬度
     */
    private String Latitude;
    /**
     * 地理位置经度
     */
    private String Longitude;
    /**
     * 地理位置精度
     */
    private String Precision;


    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getPicList() {
        return PicList;
    }

    public void setPicList(String picList) {
        PicList = picList;
    }

    public String getPicMd5Sum() {
        return PicMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        PicMd5Sum = picMd5Sum;
    }

    public String getPoiname() {
        return Poiname;
    }

    public void setPoiname(String poiname) {
        Poiname = poiname;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(String scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
    }

    public String getScanResult() {
        return ScanResult;
    }

    public void setScanResult(String scanResult) {
        ScanResult = scanResult;
    }

    public String getScanType() {
        return ScanType;
    }

    public void setScanType(String scanType) {
        ScanType = scanType;
    }

    public String getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(String sendLocationInfo) {
        SendLocationInfo = sendLocationInfo;
    }

    public String getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(String sendPicsInfo) {
        SendPicsInfo = sendPicsInfo;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    @Override
    public String toString() {
        return HttpUtils.GSON.toJson(this);
    }
}

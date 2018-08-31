<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>微信测试工具</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div style="margin-top: 50px;"></div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-8 column">
            <div class="list-group">
                <a href="getAccessToken" class="list-group-item active">1. 获取access_token</a>
                <a href="refreshAccessToken" class="list-group-item">2. 刷新access_token</a>
                <form action="createMenu">
                    <input type="submit" value="3. 自定义菜单" class="btn btn-default btn-primary"/>
                    <br>
                        <textarea name="content" cols="90" rows="10">{
     "button":[
		{
          "name":"测试按钮",
          "sub_button": [
                {
                    "type": "click",
                    "name": "点击按钮",
                    "key": "0000000000000001"
                },
                {
					"type":"view",
					"name":"视频解析",
					"url":"http://cloud.cneln.net/feipeng-ps/vip/"
				},
				{
                    "type": "scancode_waitmsg",
                    "name": "扫码带提示",
                    "key": "rselfmenu_0_0"
                },
				{
                    "type": "scancode_push",
                    "name": "扫码推事件",
                    "key": "rselfmenu_0_1"
                },
				{
					"type": "location_select",
					"name": "发送位置",
					"key": "rselfmenu_2_0"
				}
            ]
		},
		{
          "name":"测试图片",
          "sub_button": [
				{
                    "type": "pic_sysphoto",
                    "name": "系统拍照发图",
                    "key": "rselfmenu_1_0"
                 },
                {
                    "type": "pic_photo_or_album",
                    "name": "拍照或者相册发图",
                    "key": "rselfmenu_1_1"
                },
                {
                    "type": "pic_weixin",
                    "name": "微信相册发图",
                    "key": "rselfmenu_1_2"
                }
			]
		}

	]
}</textarea>
                </form>
                <a href="getMenu" class="list-group-item active">4. 自定义菜单查询接口</a>
                <a href="deleteMenu" class="list-group-item">5. 自定义菜单删除接口</a>
                <a href="getUserList" class="list-group-item active">6. 获取用户列表</a>
            </div>
        </div>
        <div class="col-md-4 column">
            <h5 class="text-success">
            ${message!}
            </h5>
        </div>
    </div>
</div>
</body>
</html>
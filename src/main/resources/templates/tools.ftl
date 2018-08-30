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
        <div class="col-md-12 column">
            <div class="list-group">
                <a href="getAccessToken" class="list-group-item active">1. 获取access_token</a>
                <a href="refreshAccessToken" class="list-group-item">2. 刷新access_token</a>
                <div class="list-group-item">
                    <form action="createMenu">
                        <div><input type="submit" value="3. 自定义菜单" class="btn btn-default"/></div>
                        <textarea name="content" cols="90" rows="10">{
                            "button":[
     {
          "type":"view",
          "name":"视频解析",
          "url":"http://45.40.202.204/vip"
      }]
 }</textarea>
                    </form>

                </div>
                <a href="getMenu" class="list-group-item active">4. 自定义菜单查询接口</a>
                <a href="deleteMenu" class="list-group-item">5. 自定义菜单删除接口</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
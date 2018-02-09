<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黑小马
  Date: 2018/1/3
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>发布后台</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../admin/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../admin/css/unicorn.main.css" />
    <link rel="stylesheet" href="../admin/css/unicorn.grey.css" class="skin-color" />
    <link href="../admin/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="third-party/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../admin/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../admin/umeditor.min.js"></script>
    <script type="text/javascript" src="../admin/lang/zh-cn/zh-cn.js"></script>
    <style type="text/css">
        h1{
            font-family: "微软雅黑";
            font-weight: normal;
        }
    </style>
</head>
<body>

<div id="sidebar">
    <ul>
        <li><a href="../admin/index.jsp"><i class="icon icon-home"></i> <span>发布</span></a></li>
        <li><a href="../admin/tables.jsp"><i class="icon icon-home"></i> <span>删除</span></a></li>
        <li><a href="../admin/pa_m.jsp"><i class="icon icon-home"></i> <span>爬虫管理</span></a></li>
        <li><a href="../admin/pa_tables.jsp"><i class="icon icon-home"></i> <span>爬虫文章删除</span></a></li>
        <li><a href="../install"><i class="icon icon-home"></i> <span>安装数据库</span></a></li>
    </ul>
</div>
<div id="content">
    <div class="widget-box" style="width: 1000px;margin: 0 auto">
        <h1 style="text-align: center">发布后台</h1>

        <form action="/Insert_sql.jsp" method="post" style="margin: 0 auto">
            <input type="text" placeholder="标题" name="title"/>
            <script type="text/plain" id="myEditor" style="width:1000px;height:240px;">
                <p>这里我可以写一些输入提示</p>
            </script>
            <button type="submit">提交</button>
                </form>
                <script type="text/javascript">
            //实例化编辑器
            var um = UM.getEditor('myEditor');
            </script>
    </div>
</div>
</div>

<div class="row-fluid">
    <div id="footer" class="span12">
       by 黑小马
    </div>
</div>
</div>
</div>



</body>
</html>

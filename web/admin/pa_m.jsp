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
    <title>爬虫管理</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../admin/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../admin/css/unicorn.main.css"/>
    <link rel="stylesheet" href="../admin/css/unicorn.grey.css" class="skin-color"/>
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
    <div class="widget-box">
        <div class="widget-title">

            <h5>爬虫管理</h5>
        </div>
        <div class="widget-content nopadding">
            <div class="widget-content">

                <h3>手动采集数据</h3>
                <p>
                    <a href="../admin/cj.jsp?type=sd" class="btn btn-success btn-large">采集</a>
                </p>
                <h3>每24小时自动采集数据</h3>
                <p>
                    <a href="../admin/cj.jsp?type=auto&status=yes" class="btn btn-success btn-large">开启</a>
                    <a href="../admin/cj.jsp?type=auto&status=no" class="btn btn-danger btn-large">关闭</a>
                </p>
            </div>
        </div>
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

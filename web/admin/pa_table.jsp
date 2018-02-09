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
    <title>爬虫文章删除</title>
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

            <h5>删除数据</h5>
        </div>
        <div class="widget-content nopadding">
            <table class="table table-bordered table-striped table-hover data-table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>标题</th>
                    <th>时间</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="lists" items="${ren_list}">
                    <tr class="gradeA">
                    <td>${lists.id}</td>
                    <td>${lists.title}</td>
                    <td>${lists.time}</td>
                    <td class="center"><a class="btn btn-danger" href="pa_tables.jsp?id=${lists.id}">删除</a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
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

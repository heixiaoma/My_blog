<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: 黑小马
Date: 2018/1/3
Time: 18:44
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>黑小马个人博客</title>
    <meta name="keywords" content="黑小马个人博客，黑小马 AIDE AIDE黑小马"/>
    <meta name="description" content="黑小马个人博客，黑小马 AIDE AIDE黑小马"/>
    <link href="../web/css/base.css" rel="stylesheet">
    <link href="../web/css/index.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="../web/js/modernizr.js"></script>
    <![endif]-->
    <script src="../web/js/scrollReveal.js"></script>
</head>
<body>
<header>
    <div class="logo" data-scroll-reveal="enter right over 1s"><a href="/">
        <img src="../web/images/logo.png"></a>
    </div>
    <nav class="topnav" >
        <a href="/"><span>首页</span><span class="en">Home</span></a>
        <a href="/pa.jsp"><span>爬虫文章</span><span class="en">爬取的文章</span></a>
        <a href="../web/about.html"><span>关于我</span><span class="en">About</span></a>
        <a href="../web/gbook.html"><span>留言</span><span class="en">Saying</span></a>
    </nav>
</header>
<article>
    <div class="container">

        <ul class="cbp_tmtimeline">
            <c:forEach var="lists" items="${ren_list}">
                <li>
                    <time class="cbp_tmtime"><span>${lists.time_m}</span> <span>${lists.time_y}</span></time>
                    <div class="cbp_tmicon"></div>
                    <div class="cbp_tmlabel" data-scroll-reveal="enter right over 1s">
                        <h2>${lists.title}</h2>
                        <p><span class="blogpic">
                                <a href="/"><img src="${lists.src}"></a></span>
                                ${lists.dw}
                        </p>
                        <a href="/pa_template?id=${lists.id}" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <div class="page"><a href="/pa_Page.jsp?type=q&page=${pages_size-1}">上</a><a href="/pa_Page.jsp?type=h&page=${pages_size}">下</a></div>

    </div>
 </article>
<footer>
    Design by 黑小马 <a href="/">蜀ICP备11002373号-1</a>
</footer>
<script>
    if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
        (function () {
            window.scrollReveal = new scrollReveal({reset: true});
        })();
    };
</script>
</body>
</html>

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
<title>${ar.title}</title>
<meta name="keywords" content="黑小马个人博客，${ar.title}" />
<meta name="description" content="黑小马个人博客，${ar.title}" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../web/css/base.css" rel="stylesheet">
<link href="../web/css/about.css" rel="stylesheet">
<link href="../web/css/m.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="../web/js/modernizr.js"></script>
<![endif]-->
<script src="../web/js/scrollReveal.js"></script>
    <script src="http://c.csdnimg.cn/public/common/libs/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="http://c.csdnimg.cn/public/static/css/avatar.css">
    <link rel="stylesheet" href="http://csdnimg.cn/release/phoenix/production/main-305f4ba2cd.css">
    <link rel="stylesheet" href="http://c.csdnimg.cn/public/common/toolbar/content_toolbar_css/content_toolbar.css">
    <script src="http://csdnimg.cn/rabbit/exposure-click/main-1.0.5.js"></script>
    <script type="text/javascript" src="http://csdnimg.cn/pubfooter/js/tracking-1.0.2.js" charset="utf-8"></script>
    <script type="text/javascript" src="http://csdnimg.cn/release/phoenix/production/main-7d75e42869.js"></script>
    <script src="http://dup.baidustatic.com/js/ds.js"></script>
    <link rel="stylesheet" href="http://csdnimg.cn/release/phoenix/production/htmledit_views-21a3eac8a8.css">
</head>
<body>
<header>
  <div class="logo"  data-scroll-reveal="enter right over 1s">
<a href="/"><img height="45" src="../web/images/logo.png"></a></div>
  <nav class="topnav" >
<a href="/"><span>首页</span><span class="en">Home</span></a>
      <a href="/pa.jsp"><span>爬虫文章</span><span class="en">爬取的文章</span></a>
<a href="../web/about.html"><span>关于我</span><span class="en">About</span></a>
<a href="../web/gbook.html"><span>留言</span><span class="en">Saying</span></a>
  </nav>
</header>
<article>
  <div class="container">
      <div class="about left">

    <ul> 
        <h4 class="atitle"><span>${ar.time}</span>${ar.title}</h4>
        <p>${ar.content}</p>
    </ul>


</div>
</div>
  </div>
  </aside>
</article>

<footer> Design by 黑小马 <a href="/">蜀ICP备11002373号-1</a> </footer>
<script>
	if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
		(function(){
			window.scrollReveal = new scrollReveal({reset: true});
		})();
	};
</script><script src="/e/public/onclick/?enews=donews&classid=11&id=789"></script></body>
</html>

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
    <link rel="stylesheet" href="https://my.oschina.net/dist/www/css/blog.min.css">

    <link rel="stylesheet" href="https://my.oschina.net/build/www/vendor/highlight/9.4.0/styles/zenburn.css">
    <style>
        #blogBody{
            margin-right: 200px;
        }
    </style>
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

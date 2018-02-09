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

    <%--<div class="nextinfo">--%>
<%--<p>上一篇：<a href='/download/div/2017-07-16/785.html'>个人博客模板古典系列之——江南墨卷Html</a></p>--%>
<%--<p>下一篇：<a href='/download/div/'>返回列表</a></p>--%>
    <%--</div>--%>
    <%--<div class="otherlink">--%>
      <%--<h2>相关文章</h2>--%>
      <%--<ul>--%>
        <%--<li><a href="/download/div/2017-07-16/785.html" title="个人博客模板古典系列之——江南墨卷Html">个人博客模板古典系列之——江南墨卷Html</a></li><li><a href="/download/div/2017-07-13/783.html" title="古典风格-个人博客模板">古典风格-个人博客模板</a></li><li><a href="/download/div/2015-06-28/748.html" title="个人博客《草根寻梦》—手机版模板">个人博客《草根寻梦》—手机版模板</a></li><li><a href="/download/div/2015-04-10/746.html" title="【活动作品】柠檬绿兔小白个人博客模板">【活动作品】柠檬绿兔小白个人博客模板</a></li><li><a href="/jstt/bj/2015-01-09/740.html" title="【匆匆那些年】总结个人博客经历的这四年…">【匆匆那些年】总结个人博客经历的这四年…</a></li><li><a href="/jstt/web/2015-01-01/739.html" title=" 2014年度优秀个人博客排名公布"> 2014年度优秀个人博客排名公布</a></li><li><a href="/jstt/web/2014-12-18/736.html" title="2014年度优秀个人博客评选活动">2014年度优秀个人博客评选活动</a></li><li><a href="/jstt/bj/2014-11-06/732.html" title="分享我的个人博客访问量如何做到IP从10到600的(图文)">分享我的个人博客访问量如何做到IP从10到600的(图文)</a></li><li><a href="/download/div/2014-06-13/689.html" title="个人博客模板《世界杯来袭》">个人博客模板《世界杯来袭》</a></li><li><a href="/download/free/2014-05-30/685.html" title="HTML5摄影主题模板">HTML5摄影主题模板</a></li>      </ul>--%>
    <%--</div>--%>
<%--<div class="gbko">--%>
<%--<!--高速版-->--%>
<%--<div id="SOHUCS" sid="789" ></div>--%>
<%--<script charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/changyan.js" ></script>--%>
<%--<script type="text/javascript">--%>
<%--window.changyan.api.config({--%>
<%--appid: 'cytoPBp6U',--%>
<%--conf: 'b270a7f7ab3f9eba827edee580af977b'--%>
<%--});--%>
<%--</script>--%>
<%--</div>--%>
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
 
<body>

<c:if test="${listbg == null}">
<jsp:forward page="ProductCategoryServlet">
<jsp:param value="pclist" name="opr"/>
</jsp:forward> 
</c:if>

<c:if test="${page == null }">
<jsp:forward page="ProductServlet">
	<jsp:param value="showKind" name="ps"/>
</jsp:forward>
</c:if>

<c:if test="${newsPage == null}">
			<jsp:forward page="NewsServlet">
				<jsp:param value="page" name="opr"/>
			</jsp:forward>
</c:if>
<div id="welcomeImage">
    <img width="100%" height="150" src="images/banner.jpg" alt="welcome">
</div>
<jsp:include page="top.jsp"></jsp:include>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>

<div id="main" class="wrap">
	<div class="lefter">
		<jsp:include page="left.jsp"></jsp:include>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			
				<c:forEach items="${plist}" var="p">
				<dl class="clearfix">
				<dt><a href="ProductServlet?ps=detail&id=${p.id }"  target="_self"><img width="80px" height="100px"  src="/easybuy/images/${p.fileName }" /></a></dt>
				<dt><a href="ProductServlet?ps=detail&id=${p.id}"  target="_self">${p.name}</a></dt>
				<dt>&nbsp;</dt>
				<dd>&nbsp;</dd>
				</dl>
				</c:forEach>	
	  </div>
	</div>
	<div class="main">
		<div class="price-off">
            <div class="slideBox">
                <ul id="slideBox">
                    <li><img src="images/product/banner_1.jpg"/></li>
                    <li><img src="images/product/banner_2.jpg"/></li>
                    <li><img src="images/product/banner_3.jpg"/></li>
                    <li><img src="images/product/banner_4.jpg"/></li>
                </ul>
            </div>
			<h2>商品列表</h2>
			<ul class="product clearfix">
				<c:forEach items="${page.pageList }" var="product">
				<li>
					<dl>
						<dt><a href="ProductServlet?ps=detail&id=${product.id }"  target="_self"><img src="/easybuy/images/${product.fileName }" /></a></dt>
						<dd class="title"><a href="ProductServlet?ps=detail&id=${product.id }" target="_self">${product.name}</a></dd>
						<dd class="price">${product.price}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
			<div class="pager" >
					当前页数:[${page.pageIndex}/${page.pageTotal}]&nbsp;

					<c:if test="${page.pageIndex>1 }">
						<a href="ProductServlet?index=1&ps=showKind">首页</a>
						<a href="ProductServlet?index=${page.pageIndex-1}&ps=showKind">上一页</a>
					</c:if>
					<c:if test="${page.pageIndex<page.pageTotal }">
						<a href="ProductServlet?index=${page.pageIndex+1}&ps=showKind">下一页</a>
						<a href="ProductServlet?index=${page.pageTotal}&ps=showKind">末页</a>
					</c:if>
				</div>
		</div>
		<div class="side">			
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
				<c:forEach items="${newsPage.pageList}" var="news">
				<li><a href="NewsServlet?id=${news.id}&&opr=read"  target="_self">${news.title}</a></li></c:forEach>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
    </div>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>

<c:if test="${listbg!=null && page!=null && newsPage!=null}">
	<c:remove var="page"/>
	<c:remove var="newsPage"/>
</c:if>	
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<jsp:include page="left.jsp"></jsp:include>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
			<c:forEach items="${pages.pageList }" var="product">
				<tr>
					<td class="first w4 c">${product.id }</td>
					<td class="thumb"><img width="80px" height="100px" src="/easybuy/images/${product.fileName}" /><a href="../product-view.jsp" target="_self">${product.name}</a></td>
					<td class="w1 c"><a href="../ProductServlet?ps=updateProduct&id=${product.id }&cid=${product.cid}">修改</a> <a class="manageDel" href="../ProductServlet?ps=delProduct&id=${product.id }">删除</a></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
				当前页数:[${pages.pageIndex}/${pages.pageTotal}]&nbsp;

					<c:if test="${pages.pageIndex>1 }">
						<a href="../ProductServlet?index=1&ps=showAllProduct">首页</a>
						<a href="../ProductServlet?index=${pages.pageIndex-1}&ps=showAllProduct">上一页</a>
					</c:if>
					<c:if test="${pages.pageIndex<pages.pageTotal }">
						<a href="../ProductServlet?index=${pages.pageIndex+1}&ps=showAllProduct">下一页</a>
						<a href="../ProductServlet?index=${pages.pageTotal}&ps=showAllProduct">末页</a>
					</c:if>
  </div>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<c:remove var="pages"/>
</html>

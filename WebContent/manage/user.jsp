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
<c:if test="${empty pageUser}">
	<jsp:forward page="../UserServlet?action=page"></jsp:forward>
</c:if>
<c:if test="${!empty delUserState}">
	<script type="text/javascript">
		alert('${delUserState}');
	</script>
</c:if>
<c:if test="${!empty modiText}">
	<script type="text/javascript">
		alert('${modiText}');
	</script>
</c:if>
<c:remove var="delUserState" scope="session"/>
<c:remove var="modiText" scope="session"/>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
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
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>用户名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageUser.pageList}" var="user">
					<tr>
						<td class="first w4 c">${user.userName}</td>
						<td class="w2 c">${user.sex}</td>
						<td>${user.email}</td>
						<td style="display:none;" id="userId">${user.id}</td>
						<td class="w4 c">${user.mobile}</td>
						<td class="w1 c"><a href='/easybuy/UserServlet?action=getUser&userId=${user.id}'>修改</a> <a class="userDel" href="javascript:void(0)">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
	<div class="clear"></div>
     <div class="pager">
		<ul class="clearfix">
			<li>当前页数:[${pageUser.pageIndex}/${pageUser.pageTotal}]</li>
			<c:if test="${pageUser.pageIndex>1}">
			    <li><a href="../UserServlet?action=page&index=1">首页</a></li>
				<li><a href="../UserServlet?action=page&index=${pageUser.pageIndex-1}">上一页</a></li>
			</c:if>
			
			<c:if test="${pageUser.pageIndex<pageUser.pageTotal }">
				<li><a href="../UserServlet?action=page&index=${pageUser.pageIndex+1}">下一页</a></li>
			    <li><a href="../UserServlet?action=page&index=${pageUser.pageTotal }">尾页</a></li>
			</c:if>
		</ul>
  </div>
</div>
		</div>
	</div>
<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<c:remove var="pageUser"/>
</html>

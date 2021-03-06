<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<c:choose>
		<c:when test="${login!=null}">
			<div class="help">
			<a href="/easybuy/CartServlet?opr=listCart" id="shoppingBag" class="shopping">购物车${fn:length(cart.listItems)}件</a>
			<a href="javascript:void()"><c:out value="${login.userName}"></c:out></a>
			<a class="button" id="logout" href="javascript:void()">注销</a><a href="guestbook.jsp">留言</a><a href="manage/index.jsp">后台管理</a></div>
		</c:when>
		<c:otherwise>
			<div class="help"><a href="/easybuy/CartServlet?opr=listCart" id="shoppingBag" class="shopping">购物车<span id="cartItem">${fn:length(cart.listItems)}</span>件</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a><a href="manage/index.jsp">后台管理</a></div>
		</c:otherwise>
	</c:choose>
    <div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="/easybuy/index.jsp">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
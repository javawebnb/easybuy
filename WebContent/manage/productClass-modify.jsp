<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="/easybuy/css/style.css" />
<script type="text/javascript" src="/easybuy/scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/easybuy/scripts/function.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="/easybuy/images/logo.gif" />
		</div>
		<div class="help">
			<a href="/easybuy/index.jsp">返回前台页面</a>
		</div>
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
		<div class="welcome wrap">管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
	</div>
	<div id="main" class="wrap">
<<<<<<< HEAD
		<jsp:include page="left.jsp"></jsp:include>
=======
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<em><a href="user-add.jsp">新增</a></em><a href="user.jsp">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					 <c:url var="url1" value="/ProductCategoryServlet">
			  	   <c:param name="opr" value="tosave"></c:param>
			   </c:url> 
				<dd><em><a href="${url1 }">新增</a></em>
				 <c:url var="url" value="/ProductCategoryServlet">
				<c:param name="opr" value="pagelist"></c:param>
				</c:url> 
				<a href="${url }">分类管理</a></dd>
					<dd>
						<em><a href="product-add.jsp">新增</a></em><a href="product.jsp">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="order.jsp">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="guestbook.jsp">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>
>>>>>>> branch 'LZM' of https://github.com/javawebnb/easybuy.git
		<div class="main">
			<h2>修改分类</h2>
			<div class="manage">
				<form action="ProductCategoryServlet">
					<table class="form">
						<tr>
							<td class="field">父分类：</td>
							<td><select name="parentId">
									<%-- <c:choose>
									<c:when test="${pc.id eq pc.parentId }"> --%>
									<option value="0" selected="selected">根栏目</option>
									<%-- </c:when>
									<c:otherwise> --%>
									<c:forEach var="item" items="${sessionScope.biglist }">
									<%-- <c:choose>
									<c:when test="${item.id eq pc.parentId }">
									<option value="${item.id }" selected="selected">${item.name }</option>
									</c:when>
									<c:otherwise> --%>
										<option value="${item.id }">${item.name }</option>
										<%-- </c:otherwise>
										</c:choose> --%>
									</c:forEach>
									<%-- </c:otherwise>
									</c:choose> --%>
							</select></td>
						</tr>
						<tr>
							<td class="field">分类名称：</td>
							<td><input type="text" class="text" name="className"
								value="${pc.name }" /></td>
						</tr>
						<tr>
							<td><input type="hidden" name="opr" value="updt"></td>
							<td><input type="hidden" name="epcid" value="${pc.id }"></td>
					 	    <td><input type="hidden" name="parentid" value="${pc.parentId }"></td> 
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="更新" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 云和学院 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

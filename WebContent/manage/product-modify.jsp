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
		<h2>修改商品</h2>
		<div class="manage">
			<form action="../ProductServlet?ps=updateProductTwo&id=${product.id}" method="post">
				<table class="form">
					<tr>
						<td class="field">商品名称(*)：</td>
						<td><input type="text" class="text" name="name" value="${product.name }" /></td>
					</tr>
                    <tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="description" value="${product.description }"/></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
						<%-- <input type="text" name="cid" value="${product.cid }"> --%>
						
						<select name="parentId">
								<c:forEach items="${sessionScope.listbg}" var="item">
									<option value="${item.id}">${item.name}</option>
									<c:forEach items="${sessionScope.listsn}" var="itemson">
										<c:choose>
										<c:when test="${item.id eq itemson.parentId}">
										      <option value="${itemson.id}">├${itemson.name}</option>
										</c:when>
										</c:choose>
									</c:forEach>
								</c:forEach>
							</select>
						
						
							<!-- <select name="parentId">
								<option value="1">电器</option>
								<option value="3">├ 电器</option>
								<option value="3">└ 电器</option>
								<option value="2">衣服</option>
								<option value="3">├ 电器</option>
								<option value="3">└ 电器</option>
							</select> -->
						</td>
					</tr>					
					<tr>
						<td class="field">商品价格(*)：</td>
						<td><input type="text" class="text tiny" name="price" value="${product.price }" /> 元</td>
					</tr>
					
					<tr>
						<td class="field">库存(*)：</td>
						<td><input type="text" class="text tiny" name="stock" value="${product.stock }"/></td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" value="${product.fileName }"/></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="确定" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>

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
		<h2>修改用户</h2>
		<div class="manage">
			<form action="/easybuy/UserServlet?action=modifyUser" method="post">
				<table class="form">
					<tr>
						<input type="hidden" name="id" value="${getUser.id}" />
						<td class="field">用户名(*)：</td>
						<td><input type="text" class="text" name="userName" value="${getUser.userName}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input type="text" class="text" name="passWord"/></td>
					</tr>
                    <tr>
						<td class="field">确认密码(*)：</td>
						<td><input type="text" class="text" name="passWord2"  /></td>
					</tr>
					<tr>
						<td class="field">性别(*)：</td>
						<td><input type="radio" name="sex" value="1" checked="checked" />男 <input type="radio" name="sex" value="0" />女</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<select name="birthyear">
								<option value="2000">2000</option>
								<option value="1999" selected="selected">1999</option>
							</select>年
							<select name="birthmonth">
								<option value="12">12</option>
								<option value="11" selected="selected">11</option>
							</select>月
							<select name="birthday">
								<option value="2">2</option>
								<option value="1" selected="selected">1</option>
							</select>日
						</td>
					</tr>
					<tr>
						<td class="field">手机(*)：</td>
						<td><input type="text" class="text" name="mobile" value="${getUser.mobile }" /></td>
					</tr>
					<tr>
						<td class="field">地址(*)：</td>
						<td><input type="text" class="text" name="address" value="${getUser.address }" /></td>
					</tr>					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<c:remove var="getUser"/>
<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>

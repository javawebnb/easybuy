<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript">
$(".manageDel").click(function(){
	confirm("确定要删除吗？");
	return true;
})
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li class="current"><a href="news.jsp">新闻</a></li>
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
<c:if test="${empty newsPage}">
	<jsp:forward page="../NewsServlet">
	<jsp:param value="page" name="opr"/>
	<jsp:param value="manager" name="role"/>
	</jsp:forward>	
</c:if>
<div id="main" class="wrap">
	<jsp:include page="left.jsp"></jsp:include>
	<div class="main">
		<h2>新闻管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>新闻标题</th>
					<th>操作</th>
				</tr>
				<c:forEach    var="news" items="${newsPage.pageList}">
					<tr>
						<td class="first w4 c">${news.id}</td>
						<td>${news.title}</td>
						<td class="w1 c"><a href="../NewsServlet?opr=toupdate&&id=${news.id}">修改</a> <a class="manageDel" href="../NewsServlet?opr=delNews&&id=${news.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
				<ul class="clearfix">
				<c:if test="${newsPage.pageIndex >1}">
					<li><a href="../NewsServlet?opr=page&role=manager&i=1">首页</a></li>
					<li><a href="../NewsServlet?opr=page&role=manager&i=${newsPage.pageIndex - 1 }">上一页</a></li>
				</c:if>
					
					<li class="current">${newsPage.pageIndex }</li>
					
				<c:if test="${newsPage.pageIndex < pageObj.pageTotal}">
					<li><a href="../NewsServlet?opr=page&role=manager&i=${newsPage.pageIndex + 1 }">下一页</a></li>
					<li><a href="../NewsServlet?opr=page&role=manager&i=${newsPage.pageTotal}">尾页</a></li>
				</c:if>	
                    
				</ul>
  </div>
</div>
<c:remove var="newsPage"/>
<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<c:remove var="pageObj"/>
</html>

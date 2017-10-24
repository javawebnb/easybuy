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
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li class="current"><a href="guestbook.jsp">留言</a></li>
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
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="user.jsp">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="productClass.jsp">分类管理</a></dd>
				<dd><em><a href="product-add.jsp">新增</a></em><a href="product.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	
	<c:if test="${empty pageObj }">
		<jsp:forward page="../CommentServlet">
			<jsp:param value="page" name="opr"/>
			<jsp:param value="manage" name="role"/>
		</jsp:forward>
	</c:if>
	
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${pageObj.pageList }" var="comment" varStatus="s">
					<tr>
						<td class="first w4 c" id="cid">${comment.id }</td>
						<td class="w1 c">${comment.nickName }</td>
						<td>${comment.content }</td>
						<c:choose>
							<c:when test="${empty comment.reply }">
								<td class="w1 c"></td>
							</c:when>
							<c:otherwise>
								<td class="w1 c">已回复</td>
							</c:otherwise>
						</c:choose>
						<td class="w1 c"><a href="../CommentServlet?opr=replyPage&id=${comment.id }">回复</a> <a href="javascript:void(0)" onclick="delComment(${comment.id})">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pageObj.pageIndex > 1 }">
						<li><a href="../CommentServlet?opr=page&role=manager&i=1">首页</a></li>
						<li><a href="../CommentServlet?opr=page&role=manager&i=${pageObj.pageIndex - 1 }">上一页</a></li>
					</c:if>
					
					<li class="current">${pageObj.pageIndex }</li>
                    
                    <c:if test="${pageObj.pageIndex < pageObj.pageTotal }">
                    	<li><a href="../CommentServlet?opr=page&role=manager&i=${pageObj.pageIndex + 1 }">下一页</a></li>
						<li><a href="../CommentServlet?opr=page&role=manager&i=${pageObj.pageTotal }">尾页</a></li>
                    </c:if>
				</ul>
			</div>
		</div>
	</div>
	<c:remove var="pageObj"/>
	<div class="clear"></div>
</div>
<script type="text/javascript">
	function delComment(id){
		if(confirm("确定删除么你？")){
			location.href= "../CommentServlet?id="+id+"&opr=delComment";
		}else{
			return false;
		}
	}
</script>

<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>

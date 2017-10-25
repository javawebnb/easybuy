<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<dt>图书音像</dt>
				<dd><a href="product-list.jsp">图书</a></dd>
				<dd><a href="product-list.jsp">音乐</a></dd>
				<dt>百货</dt>
				<dd><a href="product-list.jsp">运动健康</a></dd>
				<dd><a href="product-list.jsp">服装</a></dd>
				<dd><a href="product-list.jsp">家居</a></dd>
				<dd><a href="product-list.jsp">美妆</a></dd>
				<dd><a href="product-list.jsp">母婴</a></dd>
				<dd><a href="product-list.jsp">食品</a></dd>
				<dd><a href="product-list.jsp">手机数码</a></dd>
				<dd><a href="product-list.jsp">家具首饰</a></dd>
				<dd><a href="product-list.jsp">手表饰品</a></dd>
				<dd><a href="product-list.jsp">鞋包</a></dd>
				<dd><a href="product-list.jsp">家电</a></dd>
				<dd><a href="product-list.jsp">电脑办公</a></dd>
				<dd><a href="product-list.jsp">玩具文具</a></dd>
				<dd><a href="product-list.jsp">汽车用品</a></dd>
			</dl>
		</div>
	</div>
	
	<c:if test="${empty pageObj }">
		<jsp:forward page="CommentServlet">
			<jsp:param value="page" name="opr"/>
		</jsp:forward>
	</c:if>
	
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				
			<c:forEach items="${pageObj.pageList }" var="comment" varStatus="s">
				<li>
					<dl>
						<dt>${comment.content}</dt>
						<dd class="author">网友：${comment.nickName }<span class="timer">${comment.createTime }</span></dd>
						<dd>${comment.reply }</dd>
					</dl>
				</li>
			</c:forEach>
				
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
				<c:if test="${pageObj.pageIndex > 1 }">
					<li><a href="CommentServlet?opr=page&i=1">首页</a></li>
					<li><a href="CommentServlet?opr=page&i=${pageObj.pageIndex - 1 }">上一页</a></li>
				</c:if>
					
					
					<li class="current">${pageObj.pageIndex}</li>
                    
                    
                 <c:if test="${pageObj.pageIndex < pageObj.pageTotal }">
                 	<li><a href="CommentServlet?opr=page&i=${pageObj.pageIndex + 1 }">下一页</a></li>
					<li><a href="CommentServlet?opr=page&i=${pageObj.pageTotal }">尾页</a></li>
                 </c:if>   
                    
				</ul>
			</div>
			<div id="reply-box">
				<form id="guestBook" method="post" action="CommentServlet?opr=saveComment">
					<table>
						<tr>
							<td class="field">昵称:</td>
							<td><input readonly="readonly" class="text" type="text" name="guestName" value="${login.userName}"/></td>
						</tr>						
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	
	<c:remove var="pageObj"/>
	
>>>>>>> branch 'master' of https://github.com/javawebnb/easybuy.git
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

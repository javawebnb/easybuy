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
<script type="text/javascript">
	function check(){
		var guestContent = document.getElementById("guestContent");
		var guestName = document.getElementById("guestName");
		if(guestContent.value == ""){
			alert("留言内容不能为空！");
			guestContent.focus();
			return false;
		}
		if(guestName.value == ""){
			alert("请先登录！");
			guestName.focus();
			return false;
		}
		return true;
	}
</script>
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
		<jsp:include page="left.jsp"></jsp:include>
	</div>
	
	<c:if test="${empty commentPage }">
		<jsp:forward page="CommentServlet">
			<jsp:param value="page" name="opr"/>
		</jsp:forward>
	</c:if>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				
			<c:forEach items="${commentPage.pageList }" var="comment" varStatus="s">
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
				<c:if test="${commentPage.pageIndex > 1 }">
					<li><a href="CommentServlet?opr=page&i=1">首页</a></li>
					<li><a href="CommentServlet?opr=page&i=${commentPage.pageIndex - 1 }">上一页</a></li>
				</c:if>
					
					
					<li class="current">${commentPage.pageIndex}</li>
                    
                    
                 <c:if test="${commentPage.pageIndex < commentPage.pageTotal }">
                 	<li><a href="CommentServlet?opr=page&i=${commentPage.pageIndex + 1 }">下一页</a></li>
					<li><a href="CommentServlet?opr=page&i=${commentPage.pageTotal }">尾页</a></li>
                 </c:if>   
                    
				</ul>
			</div>
			<div id="reply-box">
				<form id="guestBook" method="post" action="CommentServlet?opr=saveComment" onsubmit="return check()">
					<table>
						<tr>
							<td class="field">昵称:</td>
							<td><input readonly="readonly" class="text" type="text" name="guestName" id="guestName" value="${login.userName}"/></td>
						</tr>						
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent" id="guestContent"></textarea><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
<<<<<<< HEAD
	</div>
	
	<c:remove var="commentPage"/>
=======
	</div>
	<c:remove var="pageObj"/>
	<c:remove var="commentPage"/>
>>>>>>> branch 'master' of https://github.com/javawebnb/easybuy.git
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

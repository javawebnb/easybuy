<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.yh.easybuy.entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="/easybuy/css/style.css" />
<script type="text/javascript"
	src="/easybuy/scripts/jquery-1.8.3.min.js"></script>
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
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<a href="user.jsp">用户管理</a>
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
		<div class="main">
			<h2>分类管理</h2>
			<div class="manage">
				<table class="list">
					<tr>
						<th>编号</th>
						<th>分类名称</th>
						<th>类别</th>
						<th>操作</th>
					</tr>
					<c:forEach var="item" items="${page.pageList}">
						<tr>
							<td class="first w4 c">${item.id }</td>
							<td>${item.name }</td>
							<c:choose>
								<c:when test="${item.parentId eq 0 }">
									<td>大类</td>
								</c:when>
								<c:otherwise>
									<td>小类</td>
								</c:otherwise>
							</c:choose>
							<c:url var="URL" value="ProductCategoryServlet">
								<c:param name="opr" value="toupdt"></c:param>
								<c:param name="epcid" value="${item.id }"></c:param>
								<c:param name="parentId" value="${item.parentId }"></c:param>
							</c:url>
							<td class="w1 c"><a href="${URL }">修改</a> <%-- <c:url var="URL1" value="ProductCategoryServlet">
								<c:param name="opr" value="del"></c:param>
								<c:param name="epcid" value="${item.id }"></c:param>
								<c:param name="parentId" value="${item.parentId }"></c:param>
							</c:url> --%> <a href="javascript:void(0);"
								onclick="del(${item.id },${item.parentId});">删除</a></td>
						</tr>
					</c:forEach>
					<script>
					function del(epcid,parentId){
						if(confirm("您确认要删除分类及其下面的商品吗？")){
							location.href="ProductCategoryServlet?epcid="+epcid+"&parentId="+parentId+"&opr=del";
						}
					}
					</script>

				</table>
			</div>
		</div>
		<div class="clear"></div>
		<div class="pager">
			<ul class="clearfix">
				<c:if test="${page.pageIndex >1}">
					
				
				<c:url var="url" value="ProductCategoryServlet">
					<c:param name="opr" value="pagelist"></c:param>
					<c:param name="i" value="1"></c:param>
				</c:url>
				<li><a href="${url }">首页</a></li>
				<%-- <c:url var="url2" value="ProductCategoryServlet">
				<c:param name="opr" value="pagelist"></c:param>
				<c:param name="i" value="${page.pageIndex }"></c:param>
				</c:url>  --%>
				<a
					href="ProductCategoryServlet?opr=pagelist&i=${page.pageIndex -1}">上一页</a>
				<%-- <c:url var="url3" value="ProductCategoryServlet">
				<c:param name="opr" value="pagelist"></c:param>
				<c:param name="i" value="${page.pageIndex }"></c:param>
				</c:url> --%>
				
				</c:if>
				
				<c:if test="${page.pageIndex < page.pageTotal }">
					
			
				<a
					href="ProductCategoryServlet?opr=pagelist&i=${page.pageIndex +1}">下一页</a>
				<c:url var="url1" value="ProductCategoryServlet">
					<c:param name="opr" value="pagelist"></c:param>
					<c:param name="i" value="${page.pageTotal }"></c:param>
				</c:url>
				<li><a href="${url1 }">尾页</a></li>
			
				</c:if>
				
			</ul>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2013云和学院 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
<c:remove var="page"/>
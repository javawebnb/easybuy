<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="/easybuy/manage/user.jsp">用户管理</a></dd>
			  <dt>商品信息</dt>
				 <c:url var="url1" value="ProductCategoryServlet">
			  	   <c:param name="opr" value="tosave"></c:param>
			   </c:url> 
				<dd><em><a href="/easybuy/${url1 }">新增</a></em>
				
				 <c:url var="url" value="ProductCategoryServlet">
				<c:param name="opr" value="pagelist"></c:param>
				</c:url> 
				<a href="/easybuy/${url}">分类管理</a></dd>
				<dd><em><a href="/easybuy/ProductServlet?ps=getSort">新增</a></em>
			  
				<a href="/easybuy/ProductServlet?ps=showAllProduct ">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="/easybuy/manage/order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="/easybuy/manage/guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="/easybuy/manage/news-add.jsp">新增</a></em><a href="/easybuy/manage/news.jsp">新闻管理</a></dd>
			</dl>
		</div>
	</div>
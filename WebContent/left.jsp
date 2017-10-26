<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<div class="box">
			<h2>商品分类</h2>
			<dl>
			<c:forEach items="${sessionScope.listbg }" var="item">
				<dt>${item.name }</dt>
				<c:forEach items="${sessionScope.listsn }" var="itemson">
				<c:choose>
				<c:when test="${item.id eq itemson.parentId}">
				<dd><a href="ProductServlet?cid=${itemson.id}&ps=showProduct">${itemson.name}</a></dd>
				</c:when>
				</c:choose>
				</c:forEach>
				</c:forEach>
			</dl>
		</div>
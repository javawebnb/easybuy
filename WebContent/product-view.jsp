<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<jsp:include page="left.jsp"></jsp:include>
	</div>
	<div id="product" class="main">
		<h1>${product.name}</h1>
		<div class="infos">
			<c:set var="tag" value="single" scope="session"></c:set>
			<c:set var="pid" value="${product.id}" scope="session"></c:set>
			<div class="pid" style="display:none">${product.id}</div>
			<div class="thumb"><img src="images/${product.fileName }" width="110" height="106" /></div>
			<div class="buy">
				商城价：<span class="price">${product.price}</span><br />
				库　存：${product.stock}
			  <div class="button"><input type="button" name="button" value="" onclick="location.href = '/easybuy/address.jsp'" /><a href="javascript:void(0)" onclick="addCart()">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">${product.description}</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<script type="text/javascript">
	function addCart(){
		var pid = $(".pid").html();
		$.ajax({
			url:"CartServlet",
			type:"post",
			data:{"opr":"addCart","pid":pid},
			dataType:"text",
			success:function(result){
				$("#shoppingBag").html("购物车"+result+"件");
				alert("添加成功!");
			}
		})
		
	}
</script>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="address.jsp">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<tr id="product_id_0">
					<td class="thumb"><img src="images/product/0.jpg" /><a href="product-view.jsp">铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机</a></td>
					<td class="price" id="price_id_0">
						<span>￥99.00</span>
						<input type="hidden" value="99" />
					</td>
					<td class="number">
                        <span name="del">-</span>
                        <input id="number_id_0" type="text" name="number" value="1" />
                        <span name="add">+</span>
					</td>
					<td class="delete"><a href="javascript:void(0)">删除</a></td>
				</tr>
                <tr id="product_id_1">
                    <td class="thumb"><img src="images/product/0.jpg" /><a href="product-view.jsp">铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机</a></td>
                    <td class="price" id="price_id_1">
                        <span>￥99.00</span>
                        <input type="hidden" value="99" />
                    </td>
                    <td class="number">
                        <span name="del">-</span>
                        <input id="number_id_1" type="text" name="number" value="1" />
                        <span name="add">+</span>
                    </td>
                    <td class="delete"><a href="javascript:void(0)">删除</a></td>
                </tr>
			</table>
            <div class="total"><span id="total">总计：￥0</span></div>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>

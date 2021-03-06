<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
			<li class="current"><a href="order.jsp">订单</a></li>
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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">				
			</div>
			<div class="spacer"></div>
			
			<c:if test="${OrderPage	== null}">
				<jsp:forward page="../OrderServlet">
					<jsp:param value="showAll" name="opr"/>
					<jsp:param value="manager" name="role"/>
				</jsp:forward>
			</c:if>
			
            <form id="orderForm" method="post"  action="/easybuy/OrderServlet?opr=showAll">
                 	订单号：<input type="text" class="text" name="entityId" id="entityId" />
                 	订货人：<input type="text" class="text" name="userName" id="userName" />
                 <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
            </form>
				<table class="list">
				<c:forEach var="order" items="${sessionScope.OrderPage.pageList}">
					<tr>
						<th colspan="2">单号：${order.id}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时间：${order.createTime}</th>					
						<th class="hiddenSta">${order.status}</th>
						<th colspan="2">状态:
							<select class="status" name="status">						    
									<option value="1"  >待审核</option>
									<option value="2"  >审核通过</option>
									<option value="3"  >配货</option>
									<option value="4" >发货</option>
									<option value="5"  >收货确认</option>
							</select>
						</th>								
					</tr>
					<c:forEach var="orderDetail" items="${order.listDetail}" varStatus="varS">
					    <tr>
							<td class="first w4 c"><img width="90px" height="70px" src="/easybuy/images/${orderDetail.product.fileName}" />${orderDetail.product.name}</td>
							<td></td>
							<td>${orderDetail.quantity}</td>
							<c:if test="${varS.count==1}">
								<td class="w1 c" rowspan="${fn:length(order.listDetail)}">总计：${order.cost}</td>
					        </c:if>	
					    </tr>
					</c:forEach>
					
			</c:forEach>			
			</table>
	<div class="clear"></div>
	<div class="pager">
			<ul class="clearfix">
			    <li class="current">当前页数:[${OrderPage.pageIndex}/${OrderPage.pageTotal}]</li>
				<c:if test="${OrderPage.pageIndex >1}"> 
					<li><a href="../OrderServlet?opr=showAll&role=manager&i=1">首页</a></li>
					<li><a href="../OrderServlet?opr=showAll&role=manager&i=${OrderPage.pageIndex - 1 }">上一页</a></li>
				</c:if>
				<c:if test="${OrderPage.pageIndex < OrderPage.pageTotal}">
					<li><a href="../OrderServlet?opr=showAll&role=manager&i=${OrderPage.pageIndex + 1 }">下一页</a></li>
					<li><a href="../OrderServlet?opr=showAll&role=manager&i=${OrderPage.pageTotal}">尾页</a></li>
				</c:if>	
                    
			</ul>
  		</div>
</div>
		</div>
	</div>
<c:remove var="OrderPage"/>
<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<c:remove var="order"/>
<script>
/* function a(obj,status){
	$(obj).parent().find("select").children().each(function(){
		var value = $(this).val();
		if(value==status){
			$(this).attr("selected","selected");
		}
	})
}
$(".hiddenSta").each(function(){
	var status = $(this).html();
	a(this,status);
}) */
var $tr = $(".list").find("tr");
$tr.children(".hiddenSta").css("display","none");
$tr.each(function(i,e){
	var status = $($tr[i]).children(".hiddenSta").html();
	var $children = $($tr[i]).find(".status").children();
	$children.each(function(j,c){
		var value = $($children[j]).val();
		if(value==status){
			$($children[j]).attr("selected","selected");
		}
	})
})
</script>
</html>

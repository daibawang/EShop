<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	String jsUrl=request.getContextPath()+"/public/js/";
	String cssUrl=request.getContextPath()+"/public/css/";
	String imgUrl=request.getContextPath()+"/public/img/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
<link rel="icon" href="./public/img/title_icon.ico" type="image/x-icon"/>
<link href="<%=cssUrl%>bootstrap.min.css" rel="stylesheet">

<link href="<%=cssUrl%>index.css" rel="stylesheet">

<script type="text/javascript" src="<%=jsUrl%>jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=jsUrl%>bootstrap.min.js"></script>
</head>
<body>
		<%  
		String pagea = "trade";
		session.setAttribute("thispage",pagea); //获取会话中的信息
		%>
	<%@ include file="./commons/header.jsp"%>
	<c:choose>
	<c:when test="${ !empty sessionScope.trades }">
	<div class="container">
		<div class="container">
			<div class="alert alert-success tip-success" id="computerNumber">您 共 有 <b> ${sessionScope.tradescount} </b> 个 订 单</div>
			<c:forEach items = "${sessionScope.trades }" var = "item">
				<table class="table table-striped">
					<tr style="">
						<td class="col-md-2">订单创建时间:${item.tradeTime}<span style="margin-left:30px;">订单号：${item.tradeId}</span></td>
						<td class="col-md-2 text-center">数量</td>
						<td class="col-md-2 text-center">单价</td>
						<td class="col-md-2 text-center">总价</td>
					</tr>
					<c:forEach items = "${item.tradeItems }" var = "tradeItems"> 
						<tr>
							<td class="col-md-6 ">
								<img src="${tradeItems.commodity.url }"/ style="width:180px;height:180px;">
								${tradeItems.commodity.brand } &nbsp; ${tradeItems.commodity.model}
							</td>
							<td class="col-md-2 cartItem text-center" style="height:100px;line-height: 200px;">
								x ${tradeItems.quantity}
							</td>
							<td class="col-md-2 text-center" style="height:100px;line-height: 200px;">￥ <b>${tradeItems.commodity.price}</b></td>
							<td class="col-md-2 text-center" style="height:100px;line-height: 200px;">
							￥ <b>${tradeItems.quantity *tradeItems.commodity.price}</b>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div id="totalMoney" style="font-size:18px;font-weight:bold;float:right;margin-right:30px;">订单总金额：￥   ${item.totalmoney}</span> 
				</div>
			</c:forEach>
		</div>
	</div>
	</c:when>
		<c:otherwise>
			<jsp:forward page="./emptyTrades.jsp" />
		</c:otherwise>
	</c:choose>
	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
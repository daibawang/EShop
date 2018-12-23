<%@page import="com.entity.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./public/js/jquery-3.2.1.min.js"></script>
</head>
<%  
	
	User user = new User();
	user=(User)session.getAttribute("user"); //获取会话中的信息
	String username ="";
	int userid =0;
	if(user!=null){
		username =user.getUsername();
		userid=user.getUserid();
	}
	String activePage = (String)session.getAttribute("thispage");
%>
<nav class="navbar navbar-default navbar-static-top">
	      <div class="container">
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="./Begin.jsp"><span class="glyphicon glyphicon-gift"></span>  EStore百货铺子</a>
		        </div>
		        <div id="navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
		          <ul class="nav navbar-nav">
		            <li id="homepage"><a href="./Begin.jsp">首页</a></li>
		            <li id="about"><a href="./about.jsp">关于</a></li>
	            	<li id="connection" ><a href="./connection.jsp">联系我们</a></li>
		          </ul>
		          <ul class="nav navbar-nav navbar-right">
      				<li role="presentation" id="cart"><a href="./cart.jsp"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>&nbsp;购物车&nbsp;<span class="badge">${sessionScope.ShoppingCart.computerNumber }</span></a></li>
      				<li id="login"><a href="./login.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp;登录/注册&nbsp;</a></li>
	       	 		<li class="dropdown" id="">
	       	 			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;<span id="usernamea"></span></span><span class="caret"></span></a>
		          		<ul class="dropdown-menu">
				            <li><a href="" id ="mytrade">我的订单</a></li>
				            <li role="separator" class="divider"></li>
				            <li><a href="UserServlet?method=Logout">退出</a></li>
		          		</ul>
	        		</li>
      			  </ul>
		        </div><!--/.nav-collapse -->
	      </div>
</nav>
<script type="text/javascript" >
$(document).ready(function () {  
	islogin();	
	active();
});


function active(){
	$("#<%=activePage%>").addClass('active',true);
}
function islogin(){
	var userid = "<%=username%>";
	var uid="<%=userid%>";
	if (userid==""){
		$(".dropdown").css("display","none");
	}else{
		$("#login").css("display","none");
		$("#usernamea").text(userid);
		$("#mytrade").attr('href','TradeServlet?method=TradeByUserId&userid='+uid); 
	}
	
	/* $("#login").css("display","none"); */
}
</script>

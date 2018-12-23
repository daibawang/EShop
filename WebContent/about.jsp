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
<title>关于我们</title>
<link rel="icon" href="./public/img/title_icon.ico" type="image/x-icon"/>
<link href="<%=cssUrl%>bootstrap.min.css" rel="stylesheet">

<link href="<%=cssUrl%>index.css" rel="stylesheet">

<script type="text/javascript" src="<%=jsUrl%>jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=jsUrl%>bootstrap.min.js"></script>
</head>
<body>
		<%  
		String pageabout = "about";
		session.setAttribute("thispage",pageabout); //获取会话中的信息
		%>
	<%@ include file="./commons/header.jsp"%>
		
	<div class="container">
		<div class="jumbotron" style="margin-top:30px;">
  			<p>欢迎光临EStore百货铺子</p>
  			<p>这一家啥都卖~啥都有宇宙最强的购物铺子~快去选购吧</p>
  			
		</div>
	</div>		
	
			
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
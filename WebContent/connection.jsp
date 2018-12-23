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
<title>联系我们</title>
<link rel="icon" href="./public/img/title_icon.ico" type="image/x-icon"/>
<link href="<%=cssUrl%>bootstrap.min.css" rel="stylesheet">

<link href="<%=cssUrl%>index.css" rel="stylesheet">

<script type="text/javascript" src="<%=jsUrl%>jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=jsUrl%>bootstrap.min.js"></script>
</head>
<body>
	<%  
		String pageconnetion = "connection";
		session.setAttribute("thispage",pageconnetion); //获取会话中的信息
	%>
	<%@ include file="./commons/header.jsp"%>
		
	<div class="container">
		<div class="jumbotron" style="margin-top:30px;">
  			<p>联系地址:北京城市学院某处某地~找得到算我输</p>
  			<p>联系方式：18810555555~打得通就怪啦</p>
  			<p>github地址：~打得通就怪啦</p>
		</div>
	</div>		
	
			
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
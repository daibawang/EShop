<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String jsUrl=request.getContextPath()+"/public/js/";
	String cssUrl=request.getContextPath()+"/public/css/";
	String imgUrl=request.getContextPath()+"/public/img/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录/注册</title>
	<link rel="icon" href="./public/img/title_icon.ico" type="image/x-icon"/>
<link href="<%=cssUrl%>bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="<%=jsUrl%>jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=jsUrl%>bootstrap.min.js"></script>
</head>
<style>
input:-webkit-autofill,
input:-webkit-autofill:hover,
input:-webkit-autofill:focus {
box-shadow:0 0 0 60px #fff inset;
-webkit-text-fill-color: #878787;
}
	button{
	margin: 0;
	padding: 0;
	border: 1px solid transparent;  //自定义边框
	outline: none;  
	}
	ul li{
		list-style-type:none;
	}
	.login-bgm{
		background-image: url("./public/img/loginbg.png");
		width: 100%;
		background-position: center 200px;
		height: 100%;
	}
	.logo-img{
		width: 175px;
		height: 40px;
		margin-top: 50px;
	}
	.container-center{
		border-radius: 5px;
		margin:30px auto 50px auto;
		width: 430px;
		height: 450px;
		background-color: #fff;
		box-shadow: 0 8px 16px #EEE;
	}


/*	.login-page{
	width: 100%;
	background: #F2F7FA;
	margin-top: -20px;
	padding-top: 55px;
	}*/
	.loagin-left-view{
		width: 100%;
		padding: 10px;
	}
	.login-bar{
		margin-top: 10px;
		display: flex;
		flex-direction: row;
	}
	.login-bar li{
		float: left;
		list-style: none;
	}
.login-tab2 a:hover,
.login-tab1 a:hover,
.login-tab2 a:focus,
.login-tab1 a:focus{
	list-style: none;
	text-decoration: none;
}
.tab-content{
	width: 75%;
	margin: -30px auto;
}
.login-left-line{
	position: relative;
	text-align: center;
	height: 34px;
	width: 136px;
	line-height: 34px;
}
.login-tab1{
	margin-left: 38px;
}
.left-line{
	transform:translate(-50%,-50%);
	left:55%;
	top:50%;
	position: absolute;
	/* Line: */
	height: 18px;
	background: #B7B7B7;
	width: 1px;
}
.active .login-left-login{
	color: #FF804D;
}
.login-left-login{
	font-family: PingFangSC-Regular;
	font-size: 24px;
	color:#333333;
	letter-spacing: 0;
}

.login-left-registered{
		/* 注册: */
	font-family: PingFangSC-Medium;
	font-size: 24px;
	color: #333333;
	letter-spacing: 0;
}
.active .login-left-registered{
	color: #FF804D;
}

.tab-login-input{
	width: 100%;
	border:0px;
	border-bottom: 1px solid #D2D2D2;
	outline: none;
	margin-top: 44px;
	height: 37px;
}
.tab-login-input-resign{
	margin-top: 30px;
	height: 30px;
}
.tab-login-input::-webkit-input-placeholder{
    font-family: PingFangSC-Light;
	font-size: 14px;
	color: #999999;
	letter-spacing: 3px;

}
 
.tab-login-input:-ms-input-placeholder {
   font-family: PingFangSC-Light;
	font-size: 10px;
	color: #999999;
	letter-spacing: 0;
}
 
.tab-login-input::-moz-placeholder {
    font-family: PingFangSC-Light;
	font-size: 10px;
	color: #999999;
	letter-spacing: 0;
}
.tab-login-checkbox{
	line-height: 30px;
	margin-top: 5px !important;
}
.tab-login-sure{
	margin-left: 5px;
	font-family: PingFangSC-Regular;
	font-size: 12px;
	line-height: 30px;
	color: #666666;
	letter-spacing: 0;
}
.tab-login-sure-agreement{
	color: #08ACFB;
	letter-spacing: 1px;
}
.login-btn{
	margin-top: 30px;
	line-height: 40px;
	text-align: center;
	width: 300px;
	height: 40px;
	background: #FF804D;
	border-radius: 5px;
	/* 立即登录: */
	font-family: PingFangSC-Semibold;
	font-size: 20px;
	color: #FFFFFF;
	letter-spacing: 0;
}
.tab-login-main, a:hover{
	list-style: none;
	text-decoration: none;
}
.tab-registered-main a:hover{
	list-style: none;
	text-decoration: none;
}
</style>
<body>
	<div class="login-bgm">
		<div class="container" style="text-align: center;">
			<img src="./public/img/logo.jpg" class="logo-img">
			<div class="container-center">
				<div class="loagin-left-view">
					<ul id="myTab" class="login-bar clearfix">
						<li class="active login-tab1" id="login-tab1" >
							<a href="#login-page" data-toggle="tab">
								 <div class="login-left-login">登 录</div>
							</a>
						</li>
						<li class="login-left-line "><div class="left-line"></div></li>
						<li class="login-tab2" id="login-tab2">
							<a href="#registered-page" data-toggle="tab">
								<div class="login-left-registered">注 册</div>	
							</a>
						</li>
						
					 </ul>

					<div id="myTabContent" class="tab-content">
							<div class="tab-login-main tab-pane fade in active" id="login-page">
								<form class="form-horizontal" action="UserServlet?method=Login" method="post" id="login">
									<input type="input" name="userName" placeholder="请输入用户名" class="tab-login-input"><br>
									<input type="password" name="userPwd" placeholder="请输入密码" class="tab-login-input"><br>

									<a href=""><button type="submit" class="login-btn">立即登录</button></a>
								</form>
							</div>

						<div class="tab-registered-main tab-pane fade" id="registered-page">
							<form class="form-horizontal"  action="UserServlet?method=Register" method="post" id="resign">
							<input type="input" name="userName" id="inputUsername" placeholder="请输入用户名" class="tab-login-input"><br>
							<input type="input" name="phone" id="phone" placeholder="请输入手机号" class="tab-login-input  tab-login-input-resign"><br>
							<input type="password" name="userPwd" id="Password1" placeholder="请输入密码" class="tab-login-input  tab-login-input-resign"><br>
							<input type="password" name="userPwdAgain" id="Password2" placeholder="请再次输入密码" class="tab-login-input tab-login-input-resign">
							<input type="checkbox" name="" class="tab-login-checkbox">
							<span class="tab-login-sure">我已阅读并同意
								<span class="tab-login-sure-agreement">《Estore百货铺子注册协议》</span>
							</span>
							<a href="" data-toggle="tab" onclick="Resign()"><p class="login-btn">立即注册</p></a>
							</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>

function Resign(){
	let pd1=$('#Password1').val();
	let pd2=$('#Password2').val();
	let username=$('#inputUsername').val();
	let phone=$('#phone').val();
	if(pd1 == pd2){
		$.ajax({
			type:"get",
			url:"UserServlet?method=Register",
			data:{
				"userName":username,
				"userPwd": pd1,
				'phone':phone
				}, 
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			success:function(data) {
				console.log(data);
				if(data==true){
					alert("注册完成");
					window.location.reload();
				}
				if(data==false){
					$('#Password1').val("");
					$('#Password2').val("");
					$('#inputUsername').val("");
					$('#phone').val("");
					alert("用户名已存在，请重新注册");
				}
			},
			});
	}else{
		alert("密码输入不一致");
	}
	
}
</script>


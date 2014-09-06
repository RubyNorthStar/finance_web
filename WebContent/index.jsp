<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		$(function(){
			
		});

		function checkLogin(){
			$.ajax({
				url: "<%=basePath%>user/login",
                data: $("#loginForm").serialize(),
                type: "POST",
                success: function(data) {
					if(data == "success"){
						alert("登录成功");
					}else{
						alert("登录失败");
					}
				}
			});
		}

		function register(){
			$.ajax({
				url: "<%=basePath%>user/register",
                data: $("#registerForm").serialize(),
                type: "POST",
                success: function(data) {
					if(data == "success"){
						alert("注册成功");
					}else{
						alert("注册失败");
					}
				}
			});
		}

		function edit(){
			$.ajax({
				url: "<%=basePath%>user/edit",
                data: $("#editForm").serialize(),
                type: "POST",
                success: function(data) {
					if(data == "success"){
						alert("修改成功");
					}else{
						alert("修改失败");
					}
				}
			});
		}
		
	</script>
  </head>
  
  <body>
  	<form id="loginForm">
	    <input type="text" name="username" /><p>
	    <input type="password" name="password" /></p>
	    <a href="javascript:void(0);" onclick="checkLogin();">登录</a>
  	</form>
  	
  	<form id="registerForm">
	    <input type="text" name="username" /><p>
	    <input type="password" name="password" /></p>
	    <a href="javascript:void(0);" onclick="register();">注册</a>
  	</form>
  	
  	<form id="editForm">
  		<input type="text" name="id" value="2450" /><p>
	    <input type="text" name="username" /><p>
	    <input type="password" name="password" /></p>
	    <a href="javascript:void(0);" onclick="edit();">修改</a>
  	</form>
  	
  </body>
</html>

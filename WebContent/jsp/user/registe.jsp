<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	  <form action="<%=basePath%>user/register" method="post">
	    	用户名：<input type="text" name="username" /><p>
	    	邮箱：<input type="text" name="email" /><p>
	    	手机号：<input type="text" name="mobile" /><p>
	  		密码：<input type="password" name="password" /><p>
	  		
	    <!-- <a href="javascript:void(0);" onclick="register();">注册</a> -->
	    <input type="submit" value="注册用户"/>
  	</form>
</body>
</html>
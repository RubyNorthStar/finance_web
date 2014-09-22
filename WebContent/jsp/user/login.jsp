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
<title>登陆</title>
 <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
 <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
 <script type="text/javascript" src="/resources/common/cookie/cookie.js"></script>
</head>
<script type="text/javascript">
	function userLogin(){
		//$('form').submit();
		var email = $('#email').val();
		var password = $('#password').val();
		var remember = $('#remember').attr("checked");
		alert(email);
		if(email){
			$('#verify').text("邮箱不能为空。");
		}
		
		$.ajax({
	           type: "POST",
	           url : "http://www.xs.com:8080/user/login.sthml",
	           data: {"email":email, "password":password},
	           dataType:"json", 
	           success: function(data){
	        	   
	        	   //跳转到个人中心
	        	   if(data.result == "success"){
						alert("如果成功跳转到个人中心");
	        	   }
	        	   if(data.result == "faile"){
	        		   $('#verify').text("邮箱地址或者密码错误，请确认后重新登录。");
	        	   }
	           }
	   });
	}
	
	function passwordLength(){
		var password = $('#password').val();
		if(password.length() < 6){
			alert("x");
		}
		if(password.length() > 6){
			alert("d");
		}
	}
</script>
<body>
	<%-- <form action="<%=basePath%>user/login.sthml" method="post">
	    <input type="text" name="email" /><p>
	    <input type="password" name="password" /></p>
	    <input type="submit" value="用户登陆"/>
  	</form> --%>
  	
  	<body>
	<div class="views">
		<div class="view">
            <!--头部导航-->
			<div class="navbar">
	          <div class="navbar-inner">
	          	<div class="left">
                    <img class="top-logo" src="/resources/images/user/logo.jpg" />
	            </div>
	            <div class="login">
                    <span style="margin: 0 10px;">|</span>
                  <a href="javascript:;">登陆</a>
                </div>
	          </div>
	        </div>
            <!--中间内容-->
                <!--登陆页-->
            <div class="pages clearfix">
                <div class="content-block">
                    <img class="left-img" src="/resources/images/user//1.jpg" />
                </div>
                <div class="content-block">
                    <div class="right-block">
	                        <div class="verify-block" id="verify"></div>
	                        <div class="input-block">
	                            <i class="icon icon-user"></i>
	                            <input class="input-text user" type="text" name="email" id="email" placeholder="用户名">
	                        </div>
	
	                        <div class="input-block">
	                            <i class="icon icon-user"></i>
	                            <input class="input-text code" type="password" name="password" id="password" placeholder="密码">
	                        </div>
	                        <div class="text">
	                            <div class="input-ck">
	                                <input class="input-checkbox" type="checkbox" id="remember">
	                            </div>
	                            	记住用户名
	                            <a class="forget Acolor" href="javascript:;">忘记密码</a>
	                        </div>
	                        <div class="login-btn">
	                            <button onclick="javascript:userLogin();">马上登陆</button>
	                            <input type="button" value="马上登陆" onclick="javascript:userLogin();" />
	                            <div class="zc">
	                               <span>没有账号？</span>
	                                <span><a class="Acolor" href="javascript:;">免费注册</a></span>
	                            </div>
	                        </div>
                        <div class="hzzh clearfix">
                            <p style="float: left; text-align: center;line-height: 45px; margin: 0 20px 0 30px">
                             	   您还可以使用合作账号登陆
                            </p>

                            <i class="icon icon-user"></i>
                            <i class="icon icon-user"></i>
                        </div>

                    </div>
                </div>
            </div>
            <!--底部工具栏-->
            <div class="page clearfix">
                <div class="toolbar">
                    <img class="bottom-logo" src="/resources/images/user//0013.jpg" />
                </div>
                <div class="toolbar">
                    <div class="top-inner toolbar-inner">
                  		  关于安心理财|联系我们|公司荣誉|合作伙伴|安心官方微博|全国免费质询电话：400-6099-800
                    </div>
                    <div class="bottom-text">
                    	    京ICP证100743号 京公网安1101055897CreditEase@Θ2009
                    </div>
                </div>
                <div class="toolbar">
                    <img class="" style="width: 200px;height: 60px" src="/resources/images/user/0012.jpg" />
                </div>
            </div>
		</div>
	</div>
	
</body>
</html>
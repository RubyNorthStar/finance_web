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
 <link rel="stylesheet" type="text/css" href="resources/css/index.css">
</head>
<body>
	<form action="<%=basePath%>user/login.sthml" method="post">
	    <input type="text" name="email" /><p>
	    <input type="password" name="password" /></p>
	    <input type="submit" value="用户登陆"/>
  	</form>
  	
  	<body>
	<div class="views">
		<div class="view">
            <!--头部导航-->
			<div class="navbar">
	          <div class="navbar-inner">
	          	<div class="left">
                    <img class="top-logo" src="images/logo.jpg" />
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
                    <img class="left-img" src="images/1.jpg" />
                </div>
                <div class="content-block">
                    <div class="right-block">
                        <div class="input-block">
                            <i class="icon icon-user"></i>
                            <input class="input-text user" type="text" value="用户名">
                        </div>

                        <div class="input-block">
                            <i class="icon icon-user"></i>
                            <input class="input-text code" type="text" value="密码">
                        </div>
                        <div class="text">
                            <div class="input-ck">
                                <input class="input-checkbox" type="checkbox">
                            </div>

                            记住用户名
                            <a class="forget Acolor" href="javascript:;">忘记密码</a>
                        </div>
                        <div class="login-btn">
                            <button class="">马上登陆</button>
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
                    <img class="bottom-logo" src="images/0013.jpg" />
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
                    <img class="" style="width: 200px;height: 60px" src="images/0012.jpg" />
                </div>
            </div>
		</div>
	</div>
	
	
	<script type="text/javascript" src="resouces/common/plugin/jquery-2.1.1.js"></script>
</body>
</html>
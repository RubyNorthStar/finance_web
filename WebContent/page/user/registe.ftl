<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<link rel="stylesheet" type="text/css" href="/resources/css/index.css">
 	<script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
  	<script type="text/javascript" src="/script/user/login.js"></script>
	<title>携手金融网 - 用户注册</title>
</head>
  <body>
	
	<div class="views">
	<#include "/index/common/top.ftl">
	<!--头部导航
	        <div class="navbar">
	            <div class="navbar-inner clearfix">
	                <div class="left">
	                    <img class="top-logo" src="/resources/images/user/logo.png" />
	                </div>
	                <div class="right">
	                	<i class="rightI" style=""></i>
	                </div>
	                <div class="login" style="display: block">
	                    <a href="javascript:;">注册</a>
	                </div>
	            </div>
	        </div>
	        -->
	    <div class="view">
	        <!--中间内容-->
	        <!--注册页-->
	        <div class="pages clearfix " style="display: block">
	        <!-- 提交注册记录条
	        	<div class="schedule clearfix">
	        		<div class="scheduleBG"></div>
	        		<i class="num numActive">1</i>
	        		<div class="scheduleBG"></div>
	        		<i class="num">2</i>
	        		<div class="scheduleBG"></div>
	        		<i class="num">3</i>
	        		<div class="scheduleBG"></div>
	        		<div><a href="javascript:;">已有账号？立即登录</a></div>
	        	</div>
	        	<div class="schedule clearfix">
	        		<i class="scheduleText ml125">填写账户信息</i>
	        		<i class="scheduleText ml105">手机信息验证</i>
	        		<i class="scheduleText ml105">注册成功</i>
	        	</div>
	        	-->
	            <div class="content-block">
	                <img class="left-img" src="/resources/images/user/2.jpg" />
	            </div>
	            <div class="content-block">
	                <div class="right-box">
	                	<div class="verify-block" id="verify"></div>
	                    <div class="input-block">
	                        <i class="icon icon-user"></i>
	                        <input class="input-text user" type="text" name="username" id="username" placeholder="输入昵称">
	                    </div>
	
	                    <div class="input-box">
	                        <i class="icon icon-number"></i>
	                        <input class="input-text code" type="text" name="mobile" id="mobile" placeholder="手机号码">
	                    </div>
	                    <div class="input-box">
	                        <i class="icon icon-mail"></i>
	                        <input class="input-text code" type="text" name="email" id="email" placeholder="邮箱">
	                    </div>
	                    <div class="input-box">
	                        <i class="icon icon-code"></i>
	                        <input class="input-text code" type="password" name="password" id="password" placeholder="设置密码">
	                    </div>
	                    <div class="input-box">
	                        <i class="icon icon-code"></i>
	                        <input class="input-text code" type="password" name="confirm_password" id="confirm_password" placeholder="重复密码">
	                    </div>
	                    <div class="input-box clearfix">
	                        <input class="input-proving" type="text" value="" id="verification_code" placeholder="验证码">
	                        <div class="proving-img" style="">
								<img class="hyx_img" src="/captcha/cimge.go" alt="img" /></a>
	                        </div>
	                    </div>
	                    <div class="login-btn">
	                        <p class="p1">我已阅读并同意《人人贷网站服务协议》</p>
	                        <button class="" style="margin-top: 10px; cursor: pointer;" onclick="javascript:userRegiste();">免费注册</button>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <!--底部工具栏
	        <div class="page clearfix" style="margin-bottom: 40px;">
	            <div class="toolbar">
	                <img class="bottom-logo" src="/resources/images/user/0013.jpg" />
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
	        </div>-->
	        <#include "/index/common/foot.ftl">
	    </div>
	</div>
  </body>
</html>

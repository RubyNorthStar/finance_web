<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<link rel="stylesheet" type="text/css" href="/resources/css/index.css">
 	<script type="text/javascript" src="/resources/common/plugin/jquery/jquery-1.4.2.min.js"></script>
  	<script type="text/javascript" src="/script/user/login.js"></script>
	<title>携手金融网 - 用户注册</title>
</head>
  <body>
	
	<div class="views">
	<#include "/index/common/top.ftl">
	    <div class="view">
	        <!--中间内容-->
	        <!--注册页-->
	        <div class="pages clearfix " style="display: block">
	        	<div class="verify-block" id="verify"><p></p></div>
	            <div class="content-block">
	                <img class="left-img" src="/resources/images/user/2.jpg" />
	            </div>
	            <div class="content-block">
	                <div class="right-box">
	                	
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
	                    <div class="input-box clearfix paddingie" style="">
	                        <input class="input-proving" style="" type="text" value="" id="verification_code" placeholder="验证码">
	                        <div class="proving-img" style="">
								<img class="hyx_img" src="/captcha/cimge.go" alt="img" /></a>
	                        </div>
	                    </div>
	                    <div class="login-btn">
	                        <p class="p1">我已阅读并同意《人人贷网站服务协议》</p>
	                        <button class="" style="margin-top: 10px; cursor: pointer;font-family: 微软雅黑;" onclick="javascript:userRegiste();">免费注册</button>
	                    </div>
	                </div>
	            </div>
	        </div>     
	    </div>
	    <#include "/index/common/foot.ftl">
	</div>
  </body>
</html>

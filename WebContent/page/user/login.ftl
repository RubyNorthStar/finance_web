<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融网 - 登陆</title>
	 <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	 <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
	 <script type="text/javascript" src="/resources/common/cookie/cookie.js"></script>
	 <script type="text/javascript" src="/script/user/login.js"></script>
</head>
  <body>
	
	<div class="views">
	<#include "/index/common/top.ftl">
		<div class="view"> 
            <!--中间内容-->
                <!--登陆页-->
            <div class="pages clearfix">
            	<div class="verify-block" id="verify"><p></p></div>
                <div class="content-block">
                    <img class="left-img"  src="/resources/images/user/1.jpg" /> <!--style="height:397px;"-->
                </div>
                <div class="content-block">
                    <div class="right-block">
	                        
	                        <div class="input-block">
	                            <i class="icon icon-user"></i>
	                            <input class="input-text user" type="text" name="email" id="email" placeholder="用户名">
	                        </div>
	
	                        <div class="input-block">
	                            <i class="icon icon-code"></i>
	                            <input class="input-text code" type="password" name="password" id="password" placeholder="密码">
	                        </div>
	                        <div class="text">
	                        <!--
	                            <div class="input-ck">
	                                <input class="input-checkbox" type="checkbox" checked="checked" id="remember">
	                            </div>
	                            	记住用户名-->
	                            
	                        </div>
	                        <div class="login-btn">
	                            <button onclick="javascript:userLogin(this);">马上登陆</button>
	                            <div class="zc">
	                               <span>没有账号？</span>
	                                <span><a class="Acolor" href="javascript:;">免费注册</a></span>
	                                <a class="forget Acolor" href="/user/forgot.go">忘记密码</a>
	                            </div>
	                        </div>
                        <div class="hzzh clearfix">
                            <!--<p style="float: left; text-align: center;line-height: 45px; margin: 0 20px 0 30px">
                             	   您还可以使用合作账号登陆
                            </p>

                            <i class="icon icon-wb"></i>
                            <i class="icon icon-qq"></i>-->
                        </div>

                    </div>
                </div>
            </div>
		</div>
		<#include "/index/common/foot.ftl">
	</div>
	
  </body>
</html>

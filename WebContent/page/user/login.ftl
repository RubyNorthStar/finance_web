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
		<!--头部导航-->
        <div class="navbar">
            <div class="navbar-inner clearfix">
                <div class="left">
                    <img class="top-logo" src="/resources/images/user/logo.png" />
                </div>
                <div class="right">
                	<i class="rightI" style=""></i>
                </div>
                <div class="login" style="display: block">
                    <a href="javascript:;">登录</a>
                </div>
            </div>
        </div>
		<div class="view"> 
            <!--中间内容-->
                <!--登陆页-->
            <div class="pages clearfix">
                <div class="content-block">
                    <img class="left-img" style="height:397px;" src="/resources/images/user/1.jpg" />
                </div>
                <div class="content-block">
                    <div class="right-block">
	                        <div class="verify-block" id="verify"></div>
	                        <div class="input-block">
	                            <i class="icon icon-user"></i>
	                            <input class="input-text user" type="text" name="email" id="email" placeholder="用户名">
	                        </div>
	
	                        <div class="input-block">
	                            <i class="icon icon-code"></i>
	                            <input class="input-text code" type="password" name="password" id="password" placeholder="密码">
	                        </div>
	                        <div class="text">
	                            <div class="input-ck">
	                                <input class="input-checkbox" type="checkbox" checked="checked" id="remember">
	                            </div>
	                            	记住用户名
	                            <a class="forget Acolor" href="/user/forgot.go">忘记密码</a>
	                        </div>
	                        <div class="login-btn">
	                            <button onclick="javascript:userLogin(this);">马上登陆</button>
	                            <div class="zc">
	                               <span>没有账号？</span>
	                                <span><a class="Acolor" href="javascript:;">免费注册</a></span>
	                            </div>
	                        </div>
                        <div class="hzzh clearfix">
                            <p style="float: left; text-align: center;line-height: 45px; margin: 0 20px 0 30px">
                             	   您还可以使用合作账号登陆
                            </p>

                            <i class="icon icon-wb"></i>
                            <i class="icon icon-qq"></i>
                        </div>

                    </div>
                </div>
            </div>
            <!--底部工具栏-->
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
            </div>
		</div>
	</div>
	
  </body>
</html>

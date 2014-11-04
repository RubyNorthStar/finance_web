<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融网 - 个人信息</title>
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
                    <a href="/index.go" ><img class="top-logo" src="/resources/images/user/logo.png" /></a>
                </div>
                <div class="right">
                	<i class="rightI" style=""></i>
                </div>
                <div class="login" style="display: block">
                    <a href="javascript:;"></a>
                </div>
            </div>
        </div>
        
        <a href="/center/projectInfo/transferType.go">发布转让信息</a>
       		 <!--中间内容-->
		  <div class="view">
	        <div class="content m-l mt20 clearfix " style="margin-bottom: 200px;">
	            <div class="fL user-info">
	                <div class="left-user-Photo"></div>
	            </div>
	            <div class="fL ml20">
	                <div class="user-name">${user.username}</div>
	                <div class="member">
	                    <p class="user-number">会员编号：${user.id}</p>
	                    <div class="user-set">
	                        <span class="user-set-code">密码设置：已设置</span><a href="javascript:;" class="alter">修改</a>
	                        <span class="user-phone-bang">手机绑定：${user.mobile}</span><a href="javascript:;" class="alter">修改</a>
	                    </div>
	                    <div>
	                        <button class="button2 cz">充值</button>
	                        <button class="button2 tx">提现</button>
	                        <span>还没有绑定银行卡？</span><a href="javascript:;" class="alter">马上设置</a>
	                    </div>
	                </div>
	            </div>
	            <div class="fL button1">
	                <div class="button3 button-color-3">借贷</div>
	                <div class="button3 button-color-4">理财</div>
	                <div class="button3 button-color-5">理财记录</div>
	                <div class="button3 button-color-6">系统消息</div>
	            </div>
	        </div>
	
	    </div>
            <!--底部工具栏-->
         <#include "/index/common/foot.ftl">
	
  </body>
</html>

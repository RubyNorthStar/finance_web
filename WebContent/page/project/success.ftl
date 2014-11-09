<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融网 - 找回密码</title>
	 <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
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
       		 <!--中间内容-->
		  <div class="banner_warp" style="margin:0 auto;padding-top:20px;">
			<div class="recover_mima" style="text-align:center;width:500px;">
				<#if project == 1>
					项目添加成功！
					<#else>
					公告添加成功！
				</#if>
		    	<p><h1 style="font-family:'微软雅黑';font-size:20px;color:#333333;margin-top:30px;">新密码发送成功！</h1></p>
		    </div>
		</div>
            <!--底部工具栏-->
         <#include "/index/common/foot.ftl">
	
  </body>
</html>

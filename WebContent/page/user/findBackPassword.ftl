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
		  <div class="view">
	        <div class="content m-l mt20 clearfix " style="margin-bottom: 200px;">
	        
	        	<div class="recover_mima">
			    	<div class="recover_tou">
			        	<span>忘记密码</span>
			        </div>
			        <form action="/user/forgot-submit.go" method="post">
				        <div class="recover_mian">
				        	<input type="text" name="email" class="text-input-email" value="" placeholder="请输入您注册时填写的邮箱"/>
				            <div class="submit-row" style="margin-left:-20px;margin-bottom:0px;">
				            <font><font><input type="submit" value="发送邮件" class="u-btn green medium" style="margin-top:25px;margin-bottom:10px;margin-left:130px;" /></font></font>
				            </div>
				        </div>
			        </form>
		    	</div>
	        
	        </div>
	    </div>
            <!--底部工具栏-->
         <#include "/index/common/foot.ftl">
	
  </body>
</html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融网 - 找回密码</title>
	 <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	 <script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	 <script>
	 	function changeValidateCode() {   
			var timenow = new Date().getTime();
			$("#image_validateCode").attr("src","/captcha/cimge.go?d="+timenow);
		} 
	 </script>
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
	        <div class="content m-l mt20 clearfix " style="margin-bottom: 140px; padding-top:112px;">
	        <!-- form开始 -->
	          <form action="/user/forgot-submit.go" method="post">
	        	<div class="recover_mima clearfix">
			    	<div class="recover_tou">
			        	<span>忘记密码</span>
			        </div>
		       		 <div class="form-box-code">
				        <div class="recover_mian clearfix">
				        	<input type="text" name="email" class="text-input-email" value="" placeholder="请输入您注册时填写的邮箱"/>
				        	<#if email??>
				        		<em>${email}</em>
				        	</#if>
				        </div>
		        	 </div>
		    	</div>
	        	
	        	<div class="recover_mima clearfix">
			    	<div class="recover_tou ">
			        	<span>请输入验证码</span>
			        </div>
			        <!-- <form class="form-box-code" action="/user/forgot-submit.go" method="post"> -->
			        <div class="form-box-code">
				        <div class="recover_mian clearfix">
				        	<input type="text" name="code" class="text-input-code" value="" placeholder="请输入验证码"/>
				            <div class="submit-row" style="">
				            	<img class="code-img" id="image_validateCode" src="/captcha/cimge.go" />
				            	<input type="button" value="换一张" onclick="changeValidateCode();" class="button-style u-btn green medium" />
				            	<#if code??>
					        		<em>${code}</em>
					        	</#if>
				            </div>
				        </div>
				    </div>
			        <!-- </form> -->
		    	</div>
		    	<div class="recover_mima clearfix">
			    	<div class="submit-row" style="">
		            	<input type="submit" value="发送邮件" class="button-style u-btn green medium" style="margin-left:55px;" />
		            </div>
		    	</div>
		    	
		    	
	        </form>  
	        <!-- form结束 -->
	        </div>
	    </div>
            <!--底部工具栏-->
         <#include "/index/common/foot.ftl">
	
  </body>
</html>

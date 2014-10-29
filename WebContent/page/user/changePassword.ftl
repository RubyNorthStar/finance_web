<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融网 - 找回密码</title>
	 <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	 <link rel="stylesheet" type="text/css" href="/resources/css/user-pass.css">
	 <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
	 <script type="text/javascript" src="/resources/common/cookie/cookie.js"></script>
	 
	 <script>

	$(function(){
		$(".confirm_password input").blur(function(){
				surPwd();
		});
		$(".new_password input").blur(function(){
				ckPwd();
		});
		$(".focusStyle").focus(function(){
			$(this).addClass("focus_style");	
		});
		$(".focusStyle").blur(function(){
			$(this).removeClass("focus_style");	
		});
	});
	
	
	function subForm(){
		var flag = ckPwd() && surPwd();
		if(flag){
			 $.ajax( {
					url : "/user/changePasswordNew.go",
					type : "post",
					data:{"newPassword":$.trim($("#new_password").val()),"user_id":$("#user_id").val()},
					dataType : "json",
					cache : false,
					success :function(data){
						if(parseInt(data)==1){
							changeSs();
						}else{
							alert("修改失败,请重新修改！");
						}
					}
				});
		}
		
	}
	
	function changeSs(){
			$(".resvise_passWord_tip").show();
			$(".resvise_passWord").hide();
			var n=5;
			var myTime=setInterval(function(){
				n=n-1;
				if(n<=0){
					n=0;
					loginOutTk();
					clearInterval(myTime);	
				}
				$(".resvise_passWord_tip i").text(n);	
			},1000);
	}
	
	function ckPwd(){
		$(".resvise_passWord .pass_error").hide();
		var newPassword=$.trim($(".new_password input").val());
		if(newPassword.length < 1){
			$(".new_password .pass_error").html("请输入您的新密码");	
			$(".new_password .pass_error").show();	
			return false;
		}
		if(newPassword.length < 6){
			$(".new_password .pass_error").html("请输入不小于6位数的新密码！");	
			$(".new_password .pass_error").show();	
			return false;
		}
		return true;
	}
	
	function surPwd(){
		$(".confirm_password .pass_error").hide();
		var newPassword=$.trim($(".new_password input").val());
		var confirmPassword=$.trim($(".confirm_password input").val());
		if(confirmPassword!=newPassword){
			$(".confirm_password .pass_error").html("两次密码输入不一致");	
			$(".confirm_password .pass_error").show();	
			return false;
		}
		return true;
	}
	
	/**
	 * 退出
	 */
	function loginOutTk(){
		delCookie("LOGINNAME");
		delCookie("LOGINPWD");
		alert("ddddmmmmm");
		window.location.href = "/index.go";
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
		 <form action="/user/changePassword/${id}.go" method="post">
			<input type="hidden" id="user_id" value="${id}">
			<div class="resvise_passWord_box">
				<div class="resvise_passWord">
			        <p>请设置一个新密码</p>
			        <p class="clearfix new_password" style="border-bottom:0"><label>输入新密码</label><input id="new_password" name="newPassword" type="password" class="focusStyle" /><span class="pass_error"></span></p>
			        <p class="clearfix confirm_password" style="border-bottom:0"><label>确认密码</label><input name="reNewPassword" type="password" onchange="surPwd()" class="focusStyle" /><span class="pass_error"></span></p>
			        <p class="clearfix submit_but" style="border-bottom:0"><input type="button" id="submit_but" onclick="subForm()" value="确定" /></p>
			    </div>
			    <div class="resvise_passWord_tip">
			    	<img src="/resources/images/user/confirm_password_ok.png" alt="img" />
			        <p><span>新密码已经生效</span></p>
			        <p><i>5</i>秒钟自动跳转到首页</p>
			        <p><a href="javascript:loginOutTk();">马上跳转</a></p>
			    </div>
			</div>
			</form>
            <!--底部工具栏-->
         <#include "/index/common/foot.ftl">
	
  </body>
</html>

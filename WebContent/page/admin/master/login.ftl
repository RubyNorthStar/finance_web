<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--后台登陆</title>
	<link href="/style/manage/logincss.css" rel="stylesheet" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script type="text/javascript">
		function login(){
			var account = $('#account').val();
			if($.trim(account).length == 0){
				$('#massges_info').html("账号不能为空！");
				return false;
			}
			var password = $('#password').val();
			if($.trim(password).length == 0){
				$('#massges_info').html("账号不能为空！");
				return false;
			}
			
			$('#login_form').submit();
		}
		
		function reset(){
			$('#account').val('');
			$('#password').val('');
		}
		
		function changeValidateCode() {   
			var timenow = new Date().getTime();
			$("#image").attr("src","/rand.shtml?d="+timenow);
		}   
	</script>
</head>
  <body>
	
	<div class="head">
    <img src="/image/manage/login/banner.gif" id="banner" height="60" width="468">
    <ul id="language">
    </ul>
</div>
	
  
	<form name="form_wm"  id="login_form" method="post" action="/manage/manage_executeLogin.shtml">
	<div class="main">
	<img src="/image/manage/login/lt.jpg" id="lt" height="164" width="133">
	<ul>
    	<li><img src="/image/manage/login/text.gif" height="20" width="120"></li>
        <li>
       		<table>
       			 <tbody><tr>
					<td width="60px">
				   <span id="chan_user">用户名：</span><img src="/image/manage/login/1x1.gif" height="1" width="60"></td>
					<td>
						<input name="masterDTO.account"  id="account" class="ipt1" type="text">						
					</td>
                    <td>			
					</td>
				</tr>
			</tbody></table>			
       </li>
        <li>
        <table>
       			 <tbody><tr>
					<td width="60px">
						<span id="chan_pass">密　码：</span>
					</td>
					<td>
						<input name="masterDTO.password" id="password" class="ipt1" value="" type="password">
					</td>
				</tr>
			</tbody></table>	
        </li>
        <li>
       		<table>
       			<tbody><tr id="cc_tr">
 					<td width="60px">
						<span id="chan_code">校验码：</span>
					</td>
					<td id="cc">
						<input id="validateCode" name="validateCode" class="ipt1_code" maxlength="4" type="text">&nbsp;<img id="image" src="/rand.shtml" onclick="changeValidateCode();" style="cursor:pointer"/>
					</td>
					<td>
						<span><a  href="javascript:void(0)" onclick="changeValidateCode();">换一张</a></span>
					</td>
				</tr>
			</tbody></table>				
        </li>
        <li><span id="massges_info" style="color:red;">
		      			<#if masterDTO??>
							<#if masterDTO.flag??>
								<#if masterDTO.flag == '1008'>
									登陆失败，验证码不正确
								</#if >
								<#if masterDTO.flag == '1007'>
									登陆失败，验证码不能为空
								</#if >
								<#if masterDTO.flag == '1006'>
									登录失败，该账户已被禁用
								</#if >
								<#if masterDTO.flag == '1005'>
									登陆成功
								</#if >
								<#if masterDTO.flag == '1004'>
									登陆失败，密码不正确
								</#if >
								<#if masterDTO.flag == '1003'>
									登陆失败，该用户不存在
								</#if >
								<#if masterDTO.flag == '1002'>
									登陆失败，登录名不能为空
								</#if >
								<#if masterDTO.flag == '1001'>
									登陆失败，登录名和密码不能为空
								</#if >
							</#if >
						</#if >
		      		</span></li>
        <li><input name="sub" value="登录" onclick="return login()" class="btn1" type="button"></li>
    </ul>
  </div>
   </form> 
	
  </body>
</html>

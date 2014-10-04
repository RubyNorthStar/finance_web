<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--登陆成功</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script type="text/javascript" src="/script/admin/action_manage.js"></script>
</head>
  <body>
	  <div class="page"><!--page开始-->
		<#include "/admin/common/top.ftl">
		<div class="main clear"><!--main开始-->
				<#include "/admin/common/left.ftl">
			    <div class="right1">
			    <h3>登陆成功</h3>
			    <div class="r1_bottom" id="layer0" style="padding:50px;text-align:center;"><font size="25">
		      			<#if masterDTO??>
							<#if masterDTO.flag??>
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
						</#if ></font>
			    </div>
		    </div>
		</div>
	</div>
</div>
	</div>
  </body>
</html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--后台登陆</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script>
	<script type="text/javascript">
		function login(){
			var account = $('#account').val();
			if($.trim(account).length == 0){
				$('#massges_info').html("账号不能为空！");
				return false;
			}
			var password = $('#password').val();
			if($.trim(password).length == 0){
				$('#massges_info').html("密码不能为空！");
				return false;
			}
			<#--
			var name = $('#name').val();
			if($.trim(name).length == 0){
				$('#massges_info').html("姓名不能为空！");
				return false;
			}
			var position = $('#position').val();
			if($.trim(position).length == 0){
				$('#massges_info').html("职位不能为空！");
				return false;
			}
			var officeTelephone = $('#officeTelephone').val();
			if($.trim(officeTelephone).length == 0){
				$('#massges_info').html("办公电话不能为空！");
				return false;
			}
			var telephone = $('#telephone').val();
			if($.trim(telephone).length == 0){
				$('#massges_info').html("电话不能为空！");
				return false;
			}
			var mobile = $('#mobile').val();
			if($.trim(mobile).length == 0){
				$('#massges_info').html("手机不能为空！");
				return false;
			}
			var email = $('#email').val();
			if($.trim(email).length == 0){
				$('#massges_info').html("邮箱不能为空！");
				return false;
			}
			var note = $('#note').val();
			if($.trim(note).length == 0){
				$('#massges_info').html("备注不能为空！");
				return false;
			}
			-->
			$('#master_add_form').submit();
		}
		
		function reset(){
			$('#account').val('');
			$('#password').val('');
			$('#name').val('');
			$('#department').val('');
			$('#position').val('');
			$('#officeTelephone').val('');
			$('#telephone').val('');
			$('#mobile').val('');
			$('#email').val('');
			$('#note').val('');
			return false;
		}
	</script>
</head>
  <body>
	 <div class="page"><!--page开始-->
		<#include "/WEB-INF/page/manage/include/top.ftl">
		<div class="main clear"><!--main开始-->
				<#include "/WEB-INF/page/manage/include/left_new.ftl">
			<div class="right1">
				<h3>管理员管理&gt;&gt;添加管理员</h3>
				<div class="r1_bottom" id="layer0">
		      		<span id="massges_info">
		      			<#if masterDTO??>
			      			<#if masterDTO.flag == '1001'>
								保存失败，保存信息为空
							</#if >
							<#if masterDTO.flag == '1002'>
								保存失败，账号不能为空
							</#if >
							<#if masterDTO.flag == '1003'>
								保存成功。
							</#if >
							<#if masterDTO.flag == '1004'>
								添加失败，该账号已存在
							</#if >
						</#if>
		      		</span>
			    </div>
			    
			    <div class="r1_bottom" id="layer0">
		      		<form action="/manage/manage_goExecuteMasterAdd.shtml" method="post" id="master_add_form">
			      		 <table border="0" cellspacing="0" cellpadding="0" style="width:70%">
			         	 	  <tr>&nbsp;</tr>
				         	  <tr>
					             <td class="td1">账号：</td><td class="td2">&nbsp;<input type="text" name="masterDTO.account" id="account" value="<#if masterDTO??><#if masterDTO.account??>${masterDTO.account}</#if></#if>"></td>
					          </tr>
					          <tr>
					             <td class="td1">密码：</td><td class="td2">&nbsp;<input type="text" name="masterDTO.password" id="password" value="<#if masterDTO??><#if masterDTO.password??>${masterDTO.password}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">姓名：</td><td class="td2">&nbsp;<input type="text" name="masterDTO.name" id="name" value="<#if masterDTO??><#if masterDTO.name??>${masterDTO.name}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">电话：</td><td class="td2">&nbsp;<input type="text" name="masterDTO.telephone" id="telephone" value="<#if masterDTO??><#if masterDTO.telephone??>${masterDTO.telephone}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">手机：</td><td class="td2">&nbsp;<input type="text" name="masterDTO.mobile" id="mobile" value="<#if masterDTO??><#if masterDTO.mobile??>${masterDTO.mobile}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1"> email：</td><td class="td2">&nbsp;<input type="text" name="masterDTO.email" id="email" value="<#if masterDTO??><#if masterDTO.email??>${masterDTO.email}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">状态：</td><td class="td2">&nbsp;<input type="radio" name="masterDTO.forbidden" value = "false" checked="checked" style="width:30px; border: 0px;">禁用&nbsp;<input type="radio" name="masterDTO.forbidden" value = "true" style="width:30px; border: 0px;">启用</td>
					           </tr>
					          <tr> <td class="td1"><button  onclick="return login()">保存</button></td><td class="td2">&nbsp;&nbsp;<button  onclick="return reset()">重置</button></td></tr>
				    	 </table>
				    </form>
			    </div>
		    </div>
		</div>
	</div>
  </body>
</html>

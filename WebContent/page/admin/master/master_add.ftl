<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--后台登陆</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
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
				$('#massges_info').html("密码不能为空！");
				return false;
			}
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
		<#include "/admin/common/top.ftl">
		<div class="main clear"><!--main开始-->
			<#include "/admin/common/left.ftl">
			<div class="right1">
				<h3>管理员管理&gt;&gt;添加管理员</h3>
				<div class="r1_bottom" id="layer0">
		      		<span id="massges_info">
		      			<#if flag??>
			      			<#if flag == '1001'>
								保存失败，保存信息为空
							</#if >
							<#if flag == '1002'>
								保存失败，账号不能为空
							</#if >
							<#if flag == '1003'>
								保存成功。
							</#if >
							<#if flag == '1004'>
								添加失败，该账号已存在
							</#if >
						</#if>
		      		</span>
			    </div>
			    
			    <div class="r1_bottom" id="layer0">
		      		<form action="/admin/master/goExecuteAddMaster.go" method="post" id="master_add_form">
			      		 <table border="0" cellspacing="0" cellpadding="0" style="width:70%">
			         	 	  <tr>&nbsp;</tr>
				         	  <tr>
					             <td class="td1">账号：</td><td class="td2">&nbsp;<input type="text" name="account" id="account" value="<#if master??><#if master.account??>${master.account}</#if></#if>"></td>
					          </tr>
					          <tr>
					             <td class="td1">密码：</td><td class="td2">&nbsp;<input type="text" name="password" id="password" value="<#if master??><#if master.password??>${master.password}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">姓名：</td><td class="td2">&nbsp;<input type="text" name="name" id="name" value="<#if master??><#if master.name??>${master.name}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">电话：</td><td class="td2">&nbsp;<input type="text" name="telephone" id="telephone" value="<#if master??><#if master.telephone??>${master.telephone}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">手机：</td><td class="td2">&nbsp;<input type="text" name="mobile" id="mobile" value="<#if master??><#if master.mobile??>${master.mobile}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1"> email：</td><td class="td2">&nbsp;<input type="text" name="email" id="email" value="<#if master??><#if master.email??>${master.email}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">状态：</td><td class="td2">&nbsp;
									<#if returnMaster??>
							      		 <#if returnMaster.forbidden??>
							      		 	 <#if (returnMaster.forbidden == 0)>
							      		 	  &nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "0" checked="checked">禁用&nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "1">启用<br>
							      		 	 </#if>
							      		 	  <#if (returnMaster.forbidden == 1)>
							      		 	&nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "0" >禁用&nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "1" checked="checked">启用<br>
							      		 	 </#if>
							      		 <#else>
							      		 	&nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "0">禁用&nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "1">启用<br>
							      		 </#if>
						      		 <#else>
						      		 	&nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "0">禁用&nbsp;<input style="width:30px; border: 0px;" type="radio" name="forbidden" value = "1">启用<br>
						      		 </#if> 
								</td>
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

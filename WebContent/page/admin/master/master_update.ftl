<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--后台登陆</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script type="text/javascript">
		function updateMaster(){
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
			var name = $('#name').val();
			if($.trim(name).length == 0){
				$('#massges_info').html("名称不能为空！");
				return false;
			}
			$('#master_update_form').submit();
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
		}
	</script>
</head>
  <body>
	 <div class="page"><!--page开始-->
		<#include "/admin/common/top.ftl">
		<div class="main clear"><!--main开始-->
			<#include "/admin/common/left.ftl">
			<div class="right1">
				<h3>管理员管理&gt;&gt;更新管理员</h3>
				<div class="r1_bottom" id="layer0">
		      		<span id="massges_info">
		      			<#if flag??> 
							<#if flag == '1001'>
								更新成功
							</#if >
							<#if flag == '1002'>
								更新失败，传输对象为空
							</#if >
							<#if flag == '1003'>
								更新失败，传输对象为空
							</#if >
							<#if flag == '1004'>
								更新失败，没有像匹配对象
							</#if >
			      		</#if>
		      		</span>
			    </div>
			    
			    <div class="r1_bottom" id="layer0">
		      		<form action="/admin/master/executeUpdateMaster.go" method="post" id="master_update_form">
				    	<table border="0" cellspacing="0" cellpadding="0" style="width:70%">
			         	 	  <tr>&nbsp;<input type="hidden" name="mtId" value="<#if returnMaster??><#if returnMaster.mtId??>${returnMaster.mtId}</#if></#if>"></tr>
				         	  <tr>
					             <td class="td1">账号：</td><td class="td2">&nbsp;<input type="text" name="account" id="account" value="<#if returnMaster??><#if returnMaster.account??>${returnMaster.account}</#if></#if>"></td>
					          </tr>
					          <tr>
					             <td class="td1">密码：</td><td class="td2">&nbsp;<input type="text" name="password" id="password" value="<#if returnMaster??><#if returnMaster.password??>${returnMaster.password}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">姓名：</td><td class="td2">&nbsp;<input type="text" name="name" id="name" value="<#if returnMaster??><#if returnMaster.name??>${returnMaster.name}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">电话：</td><td class="td2">&nbsp;<input type="text" name="telephone" id="telephone" value="<#if returnMaster??><#if returnMaster.telephone??>${returnMaster.telephone}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">手机：</td><td class="td2">&nbsp;<input type="text" name="mobile" id="mobile" value="<#if returnMaster??><#if returnMaster.mobile??>${returnMaster.mobile}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1"> email：</td><td class="td2">&nbsp;<input type="text" name="email" id="email" value="<#if returnMaster??><#if returnMaster.email??>${returnMaster.email}</#if></#if>"></td>
					          </tr>
					          <tr>   
					             <td class="td1">状态：</td><td class="td2">
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
						      		 </#if> 
					             </td>
					           </tr>
					          <tr> <td class="td1"></td><td class="td2"><img src="/images/common/update.jpg" onclick="updateMaster()" width="45px"/></td></tr>
				    	 </table>
				    </form>
			    </div>
		    </div>
		</div>
	</div>
  </body>
</html>

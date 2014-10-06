<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<title>修改基金类型</title>
	
	<script type="text/javascript">
		function updateFundType(){
			var fundName = $('#fundName').val();
			if($.trim(fundName).length == 0){
				alert("基金类型不能为空！");
				return false;
			}
			
			$('#fund_type_form').submit();
		}
	</script>
</head>
  <body>
		
		<div class="page"><!--page开始-->
			<#include "/admin/common/top.ftl">
			<div class="main clear"><!--main开始-->
				<#include "/admin/common/left.ftl">
				<div class="right1">
					<h3>产品类型管理&gt;&gt;添加产品类型</h3>
				    
				    <div class="r1_bottom" id="layer0">
			      		<form id="fund_type_form" method="post" action="/admin/fundType/update.go">
				      		 <table border="0" cellspacing="0" cellpadding="0" style="width:70%">
				         	 	  <tr>&nbsp;</tr>
				         	 	  <input type="hidden" name="id" id="fundId" value="${fundType.id}"/>
					         	  <tr>
						             <td class="td1">基金类型名称：</td><td class="td2">&nbsp;<input type="text" name="fundName" id="fundName" value="${fundType.fundName}"></td>
						          </tr>
						          <tr> <td class="td1"><button  onclick="return updateFundType()">保存</button></td></tr>
					    	 </table>
					    </form>
				    </div>
			    </div>
			</div>
		</div>
	
  </body>
</html>

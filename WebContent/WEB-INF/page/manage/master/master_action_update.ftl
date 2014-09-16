<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--后台登陆</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script>
	<script type="text/javascript">
		function updateMaster(){
			var arr=document.getElementsByName("actionName");
			var actionNames = "";
			for(i=0;i<arr.length;i++){
			    if(arr[i].checked){
			    	if(actionNames.length == 0){
			    		actionNames = arr[i].value;
			    	}else{
			    		actionNames = actionNames+","+arr[i].value;
			    	}
			    }
			}
			$('#actionNames').val(actionNames);
			$('#master_update_form').submit();
		}
	</script>
</head>
  <body>
	 <div class="page"><!--page开始-->
		<#include "/WEB-INF/page/manage/include/top.ftl">
		<div class="main clear"><!--main开始-->
				<#include "/WEB-INF/page/manage/include/left_new.ftl">
			<div class="right1">
				<div class="r1_bottom" id="layer0">
		      		<span id="massges_info">
		      			<#if masterDTO??><#if masterDTO.flag??> 
							<#if masterDTO.flag == '1002'>
								更新失败，未查询到相关管理员
							</#if >
							<#if masterDTO.flag == '1001'>
								更新失败，没有响应管理员
							</#if >
							<#if masterDTO.flag == '1003'>
								权限更新成功
							</#if >
			      		</#if></#if>
		      		</span>
			    </div>
			    <div class="r1_bottom" id="layer0">
		      		<form action="/manage/manage_executeUpdateAction.shtml" method="post" id="master_update_form">
		      			<!--table border="5">
		      				<tr>
		      					<td>
		      				  </td>
		      			  </tr>
		      		  </table-->
		      		<input type="hidden" value="${masterDTO.id}" name="masterDTO.id"/>
		      		<input type="hidden" value="" name="actionNames" id="actionNames"/>
		      			<#if columnGroupList??>
							<#list columnGroupList as columnGroup>
								<span >&nbsp;&nbsp;${columnGroup.name}</span><br>
								<#list columnGroup.actionColumnList as actionColumn>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${actionColumn.name}</span><br>
									<#list actionColumn.actionList as action>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><input type="checkbox" name="actionName" value="${action.atId?string('####')}" <#if actionNos??><#if (actionNos?index_of(action.actionNo) >= 0)>checked="true"</#if></#if >>${action.name}</span>
										<#if (action.atId == 78)>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/manage/manage_showItemList.shtml?masterDTO.id=${masterDTO.id?string('####')}&masterDTO.groupColumnId=${action.atId?string('####')}" target="_blank"> <!-- 展开 --> </a></#if> <br>
									</#list>
								</#list>
							</#list>
						</#if >
						
		      		  <!-- ${actionNos} -->
			      		 <button  onclick="return updateMaster()">更新</button>
				    </form>
			    </div>
		    </div>
		</div>
	</div>
  </body>
<script>
	function openIt(operatorId, actionId) {
		alert(operatorId + "; " + actionId);
	}
</script>
</html>

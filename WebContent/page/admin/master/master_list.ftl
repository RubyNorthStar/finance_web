<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--后台登陆</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<link href="/style/manage/page.css" rel="stylesheet" />
	<script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script>
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
	<script type="text/javascript" src="/script/admin/action_manage.js"></script>

	<script type="text/javascript">
		function reset(){
			$('#account').val('');
			$('#name').val('');
		}
		
		$(function(){
		    $('.pagination').pagination(${masterSearch.totalRecords?c}, {
				items_per_page: ${masterSearch.pageSize},
				current_page: ${masterSearch.pageNo - 1},
				prev_show_always:false,
				next_show_always:false,
				link_to: encodeURI('/manage/manage_obtainAllMasterList.shtml?page=__id__')
		    });
	   	});
	   	
	   	function searchMaster(){
	   		$('#master_list_form').submit();
	   	}
	</script>
</head>   
  <body>
	 <div class="page"><!--page开始-->
		<#include "/admin/common/top.ftl">
		<div class="main clear"><!--main开始-->
			<#include "/admin/common/left.ftl">
			<div class="right">
				<div class="m-r">
					<div style="padding:5px;background:none repeat scroll 0 0 #E4EAF6; margin-bottom:5px;border:1px solid #4F69A0">
		      		<form action="/admin/master/obtainMasterList.go" method="post" id="master_list_form">
			      		 <table >
		        			<tr>
								<td> 账号：<input type="text" name="account" id="account" value="<#if masterSearch??><#if masterSearch.account??>${masterSearch.account}</#if></#if>"></td>
							 	<td>姓名：<input type="text" name="name" id="name" value="<#if masterSearch??><#if masterSearch.name??>${masterSearch.name}</#if></#if>"></td>
								<td><button  onclick="return searchMaster()">查询</button>
								<td width="540px;">&nbsp;</td>
							</tr>
						</table>
				    </form>
				    </div>
				    <div>
				    <table class="table2">
		            	<tr>
		                    <th style="width:15%; height:28px;" >账号</th>
		                    <th style="width:15%">姓名</th>
		                    <th style="width:15%">电话</th>
		                    <th style="width:15%">手机</th>
		                    <th style="width:15%">email</th>
		                    <th style="width:15%"> 状态</th>
		                    <th style="width:10%">操作</th>
	               	    </tr>
	               	 <#if masterList??>
			    			<#list masterList as master>
					    		<tr>
					    			<td><#if master.account??>${master.account}</#if></td>
						      		<td><#if master.name??>${master.name}</#if></td>
						      		<td><#if master.telephone??>${master.telephone}</#if></td>
						      		<td><#if master.mobile??>${master.mobile}</#if></td>
						      		<td><#if master.email??>${master.email}</#if></td>
						      		<td><#if master.forbidden??><#if (master.forbidden == 0)>禁用</#if><#if (master.forbidden == 1)>启用</#if></#if></td>
						      		<td>
					      				<a href="/admin/master/goUpdateMaster.go?id=${master.mtId}">更新</a>
						      		</td>
						      	</tr>
				      		</#list>
				      	</#if>
		            </table>
		            </div>
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  </body>
</html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/style/manage/index.css" rel="stylesheet" />
	<link href="/style/manage/page.css" rel="stylesheet" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
	<title>基金类型列表</title>
	
	<script type="text/javascript">
		function reset(){
			$('#account').val('');
			$('#name').val('');
		}
		
		$(function(){
			
		    $('.pagination').pagination(${search.totalRecords?c}, {
				items_per_page: ${search.pageSize},
				current_page: ${search.pageNo - 1},
				prev_show_always:false,
				next_show_always:false,
				link_to: encodeURI('admin/fundType.go?pageNo=__id__')
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
		      		<form action="/manage/manage_obtainAllMasterList.shtml" method="post" id="master_list_form">
			      		 <table >
		        			<tr>
								<td> 类型名称：<input type="text" name="masterDTO.account" id="account" value="<#if masterDTO??><#if masterDTO.account??>${masterDTO.account}</#if></#if>"></td>
								<td><button  onclick="return searchMaster()">查询</button>
								<td width="540px;">&nbsp;</td>
							</tr>
						</table>
				    </form>
				    </div>
				    <div>
				    <table class="table2">
		            	<tr>
		                    <th style="width:25%; height:28px;" >类型名称</th>
		                    <th style="width:25%">创建时间</th>
		                    <th style="width:25%">状态</th>
		                    <th style="width:25%">操作</th>
	               	    </tr>
		               	 <#if fundTypes??>
				    			<#list fundTypes as fund>
						    		<tr>
						    			<td><#if fund.fundName??>${fund.fundName}</#if></td>
							      		<td><#if fund.status??>${fund.status}</#if></td>
							      		<td><#if fund.createTime??>${fund.createTime?string('yyyy-MM-dd')}</#if></td>
							      		<td>
							      			<a href="/admin/fundType/update.go?id=${fund.id}">更新</a> &nbsp; &nbsp;
							      			<a href="/admin/fundType/del/${fund.id}.go">删除</a> &nbsp; &nbsp;
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

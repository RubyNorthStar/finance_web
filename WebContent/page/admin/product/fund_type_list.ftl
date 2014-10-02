<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
				link_to: encodeURI('admin/fundType.go?page=__id__')
		    });
	   	});
	   	
	   	function searchMaster(){
	   		$('#master_list_form').submit();
	   	}
	</script>
	
</head>
  <body>
	 <div class="page"><!--page开始-->
		<div class="main clear"><!--main开始-->
			<div class="right">
				<div class="m-r">
				    <div>
				    <table class="table2">
		            	<tr>
		                    <th style="width:5%; height:28px;" >类型名称</th>
		                    <th style="width:8%">创建时间</th>
		                    <th style="width:7%">状态</th>
		                    <th style="width:7%">操作</th>
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

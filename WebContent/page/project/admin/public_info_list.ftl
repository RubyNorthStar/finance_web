<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
	<script src="/script/product/product.js" type="text/javascript" ></script>
	<!-- 公用样式 -->
	<link href="/style/manage/index.css" rel="stylesheet" />
	<link href="/style/manage/page.css" rel="stylesheet" />
	<title>产品列表</title>
	
	<style type="text/css">
	a {
		behavior: url(/script/jquery/hideFoucs.htc);
	}
	.rightPager{
		float: right; 
		height: 20px; 
		margin: 5px 5px 0 0 ;
	}
	.pagination .current {
		/*background-color:#D8DFEA;*/
		font-weight:bold;
		border: 1px solid #CCCCCC;
		color:#ffffff;
		display:block;
		float:left;
		padding:5px;
		text-decoration:none;
		font-size: 15px;
		margin-right: 5px;
		background: none repeat scroll 0 0 #647cbc;
	}
	.pagination a,.pagination span {
	 	border: 1px solid #CCCCCC;
		color:#647cbc;
		display:block;
		float:left;
		padding:5px;
		text-decoration:none;
		font-size: 15px;
		margin-right: 5px;
	}
</style>
	
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
				link_to: encodeURI('/admin/publicNotice.go?pageNo=__id__')
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
				    <table class="table2">
		            	<tr>
		                    <th style="width:18%; height:28px;"">公告标题</th>
		                    <th style="width:18%">所属品类</th>
		                    <th style="width:18%">所属行业</th>
		                    <th style="width:46%">操作</th>
	               	    </tr>
		               	 <#if list??>
			    			<#list list as item>
					    		<tr>
					    			<td><#if item.noticeTitle??>${item.noticeTitle}</#if></td>
						      		<td><#if item.category??>${item.category}</#if></td>
						      		<td><#if item.source??>${item.source}</#if></td>
						      		
						      		<td>
						      			<a href="/admin/publicNotice/detail.go?id=${item.id}">查看详情</a> &nbsp;
						      			<a href="/admin/publicNotice/update.go?id=${item.id}&status=4">下架</a> &nbsp;
						      			<a href="/admin/publicNotice/update.go?id=${item.id}&status=5">成交成功</a> &nbsp;
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

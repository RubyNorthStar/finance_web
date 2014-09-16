<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--后台登陆</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script>
	<script type="text/javascript" src="/script/jquery/jquery.pagination.js"></script>
	<script type="text/javascript">
		function reset(){
			$('#account').val('');
			$('#name').val('');
		}
		
		$(function(){
			var condition = "";
			
	 		var account = $('#account').val();
			if(account != ''){
				condition = "&account="+account;
			}
			var name = encodeURI($('#name').val());
			if(name != ''){
				condition = "&name="+name;
			}
			
		    $('.pagination').pagination(${pager.totalRecords?c}, {
				items_per_page: ${pager.pageSize},
				current_page: ${page - 1},
				prev_show_always:false,
				next_show_always:false,
				link_to: encodeURI('/manage/manage_obtainAllMasterList.shtml?page=__id__&'+condition)
		    });
	   	});
	   	
	   	function searchMaster(){
	   		$('#master_list_form').submit();
	   	}
	</script>
	<style type="text/css">
	.divcenter {
		text-align:center; 
		color: #0066CC; 
		margin:5px auto;
		background-color:#ccc;
	}
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
		color:#000000;
		display:block;
		float:left;
		padding:5px;
		text-decoration:none;
		font-size: 15px;
		margin-right: 5px;
	}
	.Left {
		text-align: left;
	}
</style>
</head>   
  <body>
	 <div class="page"><!--page开始-->
		<#include "/WEB-INF/page/manage/include/top.ftl">
		<div class="main clear"><!--main开始-->
				<#include "/WEB-INF/page/manage/include/left_new.ftl">
			<div class="right">
				<div class="m-r">
					<div style="padding:5px;background:none repeat scroll 0 0 #E4EAF6; margin-bottom:5px;border:1px solid #4F69A0">
		      		<form action="/manage/manage_obtainAllMasterList.shtml" method="post" id="master_list_form">
			      		 <table >
		        			<tr>
								<td> 账号：<input type="text" name="masterDTO.account" id="account" value="<#if masterDTO??><#if masterDTO.account??>${masterDTO.account}</#if></#if>"></td>
							 	<td>姓名：<input type="text" name="masterDTO.name" id="name" value="<#if masterDTO??><#if masterDTO.name??>${masterDTO.name}</#if></#if>"></td>
								<td><button  onclick="return searchMaster()">查询</button>
								<td width="540px;">&nbsp;</td>
							</tr>
						</table>
				    </form>
				    </div>
				    <div>
				    <table class="table2">
		            	<tr>
		                    <th style="width:5%; height:28px;" >账号</th>
		                    <th style="width:8%">姓名</th>
		                    <th style="width:7%">电话</th>
		                    <th style="width:7%">手机</th>
		                    <th style="width:5%">email</th>
		                    <th style="width:5%"> 状态</th>
		                    <th style="width:27%">操作</th>
	               	    </tr>
	               	 <#if pager??><#if pager.records??>
			    			<#list pager.records as master>
					    		<tr>
					    			<td><#if master.account??>${master.account}</#if></td>
						      		<td><#if master.name??>${master.name}</#if></td>
						      		<td><#if master.telephone??>${master.telephone}</#if></td>
						      		<td><#if master.mobile??>${master.mobile}</#if></td>
						      		<td><#if master.email??>${master.email}</#if></td>
						      		<td><#if master.forbidden??><#if (!master.forbidden)>禁用</#if><#if (master.forbidden)>启用</#if></#if></td>
						      		<td>
						      			<#if (actionNos?index_of("glygl") >= 0)>
						      				<a href="/manage/manage_goUpdateMaster.shtml?masterDTO.id=${master.mtId}">更新</a> &nbsp; &nbsp;
						      			</#if>
						      			<#if (actionNos?index_of("glyqx") >= 0)>
						      				<a href="/manage/manage_goUpdateAction.shtml?masterDTO.id=${master.mtId}">权限管理</a>&nbsp; &nbsp;
						      			</#if>
						      			<#if (actionNos?index_of("fzglygx") >= 0)>
						      				<a href="/manage/manage_goCopyAction.shtml?masterDTO.id=${master.mtId}">权限复制</a>
						      			</#if>
						      		</td>
						      	</tr>
				      		</#list>
				      	</#if></#if>
		            </table>
		            </div>
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  </body>
</html>

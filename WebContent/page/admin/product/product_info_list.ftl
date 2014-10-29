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
		<#include "/admin/common/top.ftl">
		<div class="main clear"><!--main开始-->
			<#include "/admin/common/left.ftl">
			<div class="right">
				<div class="m-r">
					<div style="padding:5px;background:none repeat scroll 0 0 #E4EAF6; margin-bottom:5px;border:1px solid #4F69A0">
		      		<form action="/admin/productInfo.go" method="post" id="product_list_form">
			      		 <table >
		        			<tr>
								<td> 产品名称：<input type="text" name="productName" id="productName" value="<#if search.productName??>${search.productName}</#if>"></td>
								<td><button  onclick="return searchProductByName()">查询</button>
								<td width="740px;">&nbsp;</td>
							</tr>
						</table>
				    </form>
				    </div>
				    <div>
				    <table class="table2">
		            	<tr>
		                    <th style="width:15%; height:28px;" >产品名称</th>
		                    <th style="width:7%">基金规模</th>
		                    <th style="width:7%">预期收益</th>
		                    <th style="width:9%">基金类型</th>
		                    <th style="width:5%">投资期限</th>
		                    <th style="width:12%">基金管理</th>
		                    <th style="width:5%">起投金额</th>
		                    <th style="width:7%">收益分配</th>
		                    <th style="width:5%">是否抵押</th>
		                    <th style="width:5%">年利率</th>
		                    <th style="width:5%">信用等级</th>
		                    <th style="width:18%">操作</th>
	               	    </tr>
		               	 <#if listProduct??>
			    			<#list listProduct as item>
					    		<tr>
	
					    			<td><#if item.productName??>${item.productName}</#if></td>
						      		<td><#if item.fundScale??>${item.fundScale}</#if></td>
						      		<td><#if item.expectProfit??>${item.expectProfit}</#if></td>
						      		
						      		<td><#if item.fundTypeId??>基金类型${item.fundTypeId}</#if></td>
						      		<td><#if item.investmentTimeLimit??>${item.investmentTimeLimit}</#if></td>
						      		<td><#if item.fundManage??>${item.fundManage}</#if></td>
						      		<td><#if item.minBidMoney??>${item.minBidMoney}</#if></td>
						      		<td><#if item.profitDistribution??>${item.profitDistribution}</#if></td>
						      		<td><#if item.isMortgage??> <#if item.isMortgage == 1>有<#else>无</#if></#if></td>
						      		<td><#if item.yearInterestRate??>${item.yearInterestRate}</#if></td>
						      		<td><#if item.creditLevle??>${item.creditLevle}</#if></td>
						      		<td>
						      			<#if item.toExamineStatus == 1 || item.toExamineStatus == 3>
						      					<a onclick="updateStatus(${item.id},2)" style="cursor:pointer">审核</a> &nbsp;
						      				<#else>
						      					<a onclick="updateStatus(${item.id},3)" style="cursor:pointer">禁用</a> &nbsp;
						      			</#if>
						      			<a href="/admin/productInfo/update.go?id=${item.id}">更新</a> &nbsp;
						      			<a href="/admin/productInfo/del/${item.id}.go">删除</a> &nbsp;
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

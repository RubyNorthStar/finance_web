<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
	<script src="/script/product/product.js" type="text/javascript" ></script>
	<
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
		<div class="main clear"><!--main开始-->
			<div class="right">
				<div class="m-r">
				    <div>
				    <table class="table2">
		            	<tr>
		                    <th style="width:7%; height:28px;" >产品名称</th>
		                    <th style="width:7%">基金规模</th>
		                    <th style="width:7%">预期收益</th>
		                    <th style="width:7%">基金类型</th>
		                    <th style="width:7%">投资期限</th>
		                    <th style="width:7%">基金管理</th>
		                    <th style="width:7%">起投金额</th>
		                    <th style="width:7%">收益分配</th>
		                    <th style="width:7%">是否抵押</th>
		                    <th style="width:7%">年利率</th>
		                    <th style="width:7%">信用等级</th>
		                    <th style="width:13%">操作</th>
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
						      		<td><#if item.isMortgage??>${item.isMortgage}</#if></td>
						      		<td><#if item.yearInterestRate??>${item.yearInterestRate}</#if></td>
						      		<td><#if item.creditLevle??>${item.creditLevle}</#if></td>
						      		<td><#if item.expectProfit??>${item.expectProfit}</#if></td>
						      		<td>
						      			<a onclick="updateStatus(${item.id},2)" style="cursor:pointer">审核</a> &nbsp; &nbsp;
						      			<a onclick="updateStatus(${item.id},3)" style="cursor:pointer">禁用</a> &nbsp; &nbsp;
						      			<a href="/admin/productInfo/update.go?id=${item.id}">更新</a> &nbsp; &nbsp;
						      			<a href="/admin/productInfo/del/${item.id}.go">删除</a> &nbsp; &nbsp;
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

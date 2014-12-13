<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<!-- 公用样式 -->
	<link href="/style/manage/index.css" rel="stylesheet" />
	<title>产品列表</title>
	
</head>
  <body>
  
  		<div class="page"><!--page开始-->
		<#include "/admin/common/top.ftl">
		<div class="main clear"><!--main开始-->
			<#include "/admin/common/left.ftl">
			<div class="right">
				<div class="m-r">
				    <div>
				    	投资名称：${investment.investName!''}</br>
				    	投资机构名称：${investment.agencyName!''}</br>
				    	投资机构所在地：${investment.orgAddress!''}</br>
				    	投资类型：${investment.investType!''}</br>
				    	投资形式：${investment.investStyle!''}</br>
				    	投资方式：${investment.investMode!''}</br>
				    	投资行业 ：${investment.industry!''}</br>
				    	投资地区：${investment.area!''}</br>
				    	投资企业类型：${investment.enterpriseType!''}</br>
				    	投资回报率要求：${investment.getRequire!''}</br>
				    	投资机构介绍：${investment.investOrgInfo!''}</br>
				    	对投资机构要求 ：${investment.investRequire!''}</br>
				    	其他要求：${investment.otherRequire!''}</br>
					    	
					    	<a href="/admin/projectInfo/update.go?id=${investment.id}&status=2">审核通过</a> &nbsp;
					    	<a href="/admin/projectInfo/update.go?id=${investment.id}&status=3">审核未通过</a> &nbsp;
		            </div>
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  

	
  </body>
</html>

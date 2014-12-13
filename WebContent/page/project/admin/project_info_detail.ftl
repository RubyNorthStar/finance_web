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
				    	项目名称：${projectInfo.projectName!''}</br>
				    	所属行业：${projectInfo.proindustryId!''}</br>
				    	转让金额：${projectInfo.proPrice!''}</br>
				    	所在地区（省）：${projectInfo.addressProvince!''}</br>
				    	所在地区（市）：${projectInfo.addressCity!''}</br>
				    	融资方名称：${projectInfo.financingPartyName!''}</br>
				    	投资方应具备条件：${projectInfo.investorsRequire!''}</br>
				    	项目详细：${projectInfo.proDetail!''}</br>
					    	
					    	<a href="/admin/projectInfo/update.go?id=${projectInfo.id}&status=2&projectType=${projectInfo.projectType}">审核通过</a> &nbsp;
					    	<a href="/admin/projectInfo/update.go?id=${projectInfo.id}&status=3&projectType=${projectInfo.projectType}">审核未通过</a> &nbsp;
		            </div>
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  

	
  </body>
</html>

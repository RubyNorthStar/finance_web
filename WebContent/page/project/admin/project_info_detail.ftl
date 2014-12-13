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
					<ul class="examine-list-block-ul clear">
						<li class="examine-list-block-li clear">
							<div class="examine-left">项目名称：</div>
							<div class="examine-right">&nbsp;${projectInfo.projectName!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">所属行业：2</div>
							<div class="examine-right">&nbsp;${projectInfo.proindustryId!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">转让金额：3</div>
							<div class="examine-right">&nbsp;${projectInfo.proPrice!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">所在地区（省）：4</div>
							<div class="examine-right">&nbsp;${projectInfo.addressProvince!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">所在地区（市）：5</div>
							<div class="examine-right">&nbsp;${projectInfo.addressCity!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">融资方名称：6</div>
							<div class="examine-right">&nbsp;${projectInfo.financingPartyName!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资方应具备条件：7</div>
							<div class="examine-right">&nbsp;${projectInfo.investorsRequire!''}</div>
						</li>
						<li class="examine-list-block-li clear" style="border-bottom:1px solid #ccc;">
							<div class="examine-left">项目详细：8</div>
							<div class="examine-right">&nbsp;${projectInfo.proDetail!''}</div>
						</li>
					</ul>
					<div class="examine-botton">
						<a class="button"  href="/admin/projectInfo/update.go?id=${projectInfo.id}&status=2&projectType=${projectInfo.projectType}">审核通过</a> &nbsp;
						<a class="button" href="/admin/projectInfo/update.go?id=${projectInfo.id}&status=3&projectType=${projectInfo.projectType}">审核未通过</a> &nbsp;
					</div>
					
				    
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  

	
  </body>
</html>

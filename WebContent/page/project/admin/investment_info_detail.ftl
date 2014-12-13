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
							<div class="examine-left">投资名称：</div>
							<div class="examine-right">&nbsp;${investment.investName!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资机构名称：</div>
							<div class="examine-right">&nbsp;${investment.agencyName!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资机构所在地：</div>
							<div class="examine-right">&nbsp;${investment.orgAddress!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资类型：</div>
							<div class="examine-right">&nbsp;${investment.investType!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资形式：</div>
							<div class="examine-right">&nbsp;${investment.investStyle!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资方式：</div>
							<div class="examine-right">&nbsp;${investment.investMode!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资行业 ：</div>
							<div class="examine-right">&nbsp;${investment.industry!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资地区：</div>
							<div class="examine-right">&nbsp;${investment.area!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资企业类型：</div>
							<div class="examine-right">&nbsp;${investment.enterpriseType!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资回报率要求：</div>
							<div class="examine-right">&nbsp;${investment.getRequire!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">投资机构介绍：</div>
							<div class="examine-right">&nbsp;${investment.investOrgInfo!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">对投资机构要求 ：</div>
							<div class="examine-right">&nbsp;${investment.investRequire!''}</div>
						</li>
						<li class="examine-list-block-li clear" style="border-bottom:1px solid #ccc;">
							<div class="examine-left">其他要求：</div>
							<div class="examine-right">&nbsp;${investment.otherRequire!''}</div>
						</li>
					</ul>
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  

	
  </body>
</html>

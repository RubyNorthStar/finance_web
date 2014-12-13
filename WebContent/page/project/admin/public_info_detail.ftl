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
							<div class="examine-left">公告标题：1</div>
							<div class="examine-right">&nbsp;${publicNotice.noticeTitle!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">公告副标题：2</div>
							<div class="examine-right">&nbsp;${publicNotice.noticeViceTitle!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">公告描述：3</div>
							<div class="examine-right">&nbsp;${publicNotice.noticeDescription!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">公告来源：4</div>
							<div class="examine-right">&nbsp;${publicNotice.source!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">所属品类：5</div>
							<div class="examine-right">&nbsp;${publicNotice.category!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">公告分类：6</div>
							<div class="examine-right">&nbsp;${publicNotice.classiFication!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">所属行业：7</div>
							<div class="examine-right">&nbsp;${publicNotice.industryId!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">所在地区（省）：8</div>
							<div class="examine-right">&nbsp;${publicNotice.addressProvince!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">所在地区（市）：9</div>
							<div class="examine-right">&nbsp;${publicNotice.addressCity!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">底价：10</div>
							<div class="examine-right">&nbsp;${publicNotice.floorPrice!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">公告内容：11</div>
							<div class="examine-right">&nbsp;${publicNotice.content!''}</div>
						</li>
						<li class="examine-list-block-li clear">
							<div class="examine-left">联系人：12</div>
							<div class="examine-right">&nbsp;${publicNotice.person!''}</div>
						</li>
						<li class="examine-list-block-li clear" style=" border-bottom:1px solid #ccc;">
							<div class="examine-left">手机：13</div>
							<div class="examine-right">&nbsp;${publicNotice.mobile!''}</div>
						</li>
					</ul>
					
				    <div class="examine-botton">
				    	<a class="button" href="/admin/projectInfo/update.go?id=${publicNotice.id}&status=2">审核通过</a> &nbsp;
				    	<a class="button" href="/admin/projectInfo/update.go?id=${publicNotice.id}&status=3">审核未通过</a> &nbsp;
		            </div>
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  

	
  </body>
</html>

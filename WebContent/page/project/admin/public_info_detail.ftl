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
				    	公告标题：${publicNotice.noticeTitle!''}</br>
				    	公告副标题：${publicNotice.noticeViceTitle!''}</br>
				    	公告描述：${publicNotice.noticeDescription!''}</br>
				    	公告来源：${publicNotice.source!''}</br>
				    	所属品类：${publicNotice.category!''}</br>
				    	公告分类：${publicNotice.classiFication!''}</br>
				    	所属行业：${publicNotice.industryId!''}</br>
				    	所在地区（省）：${publicNotice.addressProvince!''}</br>
				    	所在地区（市）：${publicNotice.addressCity!''}</br>
				    	底价：${publicNotice.floorPrice!''}</br>
				    	公告内容：${publicNotice.content!''}</br>
				    	联系人：${publicNotice.person!''}</br>
				    	手机：${publicNotice.mobile!''}</br>
					    	
					    	<a href="/admin/projectInfo/update.go?id=${publicNotice.id}&status=2">审核通过</a> &nbsp;
					    	<a href="/admin/projectInfo/update.go?id=${publicNotice.id}&status=3">审核未通过</a> &nbsp;
		            </div>
			    </div>
			    <div class="pagination rightPager"></div>
		    </div>
		</div>
	</div>
  

	
  </body>
</html>

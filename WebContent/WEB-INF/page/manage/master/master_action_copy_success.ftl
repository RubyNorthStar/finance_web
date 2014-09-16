<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>酒美网--复制成功</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script>
</head>
  <body>
	 <div class="page"><!--page开始-->
		<#include "/WEB-INF/page/manage/include/top.ftl">
		<div class="main clear"><!--main开始-->
				<#include "/WEB-INF/page/manage/include/left_new.ftl">
			<div class="right1">
				<div class="r1_bottom" id="layer0">
		      		<span id="massges_info">
		      			<#if masterDTO??><#if masterDTO.flag??> 
							<#if masterDTO.flag == '1002'>
								拷贝失败，未查询到相关管理员
							</#if >
							<#if masterDTO.flag == '1001'>
								拷贝失败，没有响应管理员
							</#if >
							<#if masterDTO.flag == '1003'>
								权限拷贝成功
							</#if >
			      		</#if></#if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/manage/manage_obtainAllMasterList.shtml">管理员列表</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/manage/manage_goUpdateAction.shtml?masterDTO.id=${masterDTO.id}">查看权限</a>
		      		</span>
			    </div>
		    </div>
		</div>
	</div>
  </body>
</html>

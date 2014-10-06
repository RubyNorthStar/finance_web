<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章列表</title>
<link href="/style/manage/index.css" rel="stylesheet" />
<script src="/script/jquery/jquery-1.7.js"></script>
<script src="/script/jquery/jquery.pagination.js"></script>
<#-- <script type="text/javascript" src="/script/product/leftTree.js"></script> -->
<script type="text/javascript">
//批量生成老文章数据Start
  	function batche(){
	  $.getJSON("/json/content_batchEssay.shtml?m="+ Math.random(),function(date){
	  	var id = date.msg
	  	alert(id);
	  })
  	}
//批量生成老文章数据End

	var condition ="";
	$(function(){
		makecondition();
		$('.pagination').pagination(${search.totalRecords?c}, {
			items_per_page: ${search.pageSize},
			current_page: ${search.pageNo - 1},
			prev_show_always:false,
			next_show_always:false,
			link_to: encodeURI('/admin/articleInfo/list.go?pageNo=__id__')
	    });
	});
	function makecondition(){
		var articleSource = $('#articleSource').val();
		if(articleSource.length  > 0){
			if(condition.length = 0){
				condition = condition + "&articleInfo.articleSource="+encodeURI(encodeURI(articleSource));
			}else{
				condition = condition + "&articleInfo.articleSource="+encodeURI(encodeURI(articleSource));
			}
		}
		var title = $('#title').val();
		if(title.length  > 0){
			if(condition.length = 0){
				condition = condition + "articleInfo.title="+encodeURI(encodeURI(title));
			}else{
				condition = condition + "&articleInfo.title="+encodeURI(encodeURI(title));
			}
		}
	}
	function publishInfo(id){
		if(confirm("是否确定发布？")){
	     	$.getJSON('/json/articles_publish_type_articleInfo.shtml?articleInfo.apId='+id+'&m=' + Math.random(), function(data) {
				alert(data.publishInfo);
				window.location.reload();
			});
	    }
	}
	
	function makeUrl(url,id){
		var makeUrl= url+"&m=" + Math.random();
		$("#J_L_"+id).show();
		window.open(makeUrl,"",""); 
	}
	
	function onChangePic(picId){
		document.getElementById(picId).style.background="url(/images/common/index_pic_19.gif)";
	}
	function onChangePic2(picId){
		document.getElementById(picId).style.background="url(/images/common/index_pic_18.gif)";
	}
</script>
<style type="text/css">
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
		color:#647cbc;
		display:block;
		float:left;
		padding:5px;
		text-decoration:none;
		font-size: 15px;
		margin-right: 5px;
	}
</style>
</head>
<body>
<div class="page"><!--page开始-->
	<#include "/admin/common/top.ftl">
	  <div class="main clear"><!--main开始-->
	    <#include "/admin/common/left.ftl">
    	  <div class="right"><!--right开始-->
    		<h3>文章管理&gt;&gt;文章列表</h3>
        	  <div class="m-r">
				<form action="article_publish_type_obtainarticleInfoList.shtml" method="post" style="margin-bottom:5px;">
	        		<table class="table1">
	        			<tr>
							<td>文章标题：<input type="text" id="title" name="articleInfo.title" value="<#if articleInfo??><#if articleInfo.title??>${articleInfo.title}</#if></#if>"/></td>
						 	<td>文章来源：<input type="text" id="articleSource" name="articleInfo.articleSource" value="<#if articleInfo??><#if articleInfo.articleSource??>${articleInfo.articleSource}</#if></#if>"/></td>
							<td><input type="submit" value="搜索"/></td>
							<td width="540px;">&nbsp;</td>
						</tr>
					</table>
				</form>
				<table class="table2">
	            	<tr>
	                    <th style="width:5%; height:28px;" >编号</th>
	                    <th style="width:8%">文章类型名称</th>
	                    <th style="width:15%">文章标题</th>
	                    <th style="width:10%">文章来源</th>
	                    <th style="width:10%">添加时间</th>
	                    <th style="width:7%">添加人</th>
	                    <th style="width:7%">修改人</th>
	                    <th style="width:5%">是否启用</th>
	                    <th style="width:17%">操作</th>
               	    </tr>
               	  	<#if list??>
						<#list list as articleInfo>   
							<tr onmouseover="javascript:onChangePic('picId${articleInfo.apId?c}')" onmouseout="onChangePic2('picId${articleInfo.apId?c}')" id="picId${articleInfo.apId?c}">
								<td>${articleInfo.apId?c}</td>
								<td>${articleInfo.aptId?c}</td>
								<td>${articleInfo.title}</td>
								<td>${articleInfo.articleSource}</td>
								<td><#if articleInfo.addTime??>${articleInfo.addTime?string("yyyy-MM-dd HH:mm:ss")}</#if></td>
								<td>${articleInfo.addUser}</td>
								<td>${articleInfo.lastUpdateUser}</td>
								<td><#if (articleInfo.isUsing == 1)>是 <#else>否</#if></td>
								<td>
									<a href="article_publish_type_goUpdatearticleInfo.shtml?articleInfo.apId=${articleInfo.apId?c}">
										<img src="/images/common/update.jpg" alt="更新" align="absmiddle"/>
									</a>
									<a id="J_L_${articleInfo.apId?c}" href="javascript:publishInfo(${articleInfo.apId?c})">
										<img src="/images/common/publish.jpg" alt="发布" align="absmiddle"/>
									</a>
								</td>
							<tr>
						</#list>
					</#if>
					<input type="hidden" id="isCurShowPicId" name="isCurShowPicId" value="picId000003"/>
					<input type="hidden" id="dtul" name="dtul" value="ul7"/>
		            </table>
		            <div class="pagination rightPager"></div>
        	   </div><!--m-r结束-->
	    </div><!--right结束-->
	</div><!--main结束-->
</div><!--page结束-->
<input type="button" value="批量生成" onclick="batche()" />
  </body>
</html>


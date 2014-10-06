<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章类型列表</title>
<link href="/style/manage/index.css" rel="stylesheet" />
<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
<link href="/style/manage/page.css" rel="stylesheet" />

<script type="text/javascript">
   function onChangePic(picId){
	   document.getElementById(picId).style.background="url(/images/common/index_pic_19.gif)";
   }
	
	function onChangePic2(picId){
		document.getElementById(picId).style.background="url(/images/common/index_pic_18.gif)";
	}
	function delArticleInfoType(id){
		if(confirm("是否确定删除该记录？")){
	     	$.getJSON('/admin/articleInfoType/delJson/'+id+'.go?m=' + Math.random(), function(data) {
     			window.location.reload();
			});
	    }
	}
	
	$(function(){
		    $('.pagination').pagination(${search.totalRecords?c}, {
				items_per_page: ${search.pageSize},
				current_page: ${search.pageNo - 1},
				prev_show_always:false,
				next_show_always:false,
				link_to: encodeURI('/admin/articleInfoType/list.go?pageNo=__id__')
		    });
	   	});
</script>
</head>
<body>

<div class="page"><!--page开始-->
	<#include "/admin/common/top.ftl">
	   <div class="main clear"><!--main开始-->
		  <#include "/admin/common/left.ftl">
    		<div class="right"><!--right开始-->
    		   <h3>文章类型管理&gt;&gt;文章类型列表</h3>
       			  <div class="m-r"><!--m-r开始-->
           			<table class="table2">
	            	<tr>
	                    <th style="width:10% ; height:28px;">类型编号</th>
	                    <th style="width:15%">类型名称</th>
	                    <th style="width:20%">添加时间</th>
	                    <th style="width:20%">修改时间</th>
	                    <th style="width:10%">添加人</th>
	                    <th style="width:10%">修改人</th>
	                    <th style="width:20%">操作</th>
	                </tr>
	                <#if list??>
						<#list list as articleInfoType>
							<tr onmouseover="javascript:onChangePic('picId${articleInfoType.aptId}')" onmouseout="onChangePic2('picId${articleInfoType.aptId}')" id="picId${articleInfoType.aptId}">
			                    <td>${articleInfoType.aptId}</td>
								<td>${articleInfoType.aptName}</td>
								<td><#if articleInfoType.addTime??>${articleInfoType.addTime?string("yyyy-MM-dd")}</#if ></td>
								<td><#if articleInfoType.lastUpdateTime??>${articleInfoType.lastUpdateTime?string("yyyy-MM-dd")}</#if></td>
								<td>${articleInfoType.addUser}</td>
								<td>${articleInfoType.lastUpdateUser}</td>
								<td>
									<a href="javascript:delArticleInfoType(${articleInfoType.aptId})">
										<img src="/images/common/delet.png" alt="删除" align="absmiddle" />
									</a>
									<a href="/admin/articleInfoType/goUpdate.go?id=${articleInfoType.aptId}">
										<img src="/images/common/update.jpg" alt="更新" align="absmiddle"/>
									</a>
								</td>
			                </tr>
						</#list>
					</#if>	
			<input type="hidden" id="isCurShowPicId" name="isCurShowPicId" value="picId700001"/>
			<input type="hidden" id="dtul" name="dtul" value="ul7"/>
            </table>
        </div><!--m-r结束-->
        <div class="pagination rightPager"></div>
    </div><!--right结束-->
</div><!--main结束-->
</div><!--page结束-->
</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 项目管理</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/my-app.css">
    <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
</head>
<body>

<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view-main">
        <!-- Top Navbar-->
        <#include "/index/common/top.ftl">
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" style="margin:0; ">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="margin:0; padding:0;">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <!-- 左侧部分 -->
                    <#include "/index/common/center_left.ftl">
                    <div class="right-content">
                    <!-- 中间部分开始 -->
                    	<input type="hidden" id="status" value="${search.status}"/>
                    	<input type="hidden" id="totalPage" value="${search.totalPages}"/>
                    	
                    	<div class="manage-table">
                            <table><!-- 表格 -->
                                <tbody>
                                <tr><!-- 表格行 -->
                                    <th colspan="4"  class="table-bg">
	                            		我的投资项目管理
                                    </th>
                                </tr>
                                <tr>
                                    <td class="table-bg">项目名称</td>
                                    <td rowspan="2">
                                        <input class="name" type="text">
                                    </td>
                                    <td  rowspan="3" class="table-bg">
                                        <button class="button-style button-style-blue query_project" style="margin:0; padding:5px 7px;">查询</button>
                                        <button class="button-style button-style-blue" style="margin:0; padding:5px 7px;">取消</button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class=" information">
                            <div class="info-list">
                                <ul class="info-ul clear">
                                    <li class="info-li info-active" date="1">
                                    	<a href="javascript:;">待审项目</a>
                                    </li>
                                    <li class="info-li" date="2"><a href="javascript:;">审核通过项目</a></li>
                                    <li class="info-li" date="3"><a href="javascript:;">审核未通过项目</a></li>
                                    <li class="info-li" date="4"><a href="javascript:;">下架项目</a></li>
                                    <li class="info-li" date="5"><a href="javascript:;">成交项目</a></li>
                                </ul>
                            </div>
                            <div class="info-content">
	                            <div style="height:300px;">
	                            	<div class="form-box form-box-active">
	                            		<table class="table-box">
											<tr class="tr-title">
											  <td>项目名称</td>
											  <td>操作</td>
											</tr>
											
											 <#if list??>
				                                <#list list as investment>
				                                	 <tr>
													   <td>${investment.investName}</td>
													   <td>
													   		<button class="button-style button-style-blue delete" data="${investment.id}" style="margin:0; padding:5px 7px;">删除</button>
	                                       				    <button class="button-style button-style-blue update" data="${investment.id}" style="margin:0; padding:5px 7px;">修改</button>
													   </td>
													 </tr>
				                                </#list>
			                                </#if>
										</table>
	                            	</div>
	                            	
                            	
	                            </div>
                                <div class="zr_paging clear">
                                	<input type="hidden" id="pageInput"/>
                                	<div>共${search.totalRecords}条   <span class="curNumber">第${search.pageNo}页</span>  共${search.totalPages}页</div>    
                                	<div class="pageDate" data="1">首页</div>  
                                	<div class="pageDate prefNumber" data="${search.pageNo-1}">上一页</div>  
                                	<div class="pageDate nextNumber" data="${search.pageNo+1}">下一页</div>  
                                	<div class="pageDate" data="${search.totalPages}">尾页</div>
                                </div>
                                
                            </div>
                        </div>
                    	
            
           			<!-- 中间部分结束 -->
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Path to Framework7 Library JS-->
<!--<script type="text/javascript" src="js/framework7.js"></script>-->
<!-- Path to your app js-->
<!--<script type="text/javascript" src="js/my-app.js"></script>-->
<script type="text/javascript">
	$(function(){
		$(".info-ul .info-li").click(function(){
			$(".info-ul .info-li").removeClass("info-active");
			$(this).addClass("info-active");
			//$(".form-box").removeClass("form-box-active");
        	//$(".form-box").eq( $(this).index()).addClass("form-box-active");
			
			var state = $(this).attr("date");
			var curPage = 1;
			queryProject(curPage,state,null);
		});
		
		$(".pageDate").click(function(){
			var curPage = $(this).attr("data");
			var totalPage = $('#totalPage').val();
			if(curPage <= 0){
				curPage = 1;
			}else if(curPage >= totalPage){
				curPage = totalPage;
			}
			
			$('.curNumber').html("第"+curPage+"页");
			$('.prefNumber').attr("data",parseInt(curPage)-1);
			$('.nextNumber').attr("data",parseInt(curPage)+1);
			
			var status = $("#status").val();
			queryProject(curPage,status,null);
			
		});
		
		
		$(".query_project").click(function(){
			var curPage  = 1;
			var status = $("#status").val();
			var name = $('.name').val();
			alert(name);
			queryProject(curPage,status,name);
		});
		
		$(".delete").click(function(){
			var obj = $(this);
			var id = $(this).attr("data");
			  if (confirm("确认要删除？")) {
			  	$.ajax({
					url : "/center/investment/del/"+id+".go",
					type : "get",
					dataType : "text",
					cache : false,
					success :function(data){
						if(data = "succ"){
							alert("删除成功");
							obj.parents("tr").remove();
						}else{
							alert("删除失败");
						}
					}
				});
			  }
		});
	})
	
	function queryProject( curPage, status, name){
		$.ajax({
				url : "/center/investment/ajaxList.go",
				type : "post",
				data:{"pageNo":curPage,"status":status,"investName":name},
				dataType : "html",
				cache : false,
				success :function(data){
					$(".table-box").empty();
		            $(".table-box").html(data);
				}
			});
	}
	
	
</script>
</body>
</html>
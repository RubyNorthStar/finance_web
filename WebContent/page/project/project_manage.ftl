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
                    
                    	<div class="manage-table">
                            <table style=""><!-- 表格 -->
                                <tbody>
                                <tr><!-- 表格行 -->
                                    <th colspan="4"  class="table-bg">我的转让项目管理</th>
                                </tr>
                                <tr>
                                    <td class="table-bg">项目名称</td>
                                    <td rowspan="2">
                                        <input class="name " type="text">
                                    </td>
                                    <td  rowspan="3" class="table-bg">
                                        <button class="button-style button-style-blue" style="margin:0; padding:5px 7px;">查询</button>
                                        <button class="button-style button-style-blue" style="margin:0; padding:5px 7px;">取消</button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class=" information">
                            <div class="info-list">
                                <ul class="info-ul clear">
                                    <li class="info-li info-active">
                                    	<a href="javascript:;">已发布项目</a>
                                    </li>
                                    <li class="info-li">
                                    	<a href="javascript:;">待审项目</a>
                                    </li>
                                    <li class="info-li"><a href="javascript:;">审核通过项目</a></li>
                                    <li class="info-li"><a href="javascript:;">审核未通过项目</a></li>
                                    <li class="info-li"><a href="javascript:;">下架项目</a></li>
                                    <li class="info-li"><a href="javascript:;">成交项目</a></li>
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
											<tr>
											  <td>松岛枫</td>
											  <td>刪除/修改</td>
											</tr>
										</table>
	                            	</div>
	                            	
	                            	<div class="form-box">
	                            		<table class="table-box">
											<tr class="tr-title">
											  <td>项目名称</td>
											  <td>操作</td>
											</tr>
											<tr>
											  <td>didididi</td>
											  <td>刪除/修改</td>
											</tr>
											<tr>
											  <td>didididi</td>
											  <td>刪除/修改</td>
											</tr>
											<tr>
											  <td>didididi</td>
											  <td>刪除/修改</td>
											</tr>
										</table>
	                            	</div>
                            	
	                            </div>
                                <#if list??>
	                                <#list list as project>
	                                	 <div class="info-div1">
	                                    	${project.projectName} 
	                                	 </div>
	                                </#list>
                                </#if>
                                <div class="paging clear">
                                	<div>共${search.totalRecords}条  第${search.pageNo}页</div>    <div>首页</div>  <div>上页</div>  <div>下页</div>  <div>尾页</div>
                                </div>
                                
                            </div>
                        </div>
                    	
            
           			<!-- 中间部分结束 -->
                    </div>
                </div>
            </div>
        </div>

    </div>
    <#include "/index/common/foot.ftl">
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
			$(".form-box").removeClass("form-box-active");
        	$(".form-box").eq( $(this).index()).addClass("form-box-active");
			
		})
	})
</script>
</body>
</html>
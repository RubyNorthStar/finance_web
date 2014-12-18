<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 投资列表页</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/my-app.css">
    <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
    <script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
	<link href="/style/manage/page.css" rel="stylesheet" />
	
	<script type="text/javascript">
		$(function(){
		    $('.pagination').pagination(${search.totalRecords?c}, {
				items_per_page: ${search.pageSize},
				current_page: ${search.pageNo - 1},
				prev_show_always:false,
				next_show_always:false,
				link_to: encodeURI('/projectInfo/investList.go?pageNo=__id__')
		    });
	   	});
	</script>
</head>
<body>

<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view-main">
        <!-- Top Navbar-->
        <#include "/index/common/top.ftl">
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages" style="margin:0; ">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <div class="page-content clearfix">
                    <div class="top-img">
                        <img src="/resources/images/manage/list-img.jpg">
                    </div>
                    
                    
                    <div class="content-inner">
                        <h2 class="h2-title">当前位置>项目集市</h2>
                        <div class="market-list clear">
                            <ul class="list-menu clear">
                                <li><a href="javascript:;">投资名称</a></li>
                                <li><a href="javascript:;">投资类型</a></li>
                                <li><a href="javascript:;">投资行业</a></li>
                                <li><a href="javascript:;">投资地区</a></li>
                                <li><a href="javascript:;">发布时间</a></li>
                            </ul>
                            <div class="list-content">
                                
                                 <#if investList??>
			    					<#list investList as obj>
				    					<div class="ol_div" onclick='document.location.href="/projectInfo/publicNotice.go?id=${obj.id}"' style="cursor:pointer;">
				    						 <ol class="clear" >
		                                		<li>${obj.investName!''}</li>
			                                    <li>${obj.investType!''}</li>
			                                    <li>${obj.industry!'-'}</li>
			                                    <li>${obj.addressProvince!''}-${obj.addressCity!''}</li>
			                                    <li>${obj.beginTime?string("yyyy-MM-dd")}</li>
		                                     </ol>
		                                </div>
                               		 </#list>
                               	</#if>

                            </div>
                            <div class="paging clearfix">
		                        <div class="pagination rightPager"></div>
		                    </div>
                        </div>
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
</body>
</html>
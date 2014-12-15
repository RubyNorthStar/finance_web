<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 项目详细页</title>
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
        <div class="pages" style="margin:0; ">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <div class="page-content clearfix">
                    <div class="top-img">
                        <img src="/resources/images/manage/list-img.jpg">
                    </div>
                    <div class="content-inner">
                        <h2 class="h2-title">当前位置> 项目集市> <#if projectInfo.projectType == 1>融资信息 <#else> 转让项目</#if> > ${projectInfo.projectName}</h2>
                        <div class="market-content">
                            <ul class="market-content-info">
                                <li class="clearfix">
                                    <div>
                                       <span class="span-title-green"> 项目名称：</span>
                                       <span class="span-content"> ${projectInfo.projectName!''}</span>
                                    </div>
                                    <div >
                                        <span class="span-title-green"> 交易品类：</span>
                                        <span class="span-content"> ${projectInfo.projectTypeClassify!''}</span>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div>
                                        <span class="span-title-green"> 参考价格：</span>
                                        <span class="span-content">${projectInfo.proPrice!''}万元</span>
                                    </div>
                                    <div >
                                        <span class="span-title-green"> 有效期至：</span>
                                        <span class="span-content">${projectInfo.beginTime?string("yyyy-MM-dd")}&nbsp;至&nbsp;${projectInfo.endTime?string("yyyy-MM-dd")}</span>
                                    </div>
                                </li>
                                <li class="market-content-info-button clearfix">
                                    <a class="button-gz">我要关注</a>
                                    <a class="button-fk">我要反馈</a>
                                </li>
                            </ul>
                            <div class="">
                                <h2 class="h2-title">•&numsp;融资项目简介</h2>
                                <div class="worth">
                                    <div class="span-title-green worth-title">项目基本信息</div>
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">所属行业：${projectInfo.proindustryId!''}</span>
                                        <span class="span-title-green">所在地区：${projectInfo.addressProvince!''}-${projectInfo.addressCity!''}</span>
                                    </div>
                                    <div class="worth-text">
                                        ${projectInfo.proDetail}
                                    </div>
                                </div>
                            </div>
                            
                            <div class="" style="margin-bottom: 60px;">
                                <h2 class="h2-title">•&numsp;项目反馈</h2>
                                <div class="worth">
                                    <div class="fk-info clearfix">
                                        <div class="span-title-green " style=" float: left;">反馈信息:</div>
                                        <div>
                                            <textarea class="fk-text" style="float: left;"> </textarea>
                                        </div>
                                    </div>
                                    <div class="market-person-info-2">
                                        <span class="span-title-green">&numsp;联系人：<input type="text"></span>
                                        <span class="span-title-green">邮 箱：<input type="text"></span>
                                    </div>
                                    <div class="tj-button">
                                        <a class="">提交反馈</a>
                                    </div>
                                </div>
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
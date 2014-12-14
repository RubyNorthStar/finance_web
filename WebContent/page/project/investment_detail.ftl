<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 投资项目详细页</title>
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
                        <h2 class="h2-title">当前位置> 项目集市> 投资信息  > ${investment.investName}</h2>
                        <div class="market-content">
                            <ul class="market-content-info">
                                <li class="clearfix">
                                    <div>
                                       <span class="span-title-green"> 投资意向名称：</span>
                                       <span class="span-content"> ${investment.investName!''}</span>
                                    </div>
                                    <div >
                                        <span class="span-title-green"> 投资回报率要求：</span>
                                        <span class="span-content"> ${investment.getRequire!''}</span>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div>
                                        <span class="span-title-green"> 投资规模：</span>
                                        <span class="span-content">${investment.investScale!''}万元</span>
                                    </div>
                                    <div >
                                        <span class="span-title-green"> 有效期：</span>
                                        <span class="span-content">${investment.beginTime?string("yyyy-MM-dd")}&nbsp至&nbsp${investment.endTime?string("yyyy-MM-dd")}</span>
                                    </div>
                                </li>
                                <li class="market-content-info-button clearfix">
                                    <a class="button-gz">我要关注</a>
                                    <a class="button-fk">我要反馈</a>
                                </li>
                            </ul>
                            <div class="">
                                <h2 class="h2-title">•&numsp;投资意向信息</h2>
                                <div class="worth">
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">投资类型：${investment.investType!''}</span>
                                        <span class="span-title-green">投资形式：${investment.investStyle!''}</span>
                                    </div>
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">投资企业类型：${investment.enterpriseType!''}</span>
                                        <span class="span-title-green">投资方式：${investment.investMode!''}</span>
                                    </div>
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">投资行业：${investment.enterpriseType!''}</span>
                                        <span class="span-title-green">投资方式：${investment.investMode!''}</span>
                                    </div>
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">投资地区：${investment.area!''}</span>
                                    </div>
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">对接受项目要求：${investment.investRequire!''}</span>
                                    </div>
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">其它要求：${investment.otherRequire!''}</span>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="">
                                <h2 class="h2-title">•&numsp;投资机构介绍</h2>
                                <div class="worth">
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">投资机构名称：${investment.agencyName!''}</span>
                                        <span class="span-title-green">投资机构所在地址：${investment.orgAddress!''}</span>
                                    </div>
                                    <div class="market-person-info-1">
                                        <span class="span-title-green">投资机构介绍：${investment.investOrgInfo!''}</span>
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
                                        <span class="span-title-green">联系人：<input type="text"></span>
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
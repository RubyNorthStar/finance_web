<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 公告详细页</title>
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
                        <h2 class="h2-title">当前位置> 项目集市> 公告信息 > ${publicNotice.noticeTitle!''}</h2>
                        <div class="market-content">
                            <ul class="market-content-info">
                                <li class="clearfix">
                                    <div>
                                       <span class="span-title-green"> 公告名称：</span>
                                       <span class="span-content"> ${publicNotice.noticeTitle!''}</span>
                                    </div>
                                    <div >
                                        <span class="span-title-green"> 所属品类：</span>
                                        <span class="span-content"> ${publicNotice.category!''}</span>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div>
                                        <span class="span-title-green"> 所属行业：</span>
                                        <span class="span-content">${publicNotice.industryStr!''}</span>
                                    </div>
                                    <div >
                                        <span class="span-title-green"> 所在地区：</span>
                                        <span class="span-content">${publicNotice.addressProvince!''}&nbsp-&nbsp${publicNotice.addressCity!''}</span>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div>
                                        <span class="span-title-green"> 公告分类：</span>
                                        <span class="span-content">${publicNotice.classiFication!''}</span>
                                    </div>
                                    <div >
                                        <span class="span-title-green"> 有效期至：</span>
                                        <span class="span-content">${publicNotice.beginTime?string("yyyy-MM-dd")}&nbsp&nbsp${publicNotice.endTime?string("yyyy-MM-dd")}</span>
                                    </div>
                                </li>
                            </ul>
                            <div class="">
                                <div class="worth">
                                    <div class="span-title-green worth-title">公告内容</div>
                                    <div class="worth-text">
                                        ${publicNotice.content!''}
                                    </div>
                                </div>
                            </div>
                            
                            <div class="" style="margin-bottom: 60px;">
                                <h2 class="h2-title">•&numsp;联系方式</h2>
                                <div class="worth">
                                    <div class="market-person-info-2">
                                        <span class="span-title-green">联系人：${publicNotice.person!''}</span>
                                        <span class="span-title-green">邮&nbsp;&nbsp; 箱：${publicNotice.email!''}</span>
                                    </div>
                                    <div class="market-person-info-2">
                                        <span class="span-title-green">手&nbsp;&nbsp;机：${publicNotice.mobile!''}</span>
                                        <span class="span-title-green">电&nbsp;&nbsp; 话：${publicNotice.phone!''}</span>
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
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="/style/common/index.css">
    <script src="/script/jquery/jquery-1.7.js"></script>
    <style>
        .none{
            display: none;
        }
    </style>
</head>

<body>
<div class="views">
    <div class="view">
        <!--头部导航-->
        <!--  -->
        <div class="navbar">
            <div class="navbar-inner clearfix">
                <div class="left">
                    <img class="top-logo" src="/images/common/logo.jpg" />
                </div>
                <div class="right ">
                    <div class="menu">
                       	 关于我们&numsp;|&numsp;我要理财&numsp;|&numsp;我要借款&numsp;|&numsp;新手指南&numsp;|&numsp;联系我们
                    </div>
                    <div class="button-login">
                        <button class="button button-color1">登陆</button>
                        <button class="button button-color2">注册</button>
                    </div>
                </div>
            </div>
        </div>

        <!--中间内容-->

        <div class="content m-l clearfix " style="display: block">
            <div class="content-block ">
                <img class="content-top-img box-shadow" src="/images/common/001.jpg" />
            </div>
            <div class="content-content clearfix" style="width: 81%;background: #fff;">
                <!--正文-->
                <h4 class="h4">新闻动态</h4>
                <#if list??>
						<#list list as articleInfo>   
			                <div class="newslist clearfix">
			                    <div class="fL"><img class="news-img" <#if articleInfo??><#if articleInfo.articlePic??>src="/userfiles/articleImg${articleInfo.articlePic}"</#if><#else>src="/image/manage/touming.png"</#if>/></div>
			                    <div class="fL news-content">
			                        <div class="news-title">${articleInfo.title}<span class="span7"><#if articleInfo.addTime??>${articleInfo.addTime?string("yyyy-MM-dd")}</#if ></span></div>
			                        <div class="newsInfo" style="text-indent:2em;">
			                            ${articleInfo.normalCode}
			                        </div>
			                    </div>
			                </div>
			     	</#list>
				</#if>
            </div>
            </div>
        </div>
        <!--底部工具栏   input-block-->
        <div class="page clearfix" >
            <div class="toolbar">
                <img class="bottom-logo" src="/images/common/0013.jpg" />
            </div>
            <div class="toolbar">
                <div class="top-inner toolbar-inner">
                    关于安心理财|联系我们|公司荣誉|合作伙伴|安心官方微博|全国免费质询电话：400-6099-800
                </div>
                <div class="bottom-text">
                    京ICP证100743号 京公网安1101055897CreditEase@Θ2009
                </div>
            </div>
            <div class="toolbar">
                <img class="" style="width: 200px;height: 60px" src="/images/common/0012.jpg" />
            </div>
        </div>
    </div>
</div>



<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/js.js"></script>
</body>
</html>
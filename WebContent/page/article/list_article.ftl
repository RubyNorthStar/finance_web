<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>携手金融网</title>
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
        <#include "/index/common/top.ftl">

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
			                    <div class="fL"><a href="/article/articleInfo/article_detail.go?id=7" target="_blank"><img class="news-img" <#if articleInfo??><#if articleInfo.articlePic??>src="/userfiles/articleImg${articleInfo.articlePic}"</#if><#else>src="/image/manage/touming.png"</#if>/></a></div>
			                    <div class="fL news-content">
			                        <div class="news-title"><a href="/article/articleInfo/article_detail.go?id=7" target="_blank"><span class="news-title">${articleInfo.title}</span></a><span class="span7"><#if articleInfo.addTime??>${articleInfo.addTime?string("yyyy-MM-dd")}</#if ></span></div>
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
        <#include "/index/common/foot.ftl">
    </div>
</div>
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/js.js"></script>
</body>
</html>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>携手金融网 - 产品详情</title>
    <link rel="stylesheet" href="/resources/css/idangerous.swiper.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
	<link rel="stylesheet" href="/resources/css/swiper-demos.css?v=1.8">
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <script type="text/javascript" src="/script/product/product.js"></script>
    <script src="/script/jquery/jquery-1.7.js"></script>
    <style>
        .none{
            display: none;
        }
    </style>
    
    <script type="text/javascript">
    	$(function(){
		    $(".list-li-title").mousemove(function(){
		        $(".list-li-title").removeClass("active");
		        $(this).addClass("active");
		        $(".hidden").removeClass("show");
		        $(".hidden").eq( $(this).index()).addClass("show");
		    });
		});
    </script>
</head>

<body>
<div class="views body-bg">

    <!--头部导航-->
    <#include "/index/common/top.ftl">
    <div class="view" style="width:1348px;background:#f7f7f7;">
        <!--中间内容-->

        <div class="content clearfix " style="display: block; background: #f7f7f7; padding-left: 150px;">
            <div class="content-block ">
                <!--<img class="content-top-img box-shadow" src="/images/common/001.jpg" />-->
                <div class="" >
                    <h3 class="user-name">${productInfo.productName}</h3>
                </div>
                <div class="list-box" style="">
                    <div class="list-block clearfix">
                        <ul class="list-block-ul">
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">基金规模</div>
                                <div class="fL list-block-div ml20">${productInfo.fundScale}元</div>
                            </li>
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">基金类型</div>
                                <div class="fL list-block-div ml20">${productInfo.fundTypeId}</div>
                            </li>
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">基金管理</div>
                                <div class="fL list-block-div ml20">${productInfo.fundManage}</div>
                            </li>
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">收益分配</div>
                                <div class="fL list-block-div ml20">${productInfo.profitDistribution}</div>
                            </li>
                        </ul>
                        <ul class="list-block-ul ">
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">预期收益</div>
                                <div class="fL list-block-div ml20">${productInfo.expectProfit}</div>
                            </li>
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">投资期限</div>
                                <div class="fL list-block-div ml20">${productInfo.investmentTimeLimit}</div>
                            </li>
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">起投金额</div>
                                <div class="fL list-block-div ml20">${productInfo.minBidMoney}</div>
                            </li>
                            <li class="list-block-li clearfix">
                                <div class="fL list-block-div">募集日期</div>
                                <div class="fL list-block-div ml20"><#if productInfo.beginTime??>${productInfo.beginTime?string("yyyy-MM-dd")}</#if ></div>
                            </li>
                        </ul>
                        <ul class="fL">
                            <li>
                                <img class="list-block-img" src="/images/common/0021.jpg" />
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
            <div class="" style="margin-top: 20px;">
                <div class="">
                    <ul class="tab-title clearfix">
                        <li class="list-li-title fL active">
                            	项目介绍
                        </li>
                        <li class="list-li-title fL">
                            	资金用途
                        </li>
                        <li class="list-li-title fL">
                            	还款来源
                        </li>
                        <li class="list-li-title fL">
                            	交易结构
                        </li>
                        <li class="list-li-title fL">
                            	风险措施
                        </li>
                    </ul>
                    <div class="Tab-content">
                        <div class="hidden show">
                    		${productInfo.productDetaileInfo}
                        </div>
                        <div class="hidden">
                        	${productInfo.fundUse}
                        </div>
                        <div class="hidden">
                        	${productInfo.repaymentSource}
                        </div>
                        <div class="hidden">
                        	${productInfo.businessStructure}
                        </div>
                        <div class="hidden">
                        	${productInfo.windControlMeasures}
                        </div>
                    </div>
                </div>
            </div>
            <div role="main" class="main" >
            	<div class="swiper-car content-content mt6 box-shadow clearfix" style="width:970px;height: 160px; overflow: hidden; position: relative;">
        		<!--<a class="leftMove A1" href="javascript:;"><</a>
        		<a class="rightMove A1" href="javascript:;">></a>-->
        		<div class="pagination-car"></div>
        		<div class="swiper-wrapper clearfix move">
			      <img class="swiper-slide content-img" src="/images/common/002.jpg" />
			      <img class="swiper-slide content-img" src="/images/common/003.jpg" />
			      <img class="swiper-slide content-img" src="/images/common/004.jpg" />
			      <img class="swiper-slide content-img" src="/images/common/005.jpg" />
			      <img class="swiper-slide content-img" src="/images/common/002.jpg" />
			      <img class="swiper-slide content-img" src="/images/common/003.jpg" />
			      <img class="swiper-slide content-img" src="/images/common/005.jpg" />
			    </div>
            </div>
            
        </div>
    </div>
	<div class="content-content mt6 bg-content" style="width: 100%">
        <div class="details-form" style="">
            <div class="user-name">更多产品信息请致电&numsp;400-6099-800</div>
            <div class="form-text">
                <p>在线填写真实姓名和电话号码</p>
            </div>
            <div class="form-input">
                <div class="form-input-name">贵宾姓名：<input type="text" id="vipName" style="width: 200px;"></div>
                <div class="form-input-phone">联系电话：<input type="text" id="vipMobile" style="width: 200px;"></div>
                <div class="tj-btn"><button class="tj" onclick="return addVipUser()" style="width: 100px; padding: 5px 10px; color: #fff; border: none; background: #0074c1;">提 交</button></div>
            </div>
        </div>
    </div>
	       <!--底部工具栏-->
	<div class="page clearfix" style="padding-bottom: 40px;">
	    <div class="toolbar">
	        <img class="bottom-logo" src="/resources/images/user/0013.jpg" />
	    </div>
	    <div class="toolbar">
	        <div class="top-inner toolbar-inner">
	        	    关于安心理财&numsp;|&numsp;联系我们&numsp;|&numsp;公司荣誉&numsp;|&numsp;合作伙伴&numsp;|&numsp;安心官方微博&numsp;|&numsp;全国免费质询电话：400-6099-800
	        </div>
	        <div class="bottom-text">
	          	   京ICP证100743号 京公网安1101055897CreditEase@Θ2009
	        </div>
	    </div>
	    <div class="toolbar">
	        <img class="" style="width: 200px;height: 60px" src="/resources/images/user/0012.jpg" />
	    </div>
	</div>
</div>

<script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/resources/common/plugin/jquery/js.js"></script>

<script type="text/javascript" src="/resources/common/plugin/swiper/idangerous.swiper-1.8.min.js"></script>

<script type="text/javascript" src="/resources/common/plugin/swiper/swiper-demos.js"></script>
</body>
</html>
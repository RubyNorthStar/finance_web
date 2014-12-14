<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>携手金融网 - 产品详情</title>
    <link rel="stylesheet" href="/resources/css/idangerous.swiper.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
	<link rel="stylesheet" href="/resources/css/swiper-demos.css?v=1.8">
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/my-app.css">
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
<div class="views">

    <!--头部导航-->
    <#include "/index/common/top.ftl">
    <div class="view">
        <!--中间内容-->

        <div class="content clearfix " style="">
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
                <div class="" style="border:2px solid #f7f7f7;">
                    <ul class="tab-title clearfix">
                        <li class="list-li-title fL active">
                            <a href="javascript:;">项目介绍</a>
                        </li>
                        <li class="list-li-title fL">
                            <a href="javascript:;">资金用途</a>
                        </li>
                        <li class="list-li-title fL">
                            <a href="javascript:;">还款来源</a>
                        </li>
                        <li class="list-li-title fL">
                            <a href="javascript:;">交易结构</a>
                        </li>
                        <li class="list-li-title fL">
                            <a href="javascript:;">风险措施</a>
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
            
            <#if mortgages??>
	            <div role="main" class="main" >
	            	<div class="swiper-car content-content mt6 box-shadow clearfix" style="width:970px;height: 160px; overflow: hidden; position: relative;">
	        		<!--<a class="leftMove A1" href="javascript:;"><</a>
	        		<a class="rightMove A1" href="javascript:;">></a>-->
	        		<div class="pagination-car"></div>
	        		<div class="swiper-wrapper clearfix move">
	        			<#list mortgages as m>
	        				<img class="swiper-slide content-img" src="/userfiles/mortgageImages/${m.imagUrl}" />
	        			</#list>
				      
				    <!--  <img class="swiper-slide content-img" src="/images/common/003.jpg" /> -->
				    </div>
	            </div>
            </#if>
            
        </div>
    </div>
	<div class="content-content mt6 bg-content" style="width: 100%">
        <div class="details-form" style="">
            <div class="user-name">更多产品信息请致电&nbsp;400-6099-800</div>
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
	<#include "/index/common/foot.ftl">
</div>

<script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/resources/common/plugin/jquery/js.js"></script>

<script type="text/javascript" src="/resources/common/plugin/swiper/idangerous.swiper-1.8.min.js"></script>

<script type="text/javascript" src="/resources/common/plugin/swiper/swiper-demos.js"></script>
</body>
</html>
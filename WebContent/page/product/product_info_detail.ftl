<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>携手金融网 - 产品详情</title>
    <link rel="stylesheet" type="text/css" href="/style/common/index.css">
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
    <div class="view">
        <!--头部导航-->
        <!--  -->
        <#include "/index/common/top.ftl">
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
            <div class="content-content mt6 box-shadow" style="width: 81%">
                <img class="content-img" src="/images/common/002.jpg" />
                <img class="content-img" src="/images/common/003.jpg" />
                <img class="content-img" src="/images/common/004.jpg" />
                <img class="content-img" src="/images/common/005.jpg" />
            </div>
            <div class="content-content mt6 box-shadow" style="width: 81%">
                <div class="details-form" style="">
                    <div class="user-name">更多产品信息请致电&numsp;400-6099-800</div>
                    <div class="user-name" style="font-size: 12px;">更多产品信息请致电&numsp;400-6099-800</div>
                    <div class="form-text">
                        <p>在线填写真实姓名和电话号码</p>
                        <p>在线填写真实姓名和电话号码在线填写真实姓名和电话号码</p>
                    </div>
                    <div class="form-input">
                        <div class="form-input-name">贵宾姓名：<input type="text" style="width: 200px;"></div>
                        <div class="form-input-phone">联系电话：<input type="text" style="width: 200px;"></div>
                        <div class="tj-btn"><button class="tj" style="width: 100px; padding: 5px 10px; color: #fff; border: none; background: #0074c1;">提 交</button></div>
                    </div>
                </div>
            </div>
        </div>
        <!--底部工具栏-->
        <#include "/index/common/foot.ftl">
    </div>
</div>
</body>
</html>
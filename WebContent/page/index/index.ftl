<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<title> 首页</title>
	
</head>
  <body>
  
<div class="views body-bg">
    <!--头部导航-->
    <div class="navbar">
        <div class="navbar-inner clearfix">
            <div class="left">
                <img class="top-logo" style="padding-top:0;" src="/resources/images/user/logo.png" />
            </div>
            <div class="right " style="width: 82%;">
                <div class="menu">
                    关于我们&numsp;|&numsp;我要理财&numsp;|&numsp;我要借款&numsp;|&numsp;新手指南&numsp;|&numsp;联系我们
                </div>
                <div class="button-login">
                    <a href="user/goTOLogin.go" class="button button-color1">登陆</a>
                    <a href="user/goTORegister.go" class="button button-color1">注册</a>
                </div>
            </div>
        </div>
    </div>
    <div class="view" style="background:none;">
        <!--中间内容-->
        <div class="content m-l clearfix " style="display: block">
            <div class="content-block ">
                <img class="content-top-img box-shadow" src="/resources/images/user/001.jpg" />
            </div>
            <div class="content-content mt6 box-shadow" style="width: 970px;">
                <!--正文 width: 81%;  -->
                <img class="content-img" src="/resources/images/user/002.jpg" />
                <img class="content-img" src="/resources/images/user/003.jpg" />
                <img class="content-img" src="/resources/images/user/004.jpg" />
                <img class="content-img" src="/resources/images/user/005.jpg" />
            </div>
            <div class="content-content content-content-bg mt6 clearfix">
                <div class="left">
                    <h3 style="color: #0d6fba;">什么是齐鲁儿女网？</h3>
                    <div>
                        <p class="p2">
                            惠农时贷网是“惠农时贷资产管理有限公司”旗下专业现代化平台，<br>
                            平台联合北大“富民公社”进行农村金融创新，<br>
                            致力于打造一个一发掘农村“乡土信誉”，<br>
                            培养农村“草根行长”为主要途径，<br>
                            综合运用私募投资基金、互助信用合作、第三方金融服务，互联网票p2p融资等<br>
                            现代金融服务手段的农村综合景荣服务平台。<br>
                        </p>
                    </div>

                </div>
                <div class="right pl">
                    <!--<img class="img1" style="" src="images/006.jpg" />-->
                    <div class="data">
                        <div class="data1">3078人 </div>
                        <div class="data2">精明的投资人<br />已加入惠农时代</div>
                    </div>
                    <div class="data">
                        <div class="data1 data1BG">307812321元 </div>
                        <div class="data2 data1Border">精明的投资人<br />已加入惠农时代</div>
                    </div>
                </div>
            </div>
            <div class="content-content content-content-bg mt6 clearfix">
                <!-- <div class="tag clearfix">
                    <img src="/resources/images/user/0014.jpg" />
                    <div class="more">
                        更多产品
                    </div>
                </div>-->
                
                <div class="list clearfix">
                    <div class="table-menu clearfix">
                        <ul class="list-ul ">
                            <#if fundTypes??>
				    			<#list fundTypes as fund>
				    				<#if fund_index == 0>
					    				<li class="aActive"><a href="javascript:;">${fund.fundName}</a></li>
				    				<#else>
				    					<li><a href="javascript:;">${fund.fundName}</a></li>
				    				</#if>
					      		</#list>
					      	</#if>
                        </ul>
                         
                        <ul class="fL" style="margin-top: 15px;">
                            <li class="list-li-yuan button7 button-color-3"><a href="javascript:;">预期收益</a></li>
                            <li class="list-li-yuan button7 button-color-4"> <a href="javascript:;">投资额度</a></li>
                            <li class="list-li-yuan button7 button-color-5"><a href="javascript:;">投资期限</a></li>
                            <li class="list-li-yuan button7 button-color-6"><a href="javascript:;">更多产品</a></li>
                        </ul>
                    </div>
                </div>
                <div class="table-div">
                
	                <#list linkMap?keys as mykey>
	                	<#if mykey_index == 0>
		    				<table class="tab tabActive">
	    				<#else>
	    					<table class="tab">
	    				</#if>
		                <!-- 表格 -->
		                    <tbody class="tbody">
		                        <tr class="table-title"><!-- 表格行 -->
		                            <th>借款标题</th>
		                            <th>信用等级</th>
		                            <th>利率</th>
		                            <th>金额</th>
		                            <th>期限</th>
		                            <th>进度</th>
		                            <th>操作</th>
		                        </tr>
	                        	<#assign values = linkMap[mykey]> 
		                     	<#list values as a> 
						    		<tr>
			                            <td>${a.productName?default("产品名称")} </td>
			                            <td><span class="span2 creditLevle" style="">${a.creditLevle?default("A")}</span></td>
			                            <td><span class="span3" style="" >${a.yearInterestRate?default("0")}%</span><span style="font-size: 10px;">每年</span></td>
			                            <td><span class="span4" style="" >${a.fundScale?default("0")}</span>元</td>
			                            <td><span class="span5" style="" >${a.investmentTimeLimit?default("0")}</span>个月</td>
			                            <td><span class="span6" style=""><#if a.totalMoney == 0>0<#else>${(a.totalMoney/a.fundScale*100)?int+1}</#if>%</span></td>
			                            <td>
			                            	<#if a.toExamineStatus == 1>等待审核</#if>
			                            	<#if a.toExamineStatus == 2>已审核</#if>
			                            	<#if a.toExamineStatus == 3>禁用</#if>
			                            </td>
			                        </tr>
							     </#list>
		                    </tbody>
		                </table>
	              </#list>   
                </div>
                <div class="phone clearfix">
                    <i class="icon icon-phone"></i>
                    <div class="number">010-99998888</div>
                </div>
            </div>
        </div>

    </div>
    <!--底部工具栏-->
        <div class="page clearfix" style="margin-bottom: 40px;">
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

<script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script>
<script type="text/javascript" src="/resources/common/plugin/jquery/js.js"></script>

<script type="text/javascript">
	var array = new Array("A","B","C","D","E","F","G","H","I");//直接定义并初始化
	$('.creditLevle').each(function(){
		$(this).text(array[$(this).text()]);
	});

</script>

  </body>
</html>

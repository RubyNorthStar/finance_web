<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
    <title>携手金融网-首页</title>

</head>
<body>
<div class="views">
    <#include "/index/common/top.ftl">
        
        <div class="view" style="">
            <!--中间内容-->
            <div class="content clearfix " style="display: block">
                <div class="content-block ">
                    <div class="flexslider" style="width:980px;">
                        <ul class="slides flex-viewport">
                            <li>
                                <div class="banner_box ">
                                    <img class="content-top-img" src="/resources/images/user/001.jpg">
                                </div>
                            </li>
                            <li>
                                <div class="banner_box">
                                    <img class="content-top-img" src="/resources/images/user/002.jpg">
                                </div>
                            </li>
                            <li>
                                <div class="banner_box">
                                    <img class="content-top-img" src="/resources/images/user/002.jpg">
                                </div>
                            </li>
                        </ul>
                    </div>

                </div>
                <div class="content-content content-content-bg clearfix">
                    <div class="tag clearfix">
                        <div class="text-lc-title">
                            <span class="span_lc">集市项目</span>
                            <span class="span_en">Project Market</span>
                        </div>
                        <div class="more"> <a href="javascript:;">更多产品&nbsp;&nbsp;></a></div>
                    </div>
                    			<!--market  集市-->
                    <div class="market-list clearfix">
                        <div class="table-menu clearfix">
                            <ul class="list-ul product_index  market-ul clearfix">
                            	<li class="jsActive"><a class="plr-59" href="javascript:;">挂牌项目</a></li>
                            	<li class=""><a class="plr-59" href="javascript:;">融资信息</a></li>
                            	<li class=""><a class="plr-59" href="javascript:;">投资信息</a></li>
                            	<li class=""><a class="plr-59" href="javascript:;">转让信息</a></li>
                            	<li class=""><a class="plr-59" href="javascript:;">公告信息</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="table-div">
                        
                        
                      <!-- 挂牌项目开始 -->
                        <table class="tab tabActive">
							<!-- 表格 -->
							<tbody class="tbody market-tbody">
							<tr class="table-title market-title"><!-- 表格行 -->
								<th>项目名称</th>
								<th>所属行业</th>
								<th>地区</th>
								<th>挂牌日期</th>
							</tr>
									<tr class="market-list">
										<td><a href="javascript:">SW1501273097</a></td>
										<td>陕西兆兴房地产开发有限公司商铺1</td>
										<td>西部产权交易所</td>
										<td>2015-01-28~2015-01-27</td>
									</tr>
									<tr class="market-list">
										<td><a href="javascript:">SW1501273097</a></td>
										<td>陕西兆兴房地产开发有限公司商铺2</td>
										<td>西部产权交易所</td>
										<td>2015-01-28~2015-01-27</td>
									</tr>
									<tr class="market-list">
										<td><a href="javascript:">SW1501273097</a></td>
										<td>陕西兆兴房地产开发有限公司商铺3</td>
										<td>西部产权交易所</td>
										<td>2015-01-28~2015-01-27</td>
									</tr>
									<tr class="market-list">
										<td><a href="javascript:">SW1501273097</a></td>
										<td>陕西兆兴房地产开发有限公司商铺4</td>
										<td>西部产权交易所</td>
										<td>2015-01-28~2015-01-27</td>
									</tr>
									<tr class="market-list">
										<td><a href="javascript:">SW1501273097</a></td>
										<td>陕西兆兴房地产开发有限公司商铺5</td>
										<td>西部产权交易所</td>
										<td>2015-01-28~2015-01-27</td>
									</tr>
							</tbody>
						</table>
                        
                    <!-- 挂牌项目结束 -->
                        
                    <!-- 融资信息开始 -->
						<table class="tab">
							<!-- 表格 -->
							<tbody class="tbody market-tbody">
							<tr class="table-title market-title"><!-- 表格行 -->
								<th>项目名称</th>
								<th>所属行业</th>
								<th>地区</th>
								<th>发布日期</th>
							</tr>
								<#list financeList as a>
									<tr class="market-list">
										<td><a href="javascript:">${a.projectName}</a></td>
										<td>${a.proindustryId?default("")}</td>
										<td>${a.addressProvince?default("")}-${a.addressCity?default("")}</td>
										<td>${a.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									</tr>
								</#list>
							</tbody>
						</table>
					<!-- 融资信息结束 -->
					
					
					<!-- 投资信息开始 -->
						<table class="tab">
							<!-- 表格 -->
							<tbody class="tbody market-tbody">
							<tr class="table-title market-title"><!-- 表格行 -->
								<th>项目名称</th>
								<th>投资行业</th>
								<th>地区</th>
								<th>发布日期</th>
							</tr>
								<#list investmentList as a>
									<tr class="market-list">
										<td><a href="javascript:">${a.investName}</a></td>
										<td>${a.industry?default("")}</td>
										<td>${a.orgAddress?default("")}}</td>
										<td>${a.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									</tr>
								</#list>
							</tbody>
						</table>
					<!-- 投资信息结束 -->
					
					<!-- 转让信息开始 -->
						<table class="tab">
							<!-- 表格 -->
							<tbody class="tbody market-tbody">
							<tr class="table-title market-title"><!-- 表格行 -->
								<th>项目名称</th>
								<th>所属行业</th>
								<th>地区</th>
								<th>发布日期</th>
							</tr>
								<#list transferList as a>
									<tr class="market-list">
										<td><a href="javascript:">${a.projectName}</a></td>
										<td>${a.proindustryId?default("")}</td>
										<td>${a.addressProvince?default("")}-${a.addressCity?default("")}</td>
										<td>${a.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									</tr>
								</#list>
							</tbody>
						</table>
					<!-- 转让信息结束 -->
					
					<!-- 公告信息开始 -->
						<table class="tab">
							<!-- 表格 -->
							<tbody class="tbody market-tbody">
							<tr class="table-title market-title"><!-- 表格行 -->
								<th>公告标题</th>
								<th>所属行业</th>
								<th>地区</th>
								<th>发布日期</th>
							</tr>
								<#list noticeList as a>
									<tr class="market-list">
										<td><a href="javascript:">${a.noticeTitle}</a></td>
										<td>${a.source?default("")}</td>
										<td>${a.addressProvince?default("")}-${a.addressCity?default("")}</td>
										<td>${a.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
									</tr>
								</#list>
							</tbody>
						</table>
					<!-- 公告信息结束 -->
                        
                        
                        
                        
                        
                    </div>
                </div>
                <div class="content-content content-content-bg clearfix">
                    <div class="tag clearfix">
                        <div class="text-lc-title">
                            <span class="span_lc">理财产品</span>
                            <span class="span_en">Wealth Management Products</span>
                        </div>
                        <div class="more"> <a href="/product/productInfo.go">更多产品&nbsp;&nbsp;></a></div>
                    </div>
                    <div class="list clearfix">
                        <div class="table-menu clearfix">
                            <ul class="list-ul product_index product_click">
                                <#if fundTypes??>
                                    <#list fundTypes as fund>
                                        <#if fund_index == 0>
                                            <li class="aActive"><a href="javascript:;">${fund.fundName}</a></li>
                                            <#else>
                                                <li class=""><a href="javascript:;">${fund.fundName}</a></li>
                                        </#if>
                                    </#list>
                                </#if>
                            </ul>
                        </div>
                    </div>

                    <div class="table-product">
                        <#list linkMap?keys as mykey>
                            <#if mykey_index == 0>
                                <table class="tab tabActive">
                                    <#else>
                                 <table class="tab">
                            </#if>
                            <!-- 表格 -->
                            <tbody class="tbody product">
                            <tr class="table-title product-title"><!-- 表格行 -->
                                <th>借款标题</th>
                                <th>利率</th>
                                <th>金额</th>
                                <th>期限</th>
                                <th>进度</th>
                                <th>操作</th>
                            </tr>
                            <#assign values = linkMap[mykey]>
                                <#list values as a>
                                    <tr class="product-list">
                                        <td><a href="/product/productInfo/detail.go?id=${a.id}">${a.productName?default("产品名称")}</a></td>
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
                        <img class="img-phone" src="/resources/images/user/phone.png">
                        <div class="number">010-99998888</div>
                    </div>

                </div>
                <div class="content-content content-content-bg mt6 pb20 clearfix">
                    <div class="tag clearfix">
                        <div class="text-lc-title">
                            <span class="span_lc">携手金融加盟店展示</span>
                        </div>
                    </div>
                    <div class="content-content mt6" style="width: 970px; padding: 0 4px;">
					    <img class="content-img" src="/resources/images/user/002.jpg" />
					    <img class="content-img" src="/resources/images/user/003.jpg" />
					    <img class="content-img" src="/resources/images/user/004.jpg" />
					</div>
                </div>
            </div>
        </div>
        <#include "/index/common/foot.ftl">
</div>

<script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script>
<script type="text/javascript" src="/resources/common/plugin/jquery/js.js"></script>
<script type="text/javascript" src="/resources/common/plugin/jquery/jquery.flexslider.js"></script>

<script type="text/javascript">
    var array = new Array("A","B","C","D","E","F","G","H","I");//直接定义并初始化
    $('.creditLevle').each(function(){
        $(this).text(array[$(this).text()]);
    });


    $(window).load(function(){
        var LiLength = $("li").length;
        var AllLiWidth = $("li").width();
//        alert(AllLiWidth*LiLength+"px")
        $(".moveUl").width(AllLiWidth*LiLength+"px")

        $('.flexslider').flexslider({
            animation: "slide",
            directionNav:false
        });
    });

    $(".er_wei_ma").hide();
    $('.corn_wei').click(function(){
        $(".er_wei_ma").toggle()
    })
    $('.er_wei_ma').click(function(){
        $(this).hide();
    })


    $('.xin').click(function(){
        $(".er_wei_ma").toggle()
    })
    $('.er_wei_ma').click(function(){
        $(this).hide();
    });



</script>

</body>
</html>

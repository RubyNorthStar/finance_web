<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
    <title>携手金融网-首页</title>

</head>
<body>
<div class="views body-bg">
    <#include "/index/common/top.ftl">
        <div class="menu clearfix">
            <ul class="menu_list_ul">
                <li>
                    <a href="javascript:;">关于我们</a>
                </li>
                <li>
                    <a href="javascript:;">我要理财</a>
                </li>
                <li>
                    <a href="javascript:;">我要借款</a>
                </li>
                <li>
                    <a href="javascript:;">新手指南</a>
                </li>
                <li>
                    <a href="javascript:;">联系我们</a>
                </li>
                <li>
                    <a href="/article/articleInfo/list_new.go?aptId=9">新闻动态</a>
                </li>
            </ul>
        </div>
        <div class="view" style="background:none;">
            <!--中间内容-->
            <div class="content m-l clearfix " style="display: block">
                <div class="content-block ">
                    <div class="flexslider" style="width:970px;">
                        <ul class="slides flex-viewport">
                            <li>
                                <div class="banner_box ">
                                    <img class="content-top-img box-shadow" src="/resources/images/user/001.jpg">
                                </div>
                            </li>
                            <li>
                                <div class="banner_box">
                                    <img class="content-top-img box-shadow" src="/resources/images/user/002.jpg">
                                </div>
                            </li>
                            <li>
                                <div class="banner_box">
                                    <img class="content-top-img box-shadow" src="/resources/images/user/002.jpg">
                                </div>
                            </li>
                        </ul>
                    </div>

                </div>
                <div class="content-content content-content-bg mt6 clearfix">
                    <div class="tag clearfix">
                        <div class="text-lc-title">
                            <span class="span_lc">集市项目</span>
                            <span class="span_en">Project Market</span>
                        </div>
                        <div class="more"> 更多产品&nbsp;&nbsp;></div>
                    </div>
                    <div class="list clearfix">
                        <div class="table-menu clearfix">
                            <ul class="list-ul product_index row">
                            	<li class="  col-20"><a class="plr-59" href="javascript:;">挂牌项目</a></li>
                            	<li class="jsActive col-20"><a class="plr-59" href="javascript:;">融资信息</a></li>
                            	<li class="col-20"><a class="plr-59" href="javascript:;">投资信息</a></li>
                            	<li class="col-20"><a class="plr-59" href="javascript:;">转让信息</a></li>
                            	<li class="col-20"><a class="plr-59" href="javascript:;">公告信息</a></li>
                                <!--<#if fundTypes??>
                                    <#list fundTypes as fund>
                                        <#if fund_index == 0>
                                            <li class="aActive"><a href="javascript:;">${fund.fundName}</a></li>
                                            <#else>
                                                <li><a href="javascript:;">${fund.fundName}</a></li>
                                        </#if>
                                    </#list>
                                </#if>-->
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
                                        <td><a href="/product/productInfo/detail.go?id=${a.id}">${a.productName?default("产品名称")}</a></td>
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
                </div>
                <div class="content-content content-content-bg mt6 clearfix">
                    <div class="tag clearfix">
                        <div class="text-lc-title">
                            <span class="span_lc">理财产品</span>
                            <span class="span_en">Wealth Management Products</span>
                        </div>
                        <div class="more"> 更多产品&nbsp;&nbsp;></div>
                    </div>
                    <div class="list clearfix">
                        <div class="table-menu clearfix">
                            <ul class="list-ul product_index">
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
                                        <td><a href="/product/productInfo/detail.go?id=${a.id}">${a.productName?default("产品名称")}</a></td>
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
					    <img class="content-img" src="/resources/images/user/005.jpg" />
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

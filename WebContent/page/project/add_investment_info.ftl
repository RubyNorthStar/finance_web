<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 添加投资发布</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/my-app.css">
    <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
	<style>
		.spanRed{color:red; padding:0 3px;}
	</style>
</head>
<body>

<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view-main">
        <!-- Top Navbar-->
        <#include "/index/common/top.ftl">
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" style="margin:0; ">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="margin:0; padding:0;">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <!-- 左侧部分 -->
                    <#include "/index/common/center_left.ftl">
                    <div class="right-content">
                    <!-- 中间部分开始 -->
                    	
                    	
                    	<div>
                    		<form method="post" action="/center/investment/addInvestment.go">
		                    <h3 class="user">投资意向管理 > 发布投资意向</h3>
		                    <ul class="wrap-ul">
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资意向名称</div>
		                            <div class="right-form">
		                                <input class="input-text" name="investName" type="text" placeholder="">
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>是否发送邮件短信</div>
		                            <div class="right-form">
		                                <input class="input-radio" type="radio" name="isMall"  value="是">是
		                                <input class="input-radio" type="radio" name="isMall"  value="否">否
		                                <span>【备注：默认审核时发送邮件短信，若选择'否',审核时将取消发送邮件短信】</span>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资机构名称</div>
		                            <div class="right-form">
		                                <input class="input-text" type="text" name="agencyName" placeholder="">
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资机构所在地址</div>
		                            <div class="right-form">
		                                <input class="input-text" type="text" name="orgAddress" placeholder="">
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资类型</div>
		                            <div class="right-form">
		                                <input class="input-radio" type="checkbox" name="investType"  value="股权投资[并购]">股权投资[并购]
		                                <input class="input-radio" type="checkbox" name="investType"  value="借贷式债权投资">借贷式债权投资
		                                <input class="input-radio" type="checkbox" name="investType"  value="资产购置">资产购置
		                                <input class="input-radio" type="checkbox" name="investType"  value="承包经营[租赁]项">承包经营[租赁]项
		                                <input class="input-radio" type="checkbox" name="investType"  value="项目合作">项目合作
		                                <input class="input-radio" type="checkbox" name="investType"  value="其他">其他
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资形式</div>
		                            <div class="right-form">
		                                <input class="input-radio" type="checkbox" name="investStyle"  value="风险投资">风险投资
		                                <input class="input-radio" type="checkbox" name="investStyle"  value="天使投资">天使投资
		                                <input class="input-radio" type="checkbox" name="investStyle"  value="实业投资">实业投资
		                                <input class="input-radio" type="checkbox" name="investStyle"  value="PE投资">PE投资
		                                <input class="input-radio" type="checkbox" name="investStyle"  value="其他">其他
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资方式</div>
		                            <div class="right-form">
		                                <input class="input-radio" type="checkbox" name="investMode"  value=" 现金投资"> 现金投资
		                                <input class="input-radio" type="checkbox" name="investMode"  value="管理/技术投资">管理/技术投资
		                                <input class="input-radio" type="checkbox" name="investMode"  value="有形资产/无形资产投资">有形资产/无形资产投资
		                                <input class="input-radio" type="checkbox" name="investMode"  value="其他">其他
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">投资行业</div>
		                            <div class="right-form">
		                                <button>选择</button>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">投资行业</div>
		                            <div class="right-form">
		                                <button>选择</button>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资企业类型</div>
		                            <div class="right-form w550">
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="全民所有制">全民所有制
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="全民与全民联营">全民与全民联营
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="全民与集体联营">全民与集体联营
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="股份有限公司">股份有限公司
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="股份合作制">股份合作制
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="外资独资">外资独资
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="中外合资">中外合资
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="中外合作经营">中外合作经营
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="有限责任公司">有限责任公司
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="集体所有制">集体所有制
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="事业法人">事业法人
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="其他">其他
		                                <input class="input-radio" type="checkbox" name="enterpriseType"  value="不限">不限
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">投资规模</div>
		                            <div class="right-form">
		                                <select>
		                                    <option>请选择</option>
		                                </select>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">投资回报率要求</div>
		                            <div class="right-form">
		                                	年回报率<input type="text" name="getRequire" />%以上
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">关键</div>
		                            <div class="right-form">
		                               	 年回报率<input type="text" />%以上
		                                <span class="spanRed">(输入关键字可以使您发布的信息更容易被检索到。多个关键字请用","号隔开。)</span>
		                            </div>
		                        </li>
		
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>有效起始日期</div>
		                            <div class="right-form">
		                                <input class="input-text" name="beginTime" type="date" placeholder="">
		                            </div>
		                            <div class="left-title"><span class="spanRed">*</span>有效截止日期</div>
		                            <div class="right-form">
		                                <input class="input-text" name="endTime" type="date" placeholder="">
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">
		                                <span class="spanRed">*</span>投资机构介绍
		                                <span class="spanRed">*</span>(介绍：投资团队，投资理念，优势资源，投资机构动态，成功投资案例，网站网址等)
		                                <span class="spanRed">(至少50字)</span>
		                            </div>
		                            <div class="right-form">
		                                <textarea class="input-text" name="investOrgInfo" type="data" placeholder=""></textarea>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">
		                                <span class="spanRed">*</span>对接受项目要求
		                                <span class="spanRed"> (限1000字)</span>
		                            </div>
		                            <div class="right-form">
		                                <div>
		                                    <p>
		                                        <input class="input-radio" type="checkbox"> 提供项目概述
		                                        <input class="input-radio" type="checkbox"> 提供项目详细资料及投资价值分析报告
		                                        <input class="input-radio" type="checkbox"> 提供经过第三方评估或审计过的详细资料
		                                    </p>
		                                    <textarea class="input-text" name="investRequire" placeholder=""></textarea>
		                                </div>
		                                <div>
		                                    <p>
		                                        <input class="input-radio" type="checkbox">其他要求
		                                        <sapn class="spanRed">(限1000字)</sapn>
		                                    </p>
		                                    <textarea class="input-text" name="otherRequire" placeholder=""></textarea>
		                                </div>
		                            </div>
		                        </li>
		
		                        <li class="submitBtn">
		                            <button class="button-style button-style-blue">提交审核</button>
		                        </li>
		                    </ul>
		                </div>
                    	
                    	
                    	</form>
            
           			<!-- 中间部分结束 -->
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
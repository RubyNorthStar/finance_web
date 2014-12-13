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
<#include "/index/common/top.ftl">
    <div class="view-main">
        <div class="pages" style="margin:0; ">
            <div class="page" style="margin:0; padding:0;">
                <div class="page-content clearfix">
                    <!-- 左侧部分 -->
                    <#include "/index/common/center_left.ftl">
                    <div class="right-content">
                    <!-- 中间部分开始 -->
                    	<div>
                    		<form method="post" action="/center/investment/addInvestment.go" onsubmit="return toVaild()">
		                    <h3 class="user">投资意向管理 > 发布投资意向</h3>
		                    <ul class="wrap-ul">
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资意向名称</div>
		                            <div class="right-form">
		                                <input class="input-text" name="investName" id="investName" type="text" placeholder="">
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>是否发送邮件短信</div>
		                            <div class="right-form">
		                                <input class="input-radio" type="radio" name="isMall"  value="1">是
		                                <input class="input-radio" type="radio" name="isMall" checked="checked" value="2">否
		                                <span>【备注：默认审核时发送邮件短信，若选择'否',审核时将取消发送邮件短信】</span>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资机构名称</div>
		                            <div class="right-form">
		                                <input class="input-text" type="text" name="agencyName" id="agencyName" placeholder="">
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资机构所在地址</div>
		                            <div class="right-form">
		                                <input class="input-text" type="text" name="orgAddress" id="orgAddress" placeholder="">
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
		                                <div class="tz-button tzhy ">选择</div>
		                                <div class="tzhy-inputText"></div>
		                                <input name="industry" id="industryId" type="hidden" value=""/>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">投资地区</div>
		                            <div class="right-form">
		                                <div class="tz-button tzdq">选择</div>
		                                <div class="tzdq-inputText"></div>
		                                <input name="area" id="areaId" type="hidden" value=""/>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>投资企业类型</div>
		                            <div class="right-form w550">
		                            	<div style="width:512px;">
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
		                                
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">投资规模</div>
		                            <div class="right-form">
		                                <select name="investScale" id="investScale">
		                                    <option value="小型">小型</option>
		                                    <option value="中型">中型</option>
		                                    <option value="大型">大型</option>
		                                    <option value="不限">不限</option>
		                                </select>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="left-title">投资回报率要求</div>
		                            <div class="right-form">
		                                	年回报率&nbsp&nbsp<input style="width:25px;" type="text" id="getRequire" name="getRequire" />&nbsp&nbsp%以上
		                            </div>
		                        </li>
		
		                        <li class="wrap-li clear">
		                            <div class="left-title"><span class="spanRed">*</span>有效起始日期</div>
		                            <div class="right-form">
		                                <input class="input-date" name="beginTime" id="beginTime" type="date" placeholder="">
		                            </div>
		                            <div class="left-title"><span class="spanRed" >*</span>有效截止日期</div>
		                            <div class="right-form">
		                                <input class="input-date" name="endTime" id="endTime" type="date" placeholder="">
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="right-form">
		                            	<span class="spanRed">*</span>投资机构介绍
		                                <span class="spanRed">*</span>(介绍:投资团队,投资理念,优势资源,投资机构动态,成功投资案例,网站网址等)
		                                <span class="spanRed">(至少50字)</span>
		                                <textarea class="input-textarea" name="investOrgInfo" id="investOrgInfo" type="data" placeholder=""></textarea>
		                            </div>
		                        </li>
		                        <li class="wrap-li clear">
		                            <div class="right-form">
		                            	<span class="spanRed">*</span>对接受项目要求
		                                <span class="spanRed"> (限1000字)</span>
		                                <div>
		                                    <p>
		                                        <input class="input-radio" type="checkbox"> 提供项目概述
		                                        <input class="input-radio" type="checkbox"> 提供项目详细资料及投资价值分析报告
		                                        <input class="input-radio" type="checkbox"> 提供经过第三方评估或审计过的详细资料
		                                    </p>
		                                    <textarea class="input-textarea" name="investRequire" id="investRequire" placeholder=""></textarea>
		                                </div>
		                                <div>
		                                    <p>
		                                        <input class="input-radio" type="checkbox">其他要求
		                                        <sapn class="spanRed">(限1000字)</sapn>
		                                    </p>
		                                    <textarea class="input-textarea" id="otherRequire" name="otherRequire" placeholder=""></textarea>
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
    <div class="alert-text-tzhy">
		<div class="mask"></div>
		<div class="alert-input">
			<div class="alert-input-title">
				<span class="span-title">请选择行业</span>
				<span class="tzhy-span-qd">确定</span>
			</div>
			<div class="hy">
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="酒店餐饮"> 酒店餐饮</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="房地产业"> 房地产业</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="农林牧渔"> 农林牧渔</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="批发零售贸易"> 批发零售贸易</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="材料与加工"> 材料与加工</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="信息技术服务"> 信息技术服务</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="科研设计及技术服务"> 科研设计及技术服务</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="电子通讯"> 电子通讯</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="新能源"> 新能源</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="电力工业">电力工业</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="煤炭工业"> 煤炭工业</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="冶金矿产"> 冶金矿产</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="石油石化工"> 石油石化工</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="金融保险投资"> 金融保险投资</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="机械制造"> 机械制造</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="基础设施"> 基础设施</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="建筑建材"> 建筑建材</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="物流仓储"> 物流仓储</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="纺织服装皮毛"> 纺织服装皮毛</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="社会服务"> 社会服务</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="交通运输"> 交通运输</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="教育文化广播"> 教育文化广播</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="食品饮料"> 食品饮料</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="医疗保健"> 医疗保健</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="生物科技"> 生物科技</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="旅游休闲"> 旅游休闲</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="影视娱乐"> 影视娱乐</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="汽车汽配"> 汽车汽配</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="印刷出版"> 印刷出版</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="环境保护"> 环境保护</span>
				<br />
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="广告传媒"> 广告传媒</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="其他行业"> 其他行业</span>
				<span class="hy-span"><input type="checkbox" name="industry" class="hy-checkbox" value="不限"> 不限</span>
			</div>
		</div>
	</div>
	
	<div class="alert-text-tzdq">
		<div class="mask"></div>
		<div class="alert-input">
			<div class="alert-input-title">
				<span class="span-title">请选择地区</span>
				<span class="tzdq-span-qd">确定</span>
			</div>
			<div class="hy">
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="不限"> 不限</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="境外"> 境外</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="北京"> 北京</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="天津">天津</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="上海"> 上海</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="河北"> 河北</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="山西"> 山西</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="内蒙"> 内蒙</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="辽宁"> 辽宁</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="吉林">吉林</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="江苏"> 江苏</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="浙江"> 浙江</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="安徽"> 安徽</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="福建">福建</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="江西"> 江西</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="河南"> 河南</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="湖南"> 湖南</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="湖北"> 湖北</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="广东"> 广东</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="广西"> 广西</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="海南"> 海南</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="重庆"> 重庆</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="四川"> 四川</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="贵州"> 贵州</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="云南"> 云南</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="陕西"> 陕西</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="西藏"> 西藏</span>
				<br/>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="甘肃"> 甘肃</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="青海"> 青海</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="宁夏"> 宁夏</span>
				<br />
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="新疆">新疆</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="黑龙江"> 黑龙江</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="台湾省"> 台湾省</span>
				<br />
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="香港"> 香港</span>
				<span class="hy-span"><input type="checkbox" name="area" class="du-checkbox" value="澳门"> 澳门</span>
			</div>
		</div>
	</div>
    <#include "/index/common/foot.ftl">
</div>



<!-- Path to Framework7 Library JS-->
<!--<script type="text/javascript" src="js/framework7.js"></script>-->
<!-- Path to your app js-->
<!--<script type="text/javascript" src="js/my-app.js"></script>-->
<script type="text/javascript">
	$(function(){
		$(".tzhy").click(function(){
			$(".alert-text-tzhy").css("display","block")
		})
		$(".tzhy-span-qd").click(function(){
		 	var inputText = $(".tzhy-inputText");
		 	var str = "";
			 $("input[name='industry']:checked").each(function () {
                str += this.value + ",";
            })
            var strSub = str.substring(0,str.length-1);
            $('#industryId').val(strSub);
            inputText.text(strSub);
            $(".alert-text-tzhy").css("display","none")
		})
		
		$(".tzdq").click(function(){
			$(".alert-text-tzdq").css("display","block")
		})
		$(".tzdq-span-qd").click(function(){
			var inputText = $(".tzdq-inputText");
		 	var str = "";
			 $("input[name='area']:checked").each(function () {
                str += this.value + ",";
            })
            var strSub = str.substring(0,str.length-1);
            $('#areaId').val(strSub);
            inputText.text(strSub);
            $(".alert-text-tzdq").css("display","none")
		})
	})
	
	function toVaild(){
	
		var investName = $("#investName").val();
		if(!investName){
			alert("投资意向名称不能为空");
			return false;
		}
		if(investName && investName.length > 64){
			alert("投资意向名称不能超过64位");
			return false;
		}
		
		var agencyName = $("#agencyName").val();
		if(!agencyName){
			alert("投资机构名称不能为空");
			return false;
		}
		if(agencyName && agencyName.length > 64){
			alert("投资机构名称不能超过64位");
			return false;
		}
		
		var orgAddress = $("#orgAddress").val();
		if(!orgAddress){
			alert("投资机构所在地址不能为空");
			return false;
		}
		if(orgAddress && orgAddress.length > 64){
			alert("投资机构所在地址不能超过64位");
			return false;
		}
		
		var str="";
		$("input[name='investType']:checked").each(function () {
            str += this.value + ",";
        })
        
        if(str.length < 1){
        	alert("投资类型不能为空");
			return false;
        }
        
        var str1="";
		$("input[name='investStyle']:checked").each(function () {
            str1 += this.value + ",";
        })
        
        if(str1.length < 1){
        	alert("投资形式不能为空");
			return false;
        }
        
        var str2="";
		$("input[name='investMode']:checked").each(function () {
            str2 += this.value + ",";
        })
        
        if(str2.length < 1){
        	alert("投资方式不能为空");
			return false;
        }
        
        var str3="";
		$("input[name='enterpriseType']:checked").each(function () {
            str3 += this.value + ",";
        })
        
        if(str3.length < 1){
        	alert("投资企业类型不能为空");
			return false;
        }
        
        var getRequire = $("#getRequire").val();
		if(!getRequire){
			alert("投资回报率要求不能为空");
			return false;
		}
		if(getRequire && getRequire.length > 2){
			alert("投资回报率要求不能超过2位");
			return false;
		}
		
		var beginTime = $("#beginTime").val();
		var endTime = $("#endTime").val();
		if(!beginTime){
			alert("开始时间不能为空");
			return false;
		}
		if(!endTime){
			alert("结束时间不能为空");
			return false;
		}
		
		if(endTime < beginTime){
			alert("开始时间必须小于结束时间");
			return false;
		}
        
        var investOrgInfo = $("#investOrgInfo").val();
		if(!investOrgInfo){
			alert("投资机构介绍不能为空");
			return false;
		}
		if(investOrgInfo && investOrgInfo.length < 50){
			alert("投资机构介绍至少50字");
			return false;
		}
		
		var investOrgInfo = $("#investOrgInfo").val();
		if(!investOrgInfo){
			alert("投资机构介绍不能为空");
			return false;
		}
		if(investOrgInfo && investOrgInfo.length > 1000){
			alert("投资机构介绍不能超过1000字");
			return false;
		}
		
        var otherRequire = $("#otherRequire").val();
		if(otherRequire.length > 1000){
			alert("其它要求不能超过1000字");
			return false;
		}
		return true;
	}
</script>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 添加公告</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/my-app.css">
    <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/script/project/area.js"></script>
</head>
<body>

<!-- Views-->
<div class="views">
	<#include "/index/common/top.ftl">
    <!-- Your main view, should have "view-main" class-->
    <div class="view-main">
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through" style="margin:0;">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page" style="margin:0;padding:0;">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <!-- 左侧部分 -->
                    <#include "/index/common/center_left.ftl">
                    <div class="right-content">
                    <!-- 中间部分开始 -->
                    <form method="post" action="/center/publicNotice/publicNotice.go" id="addPorjectInfo">
                    	<div class="form">
                            <h3 class="user">我的公告信息 > 公告信息录入</h3>
                            <ul class="wrap-ul">
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>公告标题</div>
                                    <div class="right-form">
                                        <input class="input-text" name="noticeTitle" type="text" placeholder=""><span class="span2">&numsp;&numsp;(最多100个汉字)</span>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">公告副标题</div>
                                    <div class="right-form">
                                        <input class="input-text" name="noticeViceTitle" type="text" placeholder=""><span class="span2">&numsp;&numsp;(最多100个汉字)</span>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">公告描述</div>
                                    <div class="right-form">
                                        <textarea class="input-text" name="noticeDescription" placeholder=""></textarea><span class="span2">&numsp;&numsp;(最多200个汉字)</span>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>公告来源</div>
                                    <div class="right-form">
                                        <input class="input-text" type="text" name="source">
                                        <span class="span2">&numsp;&numsp;(最多100个汉字)</span>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>所属品类</div>
                                    <div class="right-form">
                                        <select name="category" id="category" class="input-text">
									        <option value="">请选择</option>
									      	<option value="股权">股权</option>
									      	<option value="债权">债权</option>
									      	<option value="实物资产">实物资产</option>
									      	<option value="房产土地">房产土地</option>
									      	<option value="工美藏品">工美藏品</option>
									      	<option value="知识产权">知识产权</option>
									      	<option value="矿权">矿权</option>
									      	<option value="林权">林权</option>
									      	<option value="经营权">经营权</option>
									      	<option value="其他">其他</option>
									     </select>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>公告分类</div>
                                    <div class="right-form">
                                        <select name="classiFication" id="classiFication" class="input-text">
									        <option value="">请选择</option>
									      	<option value="拍卖">拍卖</option>
									      	<option value="招商">招商</option>
									      	<option value="其他">其他</option>
									     </select>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>所属行业</div>
                                    <div class="right-form">
                                        <#if industryList??>
						    				<select name="industryId" class="input-text" type="text"> 
						    					<option >请选择</option>
								    			<#list industryList as industry>
								    				<option value="${industry.id}">${industry.industryName}</option>	
								    			</#list>
						    				</select> 
									    </#if>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>标的所在地</div>
                                    <div class="right-form">
                                        <select id="c_area" name="addressProvince" data-selector="city" class="input-text">
                                            <option>选择城市</option>
                                        </select>
                                        <select id="c_city" name="addressCity" data-selector="area" class="input-text" >
                                            <option>选择地区</option>
                                        </select>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>底价</div>
                                    <div class="right-form">
                                        <select class="" type="text" placeholder="">
                                            <option>人民币</option>
                                        </select>
                                        <input class="rmb-input" name="floorPrice" type="text" placeholder="0.0" />
                                        <select class="" type="text" placeholder="">
                                            <option>万元</option>
                                        </select>
                                        <span class="span2">(为了更有效的促进交易，请注明价格，0为面议。)</span>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>有效起始日期</div>
                                    <div class="right-form">
                                        <input type="date" name="beginTime" />
                                    </div>
                                    <div class="left-title"><span class="span2">*</span>有效截止日期</div>
                                    <div class="right-form">
                                        <input type="date" name="endTime" />
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>审核时是否发送邮件</div>
                                    <div class="right-form">
                                        <input class="input-radio" type="radio" name="isMall"  value="1">是
                                        <input class="input-radio" type="radio" name="isMall"  value="2">否
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <p><span class="span2">*</span>公告内容<span class="span2">【至少100字】</span></p>
                                    <div class="right-form">
                                        <textarea class="textarea-img" name="content"></textarea>
                                    </div>
                                </li>
                                 <li class="wrap-li clear">
                                     <div class="user-info">
                                         	用户信息
                                     </div>
                                 </li>
                                <li class="submitBtn">
                                    <button class="button-style button-style-blue">提交待审</button>
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
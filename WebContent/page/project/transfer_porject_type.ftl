<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 修改密码</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/my-app.css">
    <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
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
                    	<div>
                            <h3 class="user">项目管理 > 项目管理 > 请选择项目种类</h3>
                            <form id="kindform" action="/center/projectInfo/transferPorject.go?type=1" method="post">
	                            <ul class="wrap-ul">
	                                <li class="wrap-li clear">
	                                    <div class="left-form">股权</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,1">股权
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">债权</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,2">债权
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">实物资产</div>
	                                    <div class="right-form w550">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,3">设备
	                                        <input class="input-radio" type="radio" name="protype"  value="1,4">车辆
	                                        <input class="input-radio" type="radio" name="protype"  value="1,5">船舶
	                                        <input class="input-radio" type="radio" name="protype"  value="1,6">化工设备
	                                        <input class="input-radio" type="radio" name="protype"  value="1,7">纺织设备
	                                        <input class="input-radio" type="radio" name="protype"  value="1,8">工程机械
	                                        <input class="input-radio" type="radio" name="protype"  value="1,9">机床设备
	                                        <input class="input-radio" type="radio" name="protype"  value="1,10">冶金设备</br>
	                                        <input class="input-radio" type="radio" name="protype"  value="1,11">锅炉设备
	                                        <input class="input-radio" type="radio" name="protype"  value="1,12">医药设备
	                                        <input class="input-radio" type="radio" name="protype"  value="1,13">食品机械
	                                        <input class="input-radio" type="radio" name="protype"  value="1,14">交通运输
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">房产土地</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,15">住宅（楼）
	                                        <input class="input-radio" type="radio" name="protype"  value="1,16">土地
	                                        <input class="input-radio" type="radio" name="protype"  value="1,17">办公楼
	                                        <input class="input-radio" type="radio" name="protype"  value="1,18">酒店
	                                        <input class="input-radio" type="radio" name="protype"  value="1,19">工厂
	                                        <input class="input-radio" type="radio" name="protype"  value="1,20">厂房
	                                        <input class="input-radio" type="radio" name="protype"  value="1,21">库房
	                                        <input class="input-radio" type="radio" name="protype"  value="1,22">店铺
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">工美藏品</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,23">工美藏品
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">知识产权</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,24">技术
	                                        <input class="input-radio" type="radio" name="protype"  value="1,25">商标
	                                        <input class="input-radio" type="radio" name="protype"  value="1,26">版权
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">矿权</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,27">矿权
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">林权</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,28">林权
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">经营权</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="1,29">经营权
	                                    </div>
	                                </li>
	                                <li class="submitBtn">
	                                    <input type="submit" class="button-style button-style-blue" value="下一步">
	                                </li>
	                            </ul>
	                         </form>
                        </div>
                    </div>
                </div>
            </div>
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
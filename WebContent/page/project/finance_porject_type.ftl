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
                            <h3 class="user">项目管理 > 录入融资项目</h3>
                            <form id="kindform" action="/center/projectInfo/transferPorject.go?type=2" method="post">
	                            <ul class="wrap-ul">
	                                <li>
	                                    <h3 class="user">请选择融资种类</h3>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">股权</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="2,1">股权融资
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">项目</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="2,2">项目融资
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">债权</div>
	                                    <div class="right-form w550">
	                                        <input class="input-radio" type="radio" name="protype"  value="2,3">债权融资
	                                    </div>
	                                </li>
	                                <li class="wrap-li clear">
	                                    <div class="left-form">租赁</div>
	                                    <div class="right-form">
	                                        <input class="input-radio" type="radio" name="protype"  value="2,4">租赁融资
	                                    </div>
	                                </li>
	                                <li class="submitBtn">
	                                    <button type="submit" class="button-style button-style-blue">下一步</button>
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
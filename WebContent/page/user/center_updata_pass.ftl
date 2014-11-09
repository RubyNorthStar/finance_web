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
    <script>
    	function updataUserPass(){
    		var oldPass = $("#oldPass").val();
    		var newPass = $("#newPass").val();
    		var newSurePass = $("#newSurePass").val();
    		if(newPass != newSurePass){
    			alert("新密码输入不一致，请重新输入");
    			return false;
    		}
    		if(newPass.length < 6){
    			alert("输入的密码必须大于6位数");
    			return false;
    		}
    		$.ajax({
				url : "/center/user/updataUserPass.go",
				type : "post",
				data:{"oldPass":$.trim($("#oldPass").val()),"newPass":$.trim($("#newPass").val()),"newSurePass":$.trim($("#newSurePass").val())},
				dataType : "json",
				cache : false,
				success :function(data){
					if(parseInt(data)==1){
						alert("老密码输入错误");
						return false;
					}else if(parseInt(data)==2){
						alert("修改成功");
						return false;
					}else if(parseInt(data)==3){
						alert("请检查您所输入的老密码或新密码");
						return false;
					}
				}
			});
    	}
    </script>
</head>
<body>

<!-- Views-->
<div class="views">
	<#include "/index/common/top.ftl">
    <!-- Your main view, should have "view-main" class-->
    <div class="view-main">
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
                            <h3 class="user">我的基本信息 > 修改密码</h3>
                            <ul class="wrap-ul">
                                <li class="wrap-li clear">
                                    <div class="left-title">登录邮箱</div>
                                    <div class="right-form">
                                        <div class="right-title clear">${user.email}</div>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">原密码<span class="span2">*</span></div>
                                    <div class="right-form">
                                        <input class="input-text" id="oldPass" type="password" >
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">新密码<span class="span2">*</span></div>
                                    <div class="right-form">
                                        <input class="input-text" id="newPass" type="password" >
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">重复新密码<span class="span2">*</span></div>
                                    <div class="right-form">
                                        <input class="input-text" id="newSurePass" type="password">
                                    </div>
                                </li>
                                <li class="code">
                                    <button onclick="updataUserPass()" class="button-style button-style-blue">修改密码</button>
                                </li>
                            </ul>
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
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
    	function updataMobile(){
    		var mobile = $("#mobile").val();
    		$.ajax({
				url : "/center/user/changeUserInfo.go",
				type : "post",
				data:{"mobile":$.trim($("#mobile").val())},
				dataType : "json",
				cache : false,
				success :function(data){
					if(parseInt(data)==1){
						alert("修改成功");
					}else{
						alert("修改失败,请重新修改！");
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
    <div class=" view-main">
        <div class="pages" style="margin:0; ">
            <div class="page">
                <!-- Scrollable page content-->
                <div class="page-content clearfix">
                    <!-- 左侧部分 -->
                    <#include "/index/common/center_left.ftl">
                    <div class="right-content">
                        <div>
                            <h3 class="user">用户基本信息</h3>
                            <ul class="wrap-ul">
                                <li class="wrap-li clear">
                                    <div class="left-title">登录账号</div>
                                    <div class="right-form">
                                        <div class="right-title clear">${user.username}</div>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">账号编码</div>
                                    <div class="right-form">
                                        ${user.id}
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">邮箱<span style="color:red; padding-left:3px;">*</span></div>
                                    <div class="right-form">
                                    	${user.email}
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">手机号<span style="color:red; padding-left:3px;">*</span></div>
                                    <div class="right-form">
                                        <input class="input-text" type="text" id="mobile" value="${user.mobile}">
                                    </div>
                                </li>
                                <li class="code">
                                <!--4cd064-->
                                    <button class="button-style button-style-blue" onclick="updataMobile()">提交</button>
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
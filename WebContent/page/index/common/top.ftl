<!--头部导航-->
<div class="navbar">
    <div class="navbar-inner clearfix">
        <div class="left">
            <img class="top-logo" style="padding-top:0;" src="/resources/images/user/logo.png" />
        </div>
        <div class="right " style="width: 82%;">
            <div class="menu">
		                关于我们&numsp;|&numsp;
		                我要理财&numsp;|&numsp;
		                我要借款&numsp;|&numsp;
		                新手指南&numsp;|&numsp;
		                联系我们&numsp;|&numsp;
		      <a href="/article/articleInfo/list_new.go?aptId=9">新闻动态</a>
            </div>
            <div class="button-login">
            		<#if user??>
            			您好，<a href="/center/user/center.go"> ${user.username}</a>
            			<a href="/user/loginOut.go" class="button button-color1">退出</a>
            		<#else>
		                <a href="/user/goTOLogin.go" class="button button-color1">登陆</a>
		                <a href="/user/goTORegister.go" class="button button-color1">注册</a>
	                </#if>
            </div>
        </div>
    </div>
</div>
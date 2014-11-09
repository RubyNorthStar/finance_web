<!--头部导航-->
<div class="navbar">
    <div class="navbar-inner clearfix">
        <div class="left">
            <img class="top-logo" src="/resources/images/user/logo.png?math=0.232323" />
        </div>
        <div class="right" style="width: 66%;">
            <div class="button-login clearfix">
        		<#if user??>
        			您好，<a href="/center/user/center.go"> ${user.username}</a>
        			<a href="/user/loginOut.go" class="button button-color1">退出</a>
        		<#else>
            		<div class="login-box">
            			<a href="/user/goTOLogin.go" class="button ">登陆</a>
		                <a href="/user/goTORegister.go" class="button button-color1">注册</a>
		            </div>
                </#if>
            </div>
        </div>
    </div>
</div>
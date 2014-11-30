<!--头部导航-->
<div class="navbar">
    <div class="navbar-inner clearfix">
        <div class="left">
            <img class="top-logo" src="/resources/images/user/logo.png?math=0.232323" />
        </div>
        <div class="right" style=""><!--width: 62%; margin:15px 0 0 46%;-->
            <div class="button-login clearfix">
        		<#if user??>
        			您好，<a href="/center/user/center.go"> ${user.username}</a>
        			<a href="/user/loginOut.go" class="button button-color1">退出</a>
        		<#else>
            		<div class="login-box clearfix">
		    			<a href="/user/goTOLogin.go" class="button_fill">登陆</a>
		                <a href="/user/goTORegister.go" class="">注册</a>
		            </div>
                </#if>
            </div>
        </div>
    </div>
</div>
<div class="menu clearfix">
    <ul class="menu_list_ul">
    	<li class="menu-active">
            <a href="javascript:;">首页</a>
        </li>
        
        <li>
            <a href="javascript:;">我要理财</a>
        </li>
        <li>
            <a href="javascript:;">我要投资</a>
        </li>
        <li>
            <a href="javascript:;">新手指南</a>
        </li>
        <li>
            <a href="/article/articleInfo/list_article.go?aptId=9">新闻动态</a>
        </li>
        <li>
            <a href="javascript:;">联系我们</a>
        </li>
        
        <li class="">
            <a href="javascript:;">关于我们</a>
        </li>
    </ul>
</div>
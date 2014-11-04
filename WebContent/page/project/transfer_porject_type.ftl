<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融网 - 项目管理</title>
	 <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	 <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
	 <script type="text/javascript" src="/resources/common/cookie/cookie.js"></script>
	 <script type="text/javascript" src="/script/user/login.js"></script>
</head>
  <body>
	
	<div class="views">
		<!--头部导航-->
        <div class="navbar">
            <div class="navbar-inner clearfix">
                <div class="left">
                    <a href="/index.go" ><img class="top-logo" src="/resources/images/user/logo.png" /></a>
                </div>
                <div class="right">
                	<i class="rightI" style=""></i>
                </div>
                <div class="login" style="display: block">
                    <a href="javascript:;"></a>
                </div>
            </div>
        </div>
       		 <!--中间内容-->
		  <div class="view">
	        <div class="content m-l mt20 clearfix " style="margin-bottom: 200px;">
	            <form id="kindform" action="/center/projectInfo/transferPorject.go" method="post">
		            <tr>
				      <td align="left">
				      	股权
				      </td>
				      <td colspan="3">
				      	<input type="radio" checked="" value="1,1" name="protype"> 股权
				      </td>
				    </tr><p>
				    <input type="submit" class="btn" value="下一步">
			    </form>
		    
	            
	        </div>
	      </div>
	       <!--中间内容结束-->
	
	    </div>
            <!--底部工具栏-->
         <#include "/index/common/foot.ftl">
	
  </body>
</html>

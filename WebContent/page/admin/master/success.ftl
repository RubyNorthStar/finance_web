<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融--登陆成功</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script type="text/javascript" src="/script/admin/action_manage.js"></script>
</head>
  <body>
	  <div class="page"><!--page开始-->
		<div class="head"><!--head开始-->
			<input type="hidden" name="group_column_id_flag" id="group_column_id_flag" value="<#if groupColumnId??>${groupColumnId}</#if >"/>
			<p class="h-p1" style="font-size:18px;color:#fff">&nbsp;</p>
		</div>
		<div class="main clear"><!--main开始-->
				<div class="left"><!--left开始-->
				    <div class="l-content"><!--l-content"-->
				    	<dl class="l-dl1">
				        	<div class="dt"><a href="javascript:showActionLeft('ul0');">频道类型管理</a></div>
				    		<ul id="ul0" style="display:none">
					        	<li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId000001')" onmouseout="javascript:onChangeLeftTreePic2('picId000001')" id="picId000001">
					        		<a href="publish_type_obtainPublishTypeList.shtml" onclick="javascript:showCurPic('picId000001')">类型列表</a>
					        	</li>
					            <li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId000002')" onmouseout="javascript:onChangeLeftTreePic2('picId000002')" id="picId000002">
					           		<a href="publish_type_addPublishType.shtml" onclick="javascript:showCurPic('picId000002')">类型添加</a>
					            </li>
				            </ul>
					        <div class="dt"><a href="javascript:showActionLeft('ul1');">频道模版管理</a></div>
					        <ul id="ul1" style="display:none">
					            <li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId000003')" onmouseout="javascript:onChangeLeftTreePic2('picId000003')" id="picId000003">
					            	<a href="publish_type_obtainChannelTemplateList.shtml" onclick="javascript:showCurPic('picId000003')">模版列表</a>
					            </li>
					            <li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId000004')" onmouseout="javascript:onChangeLeftTreePic2('picId000004')" id="picId000004">
					            	<a href="publish_type_addChannelTemplate.shtml" onclick="javascript:showCurPic('picId000004')">模版添加</a>
					            </li>
					            <li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId000006')" onmouseout="javascript:onChangeLeftTreePic2('picId000006')" id="picId000006">
					            	<a href="publish_type_addChannelTemlateArea.shtml" onclick="javascript:showCurPic('picId000006')">模版区域添加</a>
					            </li>
					        </ul>   
					        <div class="dt"><a href="javascript:showActionLeft('ul2');">频道管理</a></div>
					        <ul id="ul2" style="display:none">
					      		<li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId000007')" onmouseout="javascript:onChangeLeftTreePic2('picId000007')" id="picId000007">
					      			<a href="publish_type_obtainPublishChannelsList.shtml" onclick="javascript:showCurPic('picId000007')">栏目列表</a>
					      		</li>
					      		<li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId000008')" onmouseout="javascript:onChangeLeftTreePic2('picId000008')" id="picId000008">
					      			<a href="publish_type_addPublishChannels.shtml" onclick="javascript:showCurPic('picId000008')">栏目添加</a>
					      		</li>
					      	</ul>
					      	
					      	
					      	<div class="dt"><a href="javascript:showActionLeft('ul7');">文章类型管理</a></div>
					      	<ul id="ul7" style="display:none">
					        	<li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId700001')" onmouseout="javascript:onChangeLeftTreePic2('picId700001')" id="picId700001">
					        		<a href="article_publish_type_obtainArticlePublishTypeList.shtml" onclick="javascript:showCurPic('picId000001')">文章类型列表</a>
					        	</li>
					            <li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId700002')" onmouseout="javascript:onChangeLeftTreePic2('picId700002')" id="picId700002">
					           		<a href="article_publish_type_addArticlePublishType.shtml" onclick="javascript:showCurPic('picId000002')">文章类型添加</a>
					            </li>
					            <li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId800001')" onmouseout="javascript:onChangeLeftTreePic2('picId800001')" id="picId800001">
					        		<a href="article_publish_type_obtainArticlePublishList.shtml" onclick="javascript:showCurPic('picId000003')">文章列表</a>
					        	</li>
					            <li class="dd" onmouseover="javascript:onChangeLeftTreePic('picId800002')" onmouseout="javascript:onChangeLeftTreePic2('picId800002')" id="picId800002">
					           		<a href="article_publish_type_addArticlePublish.shtml" onclick="javascript:showCurPic('picId000004')">文章添加</a>
					            </li>
				            </ul>
				        </dl>
				    </div>
				</div>
			    <div class="right1">
			    <h3>登陆成功</h3>
			    <div class="r1_bottom" id="layer0" style="padding:50px;text-align:center;"><font size="25">
		      			<#if masterDTO??>
							<#if masterDTO.flag??>
								<#if masterDTO.flag == '1005'>
									登陆成功
								</#if >
								<#if masterDTO.flag == '1004'>
									登陆失败，密码不正确
								</#if >
								<#if masterDTO.flag == '1003'>
									登陆失败，该用户不存在
								</#if >
								<#if masterDTO.flag == '1002'>
									登陆失败，登录名不能为空
								</#if >
								<#if masterDTO.flag == '1001'>
									登陆失败，登录名和密码不能为空
								</#if >
							</#if >
						</#if ></font>
			    </div>
		    </div>
		</div>
	</div>
</div>
	</div>
  </body>
</html>

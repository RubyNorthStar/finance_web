<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>携手金融网 - 修改密码</title>
    <link rel="stylesheet" href="/resources/css/my-app.css">
    <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/script/project/area.js"></script>
	<script >
		// 添加图片
		function addVoice(self){
			var outDiv = $(self).prev('div');
			var divs = outDiv.children('div');
			var lastIndex = (parseInt($(divs.get(divs.length - 1)).attr('data-voice')) + 1) || 0;
			var html = '<div data-voice="' + lastIndex + '"  class="zs_clearfix">'
					 + 		'<div>'
					 +			'<input style="width:165px;" type="file" name="images[' + lastIndex +'].imagePath" size="37" value="浏  览" /><span class="mp3_tip">(只能上传图片)</span>'
					 +		'</div>'
					 +		'<a class="sc_but" href="javascript:void(0);" onclick="deleteVoice(this)">删除</a>'
					 +	'</div>';
			outDiv.append(html);
		}
		
		// 删除图片
		function deleteVoice(self){
			$(self).parent().remove();
		}
	</script>
	<style>
		.sc_but{color:#333;float:left;width:50px;height:21px;line-height:21px;text-align:center;border:1px solid #ddd;background:#fff;margin-top:10px;margin-bottom:10px;}
		.tj_but{color:#333;float:left;width:50px;height:21px;line-height:21px;text-align:center;border:1px solid #ddd;background:#fff;}
		.zs_clearfix {
			 zoom:1; /* IE < 8 */
			}
		.mp3_tip{font-size:12px;color:#666;}
		.question_answer{margin-left:18px;margin-right:17px;}
		.question_answer .td_r input.fl{width:55px;height:26px;border:1px solid #cccccc;text-align: center;background: #e4e4e4;font-size:12px;color:#444;cursor:pointer;margin-left:15px;}
		.question_answer table{width:100%;border:1px solid #dddddd;border-right:0;border-bottom:0;}
		.question_answer td{border-right:1px solid #ddd;border-bottom:1px solid #ddd;padding:15px 13px;font-size:14px;color:#666;}
		.question_answer .td_l{width:84px;background:#f7f7f7;border-right:0;}
		.question_answer .td_r{background:#fff;padding-right:15px;}
		.question_answer .td_r .zs_clearfix{margin-bottom:10px;}
	</style>
</head>
<body>

<!-- Views-->
<div class="views">
    <!-- Your main view, should have "view-main" class-->
    <div class="view view-main">
        <!-- Top Navbar-->
        <div class="navbar">
            <div class="navbar-inner">
                <!-- We have home navbar without left link-->
                <div class="center sliding">
                	您好，<a href="/center/user/center.go"> ${user.username}</a>
            			<a href="/user/loginOut.go" class="button button-color1">退出</a>
                </div>
                <div class="right">

                </div>
            </div>
        </div>
        <!-- Pages, because we need fixed-through navbar and toolbar, it has additional appropriate classes-->
        <div class="pages navbar-through toolbar-through">
            <!-- Page, data-page contains page name-->
            <div data-page="index" class="page">
                <!-- Scrollable page content-->
                <div class="page-content">
                    <!-- 左侧部分 -->
                    <#include "/index/common/center_left.ftl">
                    <div class="right-content">
                    <!-- 中间部分开始 -->
                    	<div class="form">
                            <h3 class="user">转让项目管理 > 转让项目基本信息</h3>
                            <ul class="wrap-ul">
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>项目名称</div>
                                    <div class="right-form">
                                        <input class="input-text" type="text" placeholder=""><span class="span2">&numsp;&numsp;</span>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>审核时是否发送邮件</div>
                                    <div class="right-form">
                                        <input class="input-radio" type="radio" name="radio"  value="是">是
                                        <input class="input-radio" type="radio" name="radio"  value="否">否
                                    </div>
                                </li>
                                 <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>所属行业</div>
                                    <div class="right-form">
                                        <#if industryList??>
						    				<select name="projectInfo.proindustryId"> 
						    					<option >请选择</option>
								    			<#list industryList as industry>
								    				<option value="${industry.id}">${industry.industryName}</option>	
								    			</#list>
						    				</select> 
								   		</#if>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>底价</div>
                                    <div class="right-form">
                                        <input class="rmb-input" type="text" value="0" />
                                        <select class="" type="text" placeholder="">
                                            <option>万元</option>
                                        </select>
                                        <span class="span2">(为了更有效的促进交易，请注明价格，0为面议。)</span>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>所在地区</div>
                                    <div class="right-form">
                                        <select id="c_area" data-selector="city" class="input-text">
                                            <option>选择省</option>
                                        </select>
                                        <select id="c_city"  data-selector="area" class="input-text" >
                                            <option>选择市</option>
                                        </select>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title">标的企业名称</div>
                                    <div class="right-form">
                                        <input class="input-text" type="text" placeholder=""><span class="span2">&numsp;&numsp;</span>
                                    </div>
                                </li>
                                 <li class="wrap-li clear">
                                    <div class="left-title">上传图片</div>
                                    <div class="right-form">
                                       <div>
					   		 				<div data-voice="0"  class="zs_clearfix">
												<div>
													<input style="width:165px;"  type="file" name="images[0].imagePath" size="27" /><span class="mp3_tip">(只能上传图片)</span>
												</div>
											</div>
										</div>
										<a class="tj_but" href="javascript:void(0);" onclick="addVoice(this)">添加</a>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <div class="left-title"><span class="span2">*</span>有效起始日期</div>
                                    <div class="right-form">
                                        <input type="date"  />
                                    </div>
                                    <div class="left-title"><span class="span2">*</span>有效截止日期</div>
                                    <div class="right-form">
                                        <input type="date"  />
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <p><span class="span2">*</span>受让方应具备条件<span class="span2">【限1000字】</span></p>
                                    <div class="right-form">
                                        <textarea class="textarea-img"></textarea>
                                    </div>
                                </li>
                                <li class="wrap-li clear">
                                    <p><span class="span2">*</span>公告内容<span class="span2">【至少100字】</span></p>
                                    <div class="right-form">
                                        <textarea class="textarea-img"></textarea>
                                    </div>
                                </li>
                                
                                
                                
                                 <li class="wrap-li clear">
                                     <div class="user-info">
                                       	  用户信息
                                     </div>
                                 </li>
                                <li class="submitBtn">
                                    <button>暂存</button>
                                    <button>提交待审</button>
                                </li>
                            </ul>
                        </div>
                    </div>
            
           			<!-- 中间部分结束 -->
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Path to Framework7 Library JS-->
<!--<script type="text/javascript" src="js/framework7.js"></script>-->
<!-- Path to your app js-->
<!--<script type="text/javascript" src="js/my-app.js"></script>-->
</body>
</html>
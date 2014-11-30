<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>携手金融网 - 项目管理</title>
	 <link rel="stylesheet" type="text/css" href="/resources/css/index.css">
	 <script type="text/javascript" src="/resources/common/plugin/jquery/jquery-2.1.1.js"></script>
	 <script type="text/javascript" src="/resources/common/cookie/cookie.js"></script>
	 <script type="text/javascript" src="/script/user/login.js"></script>
	 
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
   		 	<form method="post" action="/center/projectInfo/addTransferPorject.go" id="addPorjectInfo"  enctype="multipart/form-data">
   		 	
   		 		<input type="hidden" name="projectInfo.projectType" value="${proType}"/>
   		 		<input type="hidden" name="projectInfo.projectTypeClassify" value="${proTypeClassify}"/>
   		 
   		 		项目名称:<input type="text" value="" size="80" id="projectName" name="projectInfo.projectName"></br>
   		 		是否发送邮件：<input type="radio" checked="checked" value="1" id="isMall" name="projectInfo.isMall">是&nbsp;&nbsp;
   		 					 <input type="radio" value="2" id="ismail2" name="projectInfo.ismail">否 <span class="redstar">【备注：默认审核时发送邮件短信，若选择‘否’,审核时将取消对本项目发送邮件短信】</span></br>
   		 		所属行业:<#if industryList??>
		    				<select name="projectInfo.proindustryId"> 
		    					<option >请选择</option>
				    			<#list industryList as industry>
				    				<option value="${industry.id}">${industry.industryName}</option>	
				    			</#list>
		    				</select> 
					    </#if></br>
   		 		转让底价：<input type="text" value="" size="80" id="proPrice" name="projectInfo.proPrice">万元(为了更有效的促进交易，请注明价格，0为面议。)</br>
   		 		标的企业名称：<input type="text" value="" size="80" id="financingPartyName" name="projectInfo.financingPartyName"></br>
   		 		
   		 		<div class="question_answer">
   		 			<table>
   		 				<tr>
							<td class="td_l">上传图片</td>
							<td class="td_r">
								<div>
			   		 				<div data-voice="0"  class="zs_clearfix">
										<div>
											<input style="width:165px;"  type="file" name="images[0].imagePath" size="27" /><span class="mp3_tip">(只能上传图片)</span>
										</div>
									</div>
								</div>
								<a class="tj_but" href="javascript:void(0);" onclick="addVoice(this)">添加</a>
							</td>
						</tr>
					</table>
				</div>
   		 		
   		 		
   		 		
   		 				<!-- <div>
   		 					<input type="file" value="浏览"/> 
   		 						<a class="tj_but" href="javascript:void(0);" onclick="addVoice(this)">添加</a>
   		 						<a class="sc_but" href="javascript:void(0);" onclick="deleteVoice(this)">删除</a></br>
   		 				</div> -->
   		 		
   		 		有效起始日期:<input type="date" name="projectInfo.beginTime"/></br>
   		 		有效截止日期:<input type="date" name="projectInfo.endTime"/></br> 
   		 		受让方应具备条件(限1000字)：<textarea name="projectInfo.investorsRequire" id="investorsRequire"></textarea></br>
   		 		项目及其价值介绍【至少100字】：<textarea name="projectInfo.proDetail" id="proDetail"></textarea></br>
   		 		<input type="submit" class="btn" value="提  交">
   		 	</form>
		  
	        <!--中间内容结束-->
	
	    </div>
            <!--底部工具栏-->
         <#include "/index/common/foot.ftl">
	
  </body>
</html>

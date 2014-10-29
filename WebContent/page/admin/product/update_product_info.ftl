<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/product/product.js" type="text/javascript" ></script>
	
	<!-- 编辑器插件 -->
	<link rel="stylesheet" href="/resources/common/plugin/kindeditor/themes/default/default.css" />
	<script charset="utf-8" src="/resources/common/plugin/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="/resources/common/plugin/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="/resources/common/plugin/kindeditor/plugins/code/prettify.js"></script>
	
	<!-- 样式 -->
	<link href="/style/manage/index.css" rel="stylesheet" />
	<title>更新产品</title>
	
	<script>
        var editor;
	    KindEditor.ready(function(K) {
		    var options={
			    cssPath : ['/resources/common/plugin/kindeditor/plugins/code/prettify.css'],
			    //allowImageUpload:false,
			    allowFlashUpload:false,
			    allowFileManager : true,
			    uploadJson:'/admin/productInfo/saveImage.go',
			    items:
			   		 ['source','|','image','|','preview','|','selectall','|','fullscreen','|','justifyleft','justifycenter','justifyright','justifyfull','|','insertorderedlist','formatblock','fontname','fontsize','forecolor','hilitecolor','bold','italic','baidumap','link','unlink','clearhtml','quickformat' ]
		    };
	   		editor = K.create('#productDetaileInfo',options);
	   		editor = K.create('#fundUse',options);
	   		editor = K.create('#repaymentSource',options);
	   		editor = K.create('#businessStructure',options);
	   		editor = K.create('#windControlMeasures',options);
	    });
	    
	</script>
	
</head>
  <body>
  
  	<div class="page"><!--page开始-->
		<#include "/admin/common/top.ftl">
		<div class="main clear"><!--main开始-->
			<#include "/admin/common/left.ftl">
			<div class="right1">
				<h3>产品管理&gt;&gt;修改产品</h3>
			    
			    <div class="r1_bottom" id="layer0">
		      		<form name="form_wm"  id="product_info_form" method="post" action="/admin/productInfo/update.go">
			      		 <table border="0" cellspacing="0" cellpadding="0" style="width:70%;margin-left: 20px;">
			         	 	  <tr>&nbsp;</tr>
			         	 	  <input type="hidden" name="id" value="${proInfo.id}"/>
				         	  <tr>
					             <td class="td1">产品名称：</td><td class="td2">&nbsp;<input type="text" name="productName" id="productName" value="${proInfo.productName}"></td>
					          </tr>
					          <tr>
					             <td class="td1">基金规模：</td><td class="td2">&nbsp;<input type="text" name="fundScale" id="fundScale" value="${proInfo.fundScale}"></td>
					          </tr>
					          <tr>
					             <td class="td1">预期收益：</td><td class="td2">&nbsp;<input type="text" name="expectProfit" id="expectProfit" value="${proInfo.expectProfit}"></td>
					          </tr>
					          <tr>
					             <td class="td1">基金类型：</td>
					             <td class="td2">
					             	<select name="fundTypeId" id="fundTypeId" style="margin-left:4px;">
									  <#list fundTypes as item>
										<option value ="${item.id}" <#if proInfo.fundTypeId == item.id>selected</#if>>${item.fundName}</option>
									   </#list>
								   </select>
					             </td>
					          </tr>
					           <tr>
					             <td class="td1">投资期限：</td><td class="td2">&nbsp;<input type="text" name="investmentTimeLimit" id="investmentTimeLimit" value="${proInfo.investmentTimeLimit}"></td>
					          </tr>
					          <tr>
					             <td class="td1">基金管理：</td><td class="td2">&nbsp;<input type="text" name="fundManage" id="fundManage" value="${proInfo.fundManage}"></td>
					          </tr>
					          <tr>
					             <td class="td1">起投金额：</td><td class="td2">&nbsp;<input type="text" name="minBidMoney" id="minBidMoney" value="${proInfo.minBidMoney}"></td>
					          </tr>
					          <tr>
					             <td class="td1">收益分配：</td><td class="td2">&nbsp;<input type="text" name="profitDistribution" id="profitDistribution" value="${proInfo.profitDistribution}"></td>
					          </tr>
					          <tr>
					             <td class="td1">基金类型：</td>
					             <td class="td2">
					             	<select name="isMortgage" id="isMortgage" style="margin-left:4px;">
									  <option value ="1" <#if proInfo.isMortgage == 1>selected</#if>>有抵押</option>
									  <option value ="2" <#if proInfo.isMortgage == 2>selected</#if>>无抵押</option>
								   </select>
					             </td>
					          </tr>
					          <tr>
					             <td class="td1">年利率：</td><td class="td2">&nbsp;<input type="text" name="yearInterestRate" id="yearInterestRate" value="${proInfo.yearInterestRate}"></td>
					          </tr>
					          <tr>
					             <td class="td1">信用等级：</td><td class="td2">&nbsp;<input type="text" name="creditLevle" id="creditLevle" value="${proInfo.creditLevle}"></td>
					          </tr>
					          <tr>
					             <td class="td1">项目简介：</td><td class="td2"><textarea style="width:200px;height:100px;" name="productDetaileInfo" id="productDetaileInfo" >${proInfo.productDetaileInfo}</textarea></td>
					          </tr>
					          <tr>
					             <td class="td1">资金用途：</td><td class="td2">&nbsp;<textarea style="width:200px;height:100px;" name="fundUse" id="fundUse" >${proInfo.fundUse}</textarea></td>
					          </tr>
					          <tr>
					             <td class="td1">还款来源：</td><td class="td2">&nbsp;<textarea style="width:200px;height:100px;" name="repaymentSource" id="repaymentSource" >${proInfo.repaymentSource}</textarea></td>
					          </tr>
					          <tr>
					             <td class="td1">交易结构：</td><td class="td2">&nbsp;<textarea style="width:200px;height:100px;" name="businessStructure" id="businessStructure" >${proInfo.businessStructure}</textarea></td>
					          </tr>
					          <tr>
					             <td class="td1">风控措施：</td><td class="td2">&nbsp;<textarea style="width:200px;height:100px;" name="windControlMeasures" id="windControlMeasures" >${proInfo.windControlMeasures}</textarea></td>
					          </tr>
					          
					          <tr> <td class="td1"><button  onclick="return addProductInfo()">保存</button></td></tr>
				    	 </table>
				    </form>
			    </div>
		    </div>
		</div>
	</div>
	
  </body>
</html>

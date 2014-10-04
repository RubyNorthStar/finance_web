<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/product/product.js" type="text/javascript" ></script>
	<title>更新产品</title>
	
</head>
  <body>
		<form name="form_wm"  id="product_info_form" method="post" action="/admin/productInfo/add.go">
			<input type="hidden" name="id" value="${proInfo.id}"/>
			产品名称：<input type="text" name="productName" id="productName" value="${proInfo.productName}">齐鲁儿女第一个项目</br>
			基金规模：<input type="text" name="fundScale" id="fundScale" value="${proInfo.productName}">500000<p>
			预期收益：<input type="text" name="expectProfit" id="expectProfit" value="${proInfo.productName}">12-14%<p>
			基金类型：<select name="fundTypeId" id="fundTypeId">
					  <#list fundTypes as item>
						<option value ="${item.id}" <#if proInfo.fundTypeId == item.id>selected</#if>>${item.fundName}</option>
					   </#list>
				   </select>
				   <p>
			投资期限：<input type="text" name="investmentTimeLimit" id="investmentTimeLimit" value="${proInfo.investmentTimeLimit}">14<p>
			基金管理：<input type="text" name="fundManage" id="fundManage" value="${proInfo.fundManage}">齐鲁儿女投资管理有限公司<p>
			起投金额：<input type="text" name="minBidMoney" id="minBidMoney" value="${proInfo.minBidMoney}">5000<p>
			
			收益分配：<input type="text" name="profitDistribution" id="profitDistribution" value="${proInfo.profitDistribution}">半年分配一次收益<p>
			项目简介：<textarea rows="3" cols="20" name="productDetaileInfo" id="productDetaileInfo" value="${proInfo.productDetaileInfo}"></textarea>这个项目是齐鲁儿女的项目，请放心投资<p>
			
			是否抵押：<select name="isMortgage" id="isMortgage">
						<option value ="1">有抵押</option>
						<option value ="2">无抵押</option>
				   </select><p>
			
			资金用途：<textarea rows="3" cols="20" name="fundUse" id="fundUse" value="${proInfo.fundUse}"></textarea><p>
			
			还款来源：<textarea rows="3" cols="20" name="repaymentSource" id="repaymentSource" value="${proInfo.repaymentSource}"></textarea><p>
			
			交易结构：<textarea rows="3" cols="20" name="businessStructure" id="businessStructure" value="${proInfo.businessStructure}"></textarea><p>
			
			风控措施 ：<input type="text" name="windControlMeasures" id="windControlMeasures" value="${proInfo.windControlMeasures}"><p>
			年利率：<input type="text" name="yearInterestRate" id="yearInterestRate" value="${proInfo.yearInterestRate}"><p>
			
			信用等级：<input type="text" name="creditLevle" id="creditLevle" value="${proInfo.creditLevle}"><p>
			
			<h1>上传产品抵押产品</h1>
			
			<input name="sub" value="提交" onclick="return addProductInfo()" class="btn1" type="button">
		</form>
	
  </body>
</html>

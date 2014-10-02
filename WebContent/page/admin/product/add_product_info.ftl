<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<title>添加产品</title>
	
	<script type="text/javascript">
		function addFundType(){
			var fundName = $('#fundName').val();
			if($.trim(fundName).length == 0){
				alert("基金类型不能为空！");
				return false;
			}
			
			$('#fund_type_form').submit();
		}
	</script>
</head>
  <body>
		<form name="form_wm"  id="fund_type_form" method="post" action="/admin/productInfo/add.go">
		
			产品名称：<input type="text" name="productName" id="productName" placeholder="产品名称"></br>
			基金规模：<input type="text" name="fundScale" id="fundScale" placeholder="基金规模"><p>
			预期收益：<input type="text" name="expectProfit" id="expectProfit" placeholder="预期收益"><p>
			基金类型：<select name="fundTypeId" id="fundTypeId">
					  <#list fundTypes as item>
						<option value ="${item.id}">${item.fundName}</option>
					   </#list>
				   </select>
				   <p>
			投资期限：<input type="text" name="investmentTimeLimit" id="investmentTimeLimit" placeholder="投资期限"><p>
			基金管理：<input type="text" name="fundManage" id="fundManage" placeholder="基金管理"><p>
			起投金额：<input type="text" name="minBidMoney" id="minBidMoney" placeholder="起投金额"><p>
			
			收益分配：<input type="text" name="profitDistribution" id="profitDistribution" placeholder="收益分配"><p>
			项目简介：<input type="textarea" name="productDetaileInfo" id="productDetaileInfo" placeholder="项目简介"><p>
			是否抵押：<input type="text" name="isMortgage" id="isMortgage" placeholder="是否抵押"><p>
			资金用途：<input type="text" name="fundUse" id="fundUse" placeholder="资金用途"><p>
			还款来源：<input type="text" name="repaymentSource" id="repaymentSource" placeholder="还款来源"><p>
			
			
			交易结构：<input type="text" name="businessStructure" id="businessStructure" placeholder="交易结构"><p>
			风控措施 ：<input type="text" name="windControlMeasures" id="windControlMeasures" placeholder="风控措施 "><p>
			年利率：<input type="text" name="yearInterestRate" id="yearInterestRate" placeholder="年利率"><p>
			
			信用等级：<input type="text" name="yearInterestRate" id="yearInterestRate" placeholder="信用等级"><p>
			
			<h1>上传产品抵押产品</h1>
			
			<input name="sub" value="提交" onclick="return addFundType()" class="btn1" type="button">
		</form>
	
  </body>
</html>

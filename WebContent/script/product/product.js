function addProductInfo(){
	var productName = $('#productName').val();
	if($.trim(productName).length == 0){
		alert("产品名称不能为空！");
		return false;
	}
	var fundScale = $('#fundScale').val();
	
	if($.trim(fundScale).length == 0){
		alert("基金规模不能为空！");
		return false;
	}
	if(isNaN(fundScale)){
		alert("基金规模必须为纯数字！");
		return false;
	}
	var expectProfit = $('#expectProfit').val();
	if($.trim(expectProfit).length == 0){
		alert("预期收益不能为空！");
		return false;
	}
	var investmentTimeLimit = $('#investmentTimeLimit').val();
	if($.trim(investmentTimeLimit).length == 0){
		alert("投资期限不能为空！");
		return false;
	}
	if(isNaN(investmentTimeLimit)){
		alert("投资期限必须为纯数字！");
		return false;
	}
	var fundManage = $('#fundManage').val();
	if($.trim(fundManage).length == 0){
		alert("基金管理不能为空！");
		return false;
	}
	var minBidMoney = $('#minBidMoney').val();
	if($.trim(minBidMoney).length == 0){
		alert("起投金额不能为空！");
		return false;
	}
	if(isNaN(minBidMoney)){
		alert("起投金额必须为纯数字！");
		return false;
	}
	
	var profitDistribution = $('#profitDistribution').val();
	if($.trim(profitDistribution).length == 0){
		alert("收益分配不能为空！");
		return false;
	}
	
	var yearInterestRate = $('#yearInterestRate').val();
	if(isNaN(yearInterestRate)){
		alert("年利率必须为纯数字！");
		return false;
	}
	
	var creditLevle = $('#creditLevle').val();
	if(isNaN(creditLevle)){
		alert("信用等级必须为纯数字！");
		return false;
	}
	
	var productDetaileInfo = $('#productDetaileInfo').prev().children().eq(1).children().eq(0).contents().find("body").text();
	$('#productDetaileInfo').val(productDetaileInfo);
	
	if($.trim(productDetaileInfo).length == 0){
		alert("项目简介不能为空！");
		return false;
	}
	
	var fundUse = $('#fundUse').prev().children().eq(1).children().eq(0).contents().find("body").text();
	$('#fundUse').val(fundUse);
	
	var fundUse = $('#fundUse').val();
	if($.trim(fundUse).length == 0){
		alert("资金用途不能为空！");
		return false;
	}
	
	var repaymentSource = $('#repaymentSource').prev().children().eq(1).children().eq(0).contents().find("body").text();
	$('#repaymentSource').val(repaymentSource);
	
	var repaymentSource = $('#repaymentSource').val();
	if($.trim(repaymentSource).length == 0){
		alert("还款来源不能为空！");
		return false;
	}
	
	var businessStructure = $('#businessStructure').prev().children().eq(1).children().eq(0).contents().find("body").text();
	$('#businessStructure').val(businessStructure);
	
	var businessStructure = $('#businessStructure').val();
	if($.trim(businessStructure).length == 0){
		alert("交易结构不能为空！");
		return false;
	}
	
	var windControlMeasures = $('#windControlMeasures').prev().children().eq(1).children().eq(0).contents().find("body").text();
	$('#windControlMeasures').val(windControlMeasures);
	
	var windControlMeasures = $('#windControlMeasures').val();
	if($.trim(windControlMeasures).length == 0){
	alert("风控措施不能为空！");
	return false;
	}
	
	$('#product_info_form').submit();
}

function updateStatus(id,obj){
	
	/2014/10/06/1412583297923s7h658tbox.jpg
	
	
	$.ajax({
		type: "POST",
		url : "/admin/productInfo/updateStatus.go",
		data: {"id":id, "status":obj},
		dataType:"json", 
		success: function(data){
			alert(data.result);
			if(obj == 2){
				alert("审核成功");
			}else{
				slert("禁用成功");
			}
		},
		error:function(data)
		{
			alert("更新失败!");
		}
	});
	
}


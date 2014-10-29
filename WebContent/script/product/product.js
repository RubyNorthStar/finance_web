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
	$.ajax({
		type: "POST",
		url : "/admin/productInfo/updateStatus.go",
		data: {"id":id, "toExamineStatus":obj},
		dataType:"json", 
		success: function(data){
			if(obj == 2){
				alert("审核成功");
				window.location.href = "/admin/productInfo.go";
			}else{
				alert("禁用成功");
				window.location.href = "/admin/productInfo.go";
			}
		},
		error:function(data)
		{
			alert("更新失败!");
		}
	});
}

function addVipUser(){
	var vipName = $.trim($("#vipName").val());
	var vipMobile = $.trim($("#vipMobile").val());
	var proId = $.trim($("#proId").val());
	
	var isMobile = checkPhone(vipMobile);
	
	if(vipName == null || vipName == ''){
		alert("请输入用户名");
		return false;
	}
	if (!isMobile) {
		alert("请输入正确的手机号！");
		return false;
	}
	$.ajax({
		type: "POST",
		url : "/vipUser/add.go",
		data: {"vipName":vipName, "vipMobile":vipMobile,"productId":proId},
		dataType:"json", 
		success: function(data){
			alert("添加成功");
		},
		error:function(data)
		{
			alert("添加失败");
		}
	});
}

/**
 * 手机号检查
 * @param phone
 * @returns
 */
function checkPhone(num){ 
    var phone = num || 0;
    phone = $.trim(phone);
    var Format = /^1[3,4,5,7,8]\d{9}$/; 
    return Format.test(phone) ? true : false;
}

/**
 * 根据产品名称查询产品
 */

function searchProductByName(){
	$('#product_list_form').submit();
}


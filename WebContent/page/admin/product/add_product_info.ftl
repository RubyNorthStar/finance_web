<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/product/product.js" type="text/javascript" ></script>
	
	<style>#demo{ margin:50px auto; width:540px; min-height:200px; background:#CF9}</style>
	
	<!-- 编辑器插件 -->
	<link rel="stylesheet" href="/resources/common/plugin/kindeditor/themes/default/default.css" />
	<script charset="utf-8" src="/resources/common/plugin/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="/resources/common/plugin/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="/resources/common/plugin/kindeditor/plugins/code/prettify.js"></script>
	
	<!-- 多图片异步上传 -->
	<link rel="stylesheet" type="text/css" href="/resources/common/plugin/diyUpload/css/webuploader.css">
	<link rel="stylesheet" type="text/css" href="/resources/common/plugin/diyUpload/css/diyUpload.css">
	<script type="text/javascript" src="/resources/common/plugin/diyUpload/js/webuploader.html5only.min.js"></script>
	<script type="text/javascript" src="/resources/common/plugin/diyUpload/js/diyUpload.js"></script>
	
	<title>添加产品</title>
	
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
		<form name="form_wm"  id="product_info_form" method="post" action="/admin/productInfo/add.go" enctype="multipart/form-data">
		
			产品名称：<input type="text" name="productName" id="productName" placeholder="产品名称">齐鲁儿女第一个项目</br>
			基金规模：<input type="text" name="fundScale" id="fundScale" placeholder="基金规模">500000<p>
			预期收益：<input type="text" name="expectProfit" id="expectProfit" placeholder="预期收益">12-14%<p>
			基金类型：<select name="fundTypeId" id="fundTypeId">
					  <#list fundTypes as item>
						<option value ="${item.id}">${item.fundName}</option>
					   </#list>
				   </select>
				   <p>
			投资期限：<input type="text" name="investmentTimeLimit" id="investmentTimeLimit" placeholder="投资期限">14<p>
			基金管理：<input type="text" name="fundManage" id="fundManage" placeholder="基金管理">齐鲁儿女投资管理有限公司<p>
			起投金额：<input type="text" name="minBidMoney" id="minBidMoney" placeholder="起投金额">5000<p>
			
			收益分配：<input type="text" name="profitDistribution" id="profitDistribution" placeholder="收益分配">半年分配一次收益<p>
			是否抵押：<select name="isMortgage" id="isMortgage" onchange=check(this)>
						<option value ="1" >有抵押</option>
						<option value ="2" >无抵押</option>
				   </select><p>
			年利率：<input type="text" name="yearInterestRate" id="yearInterestRate" placeholder="年利率"><p>
			
			信用等级：<input type="text" name="creditLevle" id="creditLevle" placeholder="信用等级"><p>
			
			项目简介：<textarea style="width:200px;height:100px;" name="productDetaileInfo" id="productDetaileInfo" placeholder="项目简介"></textarea><p>
			
			资金用途：<textarea style="width:200px;height:100px;" name="fundUse" id="fundUse" placeholder="资金用途"></textarea><p>
			
			还款来源：<textarea style="width:200px;height:100px;" name="repaymentSource" id="repaymentSource" placeholder="还款来源"></textarea><p>
			
			交易结构：<textarea style="width:200px;height:100px;" name="businessStructure" id="businessStructure" placeholder="交易结构"></textarea><p>
			
			风控措施 ：<textarea style="width:200px;height:100px;" name="windControlMeasures" id="windControlMeasures" placeholder="交易结构"></textarea><p>
			
			
			<h1>上传产品抵押产品</h1>
			
			<div id="demo">
				<div id="as" ></div>
			</div>
			
			<input name="sub" value="提交" onclick="return addProductInfo()" class="btn1" type="button">
		</form>
	
  </body>
  
  <script type="text/javascript">
	  $('#as').diyUpload({
		url:'/admin/productInfo/saveImage.go',
		success:function( data ) {
			console.info( data );
		},
		error:function( err ) {
			console.info( err );	
		},
		buttonText : '选择文件',
		chunked:true,
		// 分片大小
		chunkSize:512 * 1024,
		//最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
		fileNumLimit:50,
		fileSizeLimit:500000 * 1024,
		fileSingleSizeLimit:50000 * 1024,
		accept: {}
	  });
  </script>
</html>

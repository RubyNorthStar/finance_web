<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/product/product.js" type="text/javascript" ></script>
	
	<style>#mortgageDiv{ margin:50px auto; width:540px; min-height:200px; background:#CF9}</style>
	
	<style>#mainImageDiv{ margin:50px auto; width:240px; min-height:200px; background:#CF9}</style>
	
	<!-- 多图片异步上传 -->
	<link rel="stylesheet" type="text/css" href="/resources/common/plugin/diyUpload/css/webuploader.css">
	<link rel="stylesheet" type="text/css" href="/resources/common/plugin/diyUpload/css/diyUpload.css">
	<script type="text/javascript" src="/resources/common/plugin/diyUpload/js/webuploader.html5only.min.js"></script>
	<script type="text/javascript" src="/resources/common/plugin/diyUpload/js/diyUpload.js"></script>
	
	<title>添加产品主图及抵押产品图片</title>
	
</head>
  <body>
		<form name="form_wm" id="product_info_form" method="post" action="/admin/productInfo/addImage.go" enctype="multipart/form-data">
			
			<input type="hidden" id="id" name="id" value="${proInfoId}"/>
			
			<h3>产品主图：</h3>
				<div id="mainImageDiv">
					<div id="mainImageContent" ></div>
				</div>
				<input type="text" name="mainImage" id="mainImage"/>
			
			<h3>上传抵押产品图片</h3>
			
			<div id="mortgageDiv">
				<div id="mortgageImagesDiv" ></div>
			</div>
			<input type="text" name="mortgageImage" id="mortgageImage"/>
			
			<input name="sub" value="提交" class="btn1" type="submit">
		</form>
	
  </body>
  
  <script type="text/javascript">
  	
  	   $('#mainImageContent').diyUpload({
		url:'/admin/productInfo/saveImage.go',
		success:function( data ) {
			if(!$('#mainImage').val()){
				$('#mainImage').val(data.url);
			}else{
				$('#mainImage').append(","+data.url);
			}
		},
		error:function( err ) {
			console.info( err );	
		},
		buttonText : '选择文件',
		chunked:true,
		// 分片大小
		chunkSize:512 * 1024,
		//最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
		fileNumLimit:1,
		fileSizeLimit:500000 * 1024,
		fileSingleSizeLimit:50000 * 1024,
		accept: {}
	  });
  
	  $('#mortgageImagesDiv').diyUpload({
		url:'/admin/productInfo/saveImage.go',
		success:function( data ) {
			if(!$('#mortgageImage').val()){
				$('#mortgageImage').val(data.url);
			}else{
				var content = $('#mortgageImage').val();
				content += "," + data.url
				$('#mortgageImage').val(content);
			}
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

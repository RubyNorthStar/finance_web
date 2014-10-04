<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<title>百度编辑器测试页面</title>
	
	
	<link rel="stylesheet" href="/resources/common/plugin/kindeditor/themes/default/default.css" />
	<script charset="utf-8" src="/resources/common/plugin/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="/resources/common/plugin/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="/resources/common/plugin/kindeditor/plugins/code/prettify.js"></script>
	
	
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
	   		editor = K.create('#detaileInfo',options);
	   		editor = K.create('#detaileInfo1',options);
	    });
 　　　 </script>
          
</head>
  <body>
  
		<textarea id="detaileInfo" name="content" style="width:700px;height:300px;"></textarea>
		<textarea id="detaileInfo1" name="content" style="width:700px;height:300px;"></textarea>
	
  </body>
</html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>文章添加</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script type="text/javascript" src="../script/jquery/jquery-1.7.js"></script>
	<#-- <script type="text/javascript" src="/script/product/leftTree.js"></script> -->
	<SCRIPT type="text/javascript" src="/fckeditor/fckeditor.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="/fckeditor/fckconfig.js"></SCRIPT>
	<script type="text/javascript" src="/script/publish/publish.js"></script>
</head>
<script type="text/javascript">

  window.onload = function(){
		var oFCKeditor = new FCKeditor("FCKeditor1");
		oFCKeditor.BasePath = "/fckeditor/";
		oFCKeditor.ToolbarSet = "Basic";
		oFCKeditor.Width = "130%";
		oFCKeditor.Height = "400";
		oFCKeditor.ReplaceTextarea() ;
  }
  function getEditorHTMLContents(EditorName) { 
	var oEditor = FCKeditorAPI.GetInstance(EditorName); 
	document.getElementById("editingCode").value=oEditor.GetXHTML(true);
  }
  function loadImage(obj){   
		var objPreviewFake = document.getElementById( 'preview_fake' );
		document.getElementById("uploadImage").src="/image/manage/touming.gif";
	    if(obj){   
	        //ie   
	        if (window.navigator.userAgent.indexOf("MSIE")>=1){   
	            obj.select();   
	            // IE下取得图片的本地路径   
	            var imgSrc = document.selection.createRange().text;        
                document.getElementById("imageFileName").value=imgSrc;
        		objPreviewFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;
	        }   
	        //firefox   
	        else if(window.navigator.userAgent.indexOf("Firefox")>=1){
	            if(obj.files){
	                // Firefox下取得的是图片的数据   
	                document.getElementById("imageFileName").value = "";
	                document.getElementById("uploadImage").src = window.URL.createObjectURL(obj.files[0]);   
	            }   
	            return obj.value;   
	        }   
	        return obj.value;   
	    }   
	}
  function toSubmit(){
	if(!checkIsNull('title','文章标题不能为空！')){
		return;
	}
	if(!checkForm('title',32,'文章标题长度不能超过32')){
		return;
	}
	if(!checkForm('articleSource',23,'文章来源长度不能超过23')){
		return;
	}
	getEditorHTMLContents("FCKeditor1");
	$("#myForm1").submit();
}
</script>
<style type="text/css" mce_bogus="1">       
	#preview_fake{ /* 该对象用户在IE下显示预览图片 */  
		background-color:#CCC;
		width:210px;        
	    height:100px;
	    filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);        
	}
	#uploadImage{ /* 该对象用户在FF下显示预览图片 */    
	    width:210px;        
	    height:100px;        
	}      
</style> 
  <body>
	 <div class="page"><!--page开始-->
		<#include "/admin/common/top.ftl">
			<div class="main clear"><!--main开始-->
			    <#include "/admin/common/left.ftl">
				    <div class="right1"><!--right开始-->
				    <h3>文章管理&gt;&gt;文章添加</h3>
				      <div class="r1_bottom" id="layer0">
			      		<form action="article_publish_type_saveArticlePublish.shtml" method="post" id="myForm1" enctype ="multipart/form-data">
			      			 <table border="0" cellspacing="0" cellpadding="0" style="width:70%">
			         	 	  <tr>&nbsp;</tr>
				         	  <tr>
					             <td class="td1">文章类型： </td>
								 <td class="td2">
								 	<SELECT name="articlePublishType.artPubId">
							    	<#if articlePublishTypeList??>
										<#list articlePublishTypeList as articlePublishType>
											<OPTION  value="${articlePublishType.artPubId}">${articlePublishType.artPubName}</OPTION>
										</#list>
									</#if>
									</SELECT>
								</td>
					          </tr>
					           <tr>
					             <td class="td1">文章标题：</td>
	             				 <td class="td2"><input type="text" id="title" name="articlePublish.title" value=""/></td>
					          </tr>
					          <tr>
					             <td class="td1">文章来源：</td>
	             				<td class="td2"><input type="text" id="articleSource" name="articlePublish.articleSource" value=""/></td>
					          </tr>
					          <tr>
					             <td class="td1">相关标签：</td>
	             				<td class="td2"><input type="text" id="taLabel" name="articlePublish.taLabel" value=""/></td>
					          </tr>
					          <tr>
					             <td class="td1">上传图片：</td>
					             <td class="td2" colspan="2">
					             	 <div id="preview_fake">
						             	<img id="uploadImage" <#if articlePublish??><#if articlePublish.articlePic??>src="${articlePublish.articlePic}"</#if><#else>src="/image/manage/touming.png"</#if> width="210" height="100" border="0"/>
						             </div>
						             <div>
						             	<font color="#FF0000">*建议上传100*210格式图片</font>
						             </div>
						             <input type="file" name="file" onchange="loadImage(this);" />
						             <input type="hidden" id="imageFileName"  name="imageFileName" />
						             <!--<#if productAwards??>
						             	<#if productAwards.awardsPic??>
								             <input class="ra" type="checkbox" name="removeImage" value="true"><font color="red">删除图片</font>
											 <input class="ra" type="checkbox"  name="updateImage" value="true">更新图片
						             	</#if> 
						             </#if>-->
					             </td>
						        </tr>
					          <tr>
				          	     <td class="td1">文章内容：</td>
             				     <td class="td4"><textarea id="FCKeditor1"></textarea></td>
		                         <input type="hidden" id="editingCode"  name="articlePublish.editingCode"><br>
		                      </tr>
					     	  <tr>
             					 <td colspan="2" style="text-align:center"><input type="button" onclick="toSubmit()" value="添加" style="width: 50px;"/></td>
				          	  </tr>
							  <input type="hidden" id="isCurShowPicId" name="isCurShowPicId" value="picId000004"/>
							  <input type="hidden" id="dtul" name="dtul" value="ul7"/>
				    	 </table>
				    </form>
			    </div>
		    </div><!--right结束-->
		</div><!--main结束-->
	</div><!--page结束-->
  </body>
</html>

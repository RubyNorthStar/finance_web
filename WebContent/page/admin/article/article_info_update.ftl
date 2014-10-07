<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>文章更新</title>
	<link href="/style/manage/index.css" rel="stylesheet" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
	<link href="/style/manage/page.css" rel="stylesheet" />
	<SCRIPT type="text/javascript" src="/fckeditor/fckeditor.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="/fckeditor/fckconfig.js"></SCRIPT>
	<script type="text/javascript" src="/script/admin/publish.js"></script>
</head>
<script type="text/javascript">

  window.onload = function(){
		var oFCKeditor = new FCKeditor("FCKeditor1");
		oFCKeditor.BasePath = "/fckeditor/";
		oFCKeditor.ToolbarSet = "Basic";
		oFCKeditor.Height = "400";
		oFCKeditor.Width = "130%";
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
				    <h3>文章管理&gt;&gt;文章修改</h3>
				      <div class="r1_bottom" id="layer0">
			      		<form action="/admin/articleInfo/update.go" method="post" id="myForm1" enctype ="multipart/form-data">
			      		   <input type="hidden" name="apId" value="${articleInfo.apId}"/>
			      			 <table border="0" cellspacing="0" cellpadding="0" style="width:70%">
			         	 	  <tr>&nbsp;</tr>
					          <tr>
					             <td class="td1">文章类型： </td>
								 <td class="td4">
								 	<SELECT name="aptId">
							    	<#if articleInfoTypeList??>
										<#list articleInfoTypeList as articleInfoType>
											<#if articleInfo.apId == articleInfo.apId>
													<OPTION  value="${articleInfoType.aptId}" selected="selected">${articleInfoType.aptName}</OPTION>
												<#else>
													<OPTION  value="${articleInfoType.aptId}">${articleInfoType.aptName}</OPTION>
											</#if>
										</#list>
									</#if>
									</SELECT>
								</td>
					          </tr>
					          <tr>
					             <td class="td1">作者：</td>
	             				<td class="td2"><input type="text" id="author" name="author" value="${articleInfo.author}"/></td>
					          </tr>
					          <tr>
					             <td class="td1">文章来源：</td>
	             				<td class="td4"><input type="text" id="articleSource" name="articleSource" value="${articleInfo.articleSource}"/></td>
					          </tr>
					          <tr>
					             <td class="td1">上传图片：</td>
					             <td class="td4" colspan="2">
					             	 <div id="preview_fake">
						             	<img id="uploadImage" name="uploadImage" <#if articleInfo??><#if articleInfo.articlePic??>src="/userfiles/articleImg${articleInfo.articlePic}"</#if><#else>src="/image/manage/touming.png"</#if> width="210" height="100" border="0"/>
						             </div>
						             <div>
						             	<font color="#FF0000">*建议上传100*210格式图片</font>
						             </div>
						             <input type="file" name="file" onchange="loadImage(this);" />
						             <input type="hidden" id="imageFileName"  name="imageFileName" />
					             </td>
						        </tr>
					     	   <tr>
					             <td class="td1">是否启用：</td>
					             <td class="td4">
		             				 <input name="isUsing" type="radio" value="1" <#if (articleInfo.isUsing==1) > checked="checked"</#if> style="width:30px;border:0px"/>是
									 <input name="isUsing" type="radio" value="0" <#if (articleInfo.isUsing!=1) > checked="checked"</#if> style="width:30px;border:0px"/>否
	             				 </td>
					     	  </tr>
					     	  <tr>
				          	     <td class="td1">文章内容：</td>
             				     <td class="td4"><textarea id="FCKeditor1" name="FCKeditor1"><#if articleInfo.editingCode??> ${articleInfo.editingCode}</#if></textarea></td>
		                         <input type="hidden" id="editingCode"  name="editingCode"><br>
		                      </tr>
					     	  <tr>
             					 <td colspan="2" style="text-align:center"><input type="button" onclick="toSubmit()" value="修改" style="width: 50px;"/></td>
				          	  </tr>
				    	 </table>
				    </form>
			    </div>
		    </div><!--right结束-->
		</div><!--main结束-->
	</div><!--page结束-->
  </body>
</html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章类型添加</title>
<link href="/style/manage/index.css" rel="stylesheet" />
<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
<script src="/script/jquery/jquery.pagination.js" type="text/javascript" ></script>
<link href="/style/manage/page.css" rel="stylesheet" />
</head>
<script>
function toSubmit(){
	var typeName = $('#typeName').val();
	if(typeName.length == 0 ){
		alert("类型名称不能为空");
		return;
	}
	if(typeName.length > 16 ){
		alert("类型名称的长度不能大约16个字符");
		return;
	}
	$("#myForm").submit();
}
</script>
<body>
	<div class="page"><!--page开始-->
	  <#include "/admin/common/top.ftl">
	   <div class="main clear"><!--main开始-->
		 <#include "/admin/common/left.ftl">
			<div class="right1"><!--right开始-->
				<h3>文章类型管理&gt;&gt;文章类型添加</h3>
			      <div class="r1_bottom" id="layer0">
			      	 <#if flag??>
			      	 	 <#if (flag == '1001')>
				      	 	保存成功
				      	 </#if>
				      	 <#if (flag == '1002')>
				      	 	保存失败
				      	 </#if>
			      	 </#if>
			      	<form action="/admin/articleInfoType/save.go" method="post" id="myForm">
				        <table border="0" cellspacing="0" cellpadding="0" style="width:50%">
				          <tr>
				             <td class="td1"></td>
				             <td class="td2">&nbsp;</td>
				          </tr>
				          <tr>
				             <td class="td1">类型名称：</td>
             				 <td class="td2"><input type="text" id="typeName" name="aptName" size="5"/></td>
				          </tr>
				          <tr>
             				<td colspan="2" style="text-align:center"><input type="button" onclick="toSubmit()" value="提交" style="width: 50px;"/></td>
				          </tr>
				          <input type="hidden" id="isCurShowPicId" name="isCurShowPicId" value="picId000002"/>
						  <input type="hidden" id="dtul" name="dtul" value="ul7"/>
				        </table>
			        </form>
		        </div>
		    </div><!--right结束-->
		</div><!--main结束-->
	</div><!--page结束-->
</body>
</html>
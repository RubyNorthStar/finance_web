<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>携手金融--后台登陆</title>
  <link href="/style/manage/index.css" rel="stylesheet" />
  <!--script type="text/javascript" src="/script/jquery/jquery-1.7.js"></script-->
  <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body>
   <div class="page"><!--page开始-->
   	${aaaaa}
    <#include "/WEB-INF/page/manage/include/top.ftl">
    <div class="main clear"><!--main开始-->
      <#include "/WEB-INF/page/manage/include/left_new.ftl">
      <div class="right1">
        <table style="width:400px" border="2" align="center">
          <caption>
              <!-- 操作 id: ${ACTION.atId?string('####')}；操作 no: ${ACTION.actionNo}；操作员id: ${master.mtId?string('####')}-->
              操作：${ACTION.name}；用户: ${master.name?default('')}
          </caption>
          <tr align="center" bgcolor="#C6C6C6">
            <td >
              模板 id
            </td>
            <td>
              模板 名称
            </td>
            <td> 查看 </td>
            <td> 修改 </td>
            <td> 删除 </td>
            <!--td> 改名 </td-->
          </tr>
          <#assign cnt = 0>
          <#list pager.records as item>
          <#assign cnt = cnt + 1>
          <tr <#if cnt%2==0>bgcolor="E3E3E3"</#if> align="center">
            <td  align="right">
              ${item.channelTemplateId?string('####')}&nbsp;&nbsp;
            </td>
            <td  align="left">
              &nbsp;${item.channelTemplateName?default('')}
            </td>
            <td>
              <input type="checkbox" name="itemId_q" value="${item.channelTemplateId?string('####')}" checked="true" />
            </td>
            <td>
              <input type="checkbox" name="itemId_u" value="${item.channelTemplateId?string('####')}" checked="true" />
            </td>
            <td>
              <input type="checkbox" name="itemId_d" value="${item.channelTemplateId?string('####')}|${item.channelTemplateName?default('')}" checked="true" />
            </td>
            <!--td>
              <input type="checkbox" name="itemId_r" value="${item.channelTemplateId?string('####')}" checked="true" />
            </td-->
          </tr>
          </#list>
          <tr align="center">
            <td colspan="5">
              <button onclick="return submitIt(${master.mtId?string('####')}, ${ACTION.atId?string('####')})" style="width:300px">更       新</button>
            </td>
          </tr>
        </table>

      </div>
    </div>
  </div>
</body>
<script>
  function submitIt(operatorId, actionId) {
    //alert(operatorId + "; " + actionId);
			var arrDelete=document.getElementsByName("itemId_d");
			var arrUpdate=document.getElementsByName("itemId_u");
			var arrQuery= document.getElementsByName("itemId_q");
			
			var itemDelete = "";
			var itemUpdate = "";
			var itemQuery = "";
			for(var i=0; i < arrDelete.length; i++){
				itemDelete += arrDelete[i].value + "|";
				if (arrDelete[i].checked ==true) {
					itemDelete +="1";
				} else {
					itemDelete +="0";
				}
				itemDelete += "|";

				if (arrUpdate[i].checked ==true) {
					itemDelete +="1";
				} else {
					itemDelete +="0";
				}
				itemDelete += "|";
				if (arrQuery[i].checked ==true) {
					itemDelete +="1";
				} else {
					itemDelete +="0";
				}
				itemDelete += "|";
				


				itemDelete += "#";
			}
  	//alert("itemDelete: " + itemDelete);
  	var param = {'masterDTO.id':${master.mtId?string('####')}, 'validateCode':itemDelete, 
  		'masterDTO.sex':${ACTION.atId?string('####')}, 'masterDTO.department':'${ACTION.name}'
  			};//, 'validateCode':itemDelete           
  	//alert("itemDelete: " + param);
  	$.getJSON('/json/master_updateOperatorRight.shtml?m='+Math.random(), param, function(data){
  		var info = data.validateCode;
  		alert(info);
  	})
  }
</script>
</html>

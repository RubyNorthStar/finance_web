<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/script/jquery/jquery-1.7.js" type="text/javascript" ></script>
	<title>添加基金类型</title>
	
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
		<form name="form_wm"  id="fund_type_form" method="post" action="/admin/fundType/add.go">
		
			基金类型名称：<input type="text" name="fundName" id="fundName" placeholder="输入类型名称">
			
			<input name="sub" value="提交" onclick="return addFundType()" class="btn1" type="button">
		</form>
	
  </body>
</html>

$(function(){
	$(".hyx_img").click(function(){
		$(this).attr({"src":"/captcha/cimge.go?"+Math.random()});
	});
});

function userLogin(obj){
	//$('form').submit();
	var email = $.trim($('#email').val());
	var password = $.trim($('#password').val());
	
	var isEmail = checkEmailLogin(email);
	$("#verify").empty();
	
	if (!isEmail) {
    	$("#verify").text("请输入一个有效的邮箱地址");
        $("#email").focus();
    } else if (password == null || password == '') {
    	$("#verify").text("请输入密码");
        $("#password").focus();
    } else if (password.length < 6) {
    	$("#verify").text("输入密码错误");
        $("#password").focus();
    } else{
    	$(obj).val("登录中...");
    	$.ajax({
    		type: "POST",
    		url : "/user/login.go",
    		data: {"email":email, "password":password},
    		dataType:"json", 
    		success: function(data){
    			 if (data) {
			        if ($("#remember").prop("checked")) {
			            setCookie("LOGINNAME",email);
			            setCookie("LOGINPWD",data[0].password);
			        }
			        window.location.href = "/index.go";
			    } else { 
			    	$("#verify").html("用户名或密码错误！"); 
			    	$(obj).val("马上登录");
			    }
    		},
    		error:function(data)
    		{
    			$('#verify').text("邮箱地址或者密码错误，请确认后重新登录。");
    			$(obj).val("马上登录");
    		}
    	});
    }
	
}

function userRegiste(){
	var username = $.trim($('#username').val());
	var mobile = $.trim($('#mobile').val());
	var email = $.trim($('#email').val());
	var password = $.trim($('#password').val());
	var confirm_password = $.trim($('#confirm_password').val());
    var verification_code = $.trim($("#verification_code").val());
	
	//验证用户信息是否完整
	var isEmail = checkEmailLogin(email);
	var isMobile = checkPhone(mobile);
	
	if(username == null || username == ''){
		$("#verify").text("请输入用户名");
        $("#username").focus();
	}else if (!isMobile) {
    	$("#verify").text("请输入一个有效的手机号");
        $("#mobile").focus();
    }else if(!isEmail){
    	$("#verify").text("请输入一个正确的邮箱地址");
        $("#email").focus();
    }else if(password == null || password == ''){
    	$("#verify").text("密码不能为空");
        $("#password").focus();
    }else if(password != null && password.length < 6){
    	$("#verify").text("密码不能小于六位数");
        $("#password").focus();
    }else if(confirm_password == null || confirm_password == ''){
        	$("#verify").text("确认密码不能为空");
            $("#password").focus();
    }else if(password != confirm_password){
    	$("#verify").text("两次输入密码不一致");
        $("#confirm_password").focus();
    }else if(!verification_code || !checkYzm(verification_code)){
    	$("#verify").text("验证码不正确");
        $("#verification_code").focus();
    }else{
    	
    	//检查该邮箱是否已经注册
    	$.ajax({
    		type: "POST",
    		url : "/user/verificat_email.go",
    		data: {"email":email},
    		dataType:"text", 
    		success: function(data){
    			if(data){
    				$("#verify").text("该邮箱已经注册");
    		        $("#email").focus();
    			}else{
    				$.ajax({
    		    		type: "POST",
    		    		url : "/user/register.go?yzm="+verification_code,
    		    		data: {"email":email, "username":username,"mobile":mobile,"password":password},
    		    		dataType:"text", 
    		    		success: function(data){
    		    			if(data == "success"){
    		    				window.location.href = "/center/user/center.go";
    		    			}else{
    		    				$("#verify").text("注册失败");
    		    			}
    		    		}
    				});
    			}
    		},
    		error:function(data)
    		{
    			$('#verify').text("邮箱地址或者密码错误，请确认后重新登录。");
    			$(obj).val("马上登录");
    		}
    	});
    }
	
}


/*email验证*/
function checkEmailLogin(str) {
    var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (reg.test(str)) {
        return true;
    } else {
        return false;
    }
}

/**
 * 判断验证码
 * @param str
 * @returns {Boolean}
 */
function checkYzm(str){
	return str.length == 4;
}

/**
 * 手机号检查
 * @param phone
 * @returns
 */
function checkPhone(num){ 
    var phone = num || 0;
    phone = $.trim(phone);
    var Format = /^1[3,4,5,8]\d{9}$/; 
    return Format.test(phone) ? true : false;
}
function checkIsNull(name,message){
	var obj = $("#"+name).val();	//var obj = document.ElementById(name);
	if(obj != null){
		if(obj.length == 0 || $.trim(obj).length == 0){	//obj.value.length == 0
			alert(message);
			return false;
		}else{return true;}
	}
}
function checkForm(name,length,message){
	var obj = $("#"+name).val();
	if(obj != null){
		if(obj.length > length){
			alert(message);
			return false;
		}else{return true;}
	}
}
function checkChanese(name,message){
	var reg= /[\u4E00-\u9FA5]/;
	if(reg.test($("#"+name).val())){
		alert(message);
		return false;
	}else{return true;}
}
function SubstrTitle(name,length){
	var obj = $("#"+name);
	if(obj != null){
		if(obj.length > length){
			obj.substr(0,13);
			return obj;
		}else{return true;}
	}
}
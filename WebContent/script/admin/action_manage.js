function showActionLeft(groupColumnId){
	if(groupColumnId != null){
		var display = document.getElementById(groupColumnId).style.display;
		if("none" == display){
			document.getElementById(groupColumnId).style.display = "block";
		}else if("block" == display){
			document.getElementById(groupColumnId).style.display = "none";
		}
	}
}
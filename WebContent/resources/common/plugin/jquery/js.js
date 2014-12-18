/**
 * Created by klz04 on 14-9-28.
 */
$(function(){
//       page3 点击事件
    $(".list-li-title").click(function(){
        $(".list-li-title").removeClass("active");
        $(this).addClass("active");
        $(".hidden").removeClass("show");
        $(".hidden").eq( $(this).index()).addClass("show");

    });
//       page3 点击事件结束

//  index 点击事件
    
    $(".table-menu .market-ul li").click(function(){
    	$(".market-ul li").removeClass("jsActive");
    	$(this).addClass("jsActive");
    	if($(this).index() == 0){
    		$('.project_more a').html("&nbsp");
    	}else if($(this).index() == 1){
    		$('.project_more a').html("&nbsp");
    		$('.project_more a').html("更多产品&nbsp;&nbsp;>");
    		$('.project_more a').attr("href","/projectInfo/projectList.go?projectType=2");
    	}else if($(this).index() == 2){
    		$('.project_more a').html("&nbsp");
    		$('.project_more a').html("更多产品&nbsp;&nbsp;>");
    		$('.project_more a').attr("href","/projectInfo/investList.go");
    	}else if($(this).index() == 3){
    		$('.project_more a').html("&nbsp");
    		$('.project_more a').html("更多产品&nbsp;&nbsp;>");
    		$('.project_more a').attr("href","/projectInfo/projectList.go?projectType=1");
    	}else if($(this).index() == 4){
    		$('.project_more a').html("&nbsp");
    		$('.project_more a').html("更多产品&nbsp;&nbsp;>");
    		$('.project_more a').attr("href","/projectInfo/publicList.go");
    	}
    	
    	$(".table-div .tab").removeClass("tabActive");
    	$(".table-div .tab").eq( $(this).index()).addClass("tabActive");
    });
    
     $(".table-menu .product_click li").click(function(){
    	$(".product_click li").removeClass("aActive");
    	$(this).addClass("aActive");
    	$(".table-product .tab").removeClass("tabActive");
    	$(".table-product .tab").eq( $(this).index()).addClass("tabActive");
    });
    
//       index 点击事件结束
    
//    百分比
    
    
    
// 百分比 end   ui-progressbar-mid-0  background-position:0px 0px ;  -54px

//  index 点击事件
    $(".table-menu .product_list li").click(function(){
        $(".table-menu .list-ul li").removeClass("aActive");
        $(this).addClass("aActive");
    });
//       index 点击事件结束

});
//alert($("tbody tr td span.span6").text())
percent();
function percent(){
	$("tbody tr td .span6").each(function(){
	    $(this).css("background-position",($(this).text().split('%')[0] * (-54))+"px 46px");
	});
}



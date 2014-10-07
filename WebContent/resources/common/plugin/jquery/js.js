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
    $(".table-menu .list-ul li").click(function(){
        $(".table-menu .list-ul li").removeClass("aActive");
        $(this).addClass("aActive");
//        console.log($(this).index())
        $(".table-div .tab").removeClass("tabActive");
        $(".table-div .tab").eq( $(this).index()).addClass("tabActive");

    });
//       index 点击事件结束
    
//

  //leftMove{ position: absolute; left: 0px; top: 20px;}
  //.rightMove
   var aLiWidth = $(".move li").width();
   var aLiLength = $(".move li").length;
//   alert(aLiWidth);
//   alert(aLiLength);
   
   $(".move").css('width',aLiWidth*aLiLength+"px")
   $(".leftMove").click(function(){
//	   alert("leftMove");
   })
   
   $(".rightMove").click(function(){
//	   alert("rightMove")
//	   .content-img{ width: 238px;height: 159px;}
	   
	   $(".move").css({'left':(-aLiWidth)+'px'})
	   alert($(".move").css("left"))
	   
   })
//
});
//alert($("tbody tr td span.span6").text())
percent();
function percent(){
	$("tbody tr td .span6").each(function(){
	    $(this).css("background-position",($(this).text().split('%')[0] * (-54))+"px 46px");
	});
}






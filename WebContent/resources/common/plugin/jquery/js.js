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

});
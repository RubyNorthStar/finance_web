/**
 *  用户记住用户名密码cookie js
 * @author wang.zx 
 *
 */

//写cookies
function setCookieTk(name,value)
{
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

//读取cookies
function getCookieTk(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]);
    else
        return null;
}

//删除cookies
function delCookieTk(name)
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookieTk(name);
    if(cval!=null)
        document.cookie= name + "="+cval+";expires="+exp.toGMTString();
} 
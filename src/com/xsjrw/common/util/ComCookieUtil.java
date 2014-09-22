package com.xsjrw.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 读取cookie的通用类，以Cookie[] 做参数传个构造函数；
 *
 * @author wangzx
 */
public class ComCookieUtil {
    private Cookie[] cookies;

    //    private IUnionTrackWebsiteDao unionTrackWebsiteDao;
    public ComCookieUtil(Cookie[] cs) {
        cookies = cs;
    }

    public ComCookieUtil() {

    }

    /**
     * 通过cookieName，取得cookieValue，如果没有此cookie则返回默认值
     *
     * @param cookieName
     * @param defaultValue
     * @return
     */
    public String getCookieValue(String cookieName, String defaultValue) {
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookieName.equals(cookie.getName()))
                return (cookie.getValue());
        }
        return (defaultValue);
    }

    /**
     * 类方法，通过cookieName，取得cookieValue
     *
     * @param cookies
     * @param cookieName
     * @param defaultValue
     * @return
     */
    public static String getCookieValue(Cookie[] cookies,
                                        String cookieName,
                                        String defaultValue) {
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName()))
                    return (cookie.getValue());
            }
        }
        return (defaultValue);
    }

    /**
     * cookie 删除方法所有
     */
    public static void removeCookieValue(Cookie[] cookies, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    /**
     * 删除已知cookie
     *
     * @param cookieName
     * @param response
     */
    public static void removeCookieValue(String cookieName, HttpServletResponse response) {
        Cookie newCookie = new Cookie(cookieName, null);      //假如要删除名称为username的Cookie

        newCookie.setMaxAge(0);             //立即删除型

        newCookie.setPath("/");               //项目所有目录均有效，这句很关键，否则不敢保证删除

        response.addCookie(newCookie);     //重新写入，将覆盖之前的
    }
    
    /**
     * 删除已知cookie
     *
     * @param cookieName
     * @param response
     */
    public static void removeNewCookieValue(String cookieName, String domain, HttpServletResponse response) {
        Cookie newCookie = new Cookie(cookieName, null);      //假如要删除名称为username的Cookie
        newCookie.setMaxAge(0);             //立即删除型
        newCookie.setPath("/");               //项目所有目录均有效，这句很关键，否则不敢保证删除
        newCookie.setDomain(domain);
        response.addCookie(newCookie);     //重新写入，将覆盖之前的
    }

    /**
     * 添加cookie方法
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, String ftype, HttpServletRequest request) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setComment(ftype);//链接类型（用cookieComment对象保存）
        if (maxAge > 0) cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
    
    /**
     * 添加cookie方法
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addNewCookie(HttpServletResponse response, String domain, String name, String value, int maxAge, String ftype, HttpServletRequest request) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setComment(ftype);//链接类型（用cookieComment对象保存）
        if(StringUtils.isNotBlank(domain)) {
        	cookie.setDomain(domain);
        }
        if (maxAge > 0) cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie的链接类型
     */
    public static String getCookieCommentByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie.getComment();
        } else {
            return null;
        }

    }

    /**
     * 获取cookie的Value值
     *
     * @param request
     * @param name    cookie的名称
     * @return
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (isHasCookie(request, name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     * 根据CookieName获取CookieValue，然后封装成Map
     *
     * @param cookies
     * @param request
     * @param cookieName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object[] getCookieMap(Cookie[] cookies, HttpServletRequest request, String cookieName, boolean ishascookie) {
        Object[] obj = new Object[10];
        if (null != cookies) {
            Map<String, Cookie> cookieMap = readCookieMap(request);
            Iterator it = cookieMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Entry) it.next();
                //得到联盟商中每个跟踪cookie
                Cookie cookie = (Cookie) entry.getValue();
                if (cookie.getValue().length() > 0 && cookie.getValue().indexOf("=>") > 0) {
                    //去掉大括号
                    String cookieValue = cookie.getValue().substring(1, cookie.getValue().length() - 1);
                    String[] cookieValues = cookieValue.split("=>");
                    obj[0] = cookieValues[0];
                    obj[1] = cookieValues[1].split("=")[0];
                    obj[2] = cookieValues[1].split("=")[1];
                    obj[3] = cookieValues[2];
                }

            }
        }
        return obj;
    }


    protected static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (int i = 0; i < cookies.length; i++) {
                //读取遍历联盟商的cookie的值
                if (cookies[i].getName().equals("cps")) {
                    cookieMap.put(cookies[i].getName(), cookies[i]);
                }
            }
        }
        return cookieMap;
    }

    /**
     * 根据cookieName中的ip地址来删除之前的cookie信息
     *
     * @param cookieName
     */
    public static void removeBeforeCookies(HttpServletResponse response, HttpServletRequest request, String cookieName) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey("cps")) {
            removeCookieValue("cps", response);
        }

        /*  Iterator it = cookieMap.entrySet().iterator();
        while(it.hasNext())
        {
             Map.Entry entry = (Entry) it.next();
             if(entry.getKey().toString().indexOf("_-")>0)
             {
                 //根据IP地址判断是否存在他之前记录的cookie信息
                 String sessionId = entry.getKey().toString().split("_-")[0];
                 String ipaddress = entry.getKey().toString().split("_-")[1];
                 //这里是购物车中传输过来的cookieName这里做截取
                 String newSessionId = cookieName.split("_-")[0].toString();
                 String newIpAdress = cookieName.split("_-")[1].toString();
                 //如果根据ip地址找到了cookie信息，则删除cookie信息
                 if(ipaddress.equals(newIpAdress))
                 {
                     removeCookieValue(entry.getKey().toString(),response);
                 }
             }
        }*/
    }

    /**
     * 根据cookieName判断是否用户是否存在cookie中
     *
     * @param cookieName
     * @param request
     * @return
     */
    public static boolean isHasCookie(HttpServletRequest request, String cookieName) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        //根据sessionId+"-_"+ip地址作为cookieName
        /*Iterator it = cookieMap.entrySet().iterator();
        while(it.hasNext())
        {
             Map.Entry entry = (Entry) it.next();
             if(entry.getKey().toString().indexOf("_-")>0)
             {
                 String sessionId = entry.getKey().toString().split("_-")[0];
                 String ipaddress = entry.getKey().toString().split("_-")[1];
                 
                 //这里是购物车中传输过来的cookieName这里做截取
                 String newSessionId = cookieName.split("_-")[0].toString();
                 String newIpAdress = cookieName.split("_-")[1].toString();
                 
                 //如果第二次没有通过点击跟踪代码，判断购物车传输过来的sessionId和cookie上次保存的sessionId是否一致
                 //如果sessionId不一致（一般都会不一致），则通过ip地址来进行二轮判断，
                 if(sessionId.equals(newSessionId) || ipaddress.equals(newIpAdress) )
                 {
                     return true;
                 }
             }
        }*/
        if (cookieMap.containsKey("cps")) {
            return true;
        }
        return false;

    }

    /**
     * 删除cookie信息
     *
     * @param request
     * @param response
     */
    public void removeTrackInfo(HttpServletRequest request, HttpServletResponse response) {
        String cookName = getCookieName(request);
        try {
            //取出完cookie数据以后，就马上删除cookie
            removeCookieValue(cookName, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取cookieName
     *
     * @param request
     */
    public static String getCookieName(HttpServletRequest request) {
        /*String sessionId ="LDYHpNgefCoX66VJoeyzkA__.jboss2";//request.getSession().getId();
        String ipAdress =  GetSessionUtil.getIpAddr(request);
        return sessionId+"_-"+ipAdress;*/
        return "cps";
    }


    public static void main(String[] args) {
        String cps = "84FED1466FC4001C73A78C5670FB55E7A865AE0312BD2E35BBD8F5B1984CF3ACD86C55ECF6C12F61";

        String result = "";
        Object[] obj = new Object[10];//数组长度
        //将读取出来的cookie的value值进行DES算法解密
//        String cookieV = DesUtil.decrypt(cps);
//
//        if (cookieV.length() > 0 && cookieV.indexOf("=>") > 0) {
//            //去掉大括号
//            String cookieValue = cookieV.substring(1, cookieV.length() - 1);
//            String[] cookieValues = cookieValue.split("=>");
//            obj[0] = cookieValues[0];
//            if (cookieValues[1].indexOf("=") > 0) {
//                obj[1] = cookieValues[1].substring(0, cookieValues[1].indexOf("="));
//                obj[2] = cookieValues[1].substring(cookieValues[1].indexOf("=") + 1, cookieValues[1].length());
//            }
//            /* obj[1] = cookieValues[1].split("=")[0];
//              obj[2] = cookieValues[1].split("=")[1];
//            */
//            obj[3] = cookieValues[2];
//        }
        //obj = getCookieMap(cookies,request,cookieName,ishascookie);//取出cookie

        result = obj[0] + "=>" + obj[1] + "=>" + obj[2] + "=>" + obj[3];
        System.out.println(result);
    }

}


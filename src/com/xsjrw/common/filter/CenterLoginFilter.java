package com.xsjrw.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.xsjrw.common.constans.UserConstans;
  
/** 
 * 前台登录过滤 
 *  
 * @author geloin 
 * @date 2014-11-10 下午2:37:38 
 */  
public class CenterLoginFilter extends OncePerRequestFilter {  
  
    /* 
     * (non-Javadoc) 
     * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal( 
     * javax.servlet.http.HttpServletRequest, 
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain) 
     */  
    @Override  
    protected void doFilterInternal(HttpServletRequest request,  
            HttpServletResponse response, FilterChain filterChain)  
            throws ServletException, IOException {  
  
  
        // 请求的uri  
        String uri = request.getRequestURI();  
  
        // uri中包含background时才进行过滤  
        if (uri.startsWith("/center")) {  
            // 是否过滤  
            boolean doFilter = true;  
            if (doFilter) {
                // 执行过滤  
                // 从session中获取登录者实体  
                Object obj = request.getSession().getAttribute(UserConstans.USER_LOGIN);  
                if (null == obj) {  
                    // 如果session中不存在登录者实体，则弹出框提示重新登录  
                    // 设置request和response的字符集，防止乱码  
                    request.setCharacterEncoding("UTF-8");  
                    response.setCharacterEncoding("UTF-8");  
                    PrintWriter out = response.getWriter();  
                    String loginPage = "/user/goTOLogin.go";  
                    StringBuilder builder = new StringBuilder();  
                    builder.append("<script type=\"text/javascript\">");  
                    builder.append("window.top.location.href='");  
                    builder.append(loginPage);  
                    builder.append("';");  
                    builder.append("</script>");  
                    out.print(builder.toString());  
                } else {  
                    // 如果session中存在登录者实体，则继续  
                    filterChain.doFilter(request, response);  
                }  
            } else {  
                // 如果不执行过滤，则继续  
                filterChain.doFilter(request, response);  
            }  
        } else {  
            // 如果uri中不包含background，则继续  
            filterChain.doFilter(request, response);  
        }
    }  
  
}
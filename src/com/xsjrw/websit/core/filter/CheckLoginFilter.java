package com.xsjrw.websit.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xsjrw.websit.core.util.UserHolder;

public class CheckLoginFilter implements Filter {
	
	
	//不需要登录的页面
	private static String[] noLoginPage = { 
		
	}; 
	
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String url = request.getServletPath();
		String uri = getUri(request);

		// 过滤出不需要验证的资源(包括静态项目、js、css、图片登陆资源以及不过滤列表)
		if (isNoCheckResource(uri) || isNoLoginPage(url)) {
			filterChain.doFilter(request, response);
			return;
		}
		
//		if(!isLogin(request)){
//			// 重定向到指定页面
//			
//			return;
//		}
		
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

	private boolean isLogin(HttpServletRequest request){
		return UserHolder.getCurrentUser(request) != null;
	}
	
	private boolean isNoLoginPage(String url){
		for(int i = 0; i < noLoginPage.length; i++){
        	if(url.startsWith(noLoginPage[i])){
        		return true;
        	}
        }
		return false;
	}
	
	/**
	 * 筛选出不需要验证的资源<br/>
	 * 
	 * @param uri
	 * @return
	 */
	private boolean isNoCheckResource(String uri) {
		return uri.startsWith("/resources/") || uri.endsWith(".js")
				|| uri.endsWith(".css") || uri.endsWith(".jpg")
				|| uri.endsWith(".gif") || uri.endsWith(".png")
				|| uri.endsWith(".dwr") || uri.endsWith(".ico");
	}

	/**
	 * 获取uri
	 */
	private String getUri(HttpServletRequest request) {
		return request.getServletPath()
				+ (request.getPathInfo() == null ? "" : request.getPathInfo());
	}

}

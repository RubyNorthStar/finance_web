package com.xsjrw.websit.core.util;

import javax.servlet.http.HttpServletRequest;

import com.xsjrw.websit.core.exception.LoginExpiredException;
import com.xsjrw.websit.domain.user.Users;

public class UserHolder {
	
	private static final String LOGIN_USER = "tiku_loginUser";
	
	public static Users getCurrentUser(HttpServletRequest request){
		Object obj = request.getSession().getAttribute(LOGIN_USER);
		if(obj != null){
			Users user = (Users)obj;
			return user;
		}
		return null;
	}
	
	public static void setCurrentUser(HttpServletRequest request,Users user){
		if(user == null){
			throw new LoginExpiredException("您的登录操作无效！");
		}
		request.getSession().setAttribute(LOGIN_USER, user);
	}
	
	public static void distoryCurrentUser(HttpServletRequest request){
		request.getSession().invalidate();
	}
	
}

package com.xsjrw.websit.core.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.xsjrw.websit.core.exception.LoginExpiredException;
import com.xsjrw.websit.core.util.UserHolder;
import com.xsjrw.websit.domain.user.Users;

public class BaseWebController {
	
	private Logger logger = Logger.getLogger(BaseWebController.class);
	
	protected Users getCurrentUser(HttpServletRequest request){
		Users user = UserHolder.getCurrentUser(request);
		if(user != null){
			return user;
		}
		logger.info("User is expired!");
		throw new LoginExpiredException("您长时间没有操作，系统已经自动将您退出，要继续操作请重新登录！");
	}
	
	protected Integer getCurrentUserId(HttpServletRequest request){
		Users user = getCurrentUser(request);
		return user.getId();
	}
	
	protected String getCurrentUserName(HttpServletRequest request){
		Users user = getCurrentUser(request);
		return user.getUsername();
	}
	
}

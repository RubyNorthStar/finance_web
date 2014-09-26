package com.xsjrw.common.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.websit.domain.user.Users;


public class UserSessionListener implements HttpSessionBindingListener {

	private static Logger logger = LoggerFactory.getLogger(UserSessionListener.class);
	
	private Users user;
	
	public UserSessionListener(Users user) {
        this.user = user;
    }
	
	public UserSessionListener(){
		
	}
	
	public void setUser(Users user) {
	   this.user = user;
	}
	 
	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

		HttpSession session = httpSessionBindingEvent.getSession();
        session.setAttribute(UserConstans.USER_LOGIN, user);
        logger.info("新用户 {} 登录开始记录用户日志", user.getUsername());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		
		logger.info("用户 {} 注销,已经结束监听", user.getUsername());
        HttpSession session = httpSessionBindingEvent.getSession();
        
        try {
            //如果这句没抛出异常就是正常登出，反之则是超时
            session.removeAttribute(UserConstans.USER_LOGIN);
        } catch (IllegalStateException e) {
            logger.info("session超时");
        } finally {
        	
        }
	}

}

package com.xsjrw.websit.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 应用工具类，提供如下功能
 * 静态方法获取spring的ApplicationContext
 * 静态方法获取spring容器内指定名称的javabean
 *
 */
public class ApplicationUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		applicationContext = ctx;
	}

	/**
	 * 获取spring的ApplicationContext
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取spring容器内指定名称的javabean
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return ApplicationUtil.getApplicationContext().getBean(name);
	}

}

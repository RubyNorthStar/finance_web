package com.xsjrw.websit.controller.admin;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
/**
 * @author Zhiwei Wang
 */
@RequestMapping("/admin/master")
public class MasterController {
	public static final String MASTER = "master";

	/**
	 * 去登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String goLogin() {
		System.out.println("aaaaaaaaaaa");
		return "admin/master/login";
	}
}

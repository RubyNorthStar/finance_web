package com.xsjrw.websit.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.websit.domain.user.Users;

@Controller
@RequestMapping("/center/user")
public class UserCenterController {
	
	
	/**
	 * 个人中心
	 * @param modle
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/center")
	public String center(Model modle, HttpServletRequest request){
		Users user = (Users) request.getSession().getAttribute(UserConstans.USER_LOGIN);
		System.out.println(user);
		return "user/center";
	}
}

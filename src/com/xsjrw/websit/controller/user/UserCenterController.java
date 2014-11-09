package com.xsjrw.websit.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.common.util.MD5;
import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.service.user.IUserService;

@Controller
@RequestMapping("/center/user")
public class UserCenterController {
	
	@Autowired
	protected IUserService userService;
	/**
	 * 个人中心
	 * @param modle
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/center")
	public String center(Model modle, HttpServletRequest request){
		//从session中获取User信息
		Users user = (Users) request.getSession().getAttribute(UserConstans.USER_LOGIN);
		System.out.println(user);
		
		return "user/center_user_info";
	}
	
	@RequestMapping(value="/updataPass")
	public String centerUpdataPass(Model modle, HttpServletRequest request){
		return "user/center_updata_pass";
	}
	
	@ResponseBody
	@RequestMapping(value="updataUserPass")
	public String updataUserPass(String oldPass, String newPass, String newSurePass, HttpServletRequest request){
		String result = null;
		Users user = (Users) request.getSession().getAttribute(UserConstans.USER_LOGIN);
		
		if(oldPass != null && newPass != null && newSurePass != null){
			if(user != null && user.getPassword() != null){
				if(!MD5.getMD5(oldPass).equals(user.getPassword())){
					return "1";
				}else if(newPass.equals(newSurePass)){
					user.setPassword(MD5.getMD5(newPass));
					userService.editUser(user);
					return "2";
				}else{
					return "3";
				}
			}
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="changeUserInfo")
	public String changeUserInfo(Model modle, String mobile, HttpServletRequest request){
		Users user = (Users) request.getSession().getAttribute(UserConstans.USER_LOGIN);
		String result = null;
		try {
			user.setMobile(mobile);
			userService.editUser(user);
			result = "1";
		} catch (Exception e) {
			result = "0";
		}
		return result;
	}
}

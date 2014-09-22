package com.xsjrw.websit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsjrw.common.util.MD5;
import com.xsjrw.websit.core.domain.BaseWebController;
import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.search.user.UsersSearch;
import com.xsjrw.websit.service.IUserService;

/**
 * Login 控制器
 * 
 * @author wangzhixing
 * @date 2014-09-12
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseWebController{
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	protected IUserService userService;
	
	/**
	 * 
	 * goToRegister(跳转到注册页面)
	 * @return
	 * String
	 * @exception
	 * @since  1.0.0
	 */
	
	@RequestMapping(value = "/goTORegister")
	public String goToRegister(){
		return "user/registe";
	}
	
	@RequestMapping(value = "/goTOLogin")
	public String goTOLogin(){
		return "user/login";
	}
	
	/**
	 * 2014.09.16用户登录，异步 增加对用户名、密码分别验证情况
	 */
	@ResponseBody
	@RequestMapping("/login")
	public String signin(String email, String password, String remember, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = "faile";
		
		try {
			password = MD5.getMD5(password);
			List<Users> user = userService.findUserByEmailAndPassWord(email, password);
			if(user != null && user.size() > 0){
				request.getSession().setAttribute("loginaccount_customer", user.get(0));
				result = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		return result;
//		return "{'result','"+result +"'}";
		return "{\"result\":\"" + result + "\"}";
	}

	/**
	 *用户注册
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/register")
	public String register(Model model,Users user,HttpServletRequest request) {
		String result = "faile";
		try{
			String passWord = user.getPassword();
			user.setPassword(MD5.getMD5(passWord));
			userService.saveUser(user);
			result = "success";
		}catch(Exception e){
			e.printStackTrace();
			logger.info("注册出错");
			result = "faile";
		}
		return result;
	}
	
	/**
	 *批量新增
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/batchSave")
	public String batchSave(Model model,HttpServletRequest request) {
		String result = "faile";
		try{
			List<Users> users = new ArrayList<Users>();
			Users user1 = new Users();
			user1.setUsername("测试1");
			Users user2 = new Users();
			user2.setUsername("测试2");
			Users user3 = new Users();
			user3.setUsername("测试3");
			users.add(user1);
			users.add(user2);
			users.add(user3);
			userService.batchSaveUser(users);
			result = "success";
		}catch(Exception e){
			e.printStackTrace();
			logger.info("批量新增出错");
			result = "faile";
		}
		return result;
	}
	
	/**
	 *用户修改
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String edit(Model model,Users user,HttpServletRequest request) {
		String result = "faile";
		try{
			userService.editUser(user);
			result = "success";
		}catch(Exception e){
			e.printStackTrace();
			logger.info("修改出错");
			result = "faile";
		}
		return result;
	}
	
	/**
	 *用户删除
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(Model model,Integer id,HttpServletRequest request) {
		String result = "faile";
		try{
			userService.deleteUserById(id);
			result = "success";
		}catch(Exception e){
			e.printStackTrace();
			logger.info("修改出错");
			result = "faile";
		}
		return result;
	}
	
	/**
	 *分页查询
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/pageList")
	public String pageList(Model model,UsersSearch search,HttpServletRequest request) {
		List<Users> users = userService.findUserByPage(search);
		model.addAttribute("users", users);
		return "";
	}
	
}

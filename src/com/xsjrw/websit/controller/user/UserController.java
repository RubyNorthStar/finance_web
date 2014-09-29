package com.xsjrw.websit.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.common.listener.UserSessionListener;
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
	public List<Users> signin(String email, String password, String remember, HttpServletRequest request, HttpServletResponse response){
		List<Users> user = null;
		
		try {
			password = MD5.getMD5(password);
			user = userService.findUserByEmailAndPassWord(email, password);
			if(user != null && user.size() > 0){
				// 监听用户的行为，包括把用户信息放入session的操作
				listenerUserSession(request.getSession(), user.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	@ResponseBody
	@RequestMapping("/verificat_email")
	public List<Users> verificatEmail(String email){
		List<Users> user = null;
		try {
			user = userService.findUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	/**
	 *用户注册
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register")
	public String register(Model model,Users user,HttpServletRequest request) {
		String result = "faile";
		String ym_yzm = request.getParameter("yzm");// 页面验证码
		String xs_sessionYzm = (String) request.getSession().getAttribute(UserConstans.XS_SESSIONID);  //服务器验证码
		
		//判断验证码是否相同，不同则直接返回
		if(ym_yzm == null || xs_sessionYzm == null || !ym_yzm.toUpperCase().equals(xs_sessionYzm.subSequence(0, 4))){
			return result;
		}
		
		try{
			String passWord = user.getPassword();
			user.setPassword(MD5.getMD5(passWord));
			user.setRegistTime(new Date());
			user.setState(1);
			userService.saveUser(user);
			
			/* 注册完毕之后将用户信息存入session中 */
			UsersSearch usersSearch = new UsersSearch();
			usersSearch.setEmail(user.getEmail());
			List<Users> userList = new ArrayList<Users>();
			userList = (List<Users>) userService.findUserByPage(usersSearch);
			
			if (userList != null && userList.size() != 0) {
				// 监听用户的行为，包括把用户信息放入session的操作
				listenerUserSession(request.getSession(), user);
			}
			
			result = "success";
		}catch(Exception e){
			e.printStackTrace();
			logger.info("注册出错");
			result = "faile";
		}
		return result;
	}
	
	/**
	 * 用户登出
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public String loginOut(Model model, HttpServletRequest request) {
		
		if (request.getSession().getAttribute(UserConstans.USER_LISTENER) != null) {
			request.getSession().removeAttribute(UserConstans.USER_LISTENER);
		}
		
		return "redirect:goTORegister";
		
//		if (request.getSession().getAttribute(Constans.USER_LOGIN) != null) {
//			request.getSession().removeAttribute(Constans.USER_LOGIN);
//		}
//		if (questionloginOut != null
//				&& questionloginOut.equals("questionLoginOut")) {
//			return "redirect:" + Constans.QE_TIKU_INDEX;
//		}
//		return "redirect:" + Constans.QE_TIKU_INDEX;
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
	
	// 从private 改成 public 过滤器有调用
	public void listenerUserSession(HttpSession session, Users user) {
		if (session.getAttribute(UserConstans.USER_LOGIN) == null) {
			UserSessionListener userSessionListener = new UserSessionListener();
			userSessionListener.setUser(user);
			session.setAttribute(UserConstans.USER_LISTENER, userSessionListener);
		}
	}
	
}

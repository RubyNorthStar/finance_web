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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plat.common.mail.pojo.Email;
import com.plat.common.mail.service.spi.EmailService;
import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.common.listener.UserSessionListener;
import com.xsjrw.common.util.DateCalcUtil;
import com.xsjrw.common.util.JsonUtil;
import com.xsjrw.common.util.MD5;
import com.xsjrw.common.util.StringOperUtils;
import com.xsjrw.websit.core.domain.BaseWebController;
import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.search.user.UsersSearch;
import com.xsjrw.websit.service.user.IUserService;

/**
 * Login 控制器
 * 
 * @author wang.zx
 * @date 2014-09-12
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseWebController{
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	protected IUserService userService;
	
	@Autowired
    private EmailService emailService;
	
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
	public String signin(String email, String password, String remember, HttpServletRequest request, HttpServletResponse response){
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
		
		try {
			String a = JsonUtil.getJSONString(user.get(0));
			System.out.println(a);
			return a ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/verificat_email")
	public String verificatEmail(String email){
		List<Users> user = null;
		String a = "";
		try {
			user = userService.findUserByEmail(email);
			if(user.size() > 0){
				a = JsonUtil.getJSONString(user.get(0));
			}
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return a;
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
		if(ym_yzm == null || xs_sessionYzm == null || !ym_yzm.toUpperCase().equals(xs_sessionYzm.substring(0, 4).toUpperCase())){
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
		
		return "redirect:/index.go";
		
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
	
	/** 找回密码开始 */
	
    /**
     * 前往密码重置页面
     *
     * @return
     */
    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public String forgotPassword() {
    	System.out.println("进来了");
        return "user/findBackPassword";
    }
    
    /**
     * 密码找回邮件地址提交
     *
     * @param model
     * @param email
     * @param request
     * @return
     */
    @RequestMapping(value = "/forgot-submit", method = RequestMethod.POST)
    public String forgotPasswordSubmit(Model model,  String email, HttpServletRequest request) {
        // 判断用户所输入的电子邮件地址是否存在或者邮件输入是否合法
    	List<Users> user = userService.findUserByEmail(email);
    	
        if (user == null ) {
            // 不存在则返还验证失败信息
            logger.debug("系统中没有找到此邮箱");
            model.addAttribute("email", email);
            return "/user/findBackPassword";
        }
        if (!StringOperUtils.validateEmail(email)) {
            // 不存在则返还验证失败信息
            logger.debug("所填邮箱不合法");
            model.addAttribute("email", email);
            return "/user/findBackPassword";
        }
        // 存在则获取用户信息
//        Users user = userService.findUserByEmail(email);
        Date sendEmailDate = new Date();
        // 获得通行证的密钥,密码找回使用
        String emailPassport = MD5.getMD5(user.get(0).getId() + "$" + sendEmailDate.getTime());
        String hostUrl = "";
        String urls = request.getServerName()+ ":" +request.getServerPort();
        
        hostUrl = "http://" + urls;
        // 获得域名
        String url = hostUrl + "/user/change-password/" + user.get(0).getId() + "/" + emailPassport+".go";
        // 拼装email的内容
        Email emailContent = userService.getEmailFormat(user.get(0), url);
            
            
        // 发送邮件
        try {
            emailService.send(emailContent);
        } catch (Exception e) {
            logger.info("发送找回密码邮件失败，具体信息如下:{}"+ e.getMessage());
            e.printStackTrace();
        }
        
        user.get(0).setAuthCode(emailPassport);
        user.get(0).setAuthSendtime(sendEmailDate);
        userService.editUser(user.get(0));
        
        return "/user/sendResetPasswdSuccess";
    }
    
    
    @RequestMapping(value = "/change-password/{id}/{passport}", method = RequestMethod.GET)
    public String changePassword(Model model, HttpServletRequest request, @PathVariable(value = "id") Integer id, @PathVariable(value = "passport") String passport) {
        Date currDate = new Date();
        Users user = userService.findUserById(id);
        Date sendDate = user.getAuthSendtime();
        //验证密码找回邮件的有效时间
        if (!StringOperUtils.equals(passport, user.getAuthCode()) || DateCalcUtil.dateDiff(sendDate, currDate) > 24) {
            model.addAttribute("message", "邮件已超时或者已失效，请重新修改密码");
            return "/user/changePasswdFail";
        }
        //用户登陆
        request.getSession().setAttribute(UserConstans.USER_LOGIN, user);
        model.addAttribute("email", user.getEmail());
        model.addAttribute("id", user.getId());
        return "/user/changePassword";
    }
    
    @ResponseBody
    @RequestMapping(value = "/changePasswordNew", method = RequestMethod.POST)
    public String changePasswordNew(Model model, @RequestParam(value = "user_id") int user_id, @RequestParam(value = "newPassword") String newPassword) {
    	try {
    		 Users user = userService.findUserById(user_id);
        	 user.setPassword(MD5.getMD5(newPassword));
             user.setAuthCode(MD5.getMD5(user.getId() + "$" + new Date().getTime()));
             userService.editUser(user);
		} catch (Exception e) {
			return "-1";
		}
    	
         return "1";
    }
    
    /** 找回密码结束 */
	
}

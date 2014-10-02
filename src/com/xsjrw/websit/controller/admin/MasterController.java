package com.xsjrw.websit.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.dto.MasterDTO;
import com.xsjrw.websit.service.IMasterService;

@Component
/**
 * @author Zhiwei Wang
 */
@RequestMapping("/admin/master")
public class MasterController {
	@Autowired IMasterService masterService;

	/**
	 * 去登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String goLogin() {
		System.out.println("aaaaaaaaaaa");
		return "admin/master/login";
	}
	
	/**
	 * 执行登陆请求
	 * @return
	 */
	@RequestMapping("/executeLogin")
	public String executeLogin(HttpServletRequest request) {
		MasterDTO masterDTO = new MasterDTO();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String validateCode = request.getParameter("validateCode");
		if(StringUtils.isNotBlank(account) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(validateCode)){
			HttpSession session = request.getSession(true);
		    String sessionId = session.getId();
		    validateCode = validateCode+"_"+sessionId;
			Object validatec = request.getSession().getAttribute(UserConstans.XS_SESSIONID);
			if(validatec != null && !StringUtils.isBlank(String.valueOf(validatec)) && !StringUtils.isBlank(validateCode)){
				if(String.valueOf(validatec.toString().toLowerCase()).equals(validateCode.toLowerCase())){
					if(!StringUtils.isBlank(account)){
						List<Master> masterList = masterService.obtainMasterListBuyAccount(account);
						if(masterList != null){
							if(masterList.size() > 1){
								masterDTO.setFlag("1010");//该用户名有多个用户
								return "admin/master/login";
							}else{
								Master master = masterList.get(0);
								String pass = master.getPassword();
								if(password.trim().equals(pass.trim())){
									if(master.getForbidden() == 0){
										masterDTO.setFlag("1006");//登陆失败，该账户已被禁用
										return "admin/master/login";
									}
									
									request.getSession().setAttribute(UserConstans.MASTER_LOGIN, master);
									
									masterDTO.setFlag("1005"); //登陆成功
									return "admin/master/success";
								}else{
									masterDTO.setFlag("1004");//登陆失败，密码不正确
								}
							}
						}else{
							masterDTO.setFlag("1003");//登陆失败，该用户不存在
						}
					}else{
						masterDTO.setFlag("1002");//登陆失败，登录名不能为空
					}
				}else{
					masterDTO.setFlag("1008");//登陆失败，验证码不正确
					return "admin/master/login";
				}
			}else{
				masterDTO.setFlag("1007");//登陆失败，验证码不能为空
				return "admin/master/login";
			}
		}else{
			masterDTO = new MasterDTO();
			masterDTO.setFlag("1001");//登陆失败，登录名和密码不能为空
		}
		
		return "admin/master/login";
	}
}

package com.xsjrw.websit.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.dto.MasterDTO;
import com.xsjrw.websit.search.admin.MasterSearch;
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
	public String goLogin(Model model,HttpServletRequest request) {
		Master master = (Master)request.getSession().getAttribute(UserConstans.MASTER_LOGIN);
		if(master != null && StringUtils.isNotBlank(master.getAccount())){
			MasterDTO masterDTO = new MasterDTO();
			masterDTO.setFlag("1005"); //登陆成功
			model.addAttribute("masterDTO", masterDTO);
			return "admin/master/success";
		}
		return "admin/master/login";
	}
	
	/**
	 * 执行登陆请求
	 * @return
	 */
	@RequestMapping("/executeLogin")
	public String executeLogin(Model model,HttpServletRequest request) {
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
							}else{
								Master master = masterList.get(0);
								String pass = master.getPassword();
								if(password.trim().equals(pass.trim())){
									if(master.getForbidden() == 0){
										masterDTO.setFlag("1006");//登陆失败，该账户已被禁用
									}
									
									request.getSession().setAttribute(UserConstans.MASTER_LOGIN, master);
									
									masterDTO.setFlag("1005"); //登陆成功
									model.addAttribute("masterDTO", masterDTO);
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
				}
			}else{
				masterDTO.setFlag("1007");//登陆失败，验证码不能为空
			}
		}else{
			masterDTO = new MasterDTO();
			masterDTO.setFlag("1001");//登陆失败，登录名和密码不能为空
		}
		model.addAttribute("masterDTO", masterDTO);
		return "admin/master/login";
	}
	
	@RequestMapping("/obtainMasterList")
	public String obtainMasterList(Model model,HttpServletRequest request, MasterSearch masterSearch){
		if (masterSearch == null) {
			masterSearch = new MasterSearch();
		}
		
		model.addAttribute("masterList", masterService.obtainMasterList(masterSearch));
		model.addAttribute("masterSearch", masterSearch);
		
		return "admin/master/master_list";
	}
	
	/**
	 * 去添加管理员页面
	 * @return
	 */
	@RequestMapping("/goAddMaster")
	public String goAddMaster() {
		return "admin/master/master_add";
	}
	
	/**
	 * 执行管理员添加操作
	 * @return
	 */
	@RequestMapping("/goExecuteAddMaster")
	public String goExecuteAddMaster(Model model,HttpServletRequest request, Master master) {
		String flag = "1003";
		if(master != null){
			String account = master.getAccount();
			if(!StringUtils.isBlank(account)){
				List<Master> masterList = masterService.obtainMasterListBuyAccount(account);
				if(masterList != null && masterList.size() > 0){
					flag = "1004";//添加失败，该账号已存在
				}else{
					masterService.saveMaster(master);
					flag = "1003";//保存成功。
				}
			}else{
				flag = "1002";//保存失败，账号不能为空
			}
		}else{
			flag = "1001";//保存失败，保存信息为空
		}
		model.addAttribute("returnMaster", master);
		model.addAttribute("flag", flag);
		return "admin/master/master_add";
	}
	
	/**
	 * 去更新管理员页面
	 * @return
	 */
	@RequestMapping("/goUpdateMaster")
	public String goUpdateMaster(Model model,HttpServletRequest request, Integer id) {
		if(id != null){
			Master returnMaster = new Master();
			Master master = masterService.obtainMasterBuyId(id);
			if(master != null){
				returnMaster.setMtId(master.getMtId());
				returnMaster.setAccount(master.getAccount());
				returnMaster.setPassword(master.getPassword());
				returnMaster.setEmail(master.getEmail());
				returnMaster.setForbidden(master.getForbidden());
				returnMaster.setMobile(master.getMobile());
				returnMaster.setName(master.getName());
				returnMaster.setPosition(master.getPosition());
				returnMaster.setTelephone(master.getTelephone());
			}
			
			model.addAttribute("returnMaster", returnMaster);
		}
		return "admin/master/master_update";
	}
	
	/**
	 * 执行更新管理员页面
	 * @return
	 */
	@RequestMapping("/executeUpdateMaster")
	public String executeUpdateMaster(Model model,HttpServletRequest request, Master master) {
		String flag = "1001";
		if(master != null){
			if(master.getMtId() != null){
				master = masterService.updateMaster(master);
				if(master != null){
					flag = "1001";//更新成功
				}else{
					flag = "1004";//更新失败，没有像匹配对象
				}
			}else{
				flag = "1003";//更新失败，传输对象为空
			}
		}else{
			flag = "1002";//更新失败，传输对象为空
		}
		model.addAttribute("returnMaster", master);
		model.addAttribute("flag", flag);
		return "admin/master/master_update";
	}
}

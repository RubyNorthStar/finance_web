package com.xsjrw.websit.controller.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsjrw.common.util.JsonUtil;
import com.xsjrw.websit.domain.user.VipUser;
import com.xsjrw.websit.search.user.VipUserSearch;
import com.xsjrw.websit.service.user.IVipUserService;

/**
 * Controller of VipUser
 * @author wang.zx
 * @date 2014-10-7
 */
@Controller
@RequestMapping("/vipUser")
public class VipUserController {
	
	@Autowired
	private IVipUserService vipUserServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, VipUserSearch search){
		if (search == null) {
			search = new VipUserSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", vipUserServiceImpl.findVipUserByPage(search));
		return "vipUser/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(VipUser VipUser) {
		String result = "1";
		try {
			vipUserServiceImpl.saveVipUser(VipUser);
			result = "2";
		} catch (Exception e) {
			e.printStackTrace();
		}
		result = "{\"result\":\""+result+"\"}";
		return result;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(VipUser VipUser) {
		vipUserServiceImpl.update(VipUser);
		return "redirect:/vipUser";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		vipUserServiceImpl.deleteVipUserById(id);
		return "redirect:/vipUser";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public VipUser getJson(Model model, @PathVariable Integer id){
		return vipUserServiceImpl.findVipUserById(id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}

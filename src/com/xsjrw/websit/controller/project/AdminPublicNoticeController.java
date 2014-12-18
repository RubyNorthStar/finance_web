package com.xsjrw.websit.controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.domain.project.PublicNotice;
import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.search.project.IndustrySearch;
import com.xsjrw.websit.search.project.PublicNoticeSearch;
import com.xsjrw.websit.service.project.IIndustryService;
import com.xsjrw.websit.service.project.IPublicNoticeService;

/**
 * Controller of PublicNotice
 * @author wang.zx
 * @date 2014-11-4
 */
@Controller
@RequestMapping("/admin/publicNotice")
public class AdminPublicNoticeController {
	
	@Autowired
	private IPublicNoticeService publicNoticeService;
	
	@Autowired
	private IIndustryService industryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, PublicNoticeSearch search){
		if (search == null) {
			search = new PublicNoticeSearch();
			// search.setPageSize(20);
		}
		search.setStatus(1);
		search.setPageSize(2);
		
		List<PublicNotice> proList = publicNoticeService.findPublicNoticeByPage(search);
		
		for(PublicNotice info : proList){
			Integer proIndustryId = info.getIndustryId();
			if(proIndustryId != null && proIndustryId > 0){
				Industry industry = industryService.findIndustryById(proIndustryId);
				info.setSource(industry.getIndustryName());
			}
		}
		
		model.addAttribute("list", proList);
		model.addAttribute("search", search);
		return "project/admin/public_info_list";
	}
	
	@RequestMapping(value="detail")
	public String detail(Model model, Integer id){
		
		PublicNotice publicNotice = publicNoticeService.findPublicNoticeById(id);
		model.addAttribute("publicNotice", publicNotice);
				
		return "project/admin/public_info_detail";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(PublicNotice PublicNotice) {
		publicNoticeService.savePublicNotice(PublicNotice);
		return "redirect:/publicNotice";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(PublicNotice PublicNotice) {
		publicNoticeService.update(PublicNotice);
		return "redirect:/publicNotice";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		publicNoticeService.deletePublicNoticeById(id);
		return "redirect:/publicNotice";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public PublicNotice getJson(Model model, @PathVariable Integer id){
		return publicNoticeService.findPublicNoticeById(id);
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
	
	@RequestMapping(value="publicNotice", method = RequestMethod.GET)
	public String publicNoticeGet(Model model, HttpServletRequest request){
		
		IndustrySearch search = new IndustrySearch();
		search.setPageSize(40);
		search.setStatus(1);
		
		List<Industry> industryList = industryService.findIndustryByPage(search);
		model.addAttribute("industryList", industryList);
		
		return "project/add_public_notice";
	}
	
	@RequestMapping(value="publicNotice", method = RequestMethod.POST)
	public String publicNotice(Model model,PublicNotice publicNotice, HttpServletRequest request){
		//从session中获取User信息
		Users user = (Users) request.getSession().getAttribute(UserConstans.USER_LOGIN);
		if(publicNotice != null){
			publicNotice.setStatus(1);
			publicNotice.setCreateTime(new Date());
			publicNotice.setUserId(user.getId());
			publicNoticeService.savePublicNotice(publicNotice);
		}
		
		model.addAttribute("project", 2);
		return "project/success";
	}
	
}

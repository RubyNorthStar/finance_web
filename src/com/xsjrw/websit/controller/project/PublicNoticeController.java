package com.xsjrw.websit.controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.domain.project.PublicNotice;
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
@RequestMapping("/center/publicNotice")
public class PublicNoticeController {
	
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
		model.addAttribute("list", publicNoticeService.findPublicNoticeByPage(search));
		return "publicNotice/list";
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
		if(publicNotice != null){
			publicNotice.setStatus(1);
			publicNotice.setCreateTime(new Date());
			publicNoticeService.savePublicNotice(publicNotice);
		}
		model.addAttribute("project", "2");
		return "project/success";
	}
	
}

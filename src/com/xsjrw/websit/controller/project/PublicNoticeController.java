package com.xsjrw.websit.controller.project;

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

import com.xsjrw.websit.domain.project.PublicNotice;
import com.xsjrw.websit.search.project.PublicNoticeSearch;
import com.xsjrw.websit.service.project.IPublicNoticeService;

/**
 * Controller of PublicNotice
 * @author wang.zx
 * @date 2014-11-4
 */
@Controller
@RequestMapping("/publicNotice")
public class PublicNoticeController {
	
	@Autowired
	private IPublicNoticeService publicNoticeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, PublicNoticeSearch search){
		if (search == null) {
			search = new PublicNoticeSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", publicNoticeServiceImpl.findPublicNoticeByPage(search));
		return "publicNotice/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(PublicNotice PublicNotice) {
		publicNoticeServiceImpl.savePublicNotice(PublicNotice);
		return "redirect:/publicNotice";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(PublicNotice PublicNotice) {
		publicNoticeServiceImpl.update(PublicNotice);
		return "redirect:/publicNotice";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		publicNoticeServiceImpl.deletePublicNoticeById(id);
		return "redirect:/publicNotice";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public PublicNotice getJson(Model model, @PathVariable Integer id){
		return publicNoticeServiceImpl.findPublicNoticeById(id);
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

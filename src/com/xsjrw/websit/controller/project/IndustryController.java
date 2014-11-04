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

import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.search.project.IndustrySearch;
import com.xsjrw.websit.service.project.IIndustryService;

/**
 * Controller of Industry
 * @author wang.zx
 * @date 2014-10-30
 */
@Controller
@RequestMapping("/industry")
public class IndustryController {
	
	@Autowired
	private IIndustryService industryServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, IndustrySearch search){
		if (search == null) {
			search = new IndustrySearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", industryServiceImpl.findIndustryByPage(search));
		return "industry/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Industry Industry) {
		industryServiceImpl.saveIndustry(Industry);
		return "redirect:/industry";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Industry Industry) {
		industryServiceImpl.update(Industry);
		return "redirect:/industry";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		industryServiceImpl.deleteIndustryById(id);
		return "redirect:/industry";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Industry getJson(Model model, @PathVariable Integer id){
		return industryServiceImpl.findIndustryById(id);
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

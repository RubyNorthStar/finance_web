package com.xsjrw.websit.controller.admin;

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

import com.xsjrw.websit.domain.article.ArticleInfoType;
import com.xsjrw.websit.search.article.ArticleInfoTypeSearch;
import com.xsjrw.websit.service.article.IArticleInfoTypeService;

/**
 * Controller of ArticleInfoType
 * @author wang.zx
 * @date 2014-10-6
 */
@Controller
@RequestMapping("/admin/articleInfoType")
public class ArticleInfoTypeController {
	
	@Autowired
	private IArticleInfoTypeService articleInfoTypeServiceImpl;
	
	@RequestMapping("/list")
	public String list(Model model, ArticleInfoTypeSearch search){
		if (search == null) {
			search = new ArticleInfoTypeSearch();
		}
		model.addAttribute("list", articleInfoTypeServiceImpl.findArticleInfoTypeByPage(search));
		model.addAttribute("search", search);
		return "admin/article/article_info_type_list";
	}
	
	@RequestMapping(value="/add")
	public String addArticleInfoType() {
		return "admin/article/article_info_type_add";
	}

	@RequestMapping(value="/save")
	public String saveArticleInfoType(Model model, ArticleInfoType articleInfoType) {
		String flag = "1001";
		try{
			articleInfoType.setAddTime(new Date());
			articleInfoType.setLastUpdateTime(new Date());
			articleInfoType.setAddUser("system");
			articleInfoType.setLastUpdateUser("system");
			articleInfoTypeServiceImpl.saveArticleInfoType(articleInfoType);
		}catch(Exception e){
			flag = "1002";
			e.printStackTrace();
		}
		model.addAttribute("flag", flag);
		return "admin/article/article_info_type_add";
	}
	
	@RequestMapping(value="/goUpdate", method = RequestMethod.GET)
	public String goUpdate(Model model, Integer id) {
		ArticleInfoType articleInfoType = articleInfoTypeServiceImpl.findArticleInfoTypeById(id);
		model.addAttribute("articleInfoType", articleInfoType);
		return "admin/article/article_info_type_update";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Model model, Integer aptId, String aptName) {
		ArticleInfoType articleInfoType = articleInfoTypeServiceImpl.findArticleInfoTypeById(aptId);
		String flag = "1002";
		if(articleInfoType != null){
			try {
				articleInfoType.setAptName(aptName.trim());
				articleInfoType.setLastUpdateTime(new Date());
				articleInfoType.setLastUpdateUser("system");
				articleInfoTypeServiceImpl.update(articleInfoType);
				flag = "1001";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("articleInfoType", articleInfoType);
		model.addAttribute("flag", flag);
		return "admin/article/article_info_type_update";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		articleInfoTypeServiceImpl.deleteArticleInfoTypeById(id);
		return "redirect:/articleInfoType";
	}
	
	@RequestMapping(value="/delJson/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void delJson(Model model, @PathVariable Integer id) {
		String flag = "1001";
		try {
			articleInfoTypeServiceImpl.deleteArticleInfoTypeById(id);
		} catch (Exception e) {
			flag = "1002";
		}
		
		model.addAttribute("flag", flag);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ArticleInfoType getJson(Model model, @PathVariable Integer id){
		return articleInfoTypeServiceImpl.findArticleInfoTypeById(id);
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

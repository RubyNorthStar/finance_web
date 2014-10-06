package com.xsjrw.websit.controller.article;

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
@RequestMapping("/articleInfoType")
public class ArticleInfoTypeController {
	
	@Autowired
	private IArticleInfoTypeService articleInfoTypeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ArticleInfoTypeSearch search){
		if (search == null) {
			search = new ArticleInfoTypeSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", articleInfoTypeService.findArticleInfoTypeByPage(search));
		return "articleInfoType/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ArticleInfoType ArticleInfoType) {
		articleInfoTypeService.saveArticleInfoType(ArticleInfoType);
		return "redirect:/articleInfoType";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ArticleInfoType ArticleInfoType) {
		articleInfoTypeService.update(ArticleInfoType);
		return "redirect:/articleInfoType";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		articleInfoTypeService.deleteArticleInfoTypeById(id);
		return "redirect:/articleInfoType";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ArticleInfoType getJson(Model model, @PathVariable Integer id){
		return articleInfoTypeService.findArticleInfoTypeById(id);
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

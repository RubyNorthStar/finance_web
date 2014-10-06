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

import com.xsjrw.websit.domain.article.ArticleInfo;
import com.xsjrw.websit.search.article.ArticleInfoSearch;
import com.xsjrw.websit.service.article.IArticleInfoService;

/**
 * Controller of ArticleInfo
 * @author wang.zx
 * @date 2014-10-6
 */
@Controller
@RequestMapping("/articleInfo")
public class ArticleInfoController {
	
	@Autowired
	private IArticleInfoService articleInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ArticleInfoSearch search){
		if (search == null) {
			search = new ArticleInfoSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", articleInfoService.findArticleInfoByPage(search));
		return "articleInfo/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ArticleInfo ArticleInfo) {
		articleInfoService.saveArticleInfo(ArticleInfo);
		return "redirect:/articleInfo";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ArticleInfo ArticleInfo) {
		articleInfoService.update(ArticleInfo);
		return "redirect:/articleInfo";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		articleInfoService.deleteArticleInfoById(id);
		return "redirect:/articleInfo";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ArticleInfo getJson(Model model, @PathVariable Integer id){
		return articleInfoService.findArticleInfoById(id);
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

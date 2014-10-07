package com.xsjrw.websit.controller.article;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xsjrw.websit.service.article.IArticleInfoService;

/**
 * Controller of ArticleInfo
 * @author wang.zx
 * @date 2014-10-6
 */
@Controller
@RequestMapping("/article/articleInfo")
public class ArticleInfoFrontController {
	Logger logger = Logger.getLogger(ArticleInfoFrontController.class);
	
	@Autowired
	private IArticleInfoService articleInfoServiceImpl;
	
	@RequestMapping(value="/list_new", method = RequestMethod.GET)
	public String listNew(Model model, Integer aptId, Integer number){
		if (aptId != null) {
			if(number == null){
				number = 2;
			}
			model.addAttribute("list", articleInfoServiceImpl.findArticleInfoByAptIdAndNumber(aptId, number));
		}
		return "article/list_new";
	}
	
	@RequestMapping(value="/article_detail", method = RequestMethod.GET)
	public String articleDetail(Model model, Integer id){
		if (id != null) {
			model.addAttribute("articleInfo", articleInfoServiceImpl.findArticleInfoById(id));
		}
		return "article/article_detail";
	}
}

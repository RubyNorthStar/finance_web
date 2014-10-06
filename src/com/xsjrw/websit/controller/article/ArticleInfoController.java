package com.xsjrw.websit.controller.article;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xsjrw.common.constans.Constans;
import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.common.util.DateUtil;
import com.xsjrw.common.util.FileBean;
import com.xsjrw.common.util.FileUploadUtil;
import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.domain.article.ArticleInfo;
import com.xsjrw.websit.domain.article.ArticleInfoType;
import com.xsjrw.websit.search.article.ArticleInfoSearch;
import com.xsjrw.websit.service.article.IArticleInfoService;
import com.xsjrw.websit.service.article.IArticleInfoTypeService;

/**
 * Controller of ArticleInfo
 * @author wang.zx
 * @date 2014-10-6
 */
@Controller
@RequestMapping("/admin/articleInfo")
public class ArticleInfoController {
	Logger logger = Logger.getLogger(ArticleInfoController.class);
	
	@Autowired
	private IArticleInfoService articleInfoServiceImpl;
	
	@Autowired
	private IArticleInfoTypeService articleInfoTypeServiceImpl;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(Model model, ArticleInfoSearch search){
		if (search == null) {
			search = new ArticleInfoSearch();
		}
		model.addAttribute("list", articleInfoServiceImpl.findArticleInfoByPage(search));
		model.addAttribute("search", search);
		return "admin/article/article_info_list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		List<ArticleInfoType> articleInfoTypeList = articleInfoTypeServiceImpl.selectAllArticleInfoType();
		model.addAttribute("articleInfoTypeList", articleInfoTypeList);
		return "admin/article/article_info_add";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Model model,HttpServletRequest request, ArticleInfo articleInfo) {
		String flag = "1002";
		Master master = (Master)request.getSession().getAttribute(UserConstans.MASTER_LOGIN);
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request; 
		Integer aptId = articleInfo.getAptId();
		if(aptId != null){
			ArticleInfoType articleInfoType = articleInfoTypeServiceImpl.findArticleInfoTypeById(aptId);
			
			if(articleInfoType != null){
				articleInfo.setAddTime(new Date());
				articleInfo.setLastUpdateTime(new Date());
				articleInfo.setAddUser("system");
				articleInfo.setLastUpdateUser("system");
				articleInfo.setAptId(aptId);
				articleInfo.setIsUsing(1);
				articleInfo.setArticlePath("");
				try {
					String uploadPath = Constans.PRODUCTIMAGEPATH;
					java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd");  
			        String day = format1.format(new Date());  
					String nextLevel = "/"+day.substring(0, 4)+"/"+day.substring(5, 7)+"/"+day.substring(8);
					List<FileBean> fileList = FileUploadUtil.upload(request, multipartRequest, "",uploadPath, nextLevel);
					articleInfo.setArticlePic(nextLevel+fileList.get(0).getServerName());
				} catch (Exception e) {
					logger.error("uploading wrong", e);
				}
				articleInfoServiceImpl.saveArticleInfo(articleInfo);
				flag = "1001";
			}
		}
		List<ArticleInfoType> articleInfoTypeList = articleInfoTypeServiceImpl.selectAllArticleInfoType();
		model.addAttribute("articleInfoTypeList", articleInfoTypeList);
		model.addAttribute("flag", flag);
		return "admin/article/article_info_add";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ArticleInfo ArticleInfo) {
		articleInfoServiceImpl.update(ArticleInfo);
		return "redirect:/articleInfo";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		articleInfoServiceImpl.deleteArticleInfoById(id);
		return "redirect:/articleInfo";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ArticleInfo getJson(Model model, @PathVariable Integer id){
		return articleInfoServiceImpl.findArticleInfoById(id);
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

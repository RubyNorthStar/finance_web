package com.xsjrw.websit.controller.admin;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xsjrw.common.constans.Constans;
import com.xsjrw.common.constans.UserConstans;
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
					String nextLevel = "/"+day.substring(0, 4)+"/"+day.substring(5, 7)+"/"+day.substring(8)+"/";
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
	
	@RequestMapping(value="/goUpdate", method = RequestMethod.GET)
	public String goUpdate(Model model, Integer id) {
		ArticleInfo articleInfo = articleInfoServiceImpl.findArticleInfoById(id);
		List<ArticleInfoType> articleInfoTypeList = articleInfoTypeServiceImpl.selectAllArticleInfoType();
		model.addAttribute("articleInfoTypeList", articleInfoTypeList);
		model.addAttribute("articleInfo", articleInfo);
		return "admin/article/article_info_update";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Model model,HttpServletRequest request, ArticleInfo articleInfo) {
		String flag = "1002";
		Master master = (Master)request.getSession().getAttribute(UserConstans.MASTER_LOGIN);
		MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request; 
		Integer apId = articleInfo.getApId();
		if(apId != null){
			ArticleInfo existArticleInfo = articleInfoServiceImpl.findArticleInfoById(apId);
			
			if(existArticleInfo != null){
				existArticleInfo.setLastUpdateTime(new Date());
				existArticleInfo.setLastUpdateUser("system");
				existArticleInfo.setIsUsing(1);
				existArticleInfo.setArticlePath("");
				existArticleInfo.setAptId(articleInfo.getAptId());
				existArticleInfo.setIsUsing(articleInfo.getIsUsing());
				
				if(StringUtils.isNotBlank(articleInfo.getAuthor())){
					existArticleInfo.setAuthor(articleInfo.getAuthor());
				}
				
				if(StringUtils.isNotBlank(articleInfo.getTitle())){
					existArticleInfo.setTitle(articleInfo.getTitle());
				}

				if(StringUtils.isNotBlank(articleInfo.getTitle())){
					existArticleInfo.setTitle(articleInfo.getTitle());
				}
				
				if(StringUtils.isNotBlank(articleInfo.getArticleSource())){
					existArticleInfo.setArticleSource(articleInfo.getArticleSource());
				}
				
				if(StringUtils.isNotBlank(articleInfo.getArticleSource())){
					existArticleInfo.setArticleSource(articleInfo.getArticleSource());
				}
				
				if(StringUtils.isNotBlank(articleInfo.getEditingCode())){
					existArticleInfo.setEditingCode(articleInfo.getEditingCode());
				}
				try {
					String uploadPath = Constans.PRODUCTIMAGEPATH;
					java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd");  
			        String day = format1.format(new Date());  
					String nextLevel = "/"+day.substring(0, 4)+"/"+day.substring(5, 7)+"/"+day.substring(8)+"/";
					List<FileBean> fileList = FileUploadUtil.upload(request, multipartRequest, "",uploadPath, nextLevel);
					
					if(fileList != null && fileList.size() > 0){
						existArticleInfo.setArticlePic(nextLevel+fileList.get(0).getServerName());
					}
				} catch (Exception e) {
					logger.error("uploading wrong", e);
				}
				articleInfoServiceImpl.update(existArticleInfo);
				flag = "1001";
				model.addAttribute("articleInfo", existArticleInfo);
			}
		}
		List<ArticleInfoType> articleInfoTypeList = articleInfoTypeServiceImpl.selectAllArticleInfoType();
		model.addAttribute("articleInfoTypeList", articleInfoTypeList);
		model.addAttribute("flag", flag);
		return "admin/article/article_info_update";
	}
	
	/**modified by Hector Wang on 2013-7-4 10:46:02
	 * 发布模板功能
	 */
	@RequestMapping(value="/publish/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void publish(HttpServletRequest request, @PathVariable Integer id, PrintWriter printWriter) {
		Master master = (Master) request .getSession().getAttribute("master");
		String flag = "1002";
		try{
			if(id != null){
				try {
					
//					FreemarkerConverterHTML.crateHTML(areaMap, templatePath, publishChannels.getChannelPath());
//					publishInfo = "发布成功";
					
					ArticleInfo existArticleInfo = articleInfoServiceImpl.findArticleInfoById(id);
					existArticleInfo.setNormalCode(existArticleInfo.getEditingCode());
					existArticleInfo.setStatus(1);
					articleInfoServiceImpl.update(existArticleInfo);
					flag = "1001";
					logger.info("操作者:"+"system"+"发布页面，apId:"+id);
				} catch (Exception e) {
					logger.error("publish", e);
				}
			}else{
				flag = "1002";
			}
		}catch(Exception e){
			logger.error("publish", e);
		}
        printWriter.write(flag); 
        printWriter.flush(); 
        printWriter.close();  
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
	
	@RequestMapping(value="/list_new", method = RequestMethod.GET)
	public String listNew(Model model, Integer aptId, Integer number){
		if (aptId != null) {
			if(number == null){
				number = 2;
			}
			model.addAttribute("list", articleInfoServiceImpl.findArticleInfoByAptIdAndNumber(aptId, number));
		}
		return "admin/article/article_info_list";
	}
}

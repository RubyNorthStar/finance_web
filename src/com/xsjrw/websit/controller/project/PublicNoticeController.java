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

import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.domain.project.ProjectInfo;
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
		search.setStatus(1);
		search.setPageSize(2);
		
		model.addAttribute("list", publicNoticeService.findPublicNoticeByPage(search));
		model.addAttribute("search", search);
		return "project/public_manage";
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxList")
	public String ajaxList(Model model, PublicNoticeSearch search, HttpServletResponse response){
		search.setPageSize(2);
		
		List<PublicNotice> ajaxList = publicNoticeService.findPublicNoticeByPage(search);
		
		String result = "<tr class='tr-title'><td>项目名称</td><td>地区</td><td>操作</td></tr>";
		if(ajaxList != null && ajaxList.size() > 0){
			try {
				for(PublicNotice pro : ajaxList){
					result += "<tr><td>"+pro.getNoticeTitle()+"</td><td>"+pro.getAddressProvince()+" | "+pro.getAddressCity()+
							"</td><td><button class='button-style button-style-blue delete' data='"+pro.getId()+"' style='margin:0; padding:5px 7px;'>删除</button>"
							+ " <button class='button-style button-style-blue update' data='"+pro.getId()+"' style='margin:0; padding:5px 7px;'>修改</button></td></tr>";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
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
	
	@ResponseBody
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		String del = "";
		PublicNotice publicNotice = publicNoticeService.findPublicNoticeById(id);
		publicNotice.setStatus(6);
		try {
			publicNoticeService.update(publicNotice);
			del = "succ";
		} catch (Exception e) {
			e.printStackTrace();
			del = "fail";
		}
		return del;
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
	
	@RequestMapping(value="addPublic", method = RequestMethod.GET)
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
		model.addAttribute("project", 2);
		return "project/success";
	}
	
}

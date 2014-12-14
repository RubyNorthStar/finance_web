package com.xsjrw.websit.controller.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.domain.project.ProjectInfo;
import com.xsjrw.websit.domain.project.PublicNotice;
import com.xsjrw.websit.service.project.IIndustryService;
import com.xsjrw.websit.service.project.IProjectInfoService;
import com.xsjrw.websit.service.project.IPublicNoticeService;

@Controller
@RequestMapping("/projectInfo")
public class ProjectInfoFontController {
	
	@Autowired
	private IProjectInfoService projectInfoService;
	
	@Autowired
	private IIndustryService industryService;
	
	@Autowired
	private IPublicNoticeService publicNoticeService;
	
	/**
	 * 查询融资项目、转让项目详细页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="peojectDetail")
	public String projectDetail(HttpServletRequest request, Model model){
		Integer id = Integer.parseInt(request.getParameter("id"));
		ProjectInfo projectInfo = projectInfoService.findProjectInfoById(id);
		
		Industry Industry = industryService.findIndustryById(Integer.parseInt(projectInfo.getProindustryId()));
		projectInfo.setProindustryId(Industry.getIndustryName());
		if(projectInfo != null){
			model.addAttribute("projectInfo", projectInfo);
		}
		return "project/project_detail";
	}
	
	@RequestMapping(value="publicNotice")
	public String publicNotice(HttpServletRequest request, Model model){
		Integer id = Integer.parseInt(request.getParameter("id"));
		PublicNotice publicNotice = publicNoticeService.findPublicNoticeById(id);
		
		Industry Industry = industryService.findIndustryById(publicNotice.getIndustryId());
		publicNotice.setIndustryStr(Industry.getIndustryName());
		
		model.addAttribute("publicNotice", publicNotice);
		return "project/notice_detail";
	}
	
}

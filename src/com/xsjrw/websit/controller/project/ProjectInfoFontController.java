package com.xsjrw.websit.controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.domain.project.InvestmentIntentionInfo;
import com.xsjrw.websit.domain.project.ProjectInfo;
import com.xsjrw.websit.domain.project.PublicNotice;
import com.xsjrw.websit.search.project.ProjectInfoSearch;
import com.xsjrw.websit.service.project.IIndustryService;
import com.xsjrw.websit.service.project.IInvestmentIntentionInfoService;
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
	
	@Autowired
	private IInvestmentIntentionInfoService investmentIntentionInfoService;
	
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
	
	/**
	 * 查询融资项目、转让项目列表页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="peojectList")
	public String peojectList(HttpServletRequest request, Model model, ProjectInfoSearch search){
//		ProjectInfo projectInfo = projectInfoService.findProjectInfoById(id);
		
		
		List<ProjectInfo> projectList = projectInfoService.findProjectInfoByPage(search);
		
		if(projectList != null && projectList.size() > 0){
			for(ProjectInfo project : projectList){
				String industryId = project.getProindustryId();
				if(industryId != null && industryId.length() > 0){
					Industry Industry = industryService.findIndustryById(Integer.parseInt(project.getProindustryId()));
					project.setProindustryId(Industry.getIndustryName());
				}
			}
			model.addAttribute("projectList", projectList);
		}
		model.addAttribute("search", search);
		
		return "project/project_list";
	}
	
	/**
	 * 查询公告详细页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="publicNotice")
	public String publicNotice(HttpServletRequest request, Model model){
		Integer id = Integer.parseInt(request.getParameter("id"));
		PublicNotice publicNotice = publicNoticeService.findPublicNoticeById(id);
		
		Industry Industry = industryService.findIndustryById(publicNotice.getIndustryId());
		publicNotice.setIndustryStr(Industry.getIndustryName());
		
		model.addAttribute("publicNotice", publicNotice);
		return "project/notice_detail";
	}
	
	/**
	 * 查询投资项目详细页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="investment")
	public String investment(HttpServletRequest request, Model model){
		Integer id = Integer.parseInt(request.getParameter("id"));
		InvestmentIntentionInfo investment = investmentIntentionInfoService.findInvestmentIntentionInfoById(id);
		
//		Industry Industry = industryService.findIndustryById(publicNotice.getIndustryId());
//		publicNotice.setIndustryStr(Industry.getIndustryName());
		
		model.addAttribute("investment", investment);
		return "project/investment_detail";
	}
	
}

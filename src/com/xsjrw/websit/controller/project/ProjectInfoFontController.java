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
import com.xsjrw.websit.search.project.InvestmentIntentionInfoSearch;
import com.xsjrw.websit.search.project.ProjectInfoSearch;
import com.xsjrw.websit.search.project.PublicNoticeSearch;
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
	@RequestMapping(value="projectList")
	public String peojectList(HttpServletRequest request, Model model, ProjectInfoSearch search){
		
		//为了体现出来分页此处设置为每五条一页(默认值为15)
		if(search == null){
			search = new ProjectInfoSearch();
		}
		search.setPageSize(5);
		search.setStatus(2);
		List<ProjectInfo> projectList = projectInfoService.findProjectInfoByPage(search);
		
		
		if(projectList != null && projectList.size() > 0){
			for(ProjectInfo project : projectList){
				String industryId = project.getProindustryId();
				if(industryId != null && industryId.length() > 0){
					Industry Industry = industryService.findIndustryById(Integer.parseInt(industryId));
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
	 * 查询公告列表页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="publicList")
	public String publicList(HttpServletRequest request, Model model, PublicNoticeSearch search){
		
		//为了体现出来分页此处设置为每五条一页(默认值为15)
		if(search == null){
			search = new PublicNoticeSearch();
		}
		search.setPageSize(5);
		search.setStatus(2);
		List<PublicNotice> publicList = publicNoticeService.findPublicNoticeByPage(search);
		
		if(publicList != null && publicList.size() > 0){
			for(PublicNotice publice : publicList){
				Integer industryId = publice.getIndustryId();
				if(industryId != null && industryId > 0){
					Industry Industry = industryService.findIndustryById(industryId);
					publice.setIndustryStr(Industry.getIndustryName());
				}
			}
			model.addAttribute("publicList", publicList);
		}
		model.addAttribute("search", search);
		
		return "project/public_list";
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
		
		model.addAttribute("investment", investment);
		return "project/investment_detail";
	}
	
	/**
	 * 查询公告列表页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="investList")
	public String investList(HttpServletRequest request, Model model, InvestmentIntentionInfoSearch search){
		
		//为了体现出来分页此处设置为每五条一页(默认值为15)
		if(search == null){
			search = new InvestmentIntentionInfoSearch();
		}
		search.setPageSize(5);
		search.setStatus(2);
		List<InvestmentIntentionInfo> investList = investmentIntentionInfoService.findInvestmentIntentionInfoByPage(search);
		
		model.addAttribute("investList", investList);
		model.addAttribute("search", search);
		
		return "project/invest_list";
	}
	
}

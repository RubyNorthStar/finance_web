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

import com.xsjrw.websit.domain.project.ImagePath;
import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.domain.project.ProjectInfo;
import com.xsjrw.websit.dto.ProjectInfoDto;
import com.xsjrw.websit.search.project.IndustrySearch;
import com.xsjrw.websit.search.project.ProjectInfoSearch;
import com.xsjrw.websit.service.project.IImagePathService;
import com.xsjrw.websit.service.project.IIndustryService;
import com.xsjrw.websit.service.project.IProjectInfoService;

/**
 * Controller of ProjectInfo
 * @author wang.zx
 * @date 2014-11-30
 */
@Controller
@RequestMapping("/admin/projectInfo")
public class AdminProjectInfoController {
	
	@Autowired
	private IProjectInfoService projectInfoServiceImpl;
	
	@Autowired
	private IIndustryService industryService;
	
	@Autowired
	private IImagePathService imagePathService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ProjectInfoSearch search){
		if (search == null) {
			search = new ProjectInfoSearch();
			// search.setPageSize(20);
		}
		search.setPageSize(1);
		
		List<ProjectInfo> proList = projectInfoServiceImpl.findProjectInfoByPage(search);
		
		for(ProjectInfo info : proList){
			String proIndustryId = info.getProindustryId();
			if(proIndustryId != null && proIndustryId.length() > 0){
				Industry industry = industryService.findIndustryById(Integer.parseInt(proIndustryId));
				info.setProindustryId(industry.getIndustryName());
			}
		}
		
		model.addAttribute("list", proList);
		model.addAttribute("search", search);
		return "project/admin/project_info_list";
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxList")
	public String ajaxList(Model model, ProjectInfoSearch search, HttpServletResponse response){
		search.setPageSize(2);
		
		List<ProjectInfo> ajaxList = projectInfoServiceImpl.findProjectInfoByPage(search);
		
		String result = "<tr class='tr-title'><td>项目名称</td><td>操作</td></tr>";
		if(ajaxList != null && ajaxList.size() > 0){
			try {
				for(ProjectInfo pro : ajaxList){
					result += "<tr><td>"+pro.getProjectName()+"</td><td>刪除&nbsp|&nbsp修改</td></tr>";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ProjectInfo ProjectInfo) {
		projectInfoServiceImpl.saveProjectInfo(ProjectInfo);
		return "redirect:/projectInfo";
	}
	
	@RequestMapping(value="/update")
	public String update(ProjectInfo projectInfo) {
		Integer type = projectInfo.getProjectType();
		projectInfoServiceImpl.update(projectInfo);
		
		return "redirect:/admin/projectInfo.go?projectType="+type;
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		projectInfoServiceImpl.deleteProjectInfoById(id);
		return "redirect:/projectInfo";
	}
	
	@RequestMapping(value="detail")
	public String detail(Model model, Integer id){
		System.out.println("当前Id"+id);
		
		ProjectInfo projectInfo = projectInfoServiceImpl.findProjectInfoById(id);
		model.addAttribute("projectInfo", projectInfo);
				
		return "project/admin/project_info_detail";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ProjectInfo getJson(Model model, @PathVariable Integer id){
		return projectInfoServiceImpl.findProjectInfoById(id);
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
	
	@RequestMapping(value="transferType")
	public String transferPorjectType(){
		
		return "project/transfer_porject_type";
	}
	
	@RequestMapping(value="transferPorject")
	public String transferPorject(HttpServletRequest request, String protype, Model model){
		String porjectType = protype;
		String[] proTypeArr = null;
		String type = request.getParameter("type");
		
		if(porjectType != null && porjectType.length() > 0){
			proTypeArr = porjectType.split(",");
			model.addAttribute("proType", Integer.parseInt(proTypeArr[0]));
			model.addAttribute("proTypeClassify", Integer.parseInt(proTypeArr[1]));
		}
		
		IndustrySearch search = new IndustrySearch();
		search.setPageSize(40);
		search.setStatus(1);
		
		List<Industry> industryList = industryService.findIndustryByPage(search);
		model.addAttribute("industryList", industryList);
		model.addAttribute("type", type);
		
		return "project/add_porject_info";
	}
	
	@RequestMapping(value="financeInfoType")
	public String financeInfoType(HttpServletRequest request, String protype, Model model){
		return "project/finance_porject_type";
	}
	
	@RequestMapping(value="addTransferPorject")
	public String addTransferPorject(Model model, HttpServletRequest request, ProjectInfoDto projectInfoDto){
		
		ProjectInfo projectInfo = projectInfoDto.getProjectInfo();
		projectInfo.setCreateTime(new Date());
		projectInfo.setStatus(1);
		projectInfoServiceImpl.saveProjectInfo(projectInfo);
		
		List<ImagePath> listImage = projectInfoDto.getImages();
		if(listImage != null && listImage.size() > 0){
			imagePathService.saveImagePathByProjectId(projectInfo.getId(), projectInfoDto.getImages());
		}
		model.addAttribute("project", 1);
		return "project/success";
	}
	
	
}

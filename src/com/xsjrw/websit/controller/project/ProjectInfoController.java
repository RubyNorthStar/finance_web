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
 * @date 2014-10-30
 */
@Controller
@RequestMapping("/center/projectInfo")
public class ProjectInfoController {
	
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
		search.setStatus(1);
		search.setPageSize(2);
		
		model.addAttribute("list", projectInfoServiceImpl.findProjectInfoByPage(search));
		model.addAttribute("search", search);
		return "project/project_manage";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ProjectInfo ProjectInfo) {
		projectInfoServiceImpl.saveProjectInfo(ProjectInfo);
		return "redirect:/projectInfo";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ProjectInfo ProjectInfo) {
		projectInfoServiceImpl.update(ProjectInfo);
		return "redirect:/projectInfo";
	}
	
	@ResponseBody
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		String del = "";
		ProjectInfo projectInfo = projectInfoServiceImpl.findProjectInfoById(id);
		projectInfo.setStatus(6);
		try {
			projectInfoServiceImpl.update(projectInfo);
			del = "succ";
		} catch (Exception e) {
			e.printStackTrace();
			del = "fail";
		}
		return del;
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
		String classfy = projectInfo.getProjectTypeClassify();
		classfy = getClassify(classfy);
		projectInfo.setProjectTypeClassify(classfy);
		projectInfoServiceImpl.saveProjectInfo(projectInfo);
		
		List<ImagePath> listImage = projectInfoDto.getImages();
		if(listImage != null && listImage.size() > 0){
			imagePathService.saveImagePathByProjectId(projectInfo.getId(), projectInfoDto.getImages());
		}
		model.addAttribute("project", 1);
		return "project/success";
	}
	
	
	private String getClassify(String key){
		String str = "";
		if(key != null){
			Integer type = Integer.parseInt(key);
			switch(type){
				case 1 :{
					str = "股权融资";  
				}
				case 2 :{
					str = "项目融资";  
				}
				case 3 :{
					str = "债权融资";  
				}
				case 4 :{
					str = "租赁融资";  
				}
			}
		}
		return str;
	}
	
	
	
	
}

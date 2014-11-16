package com.xsjrw.websit.controller.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsjrw.websit.domain.project.ProjectInfo;
import com.xsjrw.websit.service.project.IProjectInfoService;

@Controller
@RequestMapping("/projectInfo")
public class ProjectInfoFontController {
	
	@Autowired
	private IProjectInfoService projectInfoService;
	
	@RequestMapping(value="peojectDetail")
	public String projectDetail(HttpServletRequest request, Model model){
		Integer id = Integer.parseInt(request.getParameter("id"));
		ProjectInfo projectInfo = projectInfoService.findProjectInfoById(id);
		if(projectInfo != null){
			model.addAttribute("projectInfo", projectInfo);
		}
		return "project/project_detail";
	}
}

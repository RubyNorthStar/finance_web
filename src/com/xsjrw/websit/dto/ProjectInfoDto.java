package com.xsjrw.websit.dto;

import java.util.ArrayList;
import java.util.List;

import com.xsjrw.websit.domain.project.ImagePath;
import com.xsjrw.websit.domain.project.ProjectInfo;

public class ProjectInfoDto {

	/*******      项目对应图片              ********/
	private List<ImagePath> images = new ArrayList<ImagePath>();
	
	private ProjectInfo projectInfo = new ProjectInfo();
	
	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProjectInfo可以实现连缀设置属性
		
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	public List<ImagePath> getImages() {
		return images;
	}
	public void setImages(List<ImagePath> images) {
		this.images = images;
	}

}

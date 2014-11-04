package com.xsjrw.websit.search.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:ImagePath
 * 
 * @author wang.zx
 * @date 2014-10-30
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ImagePathSearch")
public class ImagePathSearch extends PageModel {
	
	private Integer	id;		
	private String	path;		 /* 图片路径 */ 
	private Integer	status;		 /*  状态 */ 
	private Integer	projectId;		 /* 项目ID */ 
	private Date	createTime;		 /* 创建时间 */ 

	// Constructor
	public ImagePathSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ImagePathSearch(Integer id, String path, Integer status, Integer projectId, Date createTime) {
		this.id = id;
		this.path = path;
		this.status = status;
		this.projectId = projectId;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ImagePath可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ImagePathSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getPath() {
		return path;
	}

	public ImagePathSearch setPath(String path) {
		this.path = path;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ImagePathSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public ImagePathSearch setProjectId(Integer projectId) {
		this.projectId = projectId;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public ImagePathSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
}
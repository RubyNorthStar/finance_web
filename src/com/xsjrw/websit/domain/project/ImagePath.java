package com.xsjrw.websit.domain.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.web.multipart.MultipartFile;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:ImagePath
 * 
 * @author wang.zx
 * @date 2014-10-30
 */
@SuppressWarnings("serial")
@Alias("ImagePath")
public class ImagePath extends BaseEntity {
	
	
	private String	path;		 /* 图片路径 */ 
	private Integer	status;		 /*  状态 */ 
	private Integer	projectId;		 /* 项目ID */ 
	private Date	createTime;		 /* 创建时间 */ 
	private MultipartFile imagePath;

	// Constructor
	public ImagePath() {
	}
	
	/**
	 * full Constructor
	 */
	public ImagePath(Integer id, String path, Integer status, Integer projectId, Date createTime) {
		setId(id);
		this.path = path;
		this.status = status;
		this.projectId = projectId;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ImagePath可以实现连缀设置属性
	
	public String getPath() {
		return path;
	}

	public ImagePath setPath(String path) {
		this.path = path;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ImagePath setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	
	public Integer getProjectId() {
		return projectId;
	}

	public ImagePath setProjectId(Integer projectId) {
		this.projectId = projectId;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public ImagePath setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	public MultipartFile getImagePath() {
		return imagePath;
	}

	public void setImagePath(MultipartFile imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "ImagePath [" + "id=" + getId() + ", path=" + path + ", status=" + status + ", projectId=" + projectId + ", createTime=" + createTime +  "]";
	}
}

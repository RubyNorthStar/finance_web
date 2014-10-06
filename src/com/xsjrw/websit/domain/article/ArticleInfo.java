package com.xsjrw.websit.domain.article;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:ArticleInfo
 * 
 * @author wang.zx
 * @date 2014-10-6
 */
@SuppressWarnings("serial")
@Alias("ArticleInfo")
public class ArticleInfo extends BaseEntity {
	
	
	private String	title;		 /* 文章名称 */ 
	private String	thumbnailUrl;		 /* 文章缩率图 */ 
	private String	content;		 /* 文章内容 */ 
	private Integer	status;		 /* 状态 1.可用 2.不可用 */ 
	private Date	createTime;		

	// Constructor
	public ArticleInfo() {
	}
	
	/**
	 * full Constructor
	 */
	public ArticleInfo(Integer id, String title, String thumbnailUrl, String content, Integer status, Date createTime) {
		setId(id);
		this.title = title;
		this.thumbnailUrl = thumbnailUrl;
		this.content = content;
		this.status = status;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ArticleInfo可以实现连缀设置属性
	
	public String getTitle() {
		return title;
	}

	public ArticleInfo setTitle(String title) {
		this.title = title;
		return this;
	}
	
	
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public ArticleInfo setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
		return this;
	}
	
	
	public String getContent() {
		return content;
	}

	public ArticleInfo setContent(String content) {
		this.content = content;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ArticleInfo setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public ArticleInfo setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	@Override
	public String toString() {
		return "ArticleInfo [" + "id=" + getId() + ", title=" + title + ", thumbnailUrl=" + thumbnailUrl + ", content=" + content + ", status=" + status + ", createTime=" + createTime +  "]";
	}
}

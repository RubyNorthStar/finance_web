package com.xsjrw.websit.search.article;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:ArticleInfo
 * 
 * @author wang.zx
 * @date 2014-10-6
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ArticleInfoSearch")
public class ArticleInfoSearch extends PageModel {
	
	private Integer	id;		
	private String	title;		 /* 文章名称 */ 
	private String	thumbnailUrl;		 /* 文章缩率图 */ 
	private String	content;		 /* 文章内容 */ 
	private Integer	status;		 /* 状态 1.可用 2.不可用 */ 
	private Date	createTime;		

	// Constructor
	public ArticleInfoSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ArticleInfoSearch(Integer id, String title, String thumbnailUrl, String content, Integer status, Date createTime) {
		this.id = id;
		this.title = title;
		this.thumbnailUrl = thumbnailUrl;
		this.content = content;
		this.status = status;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ArticleInfo可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ArticleInfoSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getTitle() {
		return title;
	}

	public ArticleInfoSearch setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public ArticleInfoSearch setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
		return this;
	}
	
	public String getContent() {
		return content;
	}

	public ArticleInfoSearch setContent(String content) {
		this.content = content;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ArticleInfoSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public ArticleInfoSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
}
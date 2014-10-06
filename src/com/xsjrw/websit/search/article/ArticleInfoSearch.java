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
	
	private Integer	apId;		
	private String	author;		
	private Integer	aptId;		
	private String	title;		
	private Date	publishTime;		
	private Date	addTime;		
	private Date	lastUpdateTime;		
	private String	articleSource;		
	private String	articlePath;		
	private String	addUser;		
	private String	lastUpdateUser;		
	private String	articlePic;		
	private String	editingCode;		
	private String	normalCode;		
	private Integer	isUsing;		
	private Integer	status;		
	private Integer	stick;		

	// Constructor
	public ArticleInfoSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ArticleInfoSearch(Integer apId, String author, Integer aptId, String title, Date publishTime, Date addTime, Date lastUpdateTime, String articleSource, String articlePath, String addUser, String lastUpdateUser, String articlePic, String editingCode, String normalCode, Integer isUsing, Integer status, Integer stick) {
		this.apId = apId;
		this.author = author;
		this.aptId = aptId;
		this.title = title;
		this.publishTime = publishTime;
		this.addTime = addTime;
		this.lastUpdateTime = lastUpdateTime;
		this.articleSource = articleSource;
		this.articlePath = articlePath;
		this.addUser = addUser;
		this.lastUpdateUser = lastUpdateUser;
		this.articlePic = articlePic;
		this.editingCode = editingCode;
		this.normalCode = normalCode;
		this.isUsing = isUsing;
		this.status = status;
		this.stick = stick;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ArticleInfo可以实现连缀设置属性
	public Integer getApId() {
		return apId;
	}

	public ArticleInfoSearch setApId(Integer apId) {
		this.apId = apId;
		return this;
	}
	
	public String getAuthor() {
		return author;
	}

	public ArticleInfoSearch setAuthor(String author) {
		this.author = author;
		return this;
	}
	
	public Integer getAptId() {
		return aptId;
	}

	public ArticleInfoSearch setAptId(Integer aptId) {
		this.aptId = aptId;
		return this;
	}
	
	public String getTitle() {
		return title;
	}

	public ArticleInfoSearch setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Date getPublishTime() {
		return publishTime;
	}

	public ArticleInfoSearch setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
		return this;
	}
	
	public Date getAddTime() {
		return addTime;
	}

	public ArticleInfoSearch setAddTime(Date addTime) {
		this.addTime = addTime;
		return this;
	}
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public ArticleInfoSearch setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
		return this;
	}
	
	public String getArticleSource() {
		return articleSource;
	}

	public ArticleInfoSearch setArticleSource(String articleSource) {
		this.articleSource = articleSource;
		return this;
	}
	
	public String getArticlePath() {
		return articlePath;
	}

	public ArticleInfoSearch setArticlePath(String articlePath) {
		this.articlePath = articlePath;
		return this;
	}
	
	public String getAddUser() {
		return addUser;
	}

	public ArticleInfoSearch setAddUser(String addUser) {
		this.addUser = addUser;
		return this;
	}
	
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public ArticleInfoSearch setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
		return this;
	}
	
	public String getArticlePic() {
		return articlePic;
	}

	public ArticleInfoSearch setArticlePic(String articlePic) {
		this.articlePic = articlePic;
		return this;
	}
	
	public String getEditingCode() {
		return editingCode;
	}

	public ArticleInfoSearch setEditingCode(String editingCode) {
		this.editingCode = editingCode;
		return this;
	}
	
	public String getNormalCode() {
		return normalCode;
	}

	public ArticleInfoSearch setNormalCode(String normalCode) {
		this.normalCode = normalCode;
		return this;
	}
	
	public Integer getIsUsing() {
		return isUsing;
	}

	public ArticleInfoSearch setIsUsing(Integer isUsing) {
		this.isUsing = isUsing;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ArticleInfoSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Integer getStick() {
		return stick;
	}

	public ArticleInfoSearch setStick(Integer stick) {
		this.stick = stick;
		return this;
	}
	
}
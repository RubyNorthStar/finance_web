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
@Alias("ArticleInfo")
public class ArticleInfo{
	
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
	public ArticleInfo() {
	}
	
	/**
	 * full Constructor
	 */
	public ArticleInfo(Integer apId, String author, Integer aptId, String title, Date publishTime, Date addTime, Date lastUpdateTime, String articleSource, String articlePath, String addUser, String lastUpdateUser, String articlePic, String editingCode, String normalCode, Integer isUsing, Integer status, Integer stick) {
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

	public ArticleInfo setApId(Integer apId) {
		this.apId = apId;
		return this;
	}
	
	
	public String getAuthor() {
		return author;
	}

	public ArticleInfo setAuthor(String author) {
		this.author = author;
		return this;
	}
	
	
	public Integer getAptId() {
		return aptId;
	}

	public ArticleInfo setAptId(Integer aptId) {
		this.aptId = aptId;
		return this;
	}
	
	
	public String getTitle() {
		return title;
	}

	public ArticleInfo setTitle(String title) {
		this.title = title;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getPublishTime() {
		return publishTime;
	}

	public ArticleInfo setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getAddTime() {
		return addTime;
	}

	public ArticleInfo setAddTime(Date addTime) {
		this.addTime = addTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public ArticleInfo setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
		return this;
	}
	
	
	public String getArticleSource() {
		return articleSource;
	}

	public ArticleInfo setArticleSource(String articleSource) {
		this.articleSource = articleSource;
		return this;
	}
	
	
	public String getArticlePath() {
		return articlePath;
	}

	public ArticleInfo setArticlePath(String articlePath) {
		this.articlePath = articlePath;
		return this;
	}
	
	
	public String getAddUser() {
		return addUser;
	}

	public ArticleInfo setAddUser(String addUser) {
		this.addUser = addUser;
		return this;
	}
	
	
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public ArticleInfo setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
		return this;
	}
	
	
	public String getArticlePic() {
		return articlePic;
	}

	public ArticleInfo setArticlePic(String articlePic) {
		this.articlePic = articlePic;
		return this;
	}
	
	
	public String getEditingCode() {
		return editingCode;
	}

	public ArticleInfo setEditingCode(String editingCode) {
		this.editingCode = editingCode;
		return this;
	}
	
	
	public String getNormalCode() {
		return normalCode;
	}

	public ArticleInfo setNormalCode(String normalCode) {
		this.normalCode = normalCode;
		return this;
	}
	
	
	public Integer getIsUsing() {
		return isUsing;
	}

	public ArticleInfo setIsUsing(Integer isUsing) {
		this.isUsing = isUsing;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ArticleInfo setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	
	public Integer getStick() {
		return stick;
	}

	public ArticleInfo setStick(Integer stick) {
		this.stick = stick;
		return this;
	}
	
	@Override
	public String toString() {
		return "ArticleInfo [" + "apId=" + apId + ", author=" + author + ", aptId=" + aptId + ", title=" + title + ", publishTime=" + publishTime + ", addTime=" + addTime + ", lastUpdateTime=" + lastUpdateTime + ", articleSource=" + articleSource + ", articlePath=" + articlePath + ", addUser=" + addUser + ", lastUpdateUser=" + lastUpdateUser + ", articlePic=" + articlePic + ", editingCode=" + editingCode + ", normalCode=" + normalCode + ", isUsing=" + isUsing + ", status=" + status + ", stick=" + stick +  "]";
	}
}

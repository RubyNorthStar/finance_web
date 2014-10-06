package com.xsjrw.websit.search.article;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:ArticleInfoType
 * 
 * @author wang.zx
 * @date 2014-10-6
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ArticleInfoTypeSearch")
public class ArticleInfoTypeSearch extends PageModel {
	
	private Integer	aptId;		
	private String	aptName;		
	private Date	addTime;		
	private Date	lastUpdateTime;		
	private String	addUser;		
	private String	lastUpdateUser;		
	private Integer	status;		

	// Constructor
	public ArticleInfoTypeSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ArticleInfoTypeSearch(Integer aptId, String aptName, Date addTime, Date lastUpdateTime, String addUser, String lastUpdateUser, Integer status) {
		this.aptId = aptId;
		this.aptName = aptName;
		this.addTime = addTime;
		this.lastUpdateTime = lastUpdateTime;
		this.addUser = addUser;
		this.lastUpdateUser = lastUpdateUser;
		this.status = status;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ArticleInfoType可以实现连缀设置属性
	public Integer getAptId() {
		return aptId;
	}

	public ArticleInfoTypeSearch setAptId(Integer aptId) {
		this.aptId = aptId;
		return this;
	}
	
	public String getAptName() {
		return aptName;
	}

	public ArticleInfoTypeSearch setAptName(String aptName) {
		this.aptName = aptName;
		return this;
	}
	
	public Date getAddTime() {
		return addTime;
	}

	public ArticleInfoTypeSearch setAddTime(Date addTime) {
		this.addTime = addTime;
		return this;
	}
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public ArticleInfoTypeSearch setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
		return this;
	}
	
	public String getAddUser() {
		return addUser;
	}

	public ArticleInfoTypeSearch setAddUser(String addUser) {
		this.addUser = addUser;
		return this;
	}
	
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public ArticleInfoTypeSearch setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ArticleInfoTypeSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
}
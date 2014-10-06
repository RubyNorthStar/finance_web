package com.xsjrw.websit.domain.article;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:ArticleInfoType
 * 
 * @author wang.zx
 * @date 2014-10-6
 */
@Alias("ArticleInfoType")
public class ArticleInfoType{
	
	private Integer	aptId;		
	private String	aptName;		
	private Date	addTime;		
	private Date	lastUpdateTime;		
	private String	addUser;		
	private String	lastUpdateUser;		
	private Integer	status;		

	// Constructor
	public ArticleInfoType() {
	}
	
	/**
	 * full Constructor
	 */
	public ArticleInfoType(Integer aptId, String aptName, Date addTime, Date lastUpdateTime, String addUser, String lastUpdateUser, Integer status) {
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

	public ArticleInfoType setAptId(Integer aptId) {
		this.aptId = aptId;
		return this;
	}
	
	
	public String getAptName() {
		return aptName;
	}

	public ArticleInfoType setAptName(String aptName) {
		this.aptName = aptName;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getAddTime() {
		return addTime;
	}

	public ArticleInfoType setAddTime(Date addTime) {
		this.addTime = addTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public ArticleInfoType setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
		return this;
	}
	
	
	public String getAddUser() {
		return addUser;
	}

	public ArticleInfoType setAddUser(String addUser) {
		this.addUser = addUser;
		return this;
	}
	
	
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public ArticleInfoType setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ArticleInfoType setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public String toString() {
		return "ArticleInfoType [" + "aptId=" + aptId + ", aptName=" + aptName + ", addTime=" + addTime + ", lastUpdateTime=" + lastUpdateTime + ", addUser=" + addUser + ", lastUpdateUser=" + lastUpdateUser + ", status=" + status +  "]";
	}
}

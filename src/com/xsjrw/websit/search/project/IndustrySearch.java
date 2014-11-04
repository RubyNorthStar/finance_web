package com.xsjrw.websit.search.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:Industry
 * 
 * @author wang.zx
 * @date 2014-10-30
 */
@SuppressWarnings({ "rawtypes" })
@Alias("IndustrySearch")
public class IndustrySearch extends PageModel {
	
	private Integer	id;		
	private String	industryName;		 /* 所属行业名称 */ 
	private Date	createTime;		 /* 创建时间 */ 
	private Integer	status;		 /* 状态: 1:可用 2:不可用 */ 

	// Constructor
	public IndustrySearch() {
	}
	
	/**
	 * full Constructor
	 */
	public IndustrySearch(Integer id, String industryName, Date createTime, Integer status) {
		this.id = id;
		this.industryName = industryName;
		this.createTime = createTime;
		this.status = status;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Industry可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public IndustrySearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getIndustryName() {
		return industryName;
	}

	public IndustrySearch setIndustryName(String industryName) {
		this.industryName = industryName;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public IndustrySearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public IndustrySearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
}
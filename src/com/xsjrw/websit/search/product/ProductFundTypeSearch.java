package com.xsjrw.websit.search.product;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:ProductFundType
 * 
 * @author wang.zx
 * @date 2014-9-29
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ProductFundTypeSearch")
public class ProductFundTypeSearch extends PageModel {
	
	private Integer	id;		
	private String	fundName;		 /* 基金类型名称 */ 
	private Integer	status;		 /* 状态： 1 可用，2不可用 */ 
	private Date	createTime;		

	// Constructor
	public ProductFundTypeSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ProductFundTypeSearch(Integer id, String fundName, Integer status, Date createTime) {
		this.id = id;
		this.fundName = fundName;
		this.status = status;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProductFundType可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ProductFundTypeSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getFundName() {
		return fundName;
	}

	public ProductFundTypeSearch setFundName(String fundName) {
		this.fundName = fundName;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ProductFundTypeSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public ProductFundTypeSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
}
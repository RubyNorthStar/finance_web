package com.xsjrw.websit.domain.product;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:ProductFundType
 * 
 * @author wang.zx
 * @date 2014-9-29
 */
@SuppressWarnings("serial")
@Alias("ProductFundType")
public class ProductFundType extends BaseEntity {
	
	
	private String	fundName;		 /* 基金类型名称 */ 
	private Integer	status;		 /* 状态： 1 可用，2不可用 */ 
	private Date	createTime;		

	// Constructor
	public ProductFundType() {
	}
	
	/**
	 * full Constructor
	 */
	public ProductFundType(Integer id, String fundName, Integer status, Date createTime) {
		setId(id);
		this.fundName = fundName;
		this.status = status;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProductFundType可以实现连缀设置属性
	
	public String getFundName() {
		return fundName;
	}

	public ProductFundType setFundName(String fundName) {
		this.fundName = fundName;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ProductFundType setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public ProductFundType setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	@Override
	public String toString() {
		return "ProductFundType [" + "id=" + getId() + ", fundName=" + fundName + ", status=" + status + ", createTime=" + createTime +  "]";
	}
}

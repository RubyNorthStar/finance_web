package com.xsjrw.websit.domain.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:Industry
 * 
 * @author wang.zx
 * @date 2014-10-30
 */
@SuppressWarnings("serial")
@Alias("Industry")
public class Industry extends BaseEntity {
	
	
	private String	industryName;		 /* 所属行业名称 */ 
	private Date	createTime;		 /* 创建时间 */ 
	private Integer	status;		 /* 状态: 1:可用 2:不可用 */ 

	// Constructor
	public Industry() {
	}
	
	/**
	 * full Constructor
	 */
	public Industry(Integer id, String industryName, Date createTime, Integer status) {
		setId(id);
		this.industryName = industryName;
		this.createTime = createTime;
		this.status = status;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Industry可以实现连缀设置属性
	
	public String getIndustryName() {
		return industryName;
	}

	public Industry setIndustryName(String industryName) {
		this.industryName = industryName;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public Industry setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public Industry setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public String toString() {
		return "Industry [" + "id=" + getId() + ", industryName=" + industryName + ", createTime=" + createTime + ", status=" + status +  "]";
	}
}

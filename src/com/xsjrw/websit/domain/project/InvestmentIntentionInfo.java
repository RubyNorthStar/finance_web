package com.xsjrw.websit.domain.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:InvestmentIntentionInfo
 * 
 * @author wang.zx
 * @date 2014-11-9
 */
@SuppressWarnings("serial")
@Alias("InvestmentIntentionInfo")
public class InvestmentIntentionInfo extends BaseEntity {
	
	
	private String	investName;		 /* 投资意向名称 */ 
	private Integer	isMall;		 	/* 是否发送邮件: 1:发送邮件 2：不发送邮件 */ 
	private String  agencyName; 	/*投资机构名称*/
	private String	orgAddress;		 /* 投资机构所在地 */ 
	private String	investType;		 /* 投资类型 */ 
	private String	investStyle;		 /* 投资形式 */ 
	private String	investMode;		 /* 投资方式 */ 
	private String	industry;		 /* 投资行业 */ 
	private String	area;		 /* 投资地区 */ 
	private String	enterpriseType;		 /* 投资企业类型 */ 
	private String	investScale;		 /* 投资规模 */ 
	private String	getRequire;		 /* 投资回报率要求 */ 
	private String	keyWord;		 /* 关键字 */ 
	private Integer	imageId;		
	private Date	beginTime;		 /* 开始时间 */ 
	private Date	endTime;		 /* 结束时间 */ 
	private String	investOrgInfo;		 /* 投资机构介绍 */ 
	private String	investRequire;		 /* 对投资机构要求 */ 
	private String	otherRequire;		 /* 其他要求 */ 
	private Date	createTime;		 /* 创建时间 */ 
	private Integer	status;		 /* 状态-1.审核未通过  1:未审核  2.已审核 3.已发布 4.已下架(审核通过，过期未成交) 5.已成交 */ 

	// Constructor
	public InvestmentIntentionInfo() {
	}
	
	/**
	 * full Constructor
	 */
	public InvestmentIntentionInfo(Integer id, String investName, String agencyName, Integer isMall, String orgAddress, String investType, String investStyle, String investMode, String industry, String area, String enterpriseType, String investScale, String getRequire, 
			String keyWord, Integer imageId, Date beginTime, Date endTime, String investOrgInfo, String investRequire, String otherRequire, Date createTime, Integer status) {
		setId(id);
		this.investName = investName;
		this.isMall = isMall;
		this.orgAddress = orgAddress;
		this.agencyName = agencyName;
		this.investType = investType;
		this.investStyle = investStyle;
		this.investMode = investMode;
		this.industry = industry;
		this.area = area;
		this.enterpriseType = enterpriseType;
		this.investScale = investScale;
		this.getRequire = getRequire;
		this.keyWord = keyWord;
		this.imageId = imageId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.investOrgInfo = investOrgInfo;
		this.investRequire = investRequire;
		this.otherRequire = otherRequire;
		this.createTime = createTime;
		this.status = status;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为InvestmentIntentionInfo可以实现连缀设置属性
	
	public String getInvestName() {
		return investName;
	}

	public InvestmentIntentionInfo setInvestName(String investName) {
		this.investName = investName;
		return this;
	}
	
	
	public Integer getIsMall() {
		return isMall;
	}

	public InvestmentIntentionInfo setIsMall(Integer isMall) {
		this.isMall = isMall;
		return this;
	}
	
	
	public String getOrgAddress() {
		return orgAddress;
	}

	public InvestmentIntentionInfo setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
		return this;
	}
	
	
	public String getInvestType() {
		return investType;
	}

	public InvestmentIntentionInfo setInvestType(String investType) {
		this.investType = investType;
		return this;
	}
	
	
	public String getInvestStyle() {
		return investStyle;
	}

	public InvestmentIntentionInfo setInvestStyle(String investStyle) {
		this.investStyle = investStyle;
		return this;
	}
	
	
	public String getInvestMode() {
		return investMode;
	}

	public InvestmentIntentionInfo setInvestMode(String investMode) {
		this.investMode = investMode;
		return this;
	}
	
	
	public String getIndustry() {
		return industry;
	}

	public InvestmentIntentionInfo setIndustry(String industry) {
		this.industry = industry;
		return this;
	}
	
	
	public String getArea() {
		return area;
	}

	public InvestmentIntentionInfo setArea(String area) {
		this.area = area;
		return this;
	}
	
	
	public String getEnterpriseType() {
		return enterpriseType;
	}

	public InvestmentIntentionInfo setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
		return this;
	}
	
	
	public String getInvestScale() {
		return investScale;
	}

	public InvestmentIntentionInfo setInvestScale(String investScale) {
		this.investScale = investScale;
		return this;
	}
	
	
	public String getGetRequire() {
		return getRequire;
	}

	public InvestmentIntentionInfo setGetRequire(String getRequire) {
		this.getRequire = getRequire;
		return this;
	}
	
	
	public String getKeyWord() {
		return keyWord;
	}

	public InvestmentIntentionInfo setKeyWord(String keyWord) {
		this.keyWord = keyWord;
		return this;
	}
	
	
	public Integer getImageId() {
		return imageId;
	}

	public InvestmentIntentionInfo setImageId(Integer imageId) {
		this.imageId = imageId;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getBeginTime() {
		return beginTime;
	}

	public InvestmentIntentionInfo setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}

	public InvestmentIntentionInfo setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	
	public String getInvestOrgInfo() {
		return investOrgInfo;
	}

	public InvestmentIntentionInfo setInvestOrgInfo(String investOrgInfo) {
		this.investOrgInfo = investOrgInfo;
		return this;
	}
	
	
	public String getInvestRequire() {
		return investRequire;
	}

	public InvestmentIntentionInfo setInvestRequire(String investRequire) {
		this.investRequire = investRequire;
		return this;
	}
	
	
	public String getOtherRequire() {
		return otherRequire;
	}

	public InvestmentIntentionInfo setOtherRequire(String otherRequire) {
		this.otherRequire = otherRequire;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public InvestmentIntentionInfo setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "InvestmentIntentionInfo [" + "id=" + getId() + ", investName=" + investName + ", isMall=" + isMall + ", orgAddress=" + orgAddress + ", investType=" + investType + ", investStyle=" + investStyle + ", investMode=" + investMode + ", industry=" + industry + ", area=" + area + ", enterpriseType=" + enterpriseType + ", investScale=" + investScale + ", getRequire=" + getRequire + ", keyWord=" + keyWord + ", imageId=" + imageId + ", beginTime=" + beginTime + ", endTime=" + endTime + ", investOrgInfo=" + investOrgInfo + ", investRequire=" + investRequire + ", otherRequire=" + otherRequire + ", createTime=" + createTime +  "]";
	}
}

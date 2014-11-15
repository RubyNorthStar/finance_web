package com.xsjrw.websit.search.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:InvestmentIntentionInfo
 * 
 * @author wang.zx
 * @date 2014-11-9
 */
@SuppressWarnings({ "rawtypes" })
@Alias("InvestmentIntentionInfoSearch")
public class InvestmentIntentionInfoSearch extends PageModel {
	
	private Integer	id;		
	private String	investName;		 /* 投资名 */ 
	private Integer	isMall;		 /* 是否发送邮件: 1:发送邮件 2：不发送邮件 */ 
	private String	orgAddress;		 /* 投资机构所在地 */ 
	private String  agencyName; 	/*投资机构名称*/
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

	// Constructor
	public InvestmentIntentionInfoSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public InvestmentIntentionInfoSearch(Integer id, String investName, String agencyName, Integer isMall, String orgAddress, String investType, String investStyle, String investMode, String industry, String area, String enterpriseType, String investScale, String getRequire, String keyWord, Integer imageId, Date beginTime, Date endTime, String investOrgInfo, String investRequire, String otherRequire, Date createTime) {
		this.id = id;
		this.investName = investName;
		this.isMall = isMall;
		this.orgAddress = orgAddress;
		this.investType = investType;
		this.investStyle = investStyle;
		this.investMode = investMode;
		this.industry = industry;
		this.agencyName = agencyName;
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
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为InvestmentIntentionInfo可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public InvestmentIntentionInfoSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getInvestName() {
		return investName;
	}

	public InvestmentIntentionInfoSearch setInvestName(String investName) {
		this.investName = investName;
		return this;
	}
	
	public Integer getIsMall() {
		return isMall;
	}

	public InvestmentIntentionInfoSearch setIsMall(Integer isMall) {
		this.isMall = isMall;
		return this;
	}
	
	public String getOrgAddress() {
		return orgAddress;
	}

	public InvestmentIntentionInfoSearch setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
		return this;
	}
	
	public String getInvestType() {
		return investType;
	}

	public InvestmentIntentionInfoSearch setInvestType(String investType) {
		this.investType = investType;
		return this;
	}
	
	public String getInvestStyle() {
		return investStyle;
	}

	public InvestmentIntentionInfoSearch setInvestStyle(String investStyle) {
		this.investStyle = investStyle;
		return this;
	}
	
	public String getInvestMode() {
		return investMode;
	}

	public InvestmentIntentionInfoSearch setInvestMode(String investMode) {
		this.investMode = investMode;
		return this;
	}
	
	public String getIndustry() {
		return industry;
	}

	public InvestmentIntentionInfoSearch setIndustry(String industry) {
		this.industry = industry;
		return this;
	}
	
	public String getArea() {
		return area;
	}

	public InvestmentIntentionInfoSearch setArea(String area) {
		this.area = area;
		return this;
	}
	
	public String getEnterpriseType() {
		return enterpriseType;
	}

	public InvestmentIntentionInfoSearch setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
		return this;
	}
	
	public String getInvestScale() {
		return investScale;
	}

	public InvestmentIntentionInfoSearch setInvestScale(String investScale) {
		this.investScale = investScale;
		return this;
	}
	
	public String getGetRequire() {
		return getRequire;
	}

	public InvestmentIntentionInfoSearch setGetRequire(String getRequire) {
		this.getRequire = getRequire;
		return this;
	}
	
	public String getKeyWord() {
		return keyWord;
	}

	public InvestmentIntentionInfoSearch setKeyWord(String keyWord) {
		this.keyWord = keyWord;
		return this;
	}
	
	public Integer getImageId() {
		return imageId;
	}

	public InvestmentIntentionInfoSearch setImageId(Integer imageId) {
		this.imageId = imageId;
		return this;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}

	public InvestmentIntentionInfoSearch setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public InvestmentIntentionInfoSearch setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public String getInvestOrgInfo() {
		return investOrgInfo;
	}

	public InvestmentIntentionInfoSearch setInvestOrgInfo(String investOrgInfo) {
		this.investOrgInfo = investOrgInfo;
		return this;
	}
	
	public String getInvestRequire() {
		return investRequire;
	}

	public InvestmentIntentionInfoSearch setInvestRequire(String investRequire) {
		this.investRequire = investRequire;
		return this;
	}
	
	public String getOtherRequire() {
		return otherRequire;
	}

	public InvestmentIntentionInfoSearch setOtherRequire(String otherRequire) {
		this.otherRequire = otherRequire;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public InvestmentIntentionInfoSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
}
package com.xsjrw.websit.search.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:ProjectInfo
 * 
 * @author wang.zx
 * @date 2014-10-30
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ProjectInfoSearch")
public class ProjectInfoSearch extends PageModel {
	
	private Integer	id;		
	private String	projectName;		 /* 项目名称 */ 
	private Integer	projectType;		 /* 项目类型（转让/融资） */ 
	private String	projectTypeClassify;		 /* 项目类型-子分类 */ 
	private Integer	isMall;		 /* 是否发送邮件 */ 
	private String	proindustryId;		 /* 所属行业 */ 
	private String	proPrice;		 /* 需要融资金额/转让金额 */ 
	private String	addressProvince;		 /* 所在地区（省） */ 
	private String	addressCity;		 /* 所在地区（市） */ 
	private String	financingPartyName;		 /* 融资方名称 */ 
	private String	proImageId;		 /* 项目对应图片的sessionID */ 
	private Date	beginTime;		 /* 开始时间 */ 
	private Date	endTime;		 /* 结束时间 */ 
	private String	investorsRequire;		 /* 对投资方的要求(投资方应具备条件) */ 
	private String	proDetail;		 /* 项目详细(简介) */ 
	private Date	createTime;		 /* 创建时间 */ 
	private Integer	status;		 /* 状态  1:待审 2：审核通过 3：审核未通过 4：下架项目 5：成交项目 */ 

	// Constructor
	public ProjectInfoSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ProjectInfoSearch(Integer id, String projectName, Integer projectType, String projectTypeClassify, Integer isMall, String proindustryId, String proPrice, String addressProvince, String addressCity, String financingPartyName, String proImageId, Date beginTime, Date endTime, String investorsRequire, String proDetail, Date createTime, Integer status) {
		this.id = id;
		this.projectName = projectName;
		this.projectType = projectType;
		this.projectTypeClassify = projectTypeClassify;
		this.isMall = isMall;
		this.proindustryId = proindustryId;
		this.proPrice = proPrice;
		this.addressProvince = addressProvince;
		this.addressCity = addressCity;
		this.financingPartyName = financingPartyName;
		this.proImageId = proImageId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.investorsRequire = investorsRequire;
		this.proDetail = proDetail;
		this.createTime = createTime;
		this.status = status;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProjectInfo可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ProjectInfoSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public ProjectInfoSearch setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}
	
	public Integer getProjectType() {
		return projectType;
	}

	public ProjectInfoSearch setProjectType(Integer projectType) {
		this.projectType = projectType;
		return this;
	}
	
	public String getProjectTypeClassify() {
		return projectTypeClassify;
	}

	public ProjectInfoSearch setProjectTypeClassify(String projectTypeClassify) {
		this.projectTypeClassify = projectTypeClassify;
		return this;
	}
	
	public Integer getIsMall() {
		return isMall;
	}

	public ProjectInfoSearch setIsMall(Integer isMall) {
		this.isMall = isMall;
		return this;
	}
	
	public String getProindustryId() {
		return proindustryId;
	}

	public ProjectInfoSearch setProindustryId(String proindustryId) {
		this.proindustryId = proindustryId;
		return this;
	}
	
	public String getProPrice() {
		return proPrice;
	}

	public ProjectInfoSearch setProPrice(String proPrice) {
		this.proPrice = proPrice;
		return this;
	}
	
	public String getAddressProvince() {
		return addressProvince;
	}

	public ProjectInfoSearch setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
		return this;
	}
	
	public String getAddressCity() {
		return addressCity;
	}

	public ProjectInfoSearch setAddressCity(String addressCity) {
		this.addressCity = addressCity;
		return this;
	}
	
	public String getFinancingPartyName() {
		return financingPartyName;
	}

	public ProjectInfoSearch setFinancingPartyName(String financingPartyName) {
		this.financingPartyName = financingPartyName;
		return this;
	}
	
	public String getProImageId() {
		return proImageId;
	}

	public ProjectInfoSearch setProImageId(String proImageId) {
		this.proImageId = proImageId;
		return this;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}

	public ProjectInfoSearch setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public ProjectInfoSearch setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public String getInvestorsRequire() {
		return investorsRequire;
	}

	public ProjectInfoSearch setInvestorsRequire(String investorsRequire) {
		this.investorsRequire = investorsRequire;
		return this;
	}
	
	public String getProDetail() {
		return proDetail;
	}

	public ProjectInfoSearch setProDetail(String proDetail) {
		this.proDetail = proDetail;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public ProjectInfoSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ProjectInfoSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
}
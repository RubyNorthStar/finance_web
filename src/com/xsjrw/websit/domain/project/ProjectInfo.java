package com.xsjrw.websit.domain.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:ProjectInfo
 * 
 * @author wang.zx
 * @date 2014-10-30
 */
@SuppressWarnings("serial")
@Alias("ProjectInfo")
public class ProjectInfo extends BaseEntity {
	
	
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
	private Integer	status;		 /* 状态-1.审核未通过  1:未审核  2.已审核 3.已发布 4.已下架(审核通过，过期未成交) 5.已成交 6.删除 */ 
	private Integer userId;      /* 用户ID */

	// Constructor
	public ProjectInfo() {
	}
	
	/**
	 * full Constructor
	 */
	public ProjectInfo(Integer id, String projectName, Integer projectType, String projectTypeClassify, Integer isMall, String proindustryId, String proPrice, String addressProvince, String addressCity, String financingPartyName, String proImageId,
			Date beginTime, Date endTime, String investorsRequire, String proDetail, Date createTime, Integer status, Integer userId) {
		setId(id);
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
		this.userId = userId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProjectInfo可以实现连缀设置属性
	
	public String getProjectName() {
		return projectName;
	}

	public ProjectInfo setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}
	
	
	public Integer getProjectType() {
		return projectType;
	}

	public ProjectInfo setProjectType(Integer projectType) {
		this.projectType = projectType;
		return this;
	}
	
	
	public String getProjectTypeClassify() {
		return projectTypeClassify;
	}

	public ProjectInfo setProjectTypeClassify(String projectTypeClassify) {
		this.projectTypeClassify = projectTypeClassify;
		return this;
	}
	
	
	public Integer getIsMall() {
		return isMall;
	}

	public ProjectInfo setIsMall(Integer isMall) {
		this.isMall = isMall;
		return this;
	}
	
	
	public String getProindustryId() {
		return proindustryId;
	}

	public ProjectInfo setProindustryId(String proindustryId) {
		this.proindustryId = proindustryId;
		return this;
	}
	
	
	public String getProPrice() {
		return proPrice;
	}

	public ProjectInfo setProPrice(String proPrice) {
		this.proPrice = proPrice;
		return this;
	}
	
	
	public String getAddressProvince() {
		return addressProvince;
	}

	public ProjectInfo setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
		return this;
	}
	
	
	public String getAddressCity() {
		return addressCity;
	}

	public ProjectInfo setAddressCity(String addressCity) {
		this.addressCity = addressCity;
		return this;
	}
	
	
	public String getFinancingPartyName() {
		return financingPartyName;
	}

	public ProjectInfo setFinancingPartyName(String financingPartyName) {
		this.financingPartyName = financingPartyName;
		return this;
	}
	
	
	public String getProImageId() {
		return proImageId;
	}

	public ProjectInfo setProImageId(String proImageId) {
		this.proImageId = proImageId;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getBeginTime() {
		return beginTime;
	}

	public ProjectInfo setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}

	public ProjectInfo setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	
	public String getInvestorsRequire() {
		return investorsRequire;
	}

	public ProjectInfo setInvestorsRequire(String investorsRequire) {
		this.investorsRequire = investorsRequire;
		return this;
	}
	
	
	public String getProDetail() {
		return proDetail;
	}

	public ProjectInfo setProDetail(String proDetail) {
		this.proDetail = proDetail;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public ProjectInfo setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ProjectInfo setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProjectInfo [" + "id=" + getId() + ", projectName=" + projectName + ", projectType=" + projectType + ", projectTypeClassify=" + projectTypeClassify + ", isMall=" + isMall + ", proindustryId=" + proindustryId + ", proPrice=" + proPrice + ", addressProvince=" + addressProvince + ", addressCity=" + addressCity + ", financingPartyName=" + financingPartyName + ", proImageId=" + proImageId + ", beginTime=" + beginTime + ", endTime=" + endTime + ", investorsRequire=" + investorsRequire + ", proDetail=" + proDetail + ", createTime=" + createTime + ", status=" + status +  "]";
	}
}

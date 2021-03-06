package com.xsjrw.websit.domain.project;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:PublicNotice
 * 
 * @author wang.zx
 * @date 2014-11-4
 */
@SuppressWarnings("serial")
@Alias("PublicNotice")
public class PublicNotice extends BaseEntity {
	
	
	private String	noticeTitle;		 /* 公告标题 */ 
	private String	noticeViceTitle;		 /* 公告副标题 */ 
	private String	noticeDescription;		 /* 公告描述 */ 
	private String	source;		 /* 公告来源 */ 
	private String	category;		 /* 所属品类 */ 
	private String	classiFication;		 /* 公告分类 */ 
	private Integer	industryId;		 /* 所属行业 */ 
	private String	addressProvince;		 /* 所在地区（省） */ 
	private String	addressCity;		 /* 所在地区（市） */ 
	private double	floorPrice;		 /* 底价(以万元为单位) */ 
	private Date	beginTime;		 /* 开始时间 */ 
	private Date	endTime;		 /* 结束时间 */ 
	private Integer	isMall;		 /* 是否发送邮件 */ 
	private String	content;		 /* 公告内容 */ 
	private Integer	status;		 /* 状态 1.未审核 2.已审核 */ 
	private Date	createTime;		 /* 创建时间 */ 
	
	private String person;  	   /* 联系人*/
	private String phone;		   /* 电话*/
	private String mobile;		   /* 手机*/
	private String email;		   /* 邮件*/
	
	private String industryStr;  // 所属行业
	private Integer userId;      /* 用户ID */

	// Constructor
	public PublicNotice() {
	}
	
	/**
	 * full Constructor
	 */
	public PublicNotice(Integer id, String noticeTitle, String noticeViceTitle, String noticeDescription, String source, String category, String classiFication, Integer industryId, String addressProvince, String addressCity, double floorPrice, 
			Date beginTime, Date endTime, Integer isMall, String content, Integer status, Date createTime, String person, String phone, String mobile, String email, Integer userId) {
		setId(id);
		this.noticeTitle = noticeTitle;
		this.noticeViceTitle = noticeViceTitle;
		this.noticeDescription = noticeDescription;
		this.source = source;
		this.category = category;
		this.classiFication = classiFication;
		this.industryId = industryId;
		this.addressProvince = addressProvince; 
		this.addressCity = addressCity;
		this.floorPrice = floorPrice;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.isMall = isMall;
		this.content = content;
		this.status = status;
		this.createTime = createTime;
		this.person = person;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.userId = userId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为PublicNotice可以实现连缀设置属性
	
	public String getNoticeTitle() {
		return noticeTitle;
	}

	public PublicNotice setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
		return this;
	}
	
	
	public String getNoticeViceTitle() {
		return noticeViceTitle;
	}

	public PublicNotice setNoticeViceTitle(String noticeViceTitle) {
		this.noticeViceTitle = noticeViceTitle;
		return this;
	}
	
	
	public String getNoticeDescription() {
		return noticeDescription;
	}

	public PublicNotice setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
		return this;
	}
	
	
	public String getSource() {
		return source;
	}

	public PublicNotice setSource(String source) {
		this.source = source;
		return this;
	}
	
	
	public String getCategory() {
		return category;
	}

	public PublicNotice setCategory(String category) {
		this.category = category;
		return this;
	}
	
	
	public String getClassiFication() {
		return classiFication;
	}

	public PublicNotice setClassiFication(String classiFication) {
		this.classiFication = classiFication;
		return this;
	}
	
	
	public Integer getIndustryId() {
		return industryId;
	}

	public PublicNotice setIndustryId(Integer industryId) {
		this.industryId = industryId;
		return this;
	}
	
	
	public String getAddressProvince() {
		return addressProvince;
	}

	public PublicNotice setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
		return this;
	}
	
	
	public String getAddressCity() {
		return addressCity;
	}

	public PublicNotice setAddressCity(String addressCity) {
		this.addressCity = addressCity;
		return this;
	}
	
	
	public double getFloorPrice() {
		return floorPrice;
	}

	public PublicNotice setFloorPrice(double floorPrice) {
		this.floorPrice = floorPrice;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getBeginTime() {
		return beginTime;
	}

	public PublicNotice setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}

	public PublicNotice setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	
	public Integer getIsMall() {
		return isMall;
	}

	public PublicNotice setIsMall(Integer isMall) {
		this.isMall = isMall;
		return this;
	}
	
	
	public String getContent() {
		return content;
	}

	public PublicNotice setContent(String content) {
		this.content = content;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public PublicNotice setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public PublicNotice setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndustryStr() {
		return industryStr;
	}

	public void setIndustryStr(String industryStr) {
		this.industryStr = industryStr;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PublicNotice [" + "id=" + getId() + ", noticeTitle=" + noticeTitle + ", noticeViceTitle=" + noticeViceTitle + ", noticeDescription=" + noticeDescription + ", source=" + source + ", category=" + category + ", classiFication=" + classiFication + ", industryId=" + industryId + ", addressProvince=" + addressProvince + ", addressCity=" + addressCity + ", floorPrice=" + floorPrice + ", beginTime=" + beginTime + ", endTime=" + endTime + ", isMall=" + isMall + ", content=" + content + ", status=" + status + ", createTime=" + createTime +  "]";
	}
}

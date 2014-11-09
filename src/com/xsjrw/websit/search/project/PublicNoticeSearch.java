package com.xsjrw.websit.search.project;

import java.util.Date;
import org.apache.ibatis.type.Alias;
import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:PublicNotice
 * 
 * @author wang.zx
 * @date 2014-11-4
 */
@SuppressWarnings({ "rawtypes" })
@Alias("PublicNoticeSearch")
public class PublicNoticeSearch extends PageModel {
	
	private Integer	id;		
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
	private Integer	status;		 /* 状态 */ 
	private Date	createTime;		 /* 创建时间 */ 

	// Constructor
	public PublicNoticeSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public PublicNoticeSearch(Integer id, String noticeTitle, String noticeViceTitle, String noticeDescription, String source, String category, String classiFication, Integer industryId, String addressProvince, String addressCity, double floorPrice, Date beginTime, Date endTime, Integer isMall, String content, Integer status, Date createTime) {
		this.id = id;
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
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为PublicNotice可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public PublicNoticeSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}

	public PublicNoticeSearch setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
		return this;
	}
	
	public String getNoticeViceTitle() {
		return noticeViceTitle;
	}

	public PublicNoticeSearch setNoticeViceTitle(String noticeViceTitle) {
		this.noticeViceTitle = noticeViceTitle;
		return this;
	}
	
	public String getNoticeDescription() {
		return noticeDescription;
	}

	public PublicNoticeSearch setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
		return this;
	}
	
	public String getSource() {
		return source;
	}

	public PublicNoticeSearch setSource(String source) {
		this.source = source;
		return this;
	}
	
	public String getCategory() {
		return category;
	}

	public PublicNoticeSearch setCategory(String category) {
		this.category = category;
		return this;
	}
	
	public String getClassiFication() {
		return classiFication;
	}

	public PublicNoticeSearch setClassiFication(String classiFication) {
		this.classiFication = classiFication;
		return this;
	}
	
	public Integer getIndustryId() {
		return industryId;
	}

	public PublicNoticeSearch setIndustryId(Integer industryId) {
		this.industryId = industryId;
		return this;
	}
	
	public String getAddressProvince() {
		return addressProvince;
	}

	public PublicNoticeSearch setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
		return this;
	}
	
	public String getAddressCity() {
		return addressCity;
	}

	public PublicNoticeSearch setAddressCity(String addressCity) {
		this.addressCity = addressCity;
		return this;
	}
	
	public double getFloorPrice() {
		return floorPrice;
	}

	public PublicNoticeSearch setFloorPrice(double floorPrice) {
		this.floorPrice = floorPrice;
		return this;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}

	public PublicNoticeSearch setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public PublicNoticeSearch setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public Integer getIsMall() {
		return isMall;
	}

	public PublicNoticeSearch setIsMall(Integer isMall) {
		this.isMall = isMall;
		return this;
	}
	
	public String getContent() {
		return content;
	}

	public PublicNoticeSearch setContent(String content) {
		this.content = content;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public PublicNoticeSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public PublicNoticeSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
}
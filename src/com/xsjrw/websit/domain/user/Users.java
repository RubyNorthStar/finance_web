package com.xsjrw.websit.domain.user;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.xsjrw.common.util.ShortDateSerializer;

import org.apache.ibatis.type.Alias;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:Users
 * 
 * @author xuyl
 * @date 2014-5-12
 */
@SuppressWarnings("serial")
@Alias("Users")
public class Users extends BaseEntity {
	
	
	private String	username;		
	private String	mobile;		
	private String	email;		
	private String	password;		
	private Integer	usertype;		 /* 存储字典表里的代码值 1：直接注册用户； 2：微博注册用户； 3：后台管理用户； */ 
	private Date	registTime;		
	private Integer	state;		 /* 0：无效；1：有效 */ 
	private Integer	authSign;		 /* 如果增加邮箱验证功能时使用该字段 0???未验证；1：已验证 */ 
	private String	authCode;		 /* 发送给用户注册邮箱中的验证码或者验证的url连接 */ 
	private Date	authSendtime;		 /* 验证码或验证url发送时间 */ 
	private String	unionName;		
	private String	parter;		 /* 1.新浪微博2.腾讯微博 */ 
	private String	picUrl;		
	private String	truename;		
	private String	selfDesc;		
	private String	personalPage;		
	private String	headline;		
	private String	interests;		 /* 根据用户的兴趣标签给用户推荐课程用逗????隔存储，如1,2 */ 
	private Integer	verifyStatus;		
	private String	userAddress;		
	private String	origin;		
	private String	referrer;		
	private String	uuid;		
	private String	keyPromotion;		
	private String	sourcePromotion;		
	private String	mPromotion;		
	private String	sendEmailDate;		
	private String	sex;		
	private String	qqNum;		
	private String	sign;		
	private Integer	messageSet;		
	private Integer	noteSet;		
	private Integer	money;		
	private String	medal;		
	private Integer	continueSignDay;		
	private String	phoneIdCode;		
	private String	loginType;		
	private Integer	vip;		
	private String	picUrlMid;		
	private String	picUrlMin;		
	private String	profession;		
	private Date	birthDay;		
	private String	education;		
	private Date	examineDay;		
	private String	examineProvince;		 /* 计划考试省 */ 
	private String	examineCity;		 /* 计划考试市 */ 
	private String	isReadTips;		 /* 是否阅读引导  ‘false,true’  第一个表示首页 第二个表示个人中心和做题首页 */ 
	private Integer	backImgNum;		 /* 个人中心 背景图片 索引 0~5 */ 

	// Constructor
	public Users() {
	}
	
	/**
	 * full Constructor
	 */
	public Users(Integer id, String username, String mobile, String email, String password, Integer usertype, Date registTime, Integer state, Integer authSign, String authCode, Date authSendtime, String unionName, String parter, String picUrl, String truename, String selfDesc, String personalPage, String headline, String interests, Integer verifyStatus, String userAddress, String origin, String referrer, String uuid, String keyPromotion, String sourcePromotion, String mPromotion, String sendEmailDate, String sex, String qqNum, String sign, Integer messageSet, Integer noteSet, Integer money, String medal, Integer continueSignDay, String phoneIdCode, String loginType, Integer vip, String picUrlMid, String picUrlMin, String profession, Date birthDay, String education, Date examineDay, String examineProvince, String examineCity, String isReadTips, Integer backImgNum) {
		setId(id);
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.registTime = registTime;
		this.state = state;
		this.authSign = authSign;
		this.authCode = authCode;
		this.authSendtime = authSendtime;
		this.unionName = unionName;
		this.parter = parter;
		this.picUrl = picUrl;
		this.truename = truename;
		this.selfDesc = selfDesc;
		this.personalPage = personalPage;
		this.headline = headline;
		this.interests = interests;
		this.verifyStatus = verifyStatus;
		this.userAddress = userAddress;
		this.origin = origin;
		this.referrer = referrer;
		this.uuid = uuid;
		this.keyPromotion = keyPromotion;
		this.sourcePromotion = sourcePromotion;
		this.mPromotion = mPromotion;
		this.sendEmailDate = sendEmailDate;
		this.sex = sex;
		this.qqNum = qqNum;
		this.sign = sign;
		this.messageSet = messageSet;
		this.noteSet = noteSet;
		this.money = money;
		this.medal = medal;
		this.continueSignDay = continueSignDay;
		this.phoneIdCode = phoneIdCode;
		this.loginType = loginType;
		this.vip = vip;
		this.picUrlMid = picUrlMid;
		this.picUrlMin = picUrlMin;
		this.profession = profession;
		this.birthDay = birthDay;
		this.education = education;
		this.examineDay = examineDay;
		this.examineProvince = examineProvince;
		this.examineCity = examineCity;
		this.isReadTips = isReadTips;
		this.backImgNum = backImgNum;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Users可以实现连缀设置属性
	
	public String getUsername() {
		return username;
	}

	public Users setUsername(String username) {
		this.username = username;
		return this;
	}
	
	
	public String getMobile() {
		return mobile;
	}

	public Users setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	
	public String getEmail() {
		return email;
	}

	public Users setEmail(String email) {
		this.email = email;
		return this;
	}
	
	
	public String getPassword() {
		return password;
	}

	public Users setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	public Integer getUsertype() {
		return usertype;
	}

	public Users setUsertype(Integer usertype) {
		this.usertype = usertype;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getRegistTime() {
		return registTime;
	}

	public Users setRegistTime(Date registTime) {
		this.registTime = registTime;
		return this;
	}
	
	
	public Integer getState() {
		return state;
	}

	public Users setState(Integer state) {
		this.state = state;
		return this;
	}
	
	
	public Integer getAuthSign() {
		return authSign;
	}

	public Users setAuthSign(Integer authSign) {
		this.authSign = authSign;
		return this;
	}
	
	
	public String getAuthCode() {
		return authCode;
	}

	public Users setAuthCode(String authCode) {
		this.authCode = authCode;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getAuthSendtime() {
		return authSendtime;
	}

	public Users setAuthSendtime(Date authSendtime) {
		this.authSendtime = authSendtime;
		return this;
	}
	
	
	public String getUnionName() {
		return unionName;
	}

	public Users setUnionName(String unionName) {
		this.unionName = unionName;
		return this;
	}
	
	
	public String getParter() {
		return parter;
	}

	public Users setParter(String parter) {
		this.parter = parter;
		return this;
	}
	
	
	public String getPicUrl() {
		return picUrl;
	}

	public Users setPicUrl(String picUrl) {
		this.picUrl = picUrl;
		return this;
	}
	
	
	public String getTruename() {
		return truename;
	}

	public Users setTruename(String truename) {
		this.truename = truename;
		return this;
	}
	
	
	public String getSelfDesc() {
		return selfDesc;
	}

	public Users setSelfDesc(String selfDesc) {
		this.selfDesc = selfDesc;
		return this;
	}
	
	
	public String getPersonalPage() {
		return personalPage;
	}

	public Users setPersonalPage(String personalPage) {
		this.personalPage = personalPage;
		return this;
	}
	
	
	public String getHeadline() {
		return headline;
	}

	public Users setHeadline(String headline) {
		this.headline = headline;
		return this;
	}
	
	
	public String getInterests() {
		return interests;
	}

	public Users setInterests(String interests) {
		this.interests = interests;
		return this;
	}
	
	
	public Integer getVerifyStatus() {
		return verifyStatus;
	}

	public Users setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
		return this;
	}
	
	
	public String getUserAddress() {
		return userAddress;
	}

	public Users setUserAddress(String userAddress) {
		this.userAddress = userAddress;
		return this;
	}
	
	
	public String getOrigin() {
		return origin;
	}

	public Users setOrigin(String origin) {
		this.origin = origin;
		return this;
	}
	
	
	public String getReferrer() {
		return referrer;
	}

	public Users setReferrer(String referrer) {
		this.referrer = referrer;
		return this;
	}
	
	
	public String getUuid() {
		return uuid;
	}

	public Users setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}
	
	
	public String getKeyPromotion() {
		return keyPromotion;
	}

	public Users setKeyPromotion(String keyPromotion) {
		this.keyPromotion = keyPromotion;
		return this;
	}
	
	
	public String getSourcePromotion() {
		return sourcePromotion;
	}

	public Users setSourcePromotion(String sourcePromotion) {
		this.sourcePromotion = sourcePromotion;
		return this;
	}
	
	
	public String getMPromotion() {
		return mPromotion;
	}

	public Users setMPromotion(String mPromotion) {
		this.mPromotion = mPromotion;
		return this;
	}
	
	
	public String getSendEmailDate() {
		return sendEmailDate;
	}

	public Users setSendEmailDate(String sendEmailDate) {
		this.sendEmailDate = sendEmailDate;
		return this;
	}
	
	
	public String getSex() {
		return sex;
	}

	public Users setSex(String sex) {
		this.sex = sex;
		return this;
	}
	
	
	public String getQqNum() {
		return qqNum;
	}

	public Users setQqNum(String qqNum) {
		this.qqNum = qqNum;
		return this;
	}
	
	
	public String getSign() {
		return sign;
	}

	public Users setSign(String sign) {
		this.sign = sign;
		return this;
	}
	
	
	public Integer getMessageSet() {
		return messageSet;
	}

	public Users setMessageSet(Integer messageSet) {
		this.messageSet = messageSet;
		return this;
	}
	
	
	public Integer getNoteSet() {
		return noteSet;
	}

	public Users setNoteSet(Integer noteSet) {
		this.noteSet = noteSet;
		return this;
	}
	
	
	public Integer getMoney() {
		return money;
	}

	public Users setMoney(Integer money) {
		this.money = money;
		return this;
	}
	
	
	public String getMedal() {
		return medal;
	}

	public Users setMedal(String medal) {
		this.medal = medal;
		return this;
	}
	
	
	public Integer getContinueSignDay() {
		return continueSignDay;
	}

	public Users setContinueSignDay(Integer continueSignDay) {
		this.continueSignDay = continueSignDay;
		return this;
	}
	
	
	public String getPhoneIdCode() {
		return phoneIdCode;
	}

	public Users setPhoneIdCode(String phoneIdCode) {
		this.phoneIdCode = phoneIdCode;
		return this;
	}
	
	
	public String getLoginType() {
		return loginType;
	}

	public Users setLoginType(String loginType) {
		this.loginType = loginType;
		return this;
	}
	
	
	public Integer getVip() {
		return vip;
	}

	public Users setVip(Integer vip) {
		this.vip = vip;
		return this;
	}
	
	
	public String getPicUrlMid() {
		return picUrlMid;
	}

	public Users setPicUrlMid(String picUrlMid) {
		this.picUrlMid = picUrlMid;
		return this;
	}
	
	
	public String getPicUrlMin() {
		return picUrlMin;
	}

	public Users setPicUrlMin(String picUrlMin) {
		this.picUrlMin = picUrlMin;
		return this;
	}
	
	
	public String getProfession() {
		return profession;
	}

	public Users setProfession(String profession) {
		this.profession = profession;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getBirthDay() {
		return birthDay;
	}

	public Users setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
		return this;
	}
	
	
	public String getEducation() {
		return education;
	}

	public Users setEducation(String education) {
		this.education = education;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getExamineDay() {
		return examineDay;
	}

	public Users setExamineDay(Date examineDay) {
		this.examineDay = examineDay;
		return this;
	}
	
	
	public String getExamineProvince() {
		return examineProvince;
	}

	public Users setExamineProvince(String examineProvince) {
		this.examineProvince = examineProvince;
		return this;
	}
	
	
	public String getExamineCity() {
		return examineCity;
	}

	public Users setExamineCity(String examineCity) {
		this.examineCity = examineCity;
		return this;
	}
	
	
	public String getIsReadTips() {
		return isReadTips;
	}

	public Users setIsReadTips(String isReadTips) {
		this.isReadTips = isReadTips;
		return this;
	}
	
	
	public Integer getBackImgNum() {
		return backImgNum;
	}

	public Users setBackImgNum(Integer backImgNum) {
		this.backImgNum = backImgNum;
		return this;
	}
	
	@Override
	public String toString() {
		return "Users [" + "id=" + getId() + ", username=" + username + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", usertype=" + usertype + ", registTime=" + registTime + ", state=" + state + ", authSign=" + authSign + ", authCode=" + authCode + ", authSendtime=" + authSendtime + ", unionName=" + unionName + ", parter=" + parter + ", picUrl=" + picUrl + ", truename=" + truename + ", selfDesc=" + selfDesc + ", personalPage=" + personalPage + ", headline=" + headline + ", interests=" + interests + ", verifyStatus=" + verifyStatus + ", userAddress=" + userAddress + ", origin=" + origin + ", referrer=" + referrer + ", uuid=" + uuid + ", keyPromotion=" + keyPromotion + ", sourcePromotion=" + sourcePromotion + ", mPromotion=" + mPromotion + ", sendEmailDate=" + sendEmailDate + ", sex=" + sex + ", qqNum=" + qqNum + ", sign=" + sign + ", messageSet=" + messageSet + ", noteSet=" + noteSet + ", money=" + money + ", medal=" + medal + ", continueSignDay=" + continueSignDay + ", phoneIdCode=" + phoneIdCode + ", loginType=" + loginType + ", vip=" + vip + ", picUrlMid=" + picUrlMid + ", picUrlMin=" + picUrlMin + ", profession=" + profession + ", birthDay=" + birthDay + ", education=" + education + ", examineDay=" + examineDay + ", examineProvince=" + examineProvince + ", examineCity=" + examineCity + ", isReadTips=" + isReadTips + ", backImgNum=" + backImgNum +  "]";
	}
}

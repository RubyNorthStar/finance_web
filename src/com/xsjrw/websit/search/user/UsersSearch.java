package com.xsjrw.websit.search.user;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:Users
 * 
 * @author wang.zx
 * @date 2014-9-25
 */
@Alias("UsersSearch")
public class UsersSearch extends PageModel<UsersSearch> {
	
	private Integer	id;		 /* PK */ 
	private String	username;		
	private String	mobile;		
	private String	email;		
	private String	password;		
	private Integer	usertype;		 /* 存储字典表里的代码值 1：直接注册用户； 2：微博注册用户； 3：后台管理用户； */ 
	private Date	registTime;		
	private Integer	state;		 /* 0：无效；1：有效 */ 
	private String	userAddress;	
	private String sex;
	private String	picUrl;		

	// Constructor
	public UsersSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public UsersSearch(Integer id, String username, String mobile, String email, String password, 
			Integer usertype, Date registTime, Integer state, String picUrl, String userAddress,String sex) {
		this.id = id;
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.registTime = registTime;
		this.state = state;
		this.picUrl = picUrl;
		this.userAddress = userAddress;
		this.sex = sex;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Users可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public UsersSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getUsername() {
		return username;
	}

	public UsersSearch setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public String getMobile() {
		return mobile;
	}

	public UsersSearch setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public String getEmail() {
		return email;
	}

	public UsersSearch setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getPassword() {
		return password;
	}

	public UsersSearch setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public Integer getUsertype() {
		return usertype;
	}

	public UsersSearch setUsertype(Integer usertype) {
		this.usertype = usertype;
		return this;
	}
	
	public Date getRegistTime() {
		return registTime;
	}

	public UsersSearch setRegistTime(Date registTime) {
		this.registTime = registTime;
		return this;
	}
	
	public Integer getState() {
		return state;
	}

	public UsersSearch setState(Integer state) {
		this.state = state;
		return this;
	}
	
	public String getPicUrl() {
		return picUrl;
	}

	public UsersSearch setPicUrl(String picUrl) {
		this.picUrl = picUrl;
		return this;
	}
	
	
	public String getUserAddress() {
		return userAddress;
	}

	public UsersSearch setUserAddress(String userAddress) {
		this.userAddress = userAddress;
		return this;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
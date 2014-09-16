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
	private String  mobile;		
	private String	email;		
	private String	password;		
	private Integer	usertype;		 /* 存储字典表里的代码值 1：直接注册用户； 2：微博注册用户； 3：后台管理用户； */ 
	private Date	registTime;		
	private Integer	state;		 /* 0：无效；1：有效 */ 
	private String 	userAddress; 
	private String	sex;		
	private String	picUrl;		

	// Constructor
	public Users() {
	}
	
	/**
	 * full Constructor
	 */
	public Users(Integer id, String username, String mobile, String email, String password, 
			Integer usertype, Date registTime, Integer state, String picUrl,String userAddress, String sex) {
		setId(id);
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.registTime = registTime;
		this.state = state;
		this.userAddress = userAddress;
		this.sex = sex;
		this.picUrl = picUrl;
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
	
	public String getPicUrl() {
		return picUrl;
	}

	public Users setPicUrl(String picUrl) {
		this.picUrl = picUrl;
		return this;
	}
	
	public String getUserAddress() {
		return userAddress;
	}

	public Users setUserAddress(String userAddress) {
		this.userAddress = userAddress;
		return this;
	}
	
	
	
	public String getSex() {
		return sex;
	}

	public Users setSex(String sex) {
		this.sex = sex;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "Users [" + "id=" + getId() + ", username=" + username + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", usertype=" + usertype + ", registTime=" + registTime + ", state=" + state + ", picUrl=" + picUrl + ", userAddress=" + userAddress + ", sex=" + sex +   "]";
	}
}

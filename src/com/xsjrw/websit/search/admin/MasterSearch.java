package com.xsjrw.websit.search.admin;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

@SuppressWarnings("rawtypes")
@Alias("masterSearch")
public class MasterSearch extends PageModel {
	private String account;
	private String name;
	private String position;
	private String telephone;
	private String mobile;
	private String email;
	private Short forbidden;
	
	public MasterSearch() {
		
	}

	public MasterSearch(String account, String name, String position,
			String telephone, String mobile, String email, Short forbidden) {
		super();
		this.account = account;
		this.name = name;
		this.position = position;
		this.telephone = telephone;
		this.mobile = mobile;
		this.email = email;
		this.forbidden = forbidden;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public Short getForbidden() {
		return forbidden;
	}

	public void setForbidden(Short forbidden) {
		this.forbidden = forbidden;
	}
}

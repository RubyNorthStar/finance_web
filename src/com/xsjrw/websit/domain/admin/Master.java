package com.xsjrw.websit.domain.admin;

import java.io.Serializable;
import java.util.Set;

public class Master implements Serializable{
	/**
	 * <class name="Master" table="manager">
	 */
	private static final long serialVersionUID = 5572604602767910829L;
	private Integer mtId;
	private String account;
	private String password;
	private String name;
	private String position;
	private String telephone;
	private String mobile;
	private String email;
	private String postDate;
	private boolean forbidden;
	private Set<MasterMapAction> masterMapActionList;
	
	public Integer getMtId() {
		return mtId;
	}

	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public boolean getForbidden() {
		return forbidden;
	}

	public void setForbidden(boolean forbidden) {
		this.forbidden = forbidden;
	}

	public Set<MasterMapAction> getMasterMapActionList() {
		return masterMapActionList;
	}

	public void setMasterMapActionList(Set<MasterMapAction> masterMapActionList) {
		this.masterMapActionList = masterMapActionList;
	}
}

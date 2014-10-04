package com.xsjrw.websit.domain.admin;

public class Master {
	private Integer mtId;
	private String account;
	private String password;
	private String name;
	private String position;
	private String telephone;
	private String mobile;
	private String email;
	private String postDate;
	private Short forbidden;

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
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate == null ? null : postDate.trim();
	}

	public Short getForbidden() {
		return forbidden;
	}

	public void setForbidden(Short forbidden) {
		this.forbidden = forbidden;
	}

	@Override
	public String toString() {
		return "ProductInfo [" + "mtId=" + mtId + ", account=" + account
				+ ", password=" + password + ", name=" + name + ", "
				+ "position=" + position + ", telephone=" + telephone
				+ ", mobile=" + mobile + ", email=" + email + ", forbidden="
				+ forbidden + "]";
	}
}
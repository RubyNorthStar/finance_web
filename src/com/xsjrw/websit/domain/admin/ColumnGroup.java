package com.xsjrw.websit.domain.admin;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class ColumnGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 576133982115946595L;
	private Integer cgId;
	private String name;
	private String masterName;
	private Date postDate;
	private String note;
	private Set<ActionColumn> actionColumnList;

	public Integer getCgId() {
		return cgId;
	}

	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<ActionColumn> getActionColumnList() {
		return actionColumnList;
	}

	public void setActionColumnList(Set<ActionColumn> actionColumnList) {
		this.actionColumnList = actionColumnList;
	}
}

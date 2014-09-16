package com.xsjrw.websit.dao.admin;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class ActionColumn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9182727773602620148L;
	private Integer acId;
	private String name;
	private Date postDate;
	private String note;
	private Set<Action> actionList;

	public Integer getAcId() {
		return acId;
	}

	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<Action> getActionList() {
		return actionList;
	}

	public void setActionList(Set<Action> actionList) {
		this.actionList = actionList;
	}
}

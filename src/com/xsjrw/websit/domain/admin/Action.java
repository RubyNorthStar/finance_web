package com.xsjrw.websit.domain.admin;

import java.io.Serializable;
import java.util.Date;

public class Action implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3030728463562017558L;
	private Integer atId;
	private String actionNo;	//权限编号，用英文字母编写，如：update_master
	private String name;		//权限名称
	private String masterName;
	private String actionPath;	//权限路径，如：/manage/manage_obtainAllMasterList.shtml
	private String actionDesc;	
	private Date postDate;
	private Integer viewmode; 	//0：表示不再左侧显示，1：表示在左侧显示。

	public Integer getAtId() {
		return atId;
	}

	public void setAtId(Integer atId) {
		this.atId = atId;
	}

	public String getActionNo() {
		return actionNo;
	}

	public void setActionNo(String actionNo) {
		this.actionNo = actionNo;
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

	public String getActionPath() {
		return actionPath;
	}

	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getViewmode() {
		return viewmode;
	}

	public void setViewmode(Integer viewmode) {
		this.viewmode = viewmode;
	}
}
package com.xsjrw.websit.domain.admin;

import java.util.Date;

public class Action {
    private Integer atId;

    private String name;

    private String masterName;

    private String actionDesc;

    private Date postDate;

    private Integer viewMode;

    private Integer acId;

    private String actionNo;

    private String actionPath;

    public Integer getAtId() {
        return atId;
    }

    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc == null ? null : actionDesc.trim();
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Integer getViewMode() {
        return viewMode;
    }

    public void setViewMode(Integer viewMode) {
        this.viewMode = viewMode;
    }

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public String getActionNo() {
        return actionNo;
    }

    public void setActionNo(String actionNo) {
        this.actionNo = actionNo == null ? null : actionNo.trim();
    }

    public String getActionPath() {
        return actionPath;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath == null ? null : actionPath.trim();
    }
}
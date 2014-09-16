package com.xsjrw.websit.domain.admin;

import java.util.Date;

public class ColumnGroup {
    private Integer cgId;

    private String name;

    private String masterName;

    private Date postName;

    private String note;

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
        this.name = name == null ? null : name.trim();
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    public Date getPostName() {
        return postName;
    }

    public void setPostName(Date postName) {
        this.postName = postName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}
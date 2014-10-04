package com.xsjrw.common.util;

import java.sql.Timestamp;

/**
 * 
 * 描述：文件bean，记录文件
 * 
 * @author yzp
 *
 */
public class FileBean {
	private String tagName;
	private String clientName;
	private String serverName;
	private String UUid;
	private String associateEntity;
	private Integer associateEntityId;
	private Timestamp uploadTime;
	private String fileSize;
	private String date;

	/**
	 * 
	 * 描述：附件标签名称
	 *
	 * @return
	 */
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * 
	 * 描述：客户端名称，存储源文件名称
	 *
	 * @return
	 */
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * 
	 * 描述：服务端名称，以模块名_时间戳.扩展名为名称
	 *
	 * @return
	 */
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getUUid() {
		return UUid;
	}
	public void setUUid(String uUid) {
		UUid = uUid;
	}
	public String getAssociateEntity() {
		return associateEntity;
	}
	public void setAssociateEntity(String associateEntity) {
		this.associateEntity = associateEntity;
	}
	public Integer getAssociateEntityId() {
		return associateEntityId;
	}
	public void setAssociateEntityId(Integer associateEntityId) {
		this.associateEntityId = associateEntityId;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}

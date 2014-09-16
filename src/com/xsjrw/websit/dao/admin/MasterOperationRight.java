package com.xsjrw.websit.dao.admin;

import java.io.Serializable;
import java.util.Date;

/**created on 2013-7-12 13:59:50
 * @author Hector Wang
 *<class name="MasterOperationRight" table="master_operation_right">
 */
public class MasterOperationRight implements Serializable {

	private static final long serialVersionUID = -6897875515725707488L;
	private Integer id;
	
	private Integer operatorId;
	private String operatorName;

	private Integer actionId;
	private String actionName;

	private Integer itemId;
	private String itemName;

	private Integer insertable = 0;
	private Integer deletable = 0;
	private Integer updatable = 0;
	private Integer queriable = 0;
	private Integer renamable = 0;

	private Date createTime;
	private Date updateTime;

	private Integer status = 0;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the operatorId
	 */
	public Integer getOperatorId() {
		return operatorId;
	}

	/**
	 * @param operatorId the operatorId to set
	 */
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * @param operatorName the operatorName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * @return the actionId
	 */
	public Integer getActionId() {
		return actionId;
	}

	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * @return the insertable
	 */
	public Integer getInsertable() {
		return insertable;
	}

	/**
	 * @param insertable the insertable to set
	 */
	public void setInsertable(Integer insertable) {
		this.insertable = insertable;
	}

	/**
	 * @return the deletable
	 */
	public Integer getDeletable() {
		return deletable;
	}

	/**
	 * @param deletable the deletable to set
	 */
	public void setDeletable(Integer deletable) {
		this.deletable = deletable;
	}

	/**
	 * @return the updatable
	 */
	public Integer getUpdatable() {
		return updatable;
	}

	/**
	 * @param updatable the updatable to set
	 */
	public void setUpdatable(Integer updatable) {
		this.updatable = updatable;
	}

	/**
	 * @return the queriable
	 */
	public Integer getQueriable() {
		return queriable;
	}

	/**
	 * @param queriable the queriable to set
	 */
	public void setQueriable(Integer queriable) {
		this.queriable = queriable;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MasterOperationRight [id=" + id + ", operatorId=" + operatorId
				+ ", operatorName=" + operatorName + ", actionId=" + actionId
				+ ", actionName=" + actionName + ", insertable=" + insertable
				+ ", deletable=" + deletable + ", updatable=" + updatable
				+ ", queriable=" + queriable + "]";
	}

	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the renamable
	 */
	public Integer getRenamable() {
		return renamable;
	}

	/**
	 * @param renamable the renamable to set
	 */
	public void setRenamable(Integer renamable) {
		this.renamable = renamable;
	}


}
/*
<class name="Master" table="manager">
<class name="MasterMapAction" table="master_map_action">

<class name="ColumnGroup" table="column_group">
<class name="ActionColumn" table="action_column">
<class name="Action" table="action">


drop table master_operation_right;
create table master_operation_right (
	id bigint identity not null, 
	
	operator_id int, --操作员 id
	operator_name varchar(255), -- 操作员 名字

	action_id int, --操作 id
	action_name varchar(255), -- 操作 名字

	item_id int, --操作对象 id
	item_name varchar(255), -- 操作对象 名字

	insertable int, --添加 id
	deletable int, --删除 id
	updatable int, --修改 id
	queriable int, --查看 id
	renamable int, --改名 id

	create_time datetime, --创建时间
	update_time datetime, --修改时间
	status int, --冗余
	
	primary key (id)
);



*/

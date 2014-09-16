package com.xsjrw.websit.domain.admin;

import java.io.Serializable;

public class MasterMapAction implements Serializable{
	/**
	 * <class name="MasterMapAction" table="master_map_action">
	 */
	private static final long serialVersionUID = -7380863413645694513L;
	private Integer mmaId;
	private Action action;
	private Master master;

	public Integer getMmaId() {
		return mmaId;
	}

	public void setMmaId(Integer mmaId) {
		this.mmaId = mmaId;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}
}
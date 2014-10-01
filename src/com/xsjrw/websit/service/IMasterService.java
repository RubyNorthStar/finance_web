package com.xsjrw.websit.service;

import java.util.List;

import com.xsjrw.common.util.Pager;
import com.xsjrw.websit.domain.admin.Action;
import com.xsjrw.websit.domain.admin.ColumnGroup;
import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.dto.MasterDTO;

/**
 * @author Zhiwei Wang
 */
public interface IMasterService {
	/**
	 * 根据账号获取管理员
	 * @param account
	 * @return
	 */
	public List<Master> obtainMasterListBuyAccount(String account);
	
	/**
	 * 保存管理员
	 * @param masterDTO
	 * @return
	 */
	public Master saveMaster(MasterDTO masterDTO);
	
	/**
	 * 获取管理员列表
	 * @param masterDTO
	 * @param page
	 * @return
	 */
	public Pager obtainMasterList(MasterDTO masterDTO, Integer page, Integer pageSize);
	
	/**
	 * 获取通过id获取管理员
	 * @param id
	 * @return
	 */
	public Master obtainMasterBuyId(Integer id);
	
	/**
	 * 更新管理员
	 * @param masterDTO
	 * @return
	 */
	public Master updateMaster(MasterDTO masterDTO);
	

	/**
	 * 获取所有权限分组列表
	 * @param masterDTO
	 * @param page
	 * @return
	 */
	public List<ColumnGroup> obtainAllColumnGroupList();
	
	/**
	 * 根据权限ID获取相对应权限
	 * @param id
	 * @return
	 */
	public Action obtainActionBuyId(Integer id);
	
	/**
	 * 更新管理员
	 * @param masterDTO
	 * @return
	 */
	public Master updateMaster(Master master);
	
	/**
	 * 删除相应管理员权限
	 * @param masterDTO
	 * @return
	 */
	public void deleteMasterActions(Master master);
	
	/**
	 * 获取所有管理员列表
	 * @return
	 */
	public List<Master> obtainAllMasterList();
}

package com.xsjrw.websit.service;

import java.util.List;

import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.search.admin.MasterSearch;

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
	public void saveMaster(Master master);
	
	/**
	 * 获取管理员列表
	 * @param masterDTO
	 * @param page
	 * @return
	 */
	public List<Master> obtainMasterList(MasterSearch masterSearch);
	
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
	public Master updateMaster(Master master);
}

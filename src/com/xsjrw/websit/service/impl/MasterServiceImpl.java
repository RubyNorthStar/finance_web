package com.xsjrw.websit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xsjrw.common.util.DateUtil;
import com.xsjrw.websit.dao.admin.MasterMapper;
import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.dto.MasterDTO;
import com.xsjrw.websit.search.admin.MasterSearch;
import com.xsjrw.websit.service.IMasterService;


@Component
@SuppressWarnings("all")
/**
 * @author Zhiwei Wang
 */
public class MasterServiceImpl implements IMasterService{
	Logger logger = Logger.getLogger(MasterServiceImpl.class);

	@Resource private MasterMapper masterMapper;
	/**
	 * 根据账号获取管理员
	 * @param account
	 * @return
	 */
	public List<Master> obtainMasterListBuyAccount(String account){
		if(!StringUtils.isBlank(account)){
			try {
				List<Master> masterList = masterMapper.selectByMasterAccount(account);
				
				if(masterList != null){
					
					return masterList;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * 保存管理员
	 * @param masterDTO
	 * @return
	 */
	public void saveMaster(Master tempMaster){
		Master master = masterMapper.selectByPrimaryKey(tempMaster.getMtId());
		if(master == null){
			master = new Master();
			master.setAccount(tempMaster.getAccount());
			master.setPassword(tempMaster.getPassword());
			master.setName(tempMaster.getName());
			master.setPosition(tempMaster.getPosition());
			master.setTelephone(tempMaster.getTelephone());
			master.setMobile(tempMaster.getMobile());
			master.setEmail(tempMaster.getEmail());
			master.setPostDate(DateUtil.format(new Date()));
			master.setForbidden(tempMaster.getForbidden());
			masterMapper.insert(master);
		}
	}
	
	/**
	 * 获取管理员列表
	 * @param masterDTO
	 * @param page
	 * @return
	 */
	public List<Master> obtainMasterList(MasterSearch masterSearch){
		int totalNum = masterMapper.pageCount(masterSearch);
		masterSearch.setTotalRecords(totalNum);
		return masterMapper.page(masterSearch);
	}
	
	/**
	 * 获取通过id获取管理员
	 * @param id
	 * @return
	 */
	public Master obtainMasterBuyId(Integer id){
		if(id != null){
			Master master = masterMapper.selectByPrimaryKey(id);
			return master;
		}
		
		return null;
	}
	
	/**
	 * 更新管理员
	 * @param masterDTO
	 * @return
	 */
	public Master updateMaster(Master tempMaster){
		Master master = null;
		if(tempMaster != null && tempMaster.getMtId() != null){
			master = masterMapper.selectByPrimaryKey(tempMaster.getMtId());
			if(master != null){
				if(!StringUtils.isBlank(tempMaster.getAccount())){
					master.setAccount(tempMaster.getAccount());
				}
				if(!StringUtils.isBlank(tempMaster.getPassword())){
					master.setPassword(tempMaster.getPassword());
				}
				if(!StringUtils.isBlank(tempMaster.getName())){
					master.setName(tempMaster.getName());
				}
				if(!StringUtils.isBlank(tempMaster.getPosition())){
					master.setPosition(tempMaster.getPosition());
				}
				if(!StringUtils.isBlank(tempMaster.getTelephone())){
					master.setTelephone(tempMaster.getTelephone());
				}
				if(!StringUtils.isBlank(tempMaster.getMobile())){
					master.setMobile(tempMaster.getMobile());
				}
				if(!StringUtils.isBlank(tempMaster.getEmail())){
					master.setEmail(tempMaster.getEmail());
				}
				if(!StringUtils.isBlank(tempMaster.getEmail())){
					master.setEmail(tempMaster.getEmail());
				}
				master.setForbidden(tempMaster.getForbidden());
				masterMapper.updateByPrimaryKey(master);
				return master;
			}
		}
		return null;
	}
}

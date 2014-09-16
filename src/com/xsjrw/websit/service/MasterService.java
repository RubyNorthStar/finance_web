package com.xsjrw.websit.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xsjrw.common.util.Pager;
import com.xsjrw.websit.domain.admin.Action;
import com.xsjrw.websit.domain.admin.ColumnGroup;
import com.xsjrw.websit.domain.admin.Master;
import com.xsjrw.websit.dto.MasterDTO;


@Component
@SuppressWarnings("all")
/**
 * @author Zhiwei Wang
 */
public class MasterService {
	Logger logger = Logger.getLogger(MasterService.class);
//	@Resource private EventManagerClient eventManagerClient;
//
//	@Resource private MasterDao masterDao;
//	@Resource private ColumnGroupDao columnGroupDao;
//	@Resource private ActionDao actionDao;
	/**
	 * 根据账号获取管理员
	 * @param account
	 * @return
	 */
	public Master obtainMasterBuyAccount(String account){
//		if(!StringUtil.isBlank(account)){
//			try {
//				DetachedCriteria criteria = DetachedCriteria.forClass(Master.class);
//				criteria.add(Restrictions.eq("account", account.trim()));
//				List<Master> masterList = masterDao.findByCriteria(criteria);
//				
//				if(masterList != null && masterList.size() > 0){
//					return masterList.get(0);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		return null;
	}
	
	/**
	 * 保存管理员
	 * @param masterDTO
	 * @return
	 */
	public Master saveMaster(MasterDTO masterDTO){
//		Master master = null;
//		master = obtainMasterBuyAccount(masterDTO.getAccount());
//		if(master == null){
//			master = new Master();
//			master.setAccount(masterDTO.getAccount());
//			master.setPassword(masterDTO.getPassword());
//			master.setName(masterDTO.getName());
//			master.setPosition(masterDTO.getPosition());
//			master.setTelephone(masterDTO.getTelephone());
//			master.setMobile(masterDTO.getMobile());
//			master.setEmail(masterDTO.getEmail());
//			master.setPostDate(DateUtil.format(new Date()));
//			master.setForbidden(masterDTO.getForbidden());
//			return masterDao.updateObject(master);
//		}
		return null;
	}
	
	/**
	 * 获取管理员列表
	 * @param masterDTO
	 * @param page
	 * @return
	 */
	public Pager obtainMasterList(MasterDTO masterDTO, Integer page, Integer pageSize){
//		DetachedCriteria criteria = DetachedCriteria.forClass(Master.class);
//		if(masterDTO != null && !StringUtil.isBlank(masterDTO.getAccount())){
//			criteria.add(Restrictions.eq("account", masterDTO.getAccount().trim()));
//		}
//		if(masterDTO != null && !StringUtil.isBlank(masterDTO.getName())){
//			criteria.add(Restrictions.eq("name", masterDTO.getName().trim()));
//		}
//		criteria.setProjection(Projections.rowCount());
//		Integer total = (Integer) masterDao.uniqueResult(criteria);
//		Pager pager = new Pager(total, pageSize, page);
//		criteria.setProjection(null);
//		
//		try {
//			List<Master> masterList = masterDao.findByCriteria(criteria, pager.getStart(), pager.getPageSize());
//			pager.setRecords(masterList);
//			return pager;
//		} catch (Exception e) {
//			logger.info(e.getMessage());
//		}
		
		return null;
	}
	
	/**
	 * 获取通过id获取管理员
	 * @param id
	 * @return
	 */
	public Master obtainMasterBuyId(Integer id){
//		if(id != null){
//			Master master = masterDao.get(id);
//			return master;
//		}
		
		return null;
	}
	
	/**
	 * 更新管理员
	 * @param masterDTO
	 * @return
	 */
	public Master updateMaster(MasterDTO masterDTO){
//		Master master = null;
//		if(masterDTO != null && masterDTO.getId() != null){
//			master = masterDao.get(masterDTO.getId());
//			if(master != null){
//				if(!StringUtil.isBlank(masterDTO.getAccount())){
//					master.setAccount(masterDTO.getAccount());
//				}
//				if(!StringUtil.isBlank(masterDTO.getPassword())){
//					master.setPassword(masterDTO.getPassword());
//				}
//				if(!StringUtil.isBlank(masterDTO.getName())){
//					master.setName(masterDTO.getName());
//				}
//				if(!StringUtil.isBlank(masterDTO.getPosition())){
//					master.setPosition(masterDTO.getPosition());
//				}
//				if(!StringUtil.isBlank(masterDTO.getTelephone())){
//					master.setTelephone(masterDTO.getTelephone());
//				}
//				if(!StringUtil.isBlank(masterDTO.getMobile())){
//					master.setMobile(masterDTO.getMobile());
//				}
//				if(!StringUtil.isBlank(masterDTO.getEmail())){
//					master.setEmail(masterDTO.getEmail());
//				}
//				if(!StringUtil.isBlank(masterDTO.getEmail())){
//					master.setEmail(masterDTO.getEmail());
//				}
//				master.setForbidden(masterDTO.getForbidden());
//				return masterDao.updateObject(master);
//			}
//		}
		return null;
	}
	

	/**
	 * 获取所有权限分组列表
	 * @param masterDTO
	 * @param page
	 * @return
	 */
	public List<ColumnGroup> obtainAllColumnGroupList(){
//		DetachedCriteria criteria = DetachedCriteria.forClass(ColumnGroup.class);
//		try {
//			List<ColumnGroup> columnGroupList = columnGroupDao.findByCriteria(criteria);
//			return columnGroupList;
//		} catch (Exception e) {
//			logger.info(e.getMessage());
//		}
		
		return null;
	}
	
	/**
	 * 根据权限ID获取相对应权限
	 * @param id
	 * @return
	 */
	public Action obtainActionBuyId(Integer id){
//		if(id != null){
//			Action action = actionDao.get(id);
//			return action;
//		}
		
		return null;
	}
	
	/**
	 * 更新管理员
	 * @param masterDTO
	 * @return
	 */
	public Master updateMaster(Master master){
//		master = masterDao.updateObject(master);
		return null;
	}
	
	/**
	 * 删除相应管理员权限
	 * @param masterDTO
	 * @return
	 */
	public void deleteMasterActions(Master master){
//		if(master != null && master.getMtId() != null){
//			String sql = "delete from master_map_action where mt_id='"+master.getMtId()+"'";
//			try {
//				masterDao.executeSqlForUpdateOrDelete(sql);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	/**
	 * 获取所有管理员列表
	 * @return
	 */
	public List<Master> obtainAllMasterList(){
		
		return null;
	}
	/**added by Hector on 2013-7-17 10:53:05
	 * @param object
	 */
	public void save(Serializable object) {
		if (null == object)
			return;
//		masterDao.save(object);
	}
	public void update(Serializable object) {
		if (null == object)
			return;
//		masterDao.update(object);
	}
	public Object obtainObject(Integer id, Class entityClass){
		if(id == null || id <=0){
			return null;
		}
		Object o = null;
//		Object o = masterDao.load(entityClass, id);
		return o;
		
	}
	public Pager obtainCelebrityList(Integer status, String name, String starTime, String endTime, 
			Integer page, Integer pageSize){
		Pager pager=null;
//		try{	
//			DetachedCriteria criteria = DetachedCriteria.forClass(CelebrityAndOrganization.class);
//			if(!StringUtil.strIsNull(name)){
//				criteria.add(Restrictions.like("name", name.trim(), MatchMode.ANYWHERE));
//			}
//			if(null != status && status != -1){
//				criteria.add(Restrictions.eq("status", status));
//			}
//			if(!StringUtil.strIsNull(starTime)){
//				Date d = new Date();
//				try {
//					d = DateUtil.strToDate(starTime);
//					criteria.add(Restrictions.ge("createTime", d));
//				} catch (Exception e) {
//				}
//			}
//			if(!StringUtil.strIsNull(endTime)){
//				Date d = new Date();
//				try {
//					if (endTime.length() == 10) {
//						endTime += " 23:59:59";
//					}
//					d = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endTime);
//					criteria.add(Restrictions.le("createTime", d));
//				} catch (Exception e) {
//				}
//			}
//			criteria.setProjection(Projections.rowCount());
//			Integer total = (Integer) masterDao.uniqueResult(criteria);
//			criteria.setProjection(null);
//			criteria.addOrder(Order.asc("typeId").asc("sortIndex"));
//			criteria.addOrder(Order.desc("createTime"));
//			pager = new Pager(total, pageSize, page);
//			String requestData = "status1="+status+"&starTime="+starTime+"&endTime="+endTime;
//			pager.setRequestData(requestData);
//			pager.setRecords(masterDao.findByCriteria(criteria, pager.getStart(), pager.getPageSize()));
//		} catch(Exception e) {
//			logger.error("obtainCelebrityList", e);
//		}
		return pager;
	}
	/**
	 * @param productNo
	 * @param celebrityId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager obtainCelebrityScoreList(String productNo, 
			Integer celebrityId, Integer pageNo, Integer pageSize){
		Pager pager=null;
//		try{	
//			DetachedCriteria criteria = DetachedCriteria.forClass(CelebrityAndOrganizationsScoreForProduct.class);
//			if(!StringUtil.strIsNull(productNo)){
//				criteria.add(Restrictions.eq("productNo", productNo.trim()));
//			}
//			if(null != celebrityId && celebrityId > 0){
//				criteria.add(Restrictions.eq("celebrityId", celebrityId));
//			}
//			criteria.add(Restrictions.eq("status", CelebrityAndOrganizationsScoreForProduct.STATUS_NORMAL));
//			criteria.setProjection(Projections.rowCount());
//			Integer total = (Integer) masterDao.uniqueResult(criteria);
//			criteria.setProjection(null);
//			criteria.addOrder(Order.asc("sortIndex").desc("createTime"));
//			pager = new Pager(total, pageSize, pageNo);
////			String requestData = "status1="+status+"&starTime="+starTime+"&endTime="+endTime;
////			pager.setRequestData(requestData);
//			pager.setRecords(masterDao.findByCriteria(criteria, pager.getStart(), pager.getPageSize()));
//		}catch(Exception e){
//			logger.error("obtainCelebrityScoreList",e);
//		}
		return pager;
	}
}

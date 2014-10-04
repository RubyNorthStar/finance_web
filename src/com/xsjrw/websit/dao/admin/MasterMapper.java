package com.xsjrw.websit.dao.admin;

import java.util.List;

import com.xsjrw.websit.domain.admin.Master;

public interface MasterMapper {
    int deleteByPrimaryKey(Integer mtId);

    int insert(Master record);

    int insertSelective(Master record);

    Master selectByPrimaryKey(Integer mtId);

    int updateByPrimaryKeySelective(Master record);

    int updateByPrimaryKey(Master record);
    
    List<Master> selectByMasterAccount(String account);
    
    /**
	 * 
	* @Title: page 
	* @Description: 分页查询
	* @param param
	* @return
	* @return List<T>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午12:12:38
	* @user by shangde
	 */
	List<Master> page(Object param);
	
	/**
	 * 
	* @Title: pageCount 
	* @Description: 总条数查询
	* @param param
	* @return
	* @return Integer    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午12:12:51
	* @user by shangde
	 */
	Integer pageCount(Object param);
}
package com.xsjrw.websit.service.project;

import java.util.List;

import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.search.project.IndustrySearch;

/**
 * Service Interface:Industry
 * @author wang.zx
 * @date 2014-10-30
 */
public interface IIndustryService  {
	/**
	 * 
	* @Title: saveIndustry
	* @Description: 新增Industry
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void saveIndustry(Industry T);
	
	/**
	 * 
	* @Title: batchSaveIndustry 
	* @Description: 批量新增Industry
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void batchSaveIndustry(List<Industry> T);
	
	/**
	 * 
	* @Title: updateIndustry 
	* @Description: 编辑Industry
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void update(Industry T);
	
	/**
	 * 
	* @Title: deleteIndustryById 
	* @Description: 根据id删除Industry
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void deleteIndustryById(Integer id);
	
	/**
	 * 
	* @Title: deleteIndustryByIds 
	* @Description: 根据id批量删除Industry
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void deleteIndustryByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findIndustryById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	Industry findIndustryById(Integer id);
	
	/**
	 * 
	* @Title: findIndustryByPage 
	* @Description: 分页查询
	* @return
	* @return List<Industry>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	List<Industry> findIndustryByPage(IndustrySearch search);
}
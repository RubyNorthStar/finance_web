package com.xsjrw.websit.service.project;

import java.util.List;

import com.xsjrw.websit.domain.project.InvestmentIntentionInfo;
import com.xsjrw.websit.search.project.InvestmentIntentionInfoSearch;

/**
 * Service Interface:InvestmentIntentionInfo
 * @author wang.zx
 * @date 2014-11-9
 */
public interface IInvestmentIntentionInfoService  {
	/**
	 * 
	* @Title: saveInvestmentIntentionInfo
	* @Description: 新增InvestmentIntentionInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-9
	* @user by wangzx
	 */
	void saveInvestmentIntentionInfo(InvestmentIntentionInfo T);
	
	/**
	 * 
	* @Title: batchSaveInvestmentIntentionInfo 
	* @Description: 批量新增InvestmentIntentionInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-9
	* @user by wangzx
	 */
	void batchSaveInvestmentIntentionInfo(List<InvestmentIntentionInfo> T);
	
	/**
	 * 
	* @Title: updateInvestmentIntentionInfo 
	* @Description: 编辑InvestmentIntentionInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-9
	* @user by wangzx
	 */
	void update(InvestmentIntentionInfo T);
	
	/**
	 * 
	* @Title: deleteInvestmentIntentionInfoById 
	* @Description: 根据id删除InvestmentIntentionInfo
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-9
	* @user by wangzx
	 */
	void deleteInvestmentIntentionInfoById(Integer id);
	
	/**
	 * 
	* @Title: deleteInvestmentIntentionInfoByIds 
	* @Description: 根据id批量删除InvestmentIntentionInfo
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-9
	* @user by wangzx
	 */
	void deleteInvestmentIntentionInfoByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findInvestmentIntentionInfoById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-9
	* @user by wangzx
	 */
	InvestmentIntentionInfo findInvestmentIntentionInfoById(Integer id);
	
	/**
	 * 
	* @Title: findInvestmentIntentionInfoByPage 
	* @Description: 分页查询
	* @return
	* @return List<InvestmentIntentionInfo>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-9
	* @user by wangzx
	 */
	List<InvestmentIntentionInfo> findInvestmentIntentionInfoByPage(InvestmentIntentionInfoSearch search);
}
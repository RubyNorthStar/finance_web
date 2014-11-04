package com.xsjrw.websit.service.project;

import java.util.List;

import com.xsjrw.websit.domain.project.PublicNotice;
import com.xsjrw.websit.search.project.PublicNoticeSearch;

/**
 * Service Interface:PublicNotice
 * @author wang.zx
 * @date 2014-11-4
 */
public interface IPublicNoticeService  {
	/**
	 * 
	* @Title: savePublicNotice
	* @Description: 新增PublicNotice
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-4
	* @user by wangzx
	 */
	void savePublicNotice(PublicNotice T);
	
	/**
	 * 
	* @Title: batchSavePublicNotice 
	* @Description: 批量新增PublicNotice
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-4
	* @user by wangzx
	 */
	void batchSavePublicNotice(List<PublicNotice> T);
	
	/**
	 * 
	* @Title: updatePublicNotice 
	* @Description: 编辑PublicNotice
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-4
	* @user by wangzx
	 */
	void update(PublicNotice T);
	
	/**
	 * 
	* @Title: deletePublicNoticeById 
	* @Description: 根据id删除PublicNotice
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-4
	* @user by wangzx
	 */
	void deletePublicNoticeById(Integer id);
	
	/**
	 * 
	* @Title: deletePublicNoticeByIds 
	* @Description: 根据id批量删除PublicNotice
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-4
	* @user by wangzx
	 */
	void deletePublicNoticeByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findPublicNoticeById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-4
	* @user by wangzx
	 */
	PublicNotice findPublicNoticeById(Integer id);
	
	/**
	 * 
	* @Title: findPublicNoticeByPage 
	* @Description: 分页查询
	* @return
	* @return List<PublicNotice>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-11-4
	* @user by wangzx
	 */
	List<PublicNotice> findPublicNoticeByPage(PublicNoticeSearch search);
}
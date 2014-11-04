package com.xsjrw.websit.service.project;

import java.util.List;

import com.xsjrw.websit.domain.project.ProjectInfo;
import com.xsjrw.websit.search.project.ProjectInfoSearch;

/**
 * Service Interface:ProjectInfo
 * @author wang.zx
 * @date 2014-10-30
 */
public interface IProjectInfoService  {
	/**
	 * 
	* @Title: saveProjectInfo
	* @Description: 新增ProjectInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void saveProjectInfo(ProjectInfo T);
	
	/**
	 * 
	* @Title: batchSaveProjectInfo 
	* @Description: 批量新增ProjectInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void batchSaveProjectInfo(List<ProjectInfo> T);
	
	/**
	 * 
	* @Title: updateProjectInfo 
	* @Description: 编辑ProjectInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void update(ProjectInfo T);
	
	/**
	 * 
	* @Title: deleteProjectInfoById 
	* @Description: 根据id删除ProjectInfo
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void deleteProjectInfoById(Integer id);
	
	/**
	 * 
	* @Title: deleteProjectInfoByIds 
	* @Description: 根据id批量删除ProjectInfo
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void deleteProjectInfoByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findProjectInfoById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	ProjectInfo findProjectInfoById(Integer id);
	
	/**
	 * 
	* @Title: findProjectInfoByPage 
	* @Description: 分页查询
	* @return
	* @return List<ProjectInfo>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	List<ProjectInfo> findProjectInfoByPage(ProjectInfoSearch search);
}
package com.xsjrw.websit.service.project;

import java.util.List;

import com.xsjrw.websit.domain.project.ImagePath;
import com.xsjrw.websit.search.project.ImagePathSearch;

/**
 * Service Interface:ImagePath
 * @author wang.zx
 * @date 2014-10-30
 */
public interface IImagePathService  {
	/**
	 * 
	* @Title: saveImagePath
	* @Description: 新增ImagePath
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void saveImagePath(ImagePath T);
	
	/**
	 * 
	* @Title: batchSaveImagePath 
	* @Description: 批量新增ImagePath
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void batchSaveImagePath(List<ImagePath> T);
	
	/**
	 * 
	* @Title: updateImagePath 
	* @Description: 编辑ImagePath
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void update(ImagePath T);
	
	/**
	 * 
	* @Title: deleteImagePathById 
	* @Description: 根据id删除ImagePath
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void deleteImagePathById(Integer id);
	
	/**
	 * 
	* @Title: deleteImagePathByIds 
	* @Description: 根据id批量删除ImagePath
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	void deleteImagePathByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findImagePathById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	ImagePath findImagePathById(Integer id);
	
	/**
	 * 
	* @Title: findImagePathByPage 
	* @Description: 分页查询
	* @return
	* @return List<ImagePath>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-30
	* @user by wangzx
	 */
	List<ImagePath> findImagePathByPage(ImagePathSearch search);
	
	/**
	 * 根据项目ID保存其对应的图片
	 * @param projectId
	 * @param images
	 */
	public void saveImagePathByProjectId(int projectId,  List<ImagePath> images);
}
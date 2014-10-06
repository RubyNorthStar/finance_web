package com.xsjrw.websit.service.article;

import java.util.List;

import com.xsjrw.websit.domain.article.ArticleInfoType;
import com.xsjrw.websit.search.article.ArticleInfoTypeSearch;

/**
 * Service Interface:ArticleInfoType
 * @author wang.zx
 * @date 2014-10-6
 */
public interface IArticleInfoTypeService  {
	/**
	 * 
	* @Title: saveArticleInfoType
	* @Description: 新增ArticleInfoType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void saveArticleInfoType(ArticleInfoType T);
	
	/**
	 * 
	* @Title: batchSaveArticleInfoType 
	* @Description: 批量新增ArticleInfoType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void batchSaveArticleInfoType(List<ArticleInfoType> T);
	
	/**
	 * 
	* @Title: updateArticleInfoType 
	* @Description: 编辑ArticleInfoType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void update(ArticleInfoType T);
	
	/**
	 * 
	* @Title: deleteArticleInfoTypeById 
	* @Description: 根据id删除ArticleInfoType
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void deleteArticleInfoTypeById(Integer id);
	
	/**
	 * 
	* @Title: deleteArticleInfoTypeByIds 
	* @Description: 根据id批量删除ArticleInfoType
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void deleteArticleInfoTypeByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findArticleInfoTypeById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	ArticleInfoType findArticleInfoTypeById(Integer id);
	
	/**
	 * 
	* @Title: findArticleInfoTypeByPage 
	* @Description: 分页查询
	* @return
	* @return List<ArticleInfoType>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	List<ArticleInfoType> findArticleInfoTypeByPage(ArticleInfoTypeSearch search);
}
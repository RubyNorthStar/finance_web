package com.xsjrw.websit.service.article;

import java.util.List;

import com.xsjrw.websit.domain.article.ArticleInfo;
import com.xsjrw.websit.search.article.ArticleInfoSearch;

/**
 * Service Interface:ArticleInfo
 * @author wang.zx
 * @date 2014-10-6
 */
public interface IArticleInfoService  {
	/**
	 * 
	* @Title: saveArticleInfo
	* @Description: 新增ArticleInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void saveArticleInfo(ArticleInfo T);
	
	/**
	 * 
	* @Title: batchSaveArticleInfo 
	* @Description: 批量新增ArticleInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void batchSaveArticleInfo(List<ArticleInfo> T);
	
	/**
	 * 
	* @Title: updateArticleInfo 
	* @Description: 编辑ArticleInfo
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void update(ArticleInfo T);
	
	/**
	 * 
	* @Title: deleteArticleInfoById 
	* @Description: 根据id删除ArticleInfo
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void deleteArticleInfoById(Integer id);
	
	/**
	 * 
	* @Title: deleteArticleInfoByIds 
	* @Description: 根据id批量删除ArticleInfo
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	void deleteArticleInfoByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findArticleInfoById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	ArticleInfo findArticleInfoById(Integer id);
	
	/**
	 * 
	* @Title: findArticleInfoByPage 
	* @Description: 分页查询
	* @return
	* @return List<ArticleInfo>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-6
	* @user by wangzx
	 */
	List<ArticleInfo> findArticleInfoByPage(ArticleInfoSearch search);
	
	/**
	 * 根据aptId和获取数量，获取倒叙的N个新闻
	 * @param aptId
	 * @param number
	 * @return
	 */
	List<ArticleInfo> findArticleInfoByAptIdAndNumber(Integer aptId, Integer number);
}
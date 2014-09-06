package com.xsjrw.websit.core.domain;

import java.util.List;

public interface BaseMapper<T> {
	
	/**
	 * 
	* @Title: save 
	* @Description: 添加 
	* @param T
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午12:08:06
	* @user by shangde
	 */
	void insert(T t);
	
	/**
	 * 
	* @Title: batchInsert 
	* @Description: 批量 添加
	* @param list
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-13 上午09:44:56
	* @user by shangde
	 */
	void batchInsert(List<T> list);
	
	/**
	 * 
	* @Title: update 
	* @Description: 修改
	* @param T
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午12:09:58
	* @user by shangde
	 */
	void update(T t);
	
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: 批量删除 
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午12:10:24
	* @user by shangde
	 */
	void deleteByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: deleteById 
	* @Description: 删除
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午03:42:16
	* @user by shangde
	 */
	void deleteById(Integer id);
	
	/**
	 * 
	* @Title: findById 
	* @Description: 根据id查询
	* @param id
	* @return
	* @return T    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午12:11:46
	* @user by shangde
	 */
	T findById(Integer id);
	
	/**
	 * 
	* @Title: queryAll 
	* @Description: 查询所有
	* @return
	* @return List<T>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午12:12:00
	* @user by shangde
	 */
	List<T> queryAll();
	
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
	List<T> page(Object param);
	
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

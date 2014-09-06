package com.xsjrw.websit.service;

import java.util.List;

import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.search.user.UsersSearch;

public interface IUserService {
	
	/**
	 * 
	* @Title: saveUser 
	* @Description: 新增用户
	* @param user
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午05:32:29
	* @user by shangde
	 */
	void saveUser(Users user);
	
	/**
	 * 
	* @Title: batchSaveUser 
	* @Description: 批量新增用户
	* @param users
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-13 上午09:47:32
	* @user by shangde
	 */
	void batchSaveUser(List<Users> users);
	
	/**
	 * 
	* @Title: editUser 
	* @Description: 编辑用户
	* @param user
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午05:59:25
	* @user by shangde
	 */
	void editUser(Users user);
	
	/**
	 * 
	* @Title: deleteUserById 
	* @Description: 根据id删除用户
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午06:06:57
	* @user by shangde
	 */
	void deleteUserById(Integer id);
	
	/**
	 * 
	* @Title: deleteUserByIds 
	* @Description: 根据id批量删除用户
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午06:07:32
	* @user by shangde
	 */
	void deleteUserByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findUserById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午06:00:02
	* @user by shangde
	 */
	Users findUserById(Integer id);
	
	/**
	 * 
	* @Title: findUserByPage 
	* @Description: 分页查询
	* @return
	* @return List<Users>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午06:01:30
	* @user by shangde
	 */
	List<Users> findUserByPage(UsersSearch search);
	
}

package com.xsjrw.websit.service.user;

import java.util.List;

import com.plat.common.mail.pojo.Email;
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
	* @user by wangzx
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
	* @user by wangzx
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
	* @user by wangzx
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
	* @user by wangzx
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
	* @user by wangzx
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
	* @user by wangzx
	 */
	Users findUserById(Integer id);
	
	/**
	 * 
	* @Title: findUserByEmail
	* @Description: 根据Email查询
	* @param email
	* @return List<Users>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-15 下午06:00:02
	* @user by wangzx
	 */
	List<Users> findUserByEmailAndPassWord(String email, String passWord);
	
	/**
	 * 
	 * findUserByEmail(根据邮箱查找当前email是否已经注册)
	 * @param email
	 * @return
	 *List<Users>
	 * @exception
	 * @since  1.0.0
	 */
	List<Users> findUserByEmail(String email);
	
	/**
	 * 
	* @Title: findUserByPage 
	* @Description: 分页查询
	* @return
	* @return List<Users>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午06:01:30
	* @user by wangzx
	 */
	List<Users> findUserByPage(UsersSearch search);
	
	/**
	 * 获取邮件内容
	 * @param u
	 * @param url
	 * @return
	 */
	public Email getEmailFormat(Users u, String url);
	
}

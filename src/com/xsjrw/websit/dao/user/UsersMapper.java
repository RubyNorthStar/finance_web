package com.xsjrw.websit.dao.user;

import java.util.List;

import com.xsjrw.websit.core.domain.BaseMapper;
import com.xsjrw.websit.domain.user.Users;

/**
 * Mapper Implementation:Users
 * @author xuyl
 * @date 2014-5-12
 */
public interface UsersMapper extends BaseMapper<Users>{
	
	/**
	 * 
	 * findUserByEmailAndPassWord(根据邮箱，密码查询用户)
	 * @param email
	 * @param passWord
	 * @return
	 * List<Users>
	 * @exception
	 * @since  1.0.0
	 */
	List<Users> findUserByEmailAndPassWord(String email, String passWord);
	
	/**
	 * 
	 * findUserByEmail(验证邮箱是否已经注册)
	 * @param email
	 * @param passWord
	 * @return
	 *List<Users>
	 * @exception
	 * @since  1.0.0
	 */
	List<Users> findUserByEmail(String email);
}

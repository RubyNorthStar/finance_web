package com.xsjrw.websit.service.user;

import java.util.List;

import com.xsjrw.websit.domain.user.VipUser;
import com.xsjrw.websit.search.user.VipUserSearch;

/**
 * Service Interface:VipUser
 * @author wang.zx
 * @date 2014-10-7
 */
public interface IVipUserService  {
	/**
	 * 
	* @Title: saveVipUser
	* @Description: 新增VipUser
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-7
	* @user by wangzx
	 */
	void saveVipUser(VipUser T);
	
	/**
	 * 
	* @Title: batchSaveVipUser 
	* @Description: 批量新增VipUser
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-7
	* @user by wangzx
	 */
	void batchSaveVipUser(List<VipUser> T);
	
	/**
	 * 
	* @Title: updateVipUser 
	* @Description: 编辑VipUser
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-7
	* @user by wangzx
	 */
	void update(VipUser T);
	
	/**
	 * 
	* @Title: deleteVipUserById 
	* @Description: 根据id删除VipUser
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-7
	* @user by wangzx
	 */
	void deleteVipUserById(Integer id);
	
	/**
	 * 
	* @Title: deleteVipUserByIds 
	* @Description: 根据id批量删除VipUser
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-7
	* @user by wangzx
	 */
	void deleteVipUserByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findVipUserById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-7
	* @user by wangzx
	 */
	VipUser findVipUserById(Integer id);
	
	/**
	 * 
	* @Title: findVipUserByPage 
	* @Description: 分页查询
	* @return
	* @return List<VipUser>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-10-7
	* @user by wangzx
	 */
	List<VipUser> findVipUserByPage(VipUserSearch search);
}
package com.xsjrw.websit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.common.util.MD5;
import com.xsjrw.websit.dao.user.UsersMapper;
import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.search.user.UsersSearch;
import com.xsjrw.websit.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private UsersMapper usersMapper;

	public void saveUser(Users user) {
		user.setPassword(MD5.getMD5(user.getPassword()));
		usersMapper.insert(user);
		System.out.println("-------------------------------" + user.getId());
	}

	public void batchSaveUser(List<Users> users) {
		if(users != null && !users.isEmpty()){
			usersMapper.batchInsert(users);
		}
	}

	public void editUser(Users user) {
		user.setPassword(MD5.getMD5(user.getPassword()));
		usersMapper.update(user);
	}
	
	public void deleteUserById(Integer id) {
		usersMapper.deleteById(id);
	}

	public void deleteUserByIds(Integer[] ids) {
		usersMapper.deleteByIds(ids);
	}

	public Users findUserById(Integer id) {
		return usersMapper.findById(id);
	}

	public List<Users> findUserByPage(UsersSearch search) {
		Integer totalRecords = usersMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return usersMapper.page(search);
	}

	@Override
	public List<Users> findUserByEmailAndPassWord(String email, String passWord) {
		String pass = MD5.getMD5(passWord);
				
		List<Users> users = usersMapper.findUserByEmailAndPassWord(email, pass);
		
		return users;
	}

	@Override
	public List<Users> findUserByEmail(String email) {
		
		List<Users> users = usersMapper.findUserByEmail(email);
		return users;
	}

	
}

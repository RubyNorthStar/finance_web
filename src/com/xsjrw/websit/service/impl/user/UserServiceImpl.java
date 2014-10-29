package com.xsjrw.websit.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plat.common.mail.pojo.Email;
import com.xsjrw.common.util.MD5;
import com.xsjrw.websit.dao.user.UsersMapper;
import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.search.user.UsersSearch;
import com.xsjrw.websit.service.user.IUserService;

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
		//user.setPassword(MD5.getMD5(user.getPassword()));
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
		List<Users> users = usersMapper.findUserByEmailAndPassWord(email, passWord);
		
		return users;
	}

	@Override
	public List<Users> findUserByEmail(String email) {
		
		List<Users> users = usersMapper.findUserByEmail(email);
		return users;
	}
	
	
    public Email getEmailFormat(Users user, String hostUrl) {
        StringBuffer sbff = new StringBuffer();
        sbff.append("<body> ");
        sbff
                .append("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">")
                .append("<tbody><tr><td>")
                .append("<p style=\"margin:14px 0\">Hi  ")
                .append(user.getUsername())
                .append(",</p>")
                .append("<p style=\"margin:14px 0\">")
                .append("请点击下面的按钮为您重置密码: <br>")
                .append("<a href=\"")
                .append(hostUrl)
                .append("\" style=\"display:inline-block;background-color:#ffe86f;")
                .append("background:-webkit-gradient(linear,left top,left bottom,from(#ffe86f),to(#ffa942));")
                .append("background:-moz-linear-gradient(top,#ffe86f,#ffa942);border-radius:5px;border:1px solid #f2bf2f;font-size:20px;color:#2f1506;")
                .append("padding:4px 10px;margin-top:5px;text-decoration:none\" target=\"_blank\">")
                .append("重置您的密码</a></p></td></tr>")
                .append("<tr><td style=\"padding-top:0;font-size:11px\">")
                .append("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-top:1px solid #ddd\">")
                .append("<tbody><tr><td><p style=\"margin-top:10px\">")
                .append("Best,<br>携手金融网</p></td></tr></tbody></table></td></tr></tbody></table>");
        sbff.append("</body> ");
        Email email = new Email();
        email.setPersonal("携手金融网");
        email.addTo(user.getEmail());
        email.setText(sbff.toString());
        email.setSubject("携手金融网-密码找回");
        email.setHtml(true);
        return email;
    }

	
}

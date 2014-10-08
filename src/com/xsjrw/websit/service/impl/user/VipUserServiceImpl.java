package com.xsjrw.websit.service.impl.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.user.VipUserMapper;
import com.xsjrw.websit.domain.user.VipUser;
import com.xsjrw.websit.search.user.VipUserSearch;
import com.xsjrw.websit.service.user.IVipUserService;

/**
 * Service Implementation:VipUser
 * @author wang.zx
 * @date 2014-10-7
 */
@Service
@Transactional
public class VipUserServiceImpl implements IVipUserService {

	@Autowired
	private VipUserMapper vipUserMapper;
	
	@Override
	public void saveVipUser(VipUser T) {
		T.setCreateTime(new Date());
		vipUserMapper.insert(T);
		
	}

	@Override
	public void batchSaveVipUser(List<VipUser> T) {
		vipUserMapper.batchInsert(T);
	}

	@Override
	public void update(VipUser T) {
		vipUserMapper.update(T);
	}

	@Override
	public void deleteVipUserById(Integer id) {
		vipUserMapper.deleteById(id);
	}

	@Override
	public void deleteVipUserByIds(Integer[] ids) {
		vipUserMapper.deleteByIds(ids);
	}

	@Override
	public VipUser findVipUserById(Integer id) {
		return vipUserMapper.findById(id);
	}

	@Override
	public List<VipUser> findVipUserByPage(VipUserSearch search) {
		Integer totalRecords = vipUserMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return vipUserMapper.page(search);
	}
	
}

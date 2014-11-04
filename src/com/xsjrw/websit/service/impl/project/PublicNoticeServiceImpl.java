package com.xsjrw.websit.service.impl.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.project.PublicNoticeMapper;
import com.xsjrw.websit.domain.project.PublicNotice;
import com.xsjrw.websit.search.project.PublicNoticeSearch;
import com.xsjrw.websit.service.project.IPublicNoticeService;

/**
 * Service Implementation:PublicNotice
 * @author wang.zx
 * @date 2014-11-4
 */
@Service
@Transactional
public class PublicNoticeServiceImpl implements IPublicNoticeService {
	
	@Autowired
	private PublicNoticeMapper publicNoticeMapper;

	@Override
	public void savePublicNotice(PublicNotice T) {
		publicNoticeMapper.insert(T);
	}

	@Override
	public void batchSavePublicNotice(List<PublicNotice> T) {
		publicNoticeMapper.batchInsert(T);
	}

	@Override
	public void update(PublicNotice T) {
		publicNoticeMapper.update(T);
	}

	@Override
	public void deletePublicNoticeById(Integer id) {
		publicNoticeMapper.deleteById(id);
	}

	@Override
	public void deletePublicNoticeByIds(Integer[] ids) {
		publicNoticeMapper.deleteByIds(ids);
	}

	@Override
	public PublicNotice findPublicNoticeById(Integer id) {
		return publicNoticeMapper.findById(id);
	}

	@Override
	public List<PublicNotice> findPublicNoticeByPage(PublicNoticeSearch search) {
		Integer totalRecords = publicNoticeMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return publicNoticeMapper.page(search);
	}
	
	
	
	
}

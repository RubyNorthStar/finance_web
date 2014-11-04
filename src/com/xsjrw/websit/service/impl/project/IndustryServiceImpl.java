package com.xsjrw.websit.service.impl.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.project.IndustryMapper;
import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.search.project.IndustrySearch;
import com.xsjrw.websit.service.project.IIndustryService;

/**
 * Service Implementation:Industry
 * @author wang.zx
 * @date 2014-10-30
 */
@Service
@Transactional
public class IndustryServiceImpl implements IIndustryService {

	@Autowired
	private IndustryMapper industryMapper;
	
	@Override
	public void saveIndustry(Industry industry) {
		industryMapper.insert(industry);
	}

	@Override
	public void batchSaveIndustry(List<Industry> industrys) {
		if(industrys != null && !industrys.isEmpty()){
			industryMapper.batchInsert(industrys);
		}
	}

	@Override
	public void update(Industry industry) {
		industryMapper.update(industry);
	}

	@Override
	public void deleteIndustryById(Integer id) {
		industryMapper.deleteById(id);
	}

	@Override
	public void deleteIndustryByIds(Integer[] ids) {
		industryMapper.deleteByIds(ids);
	}

	@Override
	public Industry findIndustryById(Integer id) {
		return industryMapper.findById(id);
	}

	@Override
	public List<Industry> findIndustryByPage(IndustrySearch search) {
		Integer totalRecords = industryMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return industryMapper.page(search);
	}
	
	
	
	
}

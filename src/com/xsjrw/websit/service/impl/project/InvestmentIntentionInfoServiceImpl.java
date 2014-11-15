package com.xsjrw.websit.service.impl.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.project.InvestmentIntentionInfoMapper;
import com.xsjrw.websit.domain.project.InvestmentIntentionInfo;
import com.xsjrw.websit.search.project.InvestmentIntentionInfoSearch;
import com.xsjrw.websit.service.project.IInvestmentIntentionInfoService;

/**
 * Service Implementation:InvestmentIntentionInfo
 * @author wang.zx
 * @date 2014-11-9
 */
@Service
@Transactional
public class InvestmentIntentionInfoServiceImpl implements IInvestmentIntentionInfoService {
	
	@Autowired
	private InvestmentIntentionInfoMapper investmentMapper;

	@Override
	public void saveInvestmentIntentionInfo(InvestmentIntentionInfo T) {
		investmentMapper.insert(T);
	}

	@Override
	public void batchSaveInvestmentIntentionInfo(List<InvestmentIntentionInfo> T) {
		investmentMapper.batchInsert(T);
	}

	@Override
	public void update(InvestmentIntentionInfo T) {
		investmentMapper.update(T);
	}

	@Override
	public void deleteInvestmentIntentionInfoById(Integer id) {
		investmentMapper.deleteById(id);
	}

	@Override
	public void deleteInvestmentIntentionInfoByIds(Integer[] ids) {
		investmentMapper.deleteByIds(ids);
	}

	@Override
	public InvestmentIntentionInfo findInvestmentIntentionInfoById(Integer id) {
		return investmentMapper.findById(id);
	}

	@Override
	public List<InvestmentIntentionInfo> findInvestmentIntentionInfoByPage(
			InvestmentIntentionInfoSearch search) {
		Integer totalRecords = investmentMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return investmentMapper.page(search);
	}
	
	
	
	
}

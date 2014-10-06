package com.xsjrw.websit.service.impl.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.article.ArticleInfoMapper;
import com.xsjrw.websit.domain.article.ArticleInfo;
import com.xsjrw.websit.search.article.ArticleInfoSearch;
import com.xsjrw.websit.service.article.IArticleInfoService;

/**
 * Service Implementation:ArticleInfo
 * @author wang.zx
 * @date 2014-10-6
 */
@Service
@Transactional
public class ArticleInfoServiceImpl implements IArticleInfoService {

	@Autowired
	private ArticleInfoMapper articleInfoMapper;
	
	@Override
	public void saveArticleInfo(ArticleInfo T) {
		articleInfoMapper.insert(T);
	}

	@Override
	public void batchSaveArticleInfo(List<ArticleInfo> T) {
		articleInfoMapper.batchInsert(T);
	}

	@Override
	public void update(ArticleInfo T) {
		articleInfoMapper.update(T);
	}

	@Override
	public void deleteArticleInfoById(Integer id) {
		articleInfoMapper.deleteById(id);
	}

	@Override
	public void deleteArticleInfoByIds(Integer[] ids) {
		articleInfoMapper.deleteByIds(ids);
	}

	@Override
	public ArticleInfo findArticleInfoById(Integer id) {
		return articleInfoMapper.findById(id);
	}

	@Override
	public List<ArticleInfo> findArticleInfoByPage(ArticleInfoSearch search) {
		Integer totalRecords = articleInfoMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return articleInfoMapper.page(search);
	}
	
	
	
	
}

package com.xsjrw.websit.service.impl.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.article.ArticleInfoTypeMapper;
import com.xsjrw.websit.domain.article.ArticleInfoType;
import com.xsjrw.websit.search.article.ArticleInfoTypeSearch;
import com.xsjrw.websit.service.article.IArticleInfoTypeService;

/**
 * Service Implementation:ArticleInfoType
 * @author wang.zx
 * @date 2014-10-6
 */
@Service
@Transactional
public class ArticleInfoTypeServiceImpl implements IArticleInfoTypeService {
	
	@Autowired
	private ArticleInfoTypeMapper articleInfoTypeMapper;

	@Override
	public void saveArticleInfoType(ArticleInfoType T) {
		articleInfoTypeMapper.insert(T);
	}

	@Override
	public void batchSaveArticleInfoType(List<ArticleInfoType> T) {
		articleInfoTypeMapper.batchInsert(T);
	}

	@Override
	public void update(ArticleInfoType T) {
		articleInfoTypeMapper.update(T);
	}

	@Override
	public void deleteArticleInfoTypeById(Integer id) {
		articleInfoTypeMapper.deleteById(id);
	}

	@Override
	public void deleteArticleInfoTypeByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		articleInfoTypeMapper.deleteByIds(ids);
	}

	@Override
	public ArticleInfoType findArticleInfoTypeById(Integer id) {
		return articleInfoTypeMapper.findById(id);
	}

	@Override
	public List<ArticleInfoType> findArticleInfoTypeByPage(
			ArticleInfoTypeSearch search) {
		Integer totalRecords = articleInfoTypeMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return articleInfoTypeMapper.page(search);
	}
	
	
	
	
}

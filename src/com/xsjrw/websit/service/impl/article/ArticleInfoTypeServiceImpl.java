package com.xsjrw.websit.service.impl.article;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public void saveArticleInfoType(ArticleInfoType T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchSaveArticleInfoType(List<ArticleInfoType> T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArticleInfoType T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticleInfoTypeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticleInfoTypeByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleInfoType findArticleInfoTypeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleInfoType> findArticleInfoTypeByPage(
			ArticleInfoTypeSearch search) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}

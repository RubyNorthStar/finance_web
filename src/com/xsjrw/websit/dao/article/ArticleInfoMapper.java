package com.xsjrw.websit.dao.article;

import java.util.List;

import com.xsjrw.websit.core.domain.BaseMapper;
import com.xsjrw.websit.domain.article.ArticleInfo;

public interface ArticleInfoMapper extends BaseMapper<ArticleInfo>{
	/**
	 * 
	 */
	List<ArticleInfo> findArticleInfoByAptIdAndNumber(Object param);
}

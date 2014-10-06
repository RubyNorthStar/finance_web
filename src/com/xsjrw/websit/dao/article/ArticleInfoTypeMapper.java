package com.xsjrw.websit.dao.article;

import java.util.List;

import com.xsjrw.websit.core.domain.BaseMapper;
import com.xsjrw.websit.domain.article.ArticleInfoType;

public interface ArticleInfoTypeMapper extends BaseMapper<ArticleInfoType>{
	/**
	 * 获取所有的文章类型
	 * @param param
	 * @return
	 */
	List<ArticleInfoType> selectAllArticleInfoType();
}

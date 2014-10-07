package com.xsjrw.websit.service.impl.article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
	public ArticleInfo findArticleInfoById(Integer apId) {
		return articleInfoMapper.findById(apId);
	}

	@Override
	public List<ArticleInfo> findArticleInfoByPage(ArticleInfoSearch search) {
		Integer totalRecords = articleInfoMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return articleInfoMapper.page(search);
	}

	@Override
	public List<ArticleInfo> findArticleInfoByAptIdAndNumber(Integer aptId,
			Integer number) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aptId", aptId);
		map.put("number", number);
		List<ArticleInfo> articleInfoList = articleInfoMapper.findArticleInfoByAptIdAndNumber(map);
		for(ArticleInfo articleInfo : articleInfoList){
			String code = Html2Text(articleInfo.getNormalCode());
			articleInfo.setNormalCode(code.substring(0, code.length() >= 400 ? 400 :code.length()));
		}
		return articleInfoList;
	}
	
	public String Html2Text(String inputString) {      
        String htmlStr = inputString; // 含html标签的字符串      
        String textStr = "";      
        java.util.regex.Pattern p_script;      
        java.util.regex.Matcher m_script;      
        java.util.regex.Pattern p_style;      
        java.util.regex.Matcher m_style;      
        java.util.regex.Pattern p_html;      
        java.util.regex.Matcher m_html;      
    
        java.util.regex.Pattern p_html1;      
        java.util.regex.Matcher m_html1;      
    
       try {      
            String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[//s//S]*?<///script>      
            String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[//s//S]*?<///style>      
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式      
            String regEx_html1 = "<[^>]+";      
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);      
            m_script = p_script.matcher(htmlStr);      
            htmlStr = m_script.replaceAll(""); // 过滤script标签      
    
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);      
            m_style = p_style.matcher(htmlStr);      
            htmlStr = m_style.replaceAll(""); // 过滤style标签      
    
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);      
            m_html = p_html.matcher(htmlStr);      
            htmlStr = m_html.replaceAll(""); // 过滤html标签      
    
            p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);      
            m_html1 = p_html1.matcher(htmlStr);      
            htmlStr = m_html1.replaceAll(""); // 过滤html标签      
    
            textStr = htmlStr;      
    
        } catch (Exception e) {      
            System.err.println("Html2Text: " + e.getMessage());      
        }      
    
       return textStr;// 返回文本字符串      
    }   
}

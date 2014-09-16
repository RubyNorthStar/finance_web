package com.xsjrw.common.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 分页所用的类
 * @author Zhiwei Wang(topkaiser@gmail.com)
 * @since 2010-01-06
 *
 */
@SuppressWarnings("unchecked")
public class Pager {
	public static final int NORMAL_SIZE = 10;
	public static final int LARGE_SIZE = 30;
	
	private int totalRecords; // 共有多少条记录
	private int pageSize; // 每页显示的记录数
	private int currentPage; // 当前页
	private int totalPages; // 共有多少页
	private int start;
	private List records;
	private int recordCount;
	private String requestData;
	private String paginationForFront;
	private String paginationForProAppraisal="";
	private String paginationForUserQuestion="";
	public Pager()	{
		currentPage = 1;
		pageSize = NORMAL_SIZE;
	}
	public Pager(int recordCount, int pageSize, int currentPage) {
		this.totalRecords = recordCount < 0 ? 0 : recordCount;
		this.pageSize = pageSize > 0 ? pageSize : NORMAL_SIZE;
		
		// 计算总页数
		this.totalPages = (recordCount - 1) / pageSize + 1;
		
		if (currentPage < 1) {
			this.currentPage = 1;
		} else if (currentPage > totalPages) {
			this.currentPage = totalPages;
		} else {
			this.currentPage = currentPage;
		}
		
		this.start = (this.currentPage - 1) * this.pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage){
		this.currentPage = currentPage.intValue();
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStart() {
		return start;
	}

	public List getRecords() {
		return records;
	}

	public void setRecords(List records) {
		this.records = records;
		this.recordCount = records.size();
	}

	public int getRecordCount() {
		return recordCount;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getPaginationForFront() {
		if(!StringUtils.isEmpty(this.requestData)){
		StringBuffer paginationHtml = new StringBuffer("");
		String preData = this.requestData.split("\\|")[0];
		String prxData = this.requestData.split("\\|")[1];
		String totalCount = this.requestData.split("\\|")[2];
		if("0".equals(prxData.split("-")[1])){
			prxData = "?totalCount="+totalCount;
		}else{
			prxData = "?searchType="+prxData.split("-")[0]+"&searchKey="+prxData.split("-")[1]+"&totalCount="+totalCount;
		}
		if (this.currentPage==1){
			paginationHtml.append("<span class='g_up'>上一页</span>");
		}else{
			int prePage = currentPage-1;
			paginationHtml.append("<a href='"+preData+prePage+".shtml"+prxData+"' target='_parent' class='g_up'>上一页</a>");
		}
		if(this.totalPages==9){
			int tmplPage = this.totalPages;
			for(int i=1;i<=tmplPage;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+preData+i+".shtml"+prxData+"'  target='_parent'>"+i+"</a>");
				}
			}
		}else if(this.currentPage<7||this.totalPages==7||this.totalPages==8){
			int tmplPage = 8;
			if(this.totalPages<=8){
				tmplPage = this.totalPages;
			}
			for(int i=1;i<=tmplPage;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+preData+i+".shtml"+prxData+"'  target='_parent'>"+i+"</a>");
				}
			}
			if(this.totalPages>8){
				paginationHtml.append("<span class='ellipsis'>...</span>");
				int tmplPage2 = this.totalPages-1;
				if((this.totalPages-this.currentPage)>1){
					paginationHtml.append("<a href='"+preData+tmplPage2+".shtml"+prxData+"'  target='_parent'>"+tmplPage2+"</a>");
				}
				paginationHtml.append("<a href='"+preData+this.totalPages+".shtml"+prxData+"'  target='_parent'>"+this.totalPages+"</a>");
			}
		}else if((totalPages-this.currentPage)<6){
			paginationHtml.append("<a href='"+preData+"1.shtml"+prxData+"' target='_parent'>1</a>");
			paginationHtml.append("<a href='"+preData+"2.shtml"+prxData+"' target='_parent'>2</a>");
			paginationHtml.append("<span class='ellipsis'>...</span>");
			for(int i=this.totalPages-6;i<=this.totalPages;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+preData+i+".shtml"+prxData+"'  target='_parent'>"+i+"</a>");
				}
			}
		}else{
			paginationHtml.append("<a href='"+preData+"1.shtml"+prxData+"'  target='_parent'>1</a>");
			paginationHtml.append("<a href='"+preData+"2.shtml"+prxData+"'  target='_parent'>2</a>");
			paginationHtml.append("<span class='ellipsis'>...</span>");
			for(int i=this.currentPage-3;i<=this.currentPage+2;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+preData+i+".shtml"+prxData+"'  target='_parent'>"+i+"</a>");
				}
			}
			paginationHtml.append("<span class='ellipsis'>...</span>");
			int tmplPage = this.totalPages-1;
			paginationHtml.append("<a href='"+preData+tmplPage+".shtml"+prxData+"'  target='_parent'>"+tmplPage+"</a>");
			paginationHtml.append("<a href='"+preData+this.totalPages+".shtml"+prxData+"'  target='_parent'>"+this.totalPages+"</a>");
		}
		if(this.currentPage==this.totalPages){
			paginationHtml.append("<span class='g_next'>下一页</span>");
		}else{
			int nextPage = currentPage+1;
			paginationHtml.append("<a href='"+preData+nextPage+".shtml"+prxData+"'  target='_parent' class'g_next'>下一页</a>");
		}
		paginationForFront = paginationHtml.toString();
		
		}
		return paginationForFront;
	}
	
	public String getPaginationForFront2() {
		if(!StringUtils.isEmpty(this.requestData)){
		StringBuffer paginationHtml = new StringBuffer("");
		String[] requestDatas = this.requestData.split("\\|");
		String url = requestDatas[0];
		if(!"/p-list/".equals(url))
			url += "-";
		String totalCount = "0";
		if(requestDatas.length>1)
			totalCount = requestDatas[1];
		String suffix = "?totalCount="+totalCount;
		if (this.currentPage==1){
			paginationHtml.append("<span class='g_up'>上一页</span>");
		}else{
			int prePage = currentPage-1;
			paginationHtml.append("<a href='"+url+"p"+prePage+".shtml"+suffix+"' target='_parent' class='g_up'>上一页</a>");
		}
		if(this.totalPages==9){
			int tmplPage = this.totalPages;
			for(int i=1;i<=tmplPage;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+url+"p"+i+".shtml"+suffix+"'  target='_parent'>"+i+"</a>");
				}
			}
		}else if(this.currentPage<7||this.totalPages==7||this.totalPages==8){
			int tmplPage = 8;
			if(this.totalPages<=8){
				tmplPage = this.totalPages;
			}
			for(int i=1;i<=tmplPage;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+url+"p"+i+".shtml"+suffix+"'  target='_parent'>"+i+"</a>");
				}
			}
			if(this.totalPages>8){
				paginationHtml.append("<span class='ellipsis'>...</span>");
				int tmplPage2 = this.totalPages-1;
				if((this.totalPages-this.currentPage)>1){
					paginationHtml.append("<a href='"+url+"p"+tmplPage2+".shtml"+suffix+"'  target='_parent'>"+tmplPage2+"</a>");
				}
				paginationHtml.append("<a href='"+url+"p"+this.totalPages+".shtml"+suffix+"'  target='_parent'>"+this.totalPages+"</a>");
			}
		}else if((totalPages-this.currentPage)<6){
			paginationHtml.append("<a href='"+url+"p"+"1.shtml"+suffix+"' target='_parent'>1</a>");
			paginationHtml.append("<a href='"+url+"p"+"2.shtml"+suffix+"' target='_parent'>2</a>");
			paginationHtml.append("<span class='ellipsis'>...</span>");
			for(int i=this.totalPages-6;i<=this.totalPages;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+url+"p"+i+".shtml"+suffix+"'  target='_parent'>"+i+"</a>");
				}
			}
		}else{
			paginationHtml.append("<a href='"+url+"p"+"1.shtml"+suffix+"'  target='_parent'>1</a>");
			paginationHtml.append("<a href='"+url+"p"+"2.shtml"+suffix+"'  target='_parent'>2</a>");
			paginationHtml.append("<span class='ellipsis'>...</span>");
			for(int i=this.currentPage-3;i<=this.currentPage+2;i++){
				if(this.currentPage == i){
					paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
				}else{
					paginationHtml.append("<a href='"+url+"p"+i+".shtml"+suffix+"'  target='_parent'>"+i+"</a>");
				}
			}
			paginationHtml.append("<span class='ellipsis'>...</span>");
			int tmplPage = this.totalPages-1;
			paginationHtml.append("<a href='"+url+"p"+tmplPage+".shtml"+suffix+"'  target='_parent'>"+tmplPage+"</a>");
			paginationHtml.append("<a href='"+url+"p"+this.totalPages+".shtml"+suffix+"'  target='_parent'>"+this.totalPages+"</a>");
		}
		if(this.currentPage==this.totalPages){
			paginationHtml.append("<span class='g_next'>下一页</span>");
		}else{
			int nextPage = currentPage+1;
			paginationHtml.append("<a href='"+url+"p"+nextPage+".shtml"+suffix+"'  target='_parent' class'g_next'>下一页</a>");
		}
		paginationForFront = paginationHtml.toString();
		
		}
		return paginationForFront;
	}

	public void setPaginationForFront(String paginationForFront) {
		this.paginationForFront = paginationForFront;
	}
	public String getPaginationForProAppraisal() {
		if(!StringUtils.isEmpty(this.requestData)){
			StringBuffer paginationHtml = new StringBuffer("");
			String preData = this.requestData;
			int totalCount = this.totalRecords;
			String url = preData+"pageSize="+pageSize+"&totalCount="+totalCount;
			if (this.currentPage==1){
				paginationHtml.append("<span class='g_up'>上一页</span>");
			}else{
				int prePage = currentPage-1;
				String pageUrl = url + "&page="+prePage;
				paginationHtml.append("<a href='"+pageUrl+"' target='_parent' class='g_up'>上一页</a>");
			}
			if(this.totalPages == 9){
				int tmplPage = this.totalPages;
				for(int i=1;i<=tmplPage;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
			}else if(this.currentPage<7||this.totalPages==7||this.totalPages==8){
				int tmplPage = 8;
				if(this.totalPages<=8){
					tmplPage = this.totalPages;
				}
				for(int i=1;i<=tmplPage;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
				if(this.totalPages>8){
					paginationHtml.append("<span class='ellipsis'>...</span>");
					int tmplPage2 = this.totalPages-1;
					if((this.totalPages-this.currentPage)>1){
						String pageUrl1 = url + "&page="+tmplPage2;
						paginationHtml.append("<a href='"+pageUrl1+"'  target='_parent'>"+tmplPage2+"</a>");
					}
					String pageUrl = url + "&page="+this.totalPages;
					paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+this.totalPages+"</a>");
				}
			}else if((totalPages-this.currentPage)<6){
				paginationHtml.append("<a href='"+url+"&page=1' target='_parent'>1</a>");
				paginationHtml.append("<a href='"+url+"&page=2' target='_parent'>2</a>");
				paginationHtml.append("<span class='ellipsis'>...</span>");
				for(int i=this.totalPages-6;i<=this.totalPages;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
			}else{
				paginationHtml.append("<a href='"+url+"&page=1'  target='_parent'>1</a>");
				paginationHtml.append("<a href='"+url+"&page=2'  target='_parent'>2</a>");
				paginationHtml.append("<span class='ellipsis'>...</span>");
				for(int i=this.currentPage-3;i<=this.currentPage+2;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
				paginationHtml.append("<span class='ellipsis'>...</span>");
				int tmplPage = this.totalPages-1;
				paginationHtml.append("<a href='"+url+"&page="+tmplPage+"'  target='_parent'>"+tmplPage+"</a>");
				paginationHtml.append("<a href='"+url+"&page="+this.totalPages+"'  target='_parent'>"+this.totalPages+"</a>");
			}
			if(this.currentPage==this.totalPages){
				paginationHtml.append("<span class='g_next'>下一页</span>");
			}else{
				int nextPage = currentPage+1;
				String pageUrl = url + "&page="+nextPage;
				paginationHtml.append("<a href='"+pageUrl+"'  target='_parent' class'g_next'>下一页</a>");
			}
			paginationForProAppraisal = paginationHtml.toString();
		}
		return paginationForProAppraisal;
	}
	public void setPaginationForProAppraisal(String paginationForProAppraisal) {
		this.paginationForProAppraisal = paginationForProAppraisal;
	}
	public String getPaginationForUserQuestion() {
		if(!StringUtils.isEmpty(this.requestData)){
			StringBuffer paginationHtml = new StringBuffer("");
			String preData = this.requestData;
			int totalCount = this.totalRecords;
			String url = preData+"pageSize="+pageSize+"&totalCount="+totalCount;
			if (this.currentPage==1){
				paginationHtml.append("<span class='g_up'>上一页</span>");
			}else{
				int prePage = currentPage-1;
				String pageUrl = url + "&page="+prePage;
				paginationHtml.append("<a href='"+pageUrl+"' target='_parent' class='g_up'>上一页</a>");
			}
			if(this.totalPages == 9){
				int tmplPage = this.totalPages;
				for(int i=1;i<=tmplPage;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
			}else if(this.currentPage<7||this.totalPages==7||this.totalPages==8){
				int tmplPage = 8;
				if(this.totalPages<=8){
					tmplPage = this.totalPages;
				}
				for(int i=1;i<=tmplPage;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
				if(this.totalPages>8){
					paginationHtml.append("<span class='ellipsis'>...</span>");
					int tmplPage2 = this.totalPages-1;
					if((this.totalPages-this.currentPage)>1){
						String pageUrl1 = url + "&page="+tmplPage2;
						paginationHtml.append("<a href='"+pageUrl1+"'  target='_parent'>"+tmplPage2+"</a>");
					}
					String pageUrl = url + "&page="+this.totalPages;
					paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+this.totalPages+"</a>");
				}
			}else if((totalPages-this.currentPage)<6){
				paginationHtml.append("<a href='"+url+"&page=1' target='_parent'>1</a>");
				paginationHtml.append("<a href='"+url+"&page=2' target='_parent'>2</a>");
				paginationHtml.append("<span class='ellipsis'>...</span>");
				for(int i=this.totalPages-6;i<=this.totalPages;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
			}else{
				paginationHtml.append("<a href='"+url+"&page=1'  target='_parent'>1</a>");
				paginationHtml.append("<a href='"+url+"&page=2'  target='_parent'>2</a>");
				paginationHtml.append("<span class='ellipsis'>...</span>");
				for(int i=this.currentPage-3;i<=this.currentPage+2;i++){
					if(this.currentPage == i){
						paginationHtml.append("<a class='active' href='javascript:void(0);' target='_parent'>"+i+"</a>");
					}else{
						String pageUrl = url + "&page="+i;
						paginationHtml.append("<a href='"+pageUrl+"'  target='_parent'>"+i+"</a>");
					}
				}
				paginationHtml.append("<span class='ellipsis'>...</span>");
				int tmplPage = this.totalPages-1;
				paginationHtml.append("<a href='"+url+"&page="+tmplPage+"'  target='_parent'>"+tmplPage+"</a>");
				paginationHtml.append("<a href='"+url+"&page="+this.totalPages+"'  target='_parent'>"+this.totalPages+"</a>");
			}
			if(this.currentPage==this.totalPages){
				paginationHtml.append("<span class='g_next'>下一页</span>");
			}else{
				int nextPage = currentPage+1;
				String pageUrl = url + "&page="+nextPage;
				paginationHtml.append("<a href='"+pageUrl+"'  target='_parent' class'g_next'>下一页</a>");
			}
			paginationForUserQuestion = paginationHtml.toString();
		}
		return paginationForUserQuestion;
	}
	public void setPaginationForUserQuestion(String paginationForUserQuestion) {
		this.paginationForUserQuestion = paginationForUserQuestion;
	}
	
}

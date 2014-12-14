package com.xsjrw.websit.controller.index;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsjrw.common.util.JsonUtil;
import com.xsjrw.websit.domain.product.ProductFundType;
import com.xsjrw.websit.domain.product.ProductInfo;
import com.xsjrw.websit.domain.project.Industry;
import com.xsjrw.websit.domain.project.InvestmentIntentionInfo;
import com.xsjrw.websit.domain.project.ProjectInfo;
import com.xsjrw.websit.domain.project.PublicNotice;
import com.xsjrw.websit.search.product.ProductInfoSearch;
import com.xsjrw.websit.search.project.InvestmentIntentionInfoSearch;
import com.xsjrw.websit.search.project.ProjectInfoSearch;
import com.xsjrw.websit.search.project.PublicNoticeSearch;
import com.xsjrw.websit.service.product.IProductFundTypeService;
import com.xsjrw.websit.service.product.IProductInfoService;
import com.xsjrw.websit.service.project.IIndustryService;
import com.xsjrw.websit.service.project.IInvestmentIntentionInfoService;
import com.xsjrw.websit.service.project.IProjectInfoService;
import com.xsjrw.websit.service.project.IPublicNoticeService;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@Autowired
	private IProductFundTypeService productFundTypeService;
	
	@Autowired
	private IProductInfoService productInfoService;
	
	@Autowired
	private IProjectInfoService projectInfoService;
	
	@Autowired
	private IInvestmentIntentionInfoService investmentIntentionInfoService;
	
	@Autowired
	private IPublicNoticeService publicNoticeService;
	
	@Autowired
	private IIndustryService industryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String toIndex(Model model, ProductInfoSearch search, HttpServletRequest request){
		
		//查询所有的产品类型
		List<ProductFundType> fundTypes = productFundTypeService.queryAll();
		
		LinkedHashMap<String, List<ProductInfo>> linkMap = new LinkedHashMap<String, List<ProductInfo>>();
		ProductInfoSearch infoSearch = null;
		if(fundTypes != null && fundTypes.size() > 0){
			for(ProductFundType pft : fundTypes){
				infoSearch = new ProductInfoSearch();
				infoSearch.setFundTypeId(pft.getId());
				infoSearch.setPageSize(5);
				List<ProductInfo> proInfos = productInfoService.findProductInfoByPage(infoSearch);
				linkMap.put(String.valueOf(pft.getId()), proInfos);
			}
		}
		
		//融资list
		List<ProjectInfo> financeList = new ArrayList<ProjectInfo>();
		ProjectInfoSearch financeSearch = new ProjectInfoSearch();
		financeSearch.setPageSize(5);
		financeSearch.setPageNo(1);
		financeSearch.setProjectType(1);
		financeSearch.setStatus(2);
		financeList = projectInfoService.findProjectInfoByPage(financeSearch);
		
		if(financeList.size() > 0){
			for(ProjectInfo info : financeList){
				String proIndustryId = info.getProindustryId();
				if(proIndustryId != null && proIndustryId.length() > 0){
					Industry industry = industryService.findIndustryById(Integer.parseInt(proIndustryId));
					info.setProindustryId(industry.getIndustryName());
				}
			}
		}
		
		//转让List
		List<ProjectInfo> transferList = new ArrayList<ProjectInfo>();
		ProjectInfoSearch transferSearch = new ProjectInfoSearch();
		transferSearch.setPageSize(5);
		transferSearch.setPageNo(1);
		transferSearch.setProjectType(2);
		transferSearch.setStatus(2);
		transferList = projectInfoService.findProjectInfoByPage(transferSearch);
		if(transferList.size() > 0){
			for(ProjectInfo info : transferList){
				String proIndustryId = info.getProindustryId();
				if(proIndustryId != null && proIndustryId.length() > 0){
					Industry industry = industryService.findIndustryById(Integer.parseInt(proIndustryId));
					info.setProindustryId(industry.getIndustryName());
				}
			}
		}
		
		//公告List
		List<PublicNotice> noticeList = new ArrayList<PublicNotice>();
		PublicNoticeSearch noticeSearch = new PublicNoticeSearch();
		noticeSearch.setPageSize(5);
		noticeSearch.setPageNo(1);
		noticeSearch.setStatus(2);
		
		noticeList = publicNoticeService.findPublicNoticeByPage(noticeSearch);
		if(noticeList.size() > 0){
			for(PublicNotice info : noticeList){
				Integer proIndustryId = info.getIndustryId();
				if(proIndustryId != null && proIndustryId > 0){
					Industry industry = industryService.findIndustryById(proIndustryId);
					info.setSource(industry.getIndustryName());
				}
			}
		}
		
		//投资List
		List<InvestmentIntentionInfo> investmentList = new ArrayList<InvestmentIntentionInfo>();
		InvestmentIntentionInfoSearch investmentSearch = new InvestmentIntentionInfoSearch();
		investmentSearch.setPageSize(5);
		investmentSearch.setPageNo(1);
		investmentSearch.setStatus(2);
		investmentList = investmentIntentionInfoService.findInvestmentIntentionInfoByPage(investmentSearch);
		
		model.addAttribute("financeList", financeList);
		model.addAttribute("transferList", transferList);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("investmentList", investmentList);
		model.addAttribute("fundTypes", fundTypes);
		model.addAttribute("linkMap", linkMap);
		
		return "index/index";
	}
	
	/**
	 * 查询所有的基金类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/allFund")
	public String obtainFundType(HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		
		List<ProductFundType> fundTypes = productFundTypeService.queryAll();
		String result = "";
		if(fundTypes != null && fundTypes.size() > 0){
			try {
				result = JsonUtil.getJSONString(fundTypes);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}

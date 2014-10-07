package com.xsjrw.websit.controller.index;

import java.util.LinkedHashMap;
import java.util.List;

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
import com.xsjrw.websit.search.product.ProductInfoSearch;
import com.xsjrw.websit.service.product.IProductFundTypeService;
import com.xsjrw.websit.service.product.IProductInfoService;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@Autowired
	private IProductFundTypeService productFundTypeService;
	
	@Autowired
	private IProductInfoService productInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String toIndex(Model model, ProductInfoSearch search){
		
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

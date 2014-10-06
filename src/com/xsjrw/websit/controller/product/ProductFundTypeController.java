package com.xsjrw.websit.controller.product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsjrw.common.util.JsonUtil;
import com.xsjrw.websit.domain.product.ProductFundType;
import com.xsjrw.websit.search.product.ProductFundTypeSearch;
import com.xsjrw.websit.service.product.IProductFundTypeService;

/**
 * Controller of ProductFundType
 * @author wang.zx
 * @date 2014-9-29
 */
@Controller
@RequestMapping("/admin/fundType")
public class ProductFundTypeController {
	
	@Autowired
	private IProductFundTypeService productFundTypeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ProductFundTypeSearch search){
		if (search == null) {
			search = new ProductFundTypeSearch();
			search.setStatus(1);
			// search.setPageSize(20);
		}
		
		List<ProductFundType> fundTypes =  productFundTypeService.findProductFundTypeByPage(search);
		model.addAttribute("search", search);
		model.addAttribute("fundTypes",fundTypes);
		return "admin/product/fund_type_list";
	}
	
	@RequestMapping(value="/add")
	public String add(ProductFundType productFundType) {
		
		if(productFundType.getFundName() == null && productFundType.getId() == null ){
			return "admin/product/add_fund_type";
		}
		
		productFundTypeService.saveProductFundType(productFundType);
		return "redirect:/admin/fundType.go";
	}
	
	@RequestMapping(value="/update")
	public String update(Model model, ProductFundType productFundType) {
		
		//查询出该类型，然后更新
		if(productFundType.getFundName() == null && productFundType.getId() != null ){
			ProductFundType fundType = productFundTypeService.findProductFundTypeById(productFundType.getId());
			
			if(fundType.getStatus() != 2){
				model.addAttribute("fundType", fundType);
			}else{
				return "redirect:/admin/fundType/fundType.go";
			}
			
			return "admin/product/update_fund_type";
		}
		
		if(productFundType.getId() != null && productFundType.getFundName() != null && productFundType.getFundName().length() > 0){
			productFundTypeService.update(productFundType);
		}
		
		return "redirect:/admin/fundType.go";
	}
	
	//逻辑删除，改变基金类型的状态
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		
		ProductFundType fundType = null;
		//查询出该类型，然后更新
		if(id != null){
			fundType = productFundTypeService.findProductFundTypeById(id);
			fundType.setStatus(2);
		}
		productFundTypeService.update(fundType);
		
		return "redirect:/admin/fundType.go";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ProductFundType getJson(Model model, @PathVariable Integer id){
		return productFundTypeService.findProductFundTypeById(id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	/**
	 * 查询所有的基金类型
	 * @return
	 */
	public String obtainFundType(){
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

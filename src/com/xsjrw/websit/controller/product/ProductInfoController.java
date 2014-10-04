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

import com.xsjrw.websit.domain.product.ProductFundType;
import com.xsjrw.websit.domain.product.ProductInfo;
import com.xsjrw.websit.search.product.ProductInfoSearch;
import com.xsjrw.websit.service.product.IProductFundTypeService;
import com.xsjrw.websit.service.product.IProductInfoService;

/**
 * Controller of ProductInfo
 * @author wang.zx
 * @date 2014-9-29
 */
@Controller
@RequestMapping("/admin/productInfo")
public class ProductInfoController {
	
	@Autowired
	private IProductInfoService productInfoService;
	
	@Autowired
	private IProductFundTypeService productFundTypeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ProductInfoSearch search){
		if (search == null) {
			search = new ProductInfoSearch();
			// search.setPageSize(20);
			search.setStatus(1);
		}
		
		model.addAttribute("listProduct", productInfoService.findProductInfoByPage(search));
		model.addAttribute("search", search);
		 
		return "admin/product/product_info_list";
	}
	
	@RequestMapping(value="/add")
	public String add(Model model, ProductInfo productInfo) {
		
		if(productInfo.getId() == null && productInfo.getProductName() == null){
			
			List<ProductFundType> fundTypes = productFundTypeService.queryAll();
			model.addAttribute("fundTypes", fundTypes);
			return "admin/product/add_product_info";
		}
		
		productInfo.setCreateTime(new Date());
		if(productInfo.getStatus() == null){
			productInfo.setStatus(1);
		}
		
		productInfoService.saveProductInfo(productInfo);
		return "redirect:/admin/productInfo.go";
	}
	
	@RequestMapping(value="/update")
	public String update(Model model, ProductInfo productInfo) {
		
		//查询出该产品，然后更新
		if(productInfo.getProductName() == null && productInfo.getId() != null ){
			ProductInfo proInfo = productInfoService.findProductInfoById(productInfo.getId());
			
			if(proInfo.getStatus() != 2){
				List<ProductFundType> fundTypes = productFundTypeService.queryAll();
				model.addAttribute("fundTypes", fundTypes);
				model.addAttribute("proInfo", proInfo);
			}else{
				return "redirect:/admin/productInfo/add.go";
			}
			
			return "admin/product/update_product_info";
		}
		
		if(productInfo.getId() != null && productInfo.getProductName() != null && productInfo.getProductName().length() > 0){
			productInfoService.update(productInfo);
		}
				
		return "redirect:/admin/productInfo.go";
	}
	
	@ResponseBody
	@RequestMapping(value="updateStatus")
	public String updateStatus(ProductInfo productInfo){
		
		String result = "failure";
		
		try {
			productInfoService.update(productInfo);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "{\"result\":\""+result+"\"}";
		
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		productInfoService.deleteProductInfoById(id);
		return "redirect:/productInfo";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ProductInfo getJson(Model model, @PathVariable Integer id){
		return productInfoService.findProductInfoById(id);
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
}

package com.xsjrw.websit.controller.product;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.xsjrw.websit.search.product.ProductFundTypeSearch;
import com.xsjrw.websit.service.product.IProductFundTypeService;

/**
 * Controller of ProductFundType
 * @author wang.zx
 * @date 2014-9-29
 */
@Controller
@RequestMapping("/productFundType")
public class ProductFundTypeController {
	
	@Autowired
	private IProductFundTypeService productFundTypeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ProductFundTypeSearch search){
		if (search == null) {
			search = new ProductFundTypeSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", productFundTypeServiceImpl.findProductFundTypeByPage(search));
		return "productFundType/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ProductFundType productFundType) {
		productFundTypeServiceImpl.saveProductFundType(productFundType);
		return "redirect:/productFundType";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ProductFundType productFundType) {
		productFundTypeServiceImpl.update(productFundType);
		return "redirect:/productFundType";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		productFundTypeServiceImpl.deleteProductFundTypeById(id);
		return "redirect:/productFundType";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ProductFundType getJson(Model model, @PathVariable Integer id){
		return productFundTypeServiceImpl.findProductFundTypeById(id);
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

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

import com.xsjrw.websit.domain.product.ProductMortgage;
import com.xsjrw.websit.search.product.ProductMortgageSearch;
import com.xsjrw.websit.service.IProductMortgageService;

/**
 * Controller of ProductMortgage
 * @author wang.zx
 * @date 2014-9-29
 */
@Controller
@RequestMapping("/productMortgage")
public class ProductMortgageController {
	
	@Autowired
	private IProductMortgageService productMortgageServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ProductMortgageSearch search){
		if (search == null) {
			search = new ProductMortgageSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", productMortgageServiceImpl.findProductMortgageByPage(search));
		return "productMortgage/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ProductMortgage ProductMortgage) {
		productMortgageServiceImpl.saveProductMortgage(ProductMortgage);
		return "redirect:/productMortgage";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ProductMortgage ProductMortgage) {
		productMortgageServiceImpl.update(ProductMortgage);
		return "redirect:/productMortgage";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		productMortgageServiceImpl.deleteProductMortgageById(id);
		return "redirect:/productMortgage";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ProductMortgage getJson(Model model, @PathVariable Integer id){
		return productMortgageServiceImpl.findProductMortgageById(id);
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

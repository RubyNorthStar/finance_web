//package com.xsjrw.websit.controller.product;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.xsjrw.websit.domain.productInfo.bean.ProductInfo;
//import com.xsjrw.websit.domain.productInfo.bean.ProductInfoSearch;
//import com.xsjrw.websit.domain.productInfo.service.spi.IProductInfoService;
//
///**
// * Controller of ProductInfo
// * @author wang.zx
// * @date 2014-9-29
// */
//@Controller
//@RequestMapping("/productInfo")
//public class ProductInfoController {
//	
//	@Autowired
//	private IProductInfoService productInfoServiceImpl;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public String list(Model model, ProductInfoSearch search){
//		if (search == null) {
//			search = new ProductInfoSearch();
//			// search.setPageSize(20);
//		}
//		model.addAttribute("list", productInfoServiceImpl.page(ProductInfo.class, search));
//		return "productInfo/list";
//	}
//	
//	@RequestMapping(value="/add", method = RequestMethod.POST)
//	public String add(ProductInfo ProductInfo) {
//		productInfoServiceImpl.save(ProductInfo);
//		return "redirect:/productInfo";
//	}
//	
//	@RequestMapping(value="/update", method = RequestMethod.POST)
//	public String update(ProductInfo ProductInfo) {
//		productInfoServiceImpl.update(ProductInfo);
//		return "redirect:/productInfo";
//	}
//	
//	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
//	public String del(Model model, @PathVariable Integer id) {
//		productInfoServiceImpl.delete(ProductInfo.class, id);
//		return "redirect:/productInfo";
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/{id}", method = RequestMethod.GET)
//	public ProductInfo getJson(Model model, @PathVariable Integer id){
//		return productInfoServiceImpl.find(ProductInfo.class, id);
//	}
//	
//	/**
//	 * 后台接收Date转换
//	 */
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }
//}

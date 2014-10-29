package com.xsjrw.websit.controller.product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xsjrw.common.constans.Constans;
import com.xsjrw.common.util.FileBean;
import com.xsjrw.common.util.FileUploadUtil;
import com.xsjrw.websit.domain.product.ProductFundType;
import com.xsjrw.websit.domain.product.ProductInfo;
import com.xsjrw.websit.domain.product.ProductMortgage;
import com.xsjrw.websit.dto.ProductImageDTO;
import com.xsjrw.websit.search.product.ProductInfoSearch;
import com.xsjrw.websit.service.product.IProductFundTypeService;
import com.xsjrw.websit.service.product.IProductInfoService;
import com.xsjrw.websit.service.product.IProductMortgageService;

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
	
	@Autowired
	private IProductMortgageService productMortgageService;
	
	@RequestMapping(value="/test")
	public String ueditorTest(){
		return "admin/product/ckeditor_test";
	}
	
	@RequestMapping()
	public String list(Model model, ProductInfoSearch search){
		if (search == null) {
			search = new ProductInfoSearch();
			// search.setPageSize(20);
			search.setStatus(1);
		}
		search.setStatus(1);
		model.addAttribute("listProduct", productInfoService.findProductInfoByPage(search));
		model.addAttribute("search", search);
		 
		return "admin/product/product_info_list";
	}
	
	/**
	 * 添加产品
	 * @param model
	 * @param productInfo
	 * @return
	 */
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
		productInfo.setToExamineStatus(1);  //设置为未审核状态
		productInfo.setTotalMoney(0.0);
		productInfoService.saveProductInfo(productInfo);
		Integer proInfoId = productInfo.getId();
		System.out.println("=====proInfoId====="+proInfoId);
		return "redirect:/admin/productInfo/addProImage.go?proInfoId="+proInfoId+"&isMortgage="+productInfo.getIsMortgage();
	}
	
	/**
	 * 添加产品主图及抵押产品图片
	 * @return
	 */
	@RequestMapping(value="addProImage")
	public String addProductImages(Model model, Integer isMortgage, Integer proInfoId){
		
		System.out.println("=====isMortgage====="+isMortgage);
		System.out.println("=====proInfoId====="+proInfoId);
		
		model.addAttribute("proInfoId", proInfoId);
		model.addAttribute("isMortgage", isMortgage);
		
		return "admin/product/add_product_images";
	}
	
	/**
	 * 为产品添加主图及抵押产品图
	 * @param imageDto
	 * @return
	 */
	@RequestMapping(value="addImage")
	public String addImage(ProductImageDTO imageDto){
		Integer id = imageDto.getId();
		if(imageDto != null && id != null && id > 0){
			ProductInfo proInfo = productInfoService.findProductInfoById(id);
			if(proInfo != null){
				proInfo.setPicPath(imageDto.getMainImage());
			}
			productInfoService.update(proInfo);
		}
		
		String imagePaths = imageDto.getMortgageImage();
		String[] imagePathArr = null ;
		if(imagePaths != null && imagePaths.length() > 0){
			imagePathArr = imagePaths.split(",");
		}
		
		List<ProductMortgage> mortages = new ArrayList<ProductMortgage>();
		if(imagePathArr.length > 0){
			for(int i = 0; i < imagePathArr.length; i++){
				ProductMortgage mortage = new ProductMortgage();
				mortage.setCreateTime(new Date());
				mortage.setImagUrl(imagePathArr[i]);
				mortage.setStatus(1);
				mortage.setProductId(id);
				mortages.add(mortage);
			}
			
			productMortgageService.batchSaveProductMortgage(mortages);
		}
		
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
		ProductInfo proInfo = productInfoService.findProductInfoById(id);
		proInfo.setStatus(2);
		productInfoService.update(proInfo);
		return "redirect:/admin/productInfo.go";
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
	
	/**
	 * 上传文件方法
	 * @param model
	 * @param imgPath
	 * @param request
	 * @param response
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public void saveMaterialImage(Model model, HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		try {
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			String uploadPath = Constans.product_real_path;
			java.text.DateFormat format1 = new java.text.SimpleDateFormat(  
	                "yyyy-MM-dd");  
	        String day = format1.format(new Date());  
			String nextLevel = day.substring(0, 4)+"/"+day.substring(5, 7)+"/"+day.substring(8);
			List<FileBean> fileList = FileUploadUtil.upload(request,
					multipartRequest, "",uploadPath, nextLevel);
			
			response.getWriter().print(
					"{\"url\":\"" + Constans.image_service_path+"/" + nextLevel + "/" + fileList.get(0).getServerName() + "\",\"error\":0}");
			
//			return Constans.PRODUCTSERVICEPATH+fileList.get(0).getServerName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

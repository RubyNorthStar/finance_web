package com.xsjrw.websit.service.product;

import java.util.List;

import com.xsjrw.websit.domain.product.ProductMortgage;
import com.xsjrw.websit.search.product.ProductMortgageSearch;

/**
 * Service Interface:ProductMortgage
 * @author wang.zx
 * @date 2014-9-29
 */
public interface IProductMortgageService  {
	/**
	 * 
	* @Title: saveProductMortgage
	* @Description: 新增ProductMortgage
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void saveProductMortgage(ProductMortgage T);
	
	/**
	 * 
	* @Title: batchSaveProductMortgage 
	* @Description: 批量新增ProductMortgage
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void batchSaveProductMortgage(List<ProductMortgage> T);
	
	/**
	 * 
	* @Title: editProductMortgage 
	* @Description: 编辑ProductMortgage
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void update(ProductMortgage T);
	
	/**
	 * 
	* @Title: deleteProductMortgageById 
	* @Description: 根据id删除ProductMortgage
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void deleteProductMortgageById(Integer id);
	
	/**
	 * 
	* @Title: deleteProductMortgageByIds 
	* @Description: 根据id批量删除ProductMortgage
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void deleteProductMortgageByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findProductMortgageById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	ProductMortgage findProductMortgageById(Integer id);
	
	/**
	 * 
	* @Title: findProductMortgageByPage 
	* @Description: 分页查询
	* @return
	* @return List<ProductMortgage>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	List<ProductMortgage> findProductMortgageByPage(ProductMortgageSearch search);
}
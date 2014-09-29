package com.xsjrw.websit.service.product;

import java.util.List;

import com.xsjrw.websit.domain.product.ProductFundType;
import com.xsjrw.websit.search.product.ProductFundTypeSearch;

/**
 * Service Interface:ProductFundType
 * @author wang.zx
 * @date 2014-9-29
 */
public interface IProductFundTypeService  {
	/**
	 * 
	* @Title: saveProductFundType
	* @Description: 新增ProductFundType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void saveProductFundType(ProductFundType T);
	
	/**
	 * 
	* @Title: batchSaveProductFundType 
	* @Description: 批量新增ProductFundType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void batchSaveProductFundType(List<ProductFundType> T);
	
	/**
	 * 
	* @Title: updateProductFundType 
	* @Description: 编辑ProductFundType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void update(ProductFundType T);
	
	/**
	 * 
	* @Title: deleteProductFundTypeById 
	* @Description: 根据id删除ProductFundType
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void deleteProductFundTypeById(Integer id);
	
	/**
	 * 
	* @Title: deleteProductFundTypeByIds 
	* @Description: 根据id批量删除ProductFundType
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void deleteProductFundTypeByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findProductFundTypeById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	ProductFundType findProductFundTypeById(Integer id);
	
	/**
	 * 
	* @Title: findProductFundTypeByPage 
	* @Description: 分页查询
	* @return
	* @return List<ProductFundType>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	List<ProductFundType> findProductFundTypeByPage(ProductFundTypeSearch search);
}
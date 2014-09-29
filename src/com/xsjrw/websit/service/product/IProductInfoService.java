package com.xsjrw.websit.service.product;

import java.util.List;

import com.xsjrw.websit.domain.product.ProductInfo;
import com.xsjrw.websit.search.product.ProductInfoSearch;

/**
 * Service Interface:ProductInfo
 * @author wang.zx
 * @date 2014-9-29
 */
public interface IProductInfoService  {
	/**
	 * 
	* @Title: saveProductInfo
	* @Description: 新增ProductInfo
	* @param user
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void saveProductInfo(ProductInfo T);
	
	/**
	 * 
	* @Title: batchSaveProductInfo
	* @Description: 批量新增ProductInfo
	* @param users
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void batchSaveProductInfo(List<ProductInfo> T);
	
	/**
	 * 
	* @Title: editProductInfo 
	* @Description: 编辑ProductInfo
	* @param user
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void update(ProductInfo T);
	
	/**
	 * 
	* @Title: deleteProductInfoById 
	* @Description: 根据id删除ProductInfo
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void deleteProductInfoById(Integer id);
	
	/**
	 * 
	* @Title: deleteProductInfoByIds 
	* @Description: 根据id批量删除ProductInfo
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	void deleteProductInfoByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findProductInfoById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2014-9-29
	* @user by wangzx
	 */
	ProductInfo findProductInfoById(Integer id);
	
	/**
	 * 
	* @Title: findProductInfoByPage 
	* @Description: 分页查询
	* @return
	* @return List<ProductInfo>    返回类型 
	* @throws 
	* @exception 
	* @date 2014-5-12 下午06:01:30
	* @user by wangzx
	 */
	List<ProductInfo> findProductInfoByPage(ProductInfoSearch search);
}
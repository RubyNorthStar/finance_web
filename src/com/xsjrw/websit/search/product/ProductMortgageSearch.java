package com.xsjrw.websit.search.product;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:ProductMortgage
 * 
 * @author wang.zx
 * @date 2014-9-29
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ProductMortgageSearch")
public class ProductMortgageSearch extends PageModel {
	
	private Integer	id;		
	private String	mortgageName;		 /* 抵押物品名称 */ 
	private String	imagUrl;			 /*抵押物品对应图片 */ 
	private Integer	productId;		 	 /* 对应产品ID */ 
	private Integer	status;				 /* 1.可用 2.不可用 */ 
	private Date	createTime;		

	// Constructor
	public ProductMortgageSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ProductMortgageSearch(Integer id, String mortgageName, String imagUrl, Integer productId, Integer status, Date createTime) {
		this.id = id;
		this.mortgageName = mortgageName;
		this.imagUrl = imagUrl;
		this.productId = productId;
		this.status = status;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProductMortgage可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ProductMortgageSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getMortgageName() {
		return mortgageName;
	}

	public ProductMortgageSearch setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
		return this;
	}
	
	public String getImagUrl() {
		return imagUrl;
	}

	public ProductMortgageSearch setImagUrl(String imagUrl) {
		this.imagUrl = imagUrl;
		return this;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public ProductMortgageSearch setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	
	public Integer getStatus() {
		return status;
	}

	public ProductMortgageSearch setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public ProductMortgageSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
}
package com.xsjrw.websit.domain.product;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:ProductMortgage
 * 
 * @author wang.zx
 * @date 2014-9-29
 */
@SuppressWarnings("serial")
@Alias("ProductMortgage")
public class ProductMortgage extends BaseEntity {
	
	
	private String	mortgageName;		 /* 抵押物品名称 */ 
	private String	imagUrl;		/*抵押物品对应图片 */ 
	private Integer	productId;		 /* 对应产品ID */ 
	private Integer	status;		 /* 1.可用 2.不可用 */ 
	private Date	createTime;		

	// Constructor
	public ProductMortgage() {
	}
	
	/**
	 * full Constructor
	 */
	public ProductMortgage(Integer id, String mortgageName, String imagUrl, Integer productId, Integer status, Date createTime) {
		setId(id);
		this.mortgageName = mortgageName;
		this.imagUrl = imagUrl;
		this.productId = productId;
		this.status = status;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProductMortgage可以实现连缀设置属性
	
	public String getMortgageName() {
		return mortgageName;
	}

	public ProductMortgage setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName;
		return this;
	}
	
	
	public String getImagUrl() {
		return imagUrl;
	}

	public ProductMortgage setImagUrl(String imagUrl) {
		this.imagUrl = imagUrl;
		return this;
	}
	
	
	public Integer getProductId() {
		return productId;
	}

	public ProductMortgage setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ProductMortgage setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public ProductMortgage setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	@Override
	public String toString() {
		return "ProductMortgage [" + "id=" + getId() + ", mortgageName=" + mortgageName + ", imagUrl=" + imagUrl + ", productId=" + productId + ", status=" + status + ", createTime=" + createTime +  "]";
	}
}

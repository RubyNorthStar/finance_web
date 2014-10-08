package com.xsjrw.websit.search.user;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:VipUser
 * 
 * @author wang.zx
 * @date 2014-10-7
 */
@SuppressWarnings({ "rawtypes" })
@Alias("VipUserSearch")
public class VipUserSearch extends PageModel {
	
	private Integer	id;		
	private String	vipName;		 /* vip名称 */ 
	private String	vipMobile;		 /* vip手机号 */ 
	private Integer	productId;		 /* 当前用户提交信息查看的产品 */ 
	private Date	createTime;		 /* 创建时间 */ 

	// Constructor
	public VipUserSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public VipUserSearch(Integer id, String vipName, String vipMobile, Integer productId, Date createTime) {
		this.id = id;
		this.vipName = vipName;
		this.vipMobile = vipMobile;
		this.productId = productId;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为VipUser可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public VipUserSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getVipName() {
		return vipName;
	}

	public VipUserSearch setVipName(String vipName) {
		this.vipName = vipName;
		return this;
	}
	
	public String getVipMobile() {
		return vipMobile;
	}

	public VipUserSearch setVipMobile(String vipMobile) {
		this.vipMobile = vipMobile;
		return this;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public VipUserSearch setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public VipUserSearch setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
}
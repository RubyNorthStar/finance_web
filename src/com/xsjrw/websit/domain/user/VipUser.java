package com.xsjrw.websit.domain.user;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xsjrw.common.util.ShortDateSerializer;
import com.xsjrw.websit.core.domain.BaseEntity;

/**
 * POJO:VipUser
 * 
 * @author wang.zx
 * @date 2014-10-7
 */
@SuppressWarnings("serial")
@Alias("VipUser")
public class VipUser extends BaseEntity {
	
	
	private String	vipName;		 /* vip名称 */ 
	private String	vipMobile;		 /* vip手机号 */ 
	private Integer	productId;		 /* 当前用户提交信息查看的产品 */ 
	private Date	createTime;		 /* 创建时间 */ 

	// Constructor
	public VipUser() {
	}
	
	/**
	 * full Constructor
	 */
	public VipUser(Integer id, String vipName, String vipMobile, Integer productId, Date createTime) {
		setId(id);
		this.vipName = vipName;
		this.vipMobile = vipMobile;
		this.productId = productId;
		this.createTime = createTime;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为VipUser可以实现连缀设置属性
	
	public String getVipName() {
		return vipName;
	}

	public VipUser setVipName(String vipName) {
		this.vipName = vipName;
		return this;
	}
	
	
	public String getVipMobile() {
		return vipMobile;
	}

	public VipUser setVipMobile(String vipMobile) {
		this.vipMobile = vipMobile;
		return this;
	}
	
	
	public Integer getProductId() {
		return productId;
	}

	public VipUser setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public VipUser setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	@Override
	public String toString() {
		return "VipUser [" + "id=" + getId() + ", vipName=" + vipName + ", vipMobile=" + vipMobile + ", productId=" + productId + ", createTime=" + createTime +  "]";
	}
}

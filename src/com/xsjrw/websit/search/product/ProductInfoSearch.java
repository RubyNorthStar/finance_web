package com.xsjrw.websit.search.product;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.xsjrw.websit.core.domain.PageModel;

/**
 * POJO Search:ProductInfo
 * 
 * @author wang.zx
 * @date 2014-9-29
 */
@SuppressWarnings({ "rawtypes" })
@Alias("ProductInfoSearch")
public class ProductInfoSearch extends PageModel {
	
	private Integer	id;		
	private String	productName;		 /* 项目名称 */ 
	private String	fundScale;		 /* 基金规模 */ 
	private String	expectProfit;		 /* 预期收益 */ 
	private Integer	fundTypeId;		 /* 基金类型( 基金类型表ID ) */ 
	private Integer	investmentTimeLimit;		 /* 投资期限( 以月为单位 ) */ 
	private String	fundManage;		 /* 基金管理( 目前理解为公司名称 ) */ 
	private String	minBidMoney;		 /* 起投金额( 目前为字符串，如果单位定了的话，转为int类型 ) */ 
	private String	profitDistribution;		 /* 收益分配 ( 同起投金额 ) */ 
	private Date	beginTime;		 /* 产品投资开始时间 */ 
	private Date	endTime;		 /* 产品投资结束时间( 根据开始时间及募集日期推算 ) */ 
	private String	productDetaileInfo;		 /* 项目介绍 */ 
	private Integer	isMortgage;		 /* 是否抵押( 1:有抵押，2:未抵押 ) */ 
	private String	fundUse;		 /* 资金用途 */ 
	private String	repaymentSource;		 /* 还款来源 */ 
	private String	businessStructure;		 /* business_structure */ 
	private String	windControlMeasures;		 /* 风控措施 */ 
	private Integer	toExamineStatus;		 /* 审核状态( 1.未审核 2.审核) */ 
	private Integer	productMortgageId;		 /* 产品抵押物品(对应抵押物品表) */ 

	// Constructor
	public ProductInfoSearch() {
	}
	
	/**
	 * full Constructor
	 */
	public ProductInfoSearch(Integer id, String productName, String fundScale, String expectProfit, Integer fundTypeId, Integer investmentTimeLimit, String fundManage, String minBidMoney, String profitDistribution, Date beginTime, Date endTime, String productDetaileInfo, Integer isMortgage, String fundUse, String repaymentSource, String businessStructure, String windControlMeasures, Integer toExamineStatus, Integer productMortgageId) {
		this.id = id;
		this.productName = productName;
		this.fundScale = fundScale;
		this.expectProfit = expectProfit;
		this.fundTypeId = fundTypeId;
		this.investmentTimeLimit = investmentTimeLimit;
		this.fundManage = fundManage;
		this.minBidMoney = minBidMoney;
		this.profitDistribution = profitDistribution;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.productDetaileInfo = productDetaileInfo;
		this.isMortgage = isMortgage;
		this.fundUse = fundUse;
		this.repaymentSource = repaymentSource;
		this.businessStructure = businessStructure;
		this.windControlMeasures = windControlMeasures;
		this.toExamineStatus = toExamineStatus;
		this.productMortgageId = productMortgageId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ProductInfo可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public ProductInfoSearch setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public String getProductName() {
		return productName;
	}

	public ProductInfoSearch setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	
	public String getFundScale() {
		return fundScale;
	}

	public ProductInfoSearch setFundScale(String fundScale) {
		this.fundScale = fundScale;
		return this;
	}
	
	public String getExpectProfit() {
		return expectProfit;
	}

	public ProductInfoSearch setExpectProfit(String expectProfit) {
		this.expectProfit = expectProfit;
		return this;
	}
	
	public Integer getFundTypeId() {
		return fundTypeId;
	}

	public ProductInfoSearch setFundTypeId(Integer fundTypeId) {
		this.fundTypeId = fundTypeId;
		return this;
	}
	
	public Integer getInvestmentTimeLimit() {
		return investmentTimeLimit;
	}

	public ProductInfoSearch setInvestmentTimeLimit(Integer investmentTimeLimit) {
		this.investmentTimeLimit = investmentTimeLimit;
		return this;
	}
	
	public String getFundManage() {
		return fundManage;
	}

	public ProductInfoSearch setFundManage(String fundManage) {
		this.fundManage = fundManage;
		return this;
	}
	
	public String getMinBidMoney() {
		return minBidMoney;
	}

	public ProductInfoSearch setMinBidMoney(String minBidMoney) {
		this.minBidMoney = minBidMoney;
		return this;
	}
	
	public String getProfitDistribution() {
		return profitDistribution;
	}

	public ProductInfoSearch setProfitDistribution(String profitDistribution) {
		this.profitDistribution = profitDistribution;
		return this;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}

	public ProductInfoSearch setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public ProductInfoSearch setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}
	
	public String getProductDetaileInfo() {
		return productDetaileInfo;
	}

	public ProductInfoSearch setProductDetaileInfo(String productDetaileInfo) {
		this.productDetaileInfo = productDetaileInfo;
		return this;
	}
	
	public Integer getIsMortgage() {
		return isMortgage;
	}

	public ProductInfoSearch setIsMortgage(Integer isMortgage) {
		this.isMortgage = isMortgage;
		return this;
	}
	
	public String getFundUse() {
		return fundUse;
	}

	public ProductInfoSearch setFundUse(String fundUse) {
		this.fundUse = fundUse;
		return this;
	}
	
	public String getRepaymentSource() {
		return repaymentSource;
	}

	public ProductInfoSearch setRepaymentSource(String repaymentSource) {
		this.repaymentSource = repaymentSource;
		return this;
	}
	
	public String getBusinessStructure() {
		return businessStructure;
	}

	public ProductInfoSearch setBusinessStructure(String businessStructure) {
		this.businessStructure = businessStructure;
		return this;
	}
	
	public String getWindControlMeasures() {
		return windControlMeasures;
	}

	public ProductInfoSearch setWindControlMeasures(String windControlMeasures) {
		this.windControlMeasures = windControlMeasures;
		return this;
	}
	
	public Integer getToExamineStatus() {
		return toExamineStatus;
	}

	public ProductInfoSearch setToExamineStatus(Integer toExamineStatus) {
		this.toExamineStatus = toExamineStatus;
		return this;
	}
	
	public Integer getProductMortgageId() {
		return productMortgageId;
	}

	public ProductInfoSearch setProductMortgageId(Integer productMortgageId) {
		this.productMortgageId = productMortgageId;
		return this;
	}
	
}
package com.xsjrw.websit.dao.product;

import java.util.List;

import com.xsjrw.websit.core.domain.BaseMapper;
import com.xsjrw.websit.domain.product.ProductMortgage;

public interface ProductMortgageMapper extends BaseMapper<ProductMortgage>{
	
	public List<ProductMortgage> findProductMortgageByProductId(Integer productId);
}

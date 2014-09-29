package com.xsjrw.websit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.product.ProductMortgageMapper;
import com.xsjrw.websit.domain.product.ProductMortgage;
import com.xsjrw.websit.search.product.ProductMortgageSearch;
import com.xsjrw.websit.service.IProductMortgageService;

/**
 * Service Implementation:ProductMortgage
 * @author wang.zx
 * @date 2014-9-29
 */
@Service
@Transactional
public class ProductMortgageServiceImpl implements IProductMortgageService {

	@Autowired
	private ProductMortgageMapper productMortgageMapper;
	
	@Override
	public void saveProductMortgage(ProductMortgage productMortgage) {
//		productMortgageMapper.insert(productMortgage);
	}

	@Override
	public void batchSaveProductMortgage(List<ProductMortgage> productMortgages) {
		if(productMortgages != null && !productMortgages.isEmpty()){
			productMortgageMapper.batchInsert(productMortgages);
		}
	}

	@Override
	public void update(ProductMortgage T) {
		productMortgageMapper.update(T);
	}

	@Override
	public void deleteProductMortgageById(Integer id) {
		productMortgageMapper.deleteById(id);
		
	}

	@Override
	public void deleteProductMortgageByIds(Integer[] ids) {
		productMortgageMapper.deleteByIds(ids);
		
	}

	@Override
	public ProductMortgage findProductMortgageById(Integer id) {
		return productMortgageMapper.findById(id);
	}

	@Override
	public List<ProductMortgage> findProductMortgageByPage(
			ProductMortgageSearch search) {
		Integer totalRecords = productMortgageMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return productMortgageMapper.page(search);
	}
	
	
	
	
}

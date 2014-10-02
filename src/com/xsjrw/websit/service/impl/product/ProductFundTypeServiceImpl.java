package com.xsjrw.websit.service.impl.product;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.product.ProductFundTypeMapper;
import com.xsjrw.websit.domain.product.ProductFundType;
import com.xsjrw.websit.search.product.ProductFundTypeSearch;
import com.xsjrw.websit.service.product.IProductFundTypeService;

/**
 * Service Implementation:ProductFundType
 * @author wang.zx
 * @date 2014-9-29
 */
@Service
@Transactional
public class ProductFundTypeServiceImpl implements IProductFundTypeService {

	@Autowired
	private ProductFundTypeMapper productFundTypeMapper;
	
	@Override
	public void saveProductFundType(ProductFundType productFundType) {
		
		productFundType.setCreateTime(new Date());
		productFundType.setStatus(1);
		productFundTypeMapper.insert(productFundType);
	}

	@Override
	public void batchSaveProductFundType(List<ProductFundType> productFundTypes) {
		if(productFundTypes != null && !productFundTypes.isEmpty()){
			productFundTypeMapper.batchInsert(productFundTypes);
		}
		
	}

	@Override
	public void update(ProductFundType productFundType) {
		productFundTypeMapper.update(productFundType);
		
	}

	@Override
	public void deleteProductFundTypeById(Integer id) {
		productFundTypeMapper.deleteById(id);
		
	}

	@Override
	public void deleteProductFundTypeByIds(Integer[] ids) {
		productFundTypeMapper.deleteByIds(ids);
		
	}

	@Override
	public ProductFundType findProductFundTypeById(Integer id) {
		return productFundTypeMapper.findById(id);
	}

	@Override
	public List<ProductFundType> findProductFundTypeByPage(
			ProductFundTypeSearch search) {
		Integer totalRecords = productFundTypeMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return productFundTypeMapper.page(search);
	}

	@Override
	public List<ProductFundType> queryAll() {
		return productFundTypeMapper.queryAll();
	}
	
	
	
	
}

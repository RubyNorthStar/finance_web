package com.xsjrw.websit.service.impl.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.product.ProductInfoMapper;
import com.xsjrw.websit.domain.product.ProductInfo;
import com.xsjrw.websit.search.product.ProductInfoSearch;
import com.xsjrw.websit.service.product.IProductInfoService;

/**
 * Service Implementation:ProductInfo
 * @author wang.zx
 * @date 2014-9-29
 */
@Service
@Transactional
public class ProductInfoServiceImpl implements IProductInfoService {
	
	@Autowired
	private ProductInfoMapper productInfoMapper;

	@Override
	public void saveProductInfo(ProductInfo product) {
		productInfoMapper.insert(product);
	}

	@Override
	public void batchSaveProductInfo(List<ProductInfo> products) {
		if(products != null && !products.isEmpty()){
			productInfoMapper.batchInsert(products);
		}
		
	}

	@Override
	public void update(ProductInfo product) {
		productInfoMapper.update(product);
		
	}

	@Override
	public void deleteProductInfoById(Integer id) {
		productInfoMapper.deleteById(id);
		
	}

	@Override
	public void deleteProductInfoByIds(Integer[] ids) {
		productInfoMapper.deleteByIds(ids);
		
	}

	@Override
	public ProductInfo findProductInfoById(Integer id) {
		return productInfoMapper.findById(id);
	}

	@Override
	public List<ProductInfo> findProductInfoByPage(ProductInfoSearch search) {
		Integer totalRecords = productInfoMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return productInfoMapper.page(search);
	}
	
}

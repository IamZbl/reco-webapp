package com.reco.service.impl;

import java.util.List;

import com.reco.service.IProduct;
import com.reco.dao.ProductDao;
import com.reco.exception.BusinessException;
import com.reco.model.Product;

public class ProductServiceImpl implements IProduct {

	ProductDao productDao;

	public void setProductDao(ProductDao productDao) throws BusinessException {
		this.productDao = productDao;
	}

	public void save(Product product) throws BusinessException{
		System.out.println("save called");
		try {
			productDao.save(product);
			System.out.println("save done");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	public void update(Product product) throws BusinessException {
		try {
			productDao.update(product) ;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(Product product) throws BusinessException{
		try {
			productDao.delete(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}

	}

	public Product findByProductCode(String productCode) throws BusinessException {
		try {
			return productDao.findByProductCode(productCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
	}

	public List<Product> findByProductRecommendation(Float milage,
			Integer year, String category, Float engine) throws BusinessException {
		try {
			return productDao.findByProductRecommendation(milage, year,
					category, engine);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}	

	public List<Product> fetchAllProducts()  throws BusinessException{
		try {
			return productDao.fetchAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
	}
}

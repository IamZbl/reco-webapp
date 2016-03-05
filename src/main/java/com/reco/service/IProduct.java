package com.reco.service;

import java.util.List;

import com.reco.exception.BusinessException;
import com.reco.model.Product;;

public interface IProduct {
	
	void save(Product product) throws BusinessException;
	
	void update(Product product) throws BusinessException;
	
	void delete(Product product) throws BusinessException;
	
	Product findByProductCode(String procutCode) throws BusinessException;
	
	List<Product> findByProductRecommendation(Float milage,Integer year,String category,Float engine) throws BusinessException;
	
	List<Product> fetchAllProducts() throws BusinessException;

}

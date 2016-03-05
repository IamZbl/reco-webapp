package com.reco.dao;

import java.util.List;

import com.reco.model.Product;

public interface ProductDao {
	
	void save(Product product);
	
	void update(Product product);
	
	void delete(Product product);
	
	Product findByProductCode(String productCode);

	

	List<Product> findByProductRecommendation(Float milage, Integer year,
			String category, Float engine);
	
	List<Product> fetchAllProducts();
}

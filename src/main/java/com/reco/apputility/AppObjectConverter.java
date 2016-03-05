package com.reco.apputility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.reco.appmodel.ProductAppObject;
import com.reco.model.Product;
import com.reco.model.ProductAttribute;

public class AppObjectConverter {
	
	public static Set<ProductAttribute> createProductAttribute(ProductAppObject productAppObject){
		ProductAttribute productAttribute = new ProductAttribute();
		HashSet<ProductAttribute> productAttributes = new HashSet<ProductAttribute>();
		productAttribute.setAttrName("Country");
		productAttribute.setAttrValue(productAppObject.getCountry());
		productAttributes.add(productAttribute);
		productAttribute = new ProductAttribute();
		productAttribute.setAttrName("notes");
		productAttribute.setAttrValue(productAppObject.getNotes());
		productAttributes.add(productAttribute);
		return productAttributes;
		
	}
	
	public static Product  createProduct(Product product,ProductAppObject productAppModel){
		
		  product.setName(productAppModel.getName());
		  product.setCategory(productAppModel.getCategory());
		  product.setEngine(productAppModel.getEngine());
		  product.setMaxp(productAppModel.getMaxp());
		  product.setMilage(productAppModel.getMilage());
		  product.setProductCode(productAppModel.getName());
		  product.setYear(productAppModel.getYear());
		  return product;
		
	}
	
	public static ProductAppObject  createProductAppObject(Product product){
		ProductAppObject productAppModel = new ProductAppObject();
		  productAppModel.setName(product.getName());
		  productAppModel.setCategory(product.getCategory());
		  productAppModel.setEngine(product.getEngine());
		  productAppModel.setMaxp(product.getMaxp());
		  productAppModel.setMilage(product.getMilage());
		  productAppModel.setProductCode(product.getName());
		  productAppModel.setYear(product.getYear());
		  Set<ProductAttribute>   productAttributes = product.getProductAttributes();
		  System.out.println("Project atribute size :" + productAttributes.size());
		  if(productAttributes != null && productAttributes.size() > 0){
			  Iterator<ProductAttribute> iterator = productAttributes.iterator();
			  while(iterator.hasNext()){
				  ProductAttribute productAttribute = iterator.next();
				  String country = productAttribute.getAttrName();
				  System.out.println("Attribute name :" + country);
				  if(country != null){
					  
					  if("Country".equals(country)){
						  productAppModel.setCountry(productAttribute.getAttrValue());  
					  }else{
						  System.out.println("note section");
						  productAppModel.setNotes(productAttribute.getAttrValue());
					  }
				  }
			  }
		  }
		  System.out.println("notes :" + productAppModel.getNotes());
		  return productAppModel;
		
	}

}

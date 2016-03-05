package com.reco.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable{

	private Integer id;
	private String name;
	private String productCode;

	public Integer version;
	private String category;
	
	
	private Float engine;
	private Float milage;
	private Integer year;
	private Integer maxp;
	
	private Set<ProductAttribute> productAttributes = 	new HashSet<ProductAttribute>(0);
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getProductCode() {
		return productCode;
	}
	

	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Set<ProductAttribute> getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(Set<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Float getEngine() {
		return engine;
	}
	public void setEngine(Float engine) {
		this.engine = engine;
	}
	public Float getMilage() {
		return milage;
	}
	public void setMilage(Float milage) {
		this.milage = milage;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMaxp() {
		return maxp;
	}
	public void setMaxp(Integer maxp) {
		this.maxp = maxp;
	}
	
}

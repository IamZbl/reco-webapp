package com.reco.appmodel;

public class ProductAppObject {
	
	private String name;
	private String productCode;
	private String id;
	
	private String category;
	private Float engine;
	private Float milage;
	private Integer year;
	private Integer maxp;
	private String country;
	private String notes;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}

package com.example.dto.request;

public class ProductDTORequest {

	
	private String name;
	private String description;
	private double price;
	private String category;
	private String availablitityStatus;  // IN_STOCK / OUT_OF_STOCK
	private int stockQuantity ;
	
	public ProductDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTORequest(String name, String description, double price, String category, String availablitityStatus,
	 int stockQuantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.availablitityStatus = availablitityStatus;
	
		this.stockQuantity = stockQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAvailablitityStatus() {
		return availablitityStatus;
	}

	public void setAvailablitityStatus(String availablitityStatus) {
		this.availablitityStatus = availablitityStatus;
	}


	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	
	
	
	
	
}

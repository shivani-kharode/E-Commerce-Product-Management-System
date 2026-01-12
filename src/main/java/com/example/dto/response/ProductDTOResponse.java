package com.example.dto.response;

public class ProductDTOResponse {

	private int productId;
	private String name;
	private String description;
	private double price;
	private String category;
	private String availablitityStatus;  // IN_STOCK / OUT_OF_STOCK
	private boolean isActive;
	private int stockQuantity ;
	
	
	public ProductDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTOResponse(int productId, String name, String description, double price, String category,
			String availablitityStatus, boolean isActive, int stockQuantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.availablitityStatus = availablitityStatus;
		this.isActive = isActive;
		this.stockQuantity = stockQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	
	
}

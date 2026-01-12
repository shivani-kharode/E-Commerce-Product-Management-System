package com.example.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "category"})
    })
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String name;
	private String description;
	private double price;
	private String category;
	private String availablitityStatus;  // IN_STOCK / OUT_OF_STOCK
	private boolean isActive=true;
	private LocalDateTime createdAt=LocalDateTime.now();
	private LocalDateTime updatedAt=LocalDateTime.now();
	
	private int stockQuantity ;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	List<ProductReview> reviews;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	List<ProductImage> images ;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	List<CartItems> cartitems ;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	List<OrderItem> orderitems ;

	public Product(int productId, String name, String description, double price, String category,
			String availablitityStatus, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt,
			int stockQuantity, List<ProductReview> reviews, List<ProductImage> images, List<CartItems> cartitems,List<OrderItem> orderitems) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.availablitityStatus = availablitityStatus;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.stockQuantity = stockQuantity;
		this.reviews = reviews;
		this.images = images;
		this.cartitems = cartitems;
		this.orderitems=orderitems;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<ProductReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<ProductReview> reviews) {
		this.reviews = reviews;
	}

	public List<ProductImage> getImages() {
		return images;
	}

	public void setImages(List<ProductImage> images) {
		this.images = images;
	}

	public List<CartItems> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}

	public List<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	
	
	
	
	
	

}

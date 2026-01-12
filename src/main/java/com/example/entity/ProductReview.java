package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
name = "product_review",
uniqueConstraints = {
		@UniqueConstraint(columnNames = {"product_id","customer_name"})
})
public class ProductReview {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reviewId;
	
	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Product  product;
	 
    @Column(name = "customer_name")
	private String customerName;
	
	private int rating;
	
	private String reviewText;
	

	private LocalDateTime createdAt=LocalDateTime.now();
	

	public ProductReview() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductReview(int reviewId, Product pro, String customerName, int rating, String reviewText,
			LocalDateTime createdAt) {
		super();
		this.reviewId = reviewId;
		this.product = pro;
		this.customerName = customerName;
		this.rating = rating;
		this.reviewText = reviewText;
		this.createdAt = createdAt;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public Product getPro() {
		return product;
	}


	public void setPro(Product pro) {
		this.product = pro;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getReviewText() {
		return reviewText;
	}


	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	
	

}

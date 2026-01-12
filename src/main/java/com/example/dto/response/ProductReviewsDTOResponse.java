package com.example.dto.response;

public class ProductReviewsDTOResponse {

     private int reviewId;
  
     private int productId;
	
	private String customerName;
	
	private int rating;
	
	private String reviewText;

	public ProductReviewsDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductReviewsDTOResponse(int reviewId, int productId, String customerName, int rating, String reviewText) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.customerName = customerName;
		this.rating = rating;
		this.reviewText = reviewText;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
	
	

	

}

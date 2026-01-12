package com.example.dto.request;


public class ProductReviewsDTORequest {

	
	private String customerName;
	
	private int rating;
	
	private String reviewText;

	public ProductReviewsDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductReviewsDTORequest( String customerName, int rating, String reviewText) {
	
		this.customerName = customerName;
		this.rating = rating;
		this.reviewText = reviewText;
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

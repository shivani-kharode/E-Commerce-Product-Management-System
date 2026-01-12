package com.example.dto.request;

public class CartsDTORequest {

	private String customerName;

	public CartsDTORequest(String customerName) {
		super();
		this.customerName = customerName;
	}

	public CartsDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}

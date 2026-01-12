package com.example.dto.response;

public class CartsDTOResponse {
	
	private int cartId;
	
	private String customerName;

	public CartsDTOResponse(int cartId, String customerName) {
		super();
		this.cartId = cartId;
		this.customerName = customerName;
	}

	public CartsDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	
	

}

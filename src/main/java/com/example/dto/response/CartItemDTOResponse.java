package com.example.dto.response;

public class CartItemDTOResponse {
	
	    private int cartItemId;
	    private int cartId;
	    private String customerName;
	    private int productId;
	    private int quantity;
	    private double price;
		public CartItemDTOResponse(int cartItemId, int cartId, String customerName, int productId, int quantity,
				double price) {
			super();
			this.cartItemId = cartItemId;
			this.cartId = cartId;
			this.customerName = customerName;
			this.productId = productId;
			this.quantity = quantity;
			this.price = price;
		}
		public CartItemDTOResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getCartItemId() {
			return cartItemId;
		}
		public void setCartItemId(int cartItemId) {
			this.cartItemId = cartItemId;
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
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
	    
	    

}

package com.example.dto.response;

public class OrderItemDTOResponse {
	
	    private int orderItemId;
	    private String productName;
	    private int quantity;
	    private double price;
	    
		public OrderItemDTOResponse(int orderItemId, String productName, int quantity, double price) {
			super();
			this.orderItemId = orderItemId;
			this.productName = productName;
			this.quantity = quantity;
			this.price = price;
		}

		public OrderItemDTOResponse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getOrderItemId() {
			return orderItemId;
		}

		public void setOrderItemId(int orderItemId) {
			this.orderItemId = orderItemId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
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

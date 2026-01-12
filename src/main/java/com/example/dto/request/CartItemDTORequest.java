package com.example.dto.request;

public class CartItemDTORequest {
	
       private int quantity;
	
	    
	   public CartItemDTORequest() {
			super();
			// TODO Auto-generated constructor stub
		}

	

		public CartItemDTORequest( int quantity) {
		super();
		
		this.quantity = quantity;
	}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		

		
	    

}

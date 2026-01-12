
package com.example.dto.response;

public class WistListsDTOResponse {
	
	  private int wishlistId;
      
      private String customerName;
      
     private int productId;

	 public WistListsDTOResponse(int wishlistId, String customerName, int productId) {
		super();
		this.wishlistId = wishlistId;
		this.customerName = customerName;
		this.productId = productId;
	 }

	 public WistListsDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	 }

	 public int getWishlistId() {
		 return wishlistId;
	 }

	 public void setWishlistId(int wishlistId) {
		 this.wishlistId = wishlistId;
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
     
     


}

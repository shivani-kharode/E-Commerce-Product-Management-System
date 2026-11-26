package com.example.dto.request;

public class OrdersDTORequest {
	
	   private String customerName;
	   private String orderStatus;

	   public OrdersDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	   }

	   public OrdersDTORequest(String customerName, String orderStatus) {
		super();
		this.customerName = customerName;
		this.orderStatus = orderStatus;
	   }

	   public String getCustomerName() {
		   return customerName;
	   }

	   public void setCustomerName(String customerName) {
		   this.customerName = customerName;
	   }

	   public String getOrderStatus() {
		   return orderStatus;
	   }

	   public void setOrderStatus(String orderStatus) {
		   this.orderStatus = orderStatus;
	   }


}

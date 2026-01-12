package com.example.dto.response;

import java.time.LocalDate;

public class OrdersDTOResponse {
	
	   private int  orderId;
	   
	   private String customerName;
	   
	   private double totalAmount;
	   
	   private String orderStatus;
	   
	   private LocalDate orderDate;
	   
	  

	   public OrdersDTOResponse(int orderId, String customerName, double totalAmount, String orderStatus
			) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	
		
	   }

	   public OrdersDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	   }

	   public int getOrderId() {
		   return orderId;
	   }

	   public void setOrderId(int orderId) {
		   this.orderId = orderId;
	   }

	   public String getCustomerName() {
		   return customerName;
	   }

	   public void setCustomerName(String customerName) {
		   this.customerName = customerName;
	   }

	   public double getTotalAmount() {
		   return totalAmount;
	   }

	   public void setTotalAmount(double totalAmount) {
		   this.totalAmount = totalAmount;
	   }

	   public String getOrderStatus() {
		   return orderStatus;
	   }

	   public void setOrderStatus(String orderStatus) {
		   this.orderStatus = orderStatus;
	   }

	   public LocalDate getOrderDate() {
		   return orderDate;
	   }

	   public void setOrderDate(LocalDate orderDate) {
		   this.orderDate = orderDate;
	   }

	 

	   
	   
	   

}

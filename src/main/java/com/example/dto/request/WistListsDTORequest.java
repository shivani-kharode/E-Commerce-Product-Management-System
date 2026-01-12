package com.example.dto.request;

public class WistListsDTORequest {
	
	 private String customerName;
	 private int product_id;


	 public WistListsDTORequest() {
		super();
		// TODO Auto-generated constructor stub
	 }


	 public WistListsDTORequest(String customerName, int product_id) {
		super();
		this.customerName = customerName;
		this.product_id = product_id;
	 }


	 public String getCustomerName() {
		 return customerName;
	 }


	 public void setCustomerName(String customerName) {
		 this.customerName = customerName;
	 }


	 public int getProduct_id() {
		 return product_id;
	 }


	 public void setProduct_id(int product_id) {
		 this.product_id = product_id;
	 }


	 

}

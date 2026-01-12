package com.example.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int  orderId;
	   
	   private String customerName;
	   
	   private double totalAmount;
	   
	   private String orderStatus;
	   
	   private LocalDate orderDate= LocalDate.now();
	   
	   @OneToMany(mappedBy="orders",cascade=CascadeType.ALL)
	   private List<OrderItem> orderitem = new ArrayList<>();

	   public Orders() {
		super();
		// TODO Auto-generated constructor stub
	   }

	   public Orders(int orderId, String customerName, double totalAmount, String orderStatus, LocalDate orderDate,
			List<OrderItem> orderItem) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderitem = orderItem;
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

	   public List<OrderItem> getOrderItem() {
		   return orderitem;
	   }

	   public void setOrderItem(List<OrderItem> orderItem) {
		   this.orderitem = orderItem;
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}

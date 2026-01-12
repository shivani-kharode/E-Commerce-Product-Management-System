package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	private String customerName;
	@OneToMany(mappedBy="carts",cascade=CascadeType.ALL)
	List<CartItems> cartitems = new ArrayList<>();
	
	public Carts(int cartId, String customerName, List<CartItems> cartitems) {
		super();
		this.cartId = cartId;
		this.customerName = customerName;
		this.cartitems = cartitems;
	}

	public Carts() {
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

	public List<CartItems> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}
	
	
	
	
	
}

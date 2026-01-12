package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartItemId;
	
	@ManyToOne()
	@JoinColumn(name="cart_id")
	private Carts carts;
	
	
	@ManyToOne()
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;
	
	private double price;

	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItems(int cartItemId, Carts cart, Product pro, int quantity, double price) {
		super();
		this.cartItemId = cartItemId;
		this.carts = cart;
		this.product = pro;
		this.quantity = quantity;
		this.price = price;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Carts getCart() {
		return carts;
	}

	public void setCart(Carts cart) {
		this.carts = cart;
	}

	public Product getPro() {
		return product;
	}

	public void setPro(Product pro) {
		this.product = pro;
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

package com.example.entity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"customer_name","product_id"})
})
public class WishLists {
	      @Id
	      @GeneratedValue(strategy=GenerationType.IDENTITY)
	      private int wishlistId;
	      @Column(name="customer_name")
	      private String customerName;
	      
	      @ManyToOne()
	      @JoinColumn(name="product_id")
	      private Product product;
	      
	      @ManyToOne
	      @JoinColumn(name="user_id")
	      private User user;
	      
	      private LocalDateTime addedAt= LocalDateTime.now();

		 
		  public WishLists() {
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


		  public Product getProduct() {
			  return product;
		  }


		  public void setProduct(Product product) {
			  this.product = product;
		  }


		  public User getUser() {
			  return user;
		  }


		  public void setUser(User user) {
			  this.user = user;
		  }


		  public LocalDateTime getAddedAt() {
			  return addedAt;
		  }


		  public void setAddedAt(LocalDateTime addedAt) {
			  this.addedAt = addedAt;
		  }


		  public WishLists(int wishlistId, String customerName, Product product, User user, LocalDateTime addedAt) {
			super();
			this.wishlistId = wishlistId;
			this.customerName = customerName;
			this.product = product;
			this.user = user;
			this.addedAt = addedAt;
		  }

		
 
}

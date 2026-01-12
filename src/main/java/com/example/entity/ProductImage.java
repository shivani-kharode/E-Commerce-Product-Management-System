package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_image")
public class ProductImage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int imageId;
	
	private String imageName;
	
	private String imageUrl;
	
	private String imageSize;
	
	private String imageType;
	
	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Product  product;

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImage(int imageId, String imageName, String imageUrl, String imageSize, String imageType,
			Product pro) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.imageSize = imageSize;
		this.imageType = imageType;
		this.product = pro;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageSize() {
		return imageSize;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Product getPro() {
		return product;
	}

	public void setPro(Product pro) {
		this.product = pro;
	}
	
	
	
	
	

}

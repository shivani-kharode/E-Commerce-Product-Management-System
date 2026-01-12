package com.example.dto.request;

public class ProductImagesDTORequest {
	
	
	private String imageName;
	
	private String imageUrl;
	
	private String imageSize;
	
	private String imageType;

	public ProductImagesDTORequest(String imageName, String imageUrl, String imageSize, String imageType) {
		super();
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.imageSize = imageSize;
		this.imageType = imageType;
	}

	public ProductImagesDTORequest() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
	

}

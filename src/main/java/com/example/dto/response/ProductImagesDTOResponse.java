package com.example.dto.response;

public class ProductImagesDTOResponse {
	
	   private int imageId;
		
	   private int productId;
	   
		private String imageName;
		
		private String imageUrl;
		
		private String imageSize;
		
		private String imageType;

		public ProductImagesDTOResponse() {
			super();
			// TODO Auto-generated constructor stub
		}


		public ProductImagesDTOResponse(int imageId, int productId, String imageName, String imageUrl, String imageSize,
				String imageType) {
			super();
			this.imageId = imageId;
			this.productId = productId;
			this.imageName = imageName;
			this.imageUrl = imageUrl;
			this.imageSize = imageSize;
			this.imageType = imageType;
		}


		public int getImageId() {
			return imageId;
		}


		public void setImageId(int imageId) {
			this.imageId = imageId;
		}


		public int getProductId() {
			return productId;
		}


		public void setProductId(int productId) {
			this.productId = productId;
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

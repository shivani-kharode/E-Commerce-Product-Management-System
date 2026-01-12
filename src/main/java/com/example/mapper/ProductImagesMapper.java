package com.example.mapper;

import com.example.dto.request.ProductImagesDTORequest;
import com.example.dto.response.ProductImagesDTOResponse;
import com.example.entity.ProductImage;

public class ProductImagesMapper {
	   
	public static ProductImage toEntity( ProductImagesDTORequest image) {
		    
		ProductImage  pi = new ProductImage();
		
		  pi.setImageName(image.getImageName());
		  pi.setImageSize(image.getImageSize());
		  pi.setImageType(image.getImageType());
		  pi.setImageUrl(image.getImageUrl());
		  return pi;
	}

	public static ProductImagesDTOResponse toResponse( ProductImage image) {
		ProductImagesDTOResponse  response = new ProductImagesDTOResponse();
		response.setImageId(image.getImageId());
		response.setImageName(image.getImageName());
		response.setImageSize(image.getImageSize());
		response.setImageType(image.getImageType());
		response.setImageUrl(image.getImageUrl());
		response.setProductId(image.getPro().getProductId());
		 return response;
	}

	
	
}

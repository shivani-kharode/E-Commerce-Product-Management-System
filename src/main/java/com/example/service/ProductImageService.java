package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.request.ProductImagesDTORequest;
import com.example.dto.response.ProductImagesDTOResponse;
import com.example.entity.ProductImage;
import com.example.mapper.ProductImagesMapper;
import com.example.repository.ProductImageRepository;
@Service
public class ProductImageService {

	 @Autowired
	 private ProductImageRepository repository;
	 
	 private static final List<String> AllowedExtension = List.of("jpg","jpeg","png","webp");
	 
	public void createImage(int productId, ProductImagesDTORequest image) {
		
		// validate image type 
		 validateImageType(image.getImageUrl());
		// mapping of dto to entity 
	
		ProductImage   pi  = ProductImagesMapper.toEntity(image);
		        repository.createImage(productId,pi);
	}
	
	private void validateImageType(String imageUrl) {
		
		if( imageUrl == null || imageUrl.isEmpty()) {
			throw new IllegalArgumentException("Image Url cannot be null");
		}

		String extension = imageUrl.substring(imageUrl.lastIndexOf('.')+1).toLowerCase();
		if(!AllowedExtension.contains(extension)) {
			throw new IllegalArgumentException("Invalid Image Type . Only .jpg , jpeg , png , webp are allowed !!");
		}
	}

	public List<ProductImagesDTOResponse> getImageById(int productId){
		      List<ProductImage>  images=repository.getImageBId(productId);
		      
		      List<ProductImagesDTOResponse> list = new ArrayList<>();
		      for(ProductImage pro : images ) {
		    	   ProductImagesDTOResponse pidr =  ProductImagesMapper.toResponse(pro);
		    	   list.add(pidr);
		      }
		      return list;
		      
	}

	public void deleteImage(int imageId) {
		repository.deleteImage(imageId);
	}

}

package com.example.mapper;

import java.time.LocalDateTime;

import com.example.dto.request.ProductDTORequest;
import com.example.dto.response.ProductDTOResponse;
import com.example.entity.Product;

public class ProductMapper {
            
	 public static Product toEntity(ProductDTORequest dto) {
        // dto to entity
	        Product product = new Product();
	        product.setName(dto.getName());
	        product.setDescription(dto.getDescription());
	        product.setPrice(dto.getPrice());
	        product.setCategory(dto.getCategory());
	        product.setAvailablitityStatus(dto.getAvailablitityStatus());
	        product.setStockQuantity(dto.getStockQuantity());



	        return product;
	    }

	    // 🔹 Entity → Response DTO (READ)
	    public static ProductDTOResponse toResponse(Product product) {

	        ProductDTOResponse response = new ProductDTOResponse();
	        response.setProductId(product.getProductId());
	        response.setName(product.getName());
	        response.setDescription(product.getDescription());
	        response.setPrice(product.getPrice());
	        response.setCategory(product.getCategory());
	        response.setAvailablitityStatus(product.getAvailablitityStatus());
	        response.setActive(product.isActive());
	        response.setStockQuantity(product.getStockQuantity());
	     

	        return response;
	    }

	    // 🔹 Update existing entity (PUT)
	    public static void updateEntity(Product product, ProductDTORequest dto) {

	        product.setName(dto.getName());
	        product.setDescription(dto.getDescription());
	        product.setPrice(dto.getPrice());
	        product.setCategory(dto.getCategory());
	        product.setAvailablitityStatus(dto.getAvailablitityStatus());
	        product.setActive(true);
            
	        product.setUpdatedAt(LocalDateTime.now());
	    }
	
}

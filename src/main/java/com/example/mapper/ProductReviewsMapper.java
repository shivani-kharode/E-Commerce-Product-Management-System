package com.example.mapper;

import com.example.dto.request.ProductReviewsDTORequest;
import com.example.dto.response.ProductReviewsDTOResponse;
import com.example.entity.ProductReview;

public class ProductReviewsMapper {

	public static  ProductReview toEntity(ProductReviewsDTORequest prdr, int productId) {
	       
		    ProductReview review  = new ProductReview();
		    
		    review.setCustomerName(prdr.getCustomerName());
		    review.setRating(prdr.getRating());
		    review.setReviewText(prdr.getReviewText());
		
		  
		    return review;

	}
	
	public static  ProductReviewsDTOResponse toResponse( ProductReview review) {
		ProductReviewsDTOResponse  response = new ProductReviewsDTOResponse();
		
		response.setReviewId(review.getReviewId());
		response.setCustomerName(review.getCustomerName());
		response.setRating(review.getRating());
		response.setReviewText(review.getReviewText());
		response.setProductId(review.getProduct().getProductId());
		
		return response;
	}
	
	

}

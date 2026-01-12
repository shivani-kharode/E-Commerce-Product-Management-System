package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dto.request.ProductReviewsDTORequest;
import com.example.dto.response.ProductReviewsDTOResponse;
import com.example.entity.ProductReview;
import com.example.mapper.ProductReviewsMapper;
import com.example.repository.ProductReviewRepository;
@Service
public class ProductReviewService {
	
	@Autowired
	private ProductReviewRepository repository;

	public void createReview(int productId, ProductReviewsDTORequest prdr) {
		   	// rating must be between 1 to  5	
		  if( prdr.getRating() < 1  || prdr.getRating() > 5) {
			    throw new RuntimeException("Rating must be between 1 to 5 ");
		  }
		  
          
		// mapping of dto to entity 
		ProductReview review = ProductReviewsMapper.toEntity(prdr,productId);
		  
		   // save data in  db
	         repository.createReview(review,productId);
	}

	public List<ProductReviewsDTOResponse> getReviewProductId(int productId) {
		List<ProductReview>  pr =  repository.getReviewProductId(productId);
		 
		List<ProductReviewsDTOResponse> list = new ArrayList<>();
		for( ProductReview review : pr) {
			 
			ProductReviewsDTOResponse prdr	= ProductReviewsMapper.toResponse(review);
			list.add(prdr);
			
		}
		
		 return list;
		
	}

	public void changeRatingById(int reviewId, int rating) {
		         repository.changeRatingById(reviewId,rating);
		
	}

	public void deleteReview(int reviewId) {
                   repository.deleteReview(reviewId);
		
	}

}

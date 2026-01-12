package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.ProductReviewsDTORequest;
import com.example.dto.response.ProductReviewsDTOResponse;

import com.example.service.ProductReviewService;

@RestController
@RequestMapping("/api/products")
public class ProductReviewController {
	
	 @Autowired
	 private  ProductReviewService  service;
	 
	 
	 // 8]   Product Rating & Review CRUD API 
	        
	 
	    //  a]  create 
	 
	 //  http://localhost:8080/api/products/{productId}/reviews 
	 
	  @PostMapping("/{productId}/reviews")
	   public String createReview(@PathVariable(name="productId") int productId, @RequestBody ProductReviewsDTORequest  prdr) {
		            service.createReview(productId,prdr);
		            return "Data inserted";
	  }
	  
	  // b]  get 
	  
	 //  http://localhost:8080/api/products/{productId}/reviews 
	  
	  @GetMapping("/{productId}/reviews")
	 public List<ProductReviewsDTOResponse> getReviewByProductId(@PathVariable(name="productId") int productId) {
		  
		return   service.getReviewProductId(productId);
	  }
	  
	  // c]  put 
	  
	  // change rating of a product 
	  

	  // PUT http://localhost:8080/api/products/put?reviewId=1&rating=4
	   
	  
	  @PutMapping("put")
	  public void changeRatingById(@RequestParam(name="reviewId") int reviewId , @RequestParam(name="rating") int rating) {
		        service.changeRatingById(reviewId,rating);
	  }
	  
	  // d] delete
	  
	 //  http://localhost:8080/api/products/reviews/{reviewId} 
	       
	  @DeleteMapping("/reviews/{reviewId}")
	  public void deleteReview(@PathVariable(name="reviewId") int reviewId) {
		      service.deleteReview(reviewId);
	  }

}

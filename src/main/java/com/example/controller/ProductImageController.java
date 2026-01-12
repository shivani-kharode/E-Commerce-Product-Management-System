package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.ProductImagesDTORequest;
import com.example.dto.response.ProductImagesDTOResponse;
import com.example.service.ProductImageService;


@RestController
@RequestMapping("/api/products")
public class ProductImageController {

	 @Autowired 
	 private ProductImageService service;
	 
	 // Product Image Metadata CRUD API 
	 
	 //  a] create
	 //http://localhost:8080/api/products/{productId}/images 
	 
	 @PostMapping("/{productId}/images")
	 public String  createImage(@PathVariable(name="productId") int productId,@RequestBody  ProductImagesDTORequest image) {
		  
		     service.createImage(productId,image);
		 
		 return "Data inserted";
		 
		 }
	 
	 // b] get 
	 
	 // http://localhost:8080/api/products/{productId}/images
	 
	 @GetMapping("/{productId}/images")
	 
	 public List<ProductImagesDTOResponse> getImageById(@PathVariable(name="productId") int productId){
		 return  service.getImageById(productId);
	 }
	 
	 // c] DELETE
	 
	 //   http://localhost:8080/api/products/images/{imageId} 
	 
	 @DeleteMapping("/images/{imageId}")
	 public void deleteImage(@PathVariable(name="imageId") int imageId) {
		  service.deleteImage(imageId);
	 }
}


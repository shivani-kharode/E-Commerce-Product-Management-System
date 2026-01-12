package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.WistListsDTORequest;
import com.example.dto.response.WistListsDTOResponse;
import com.example.service.WishListsService;

@RestController
public class WishListsController {
	
	@Autowired 
	private WishListsService service;

	// 7] Wishlist CRUD API 
	
	// a] create 
	
	// POST   http://localhost:8080/api/wishlist 

	@PostMapping("api/wishlist")
	public  String createWishList(@RequestBody WistListsDTORequest wish ) {
		 service.createWishList(wish);
		 return "Data Added";
	}
	
	// b] get 
	//   http://localhost:8080/api/wishlist/{customerName}
	
	@GetMapping("api/wishlist/{customerName}")
	public List<WistListsDTOResponse> getAllWishList(@PathVariable(name="customerName") String c){
		return service.getAllWishList(c);
	}
	
	 // c] delete 
       //  http://localhost:8080/api/wishlist/{wishlistId}
	
	@DeleteMapping("api/wishlist/{wishlistId}")
	public void deleteWishList(@PathVariable(name="wishlistId") int wishlistId) {
		 service.deleteWishList(wishlistId);
	}
}

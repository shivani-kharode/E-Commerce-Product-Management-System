package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.dto.request.CartsDTORequest;
import com.example.dto.response.CartsDTOResponse;
import com.example.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private CartService service;
	// 1] create 

	// POST http://localhost:8080/api/cartitem/create

	
	 @PostMapping("/create")
	 public String createCart(@RequestBody CartsDTORequest  cart ) {
		 service.createCart(cart);
		 return "Data inserted";
		 }
	 
	 // 2] get
	 
	 // http://localhost:8080/cart/get
	 
	 @GetMapping("/get")
	 public List<CartsDTOResponse> getAllCart(){
		 return service.getAllCart();
	 }

	
}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.OrdersDTORequest;
import com.example.dto.response.OrdersDTOResponse;
import com.example.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
    private OrderService service;
	
	// 1]  create
	// http://localhost:8080/api/order/create
	@PreAuthorize("hasRole('CUSTOMER')")
	@PostMapping("/create")
	public String createOrder(@RequestBody OrdersDTORequest order) {
		service.createOrder(order);
		return "Data inserted";
	}
	
	// 2] uodate order status
	
	// http://localhost:8080/api/order/{orderId}/status
	
	@PutMapping("/{orderId}/status")
	public OrdersDTOResponse updateOrderStatus(@RequestBody OrdersDTORequest order , @PathVariable int orderId) {
		return service.updateOrderStatus(order ,orderId);
		
	}
	

}

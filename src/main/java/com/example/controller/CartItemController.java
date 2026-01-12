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
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.CartItemDTORequest;
import com.example.dto.response.CartItemDTOResponse;
import com.example.service.CartItemService;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
	
	@Autowired
	private CartItemService service;
	
	
	
	// 8⃣ Cart Item Add / Remove / Update API
	
	// 1] create 
	

	// POST http://localhost:8080/api/cart/{cartId}/items/{productId}
	@PostMapping("/{cartId}/items/{productId}")
	public String  createCartItems(@PathVariable(name="cartId") int cartId,@PathVariable(name="productId")int productId,@RequestBody CartItemDTORequest cidr) {
		service.createCartItems(cidr,cartId,productId);
		return "Data inserted";
	}
	
	 // 2]	GET 
     // http://localhost:8080/api/cart/{customerName} 
	
	@GetMapping("/{customerName}")
	public List<CartItemDTOResponse> getCartItemByCN(@PathVariable String customerName){
		return  service.getCartItemByCN(customerName);
		
	}
	
    // 3] 	PUT    
	//     http://localhost:8080/api/cart/{cartItemId} 
	
	@PutMapping("/{cartItemId}")
	public void updateQuantity(@PathVariable(name="cartItemId") int cartItemId,  @RequestBody CartItemDTORequest cidr)  {
		service.updateQuantity(cartItemId,cidr);
	}
	
	// 4]  DELETE 
	// http://localhost:8080/api/cart/{cartItemId} 
	
	@DeleteMapping("/{cartItemId}")
	public void deleteCartItem(@PathVariable int cartItemId) {
		service.deleteCartItem(cartItemId);
	}
	
  

}

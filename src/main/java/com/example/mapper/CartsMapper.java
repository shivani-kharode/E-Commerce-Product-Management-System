package com.example.mapper;

import com.example.dto.request.CartsDTORequest;
import com.example.dto.response.CartsDTOResponse;
import com.example.entity.Carts;

public class CartsMapper {
	
	public static  Carts toEntity(CartsDTORequest cdr) {
		Carts cart = new Carts();
		
		cart.setCustomerName(cdr.getCustomerName());
		
		return cart;
		
	}
	
	public static   CartsDTOResponse toResponse(Carts cart) {
		
		CartsDTOResponse res = new CartsDTOResponse();
		res.setCartId(cart.getCartId());
		res.setCustomerName(cart.getCustomerName());
		return res;
	}

}

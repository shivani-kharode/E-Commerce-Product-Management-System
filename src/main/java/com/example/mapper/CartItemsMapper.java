package com.example.mapper;

import com.example.dto.request.CartItemDTORequest;
import com.example.dto.response.CartItemDTOResponse;
import com.example.entity.CartItems;
import com.example.entity.Carts;
import com.example.entity.Product;

public class CartItemsMapper {
	
	public static CartItems  toEntity(CartItemDTORequest cartitem, Carts cart, Product product) {
		  
		CartItems ci = new CartItems();
		ci.setCart(cart);
		ci.setPro(product);
		ci.setPrice(product.getPrice());
	    ci.setQuantity(cartitem.getQuantity());
		return ci;
		
		
	}
	
	public static CartItemDTOResponse toResponse( CartItems cart) {
		
		CartItemDTOResponse  dto = new CartItemDTOResponse();
		dto.setCartItemId(cart.getCartItemId());
		dto.setCartId(cart.getCart().getCartId());
		dto.setCustomerName(cart.getCart().getCustomerName());
		dto.setPrice(cart.getPrice());
		dto.setQuantity(cart.getQuantity());
		dto.setProductId(cart.getPro().getProductId());
		return dto;
		
	}

	public static CartItemDTOResponse toResponseObjectArray(Object[] row) {
		
		CartItemDTOResponse  dto = new CartItemDTOResponse();
		dto.setCartId((Integer) row[0]);
		dto.setProductId((Integer) row[1]);
		dto.setQuantity((Integer) row[2]);
		dto.setPrice((Double) row[3]);
		dto.setCustomerName((String) row[4]);
		return dto;
	}

}

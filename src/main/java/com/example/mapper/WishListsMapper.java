package com.example.mapper;

import com.example.dto.request.WistListsDTORequest;
import com.example.dto.response.WistListsDTOResponse;
import com.example.entity.Product;
import com.example.entity.WishLists;

public class WishListsMapper {

	public static WishLists toEntity(WistListsDTORequest wish, Product product ) {
		
		WishLists wl = new WishLists();
		wl.setProduct(product);
		wl.setCustomerName(wish.getCustomerName());
		return wl;
		
	}
	
	public static WistListsDTOResponse toResponse( WishLists wl) {
		
		 WistListsDTOResponse wish = new  WistListsDTOResponse();
		 
		 wish.setWishlistId(wl.getWishlistId());
		 wish.setCustomerName(wl.getCustomerName());
		 wish.setProductId(wl.getProduct().getProductId());
		 return wish;
		
	}
}

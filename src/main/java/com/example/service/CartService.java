package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dto.request.CartsDTORequest;
import com.example.dto.response.CartsDTOResponse;
import com.example.entity.Carts;
import com.example.mapper.CartsMapper;
import com.example.repository.CartRepository;
@Service
public class CartService {

     @Autowired
     private CartRepository repository;
     
	public void createCart(CartsDTORequest cart) {
		     
		Carts carts =  CartsMapper.toEntity(cart);
		
		repository.createCart(carts);
		
	}

	public List<CartsDTOResponse> getAllCart() {
	List<Carts>	carts=  repository.getAllCart();
	
	List<CartsDTOResponse> list = new ArrayList<>();
	
	for( Carts res : carts) {
		
		 CartsDTOResponse  dto = CartsMapper.toResponse(res);
		 list.add(dto);
		}
	
	return list;
	}

}

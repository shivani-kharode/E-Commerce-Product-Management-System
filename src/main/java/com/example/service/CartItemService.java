package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.request.CartItemDTORequest;
import com.example.dto.response.CartItemDTOResponse;
import com.example.entity.CartItems;
import com.example.entity.Carts;
import com.example.entity.Product;
import com.example.mapper.CartItemsMapper;
import com.example.repository.CartItemRepository;
import com.example.repository.CartRepository;
import com.example.repository.ProductRepository;
@Service
public class CartItemService {
    
	@Autowired
	private CartItemRepository repository;
	
	@Autowired 
	private CartRepository   cartRepo;
	
	@Autowired 
	private ProductRepository proReop;


	public void createCartItems(CartItemDTORequest cidr, int cartId, int productId) {
		  if(cidr.getQuantity() < 1 ) {
				throw new RuntimeException("Insufficient stock !!");
			   }
			
			   Carts cart  = cartRepo.findById(cartId);
			   if(cart == null) {
				   throw new RuntimeException("Cart not found!!");
			   }
			   
			   Product product = proReop.findById(productId);
			   
			   if( product == null) {
				   throw new RuntimeException("Product not found !!");
			   }
			   
			   if(product.getStockQuantity() < cidr.getQuantity()) {
				   throw new RuntimeException("Insufficent stock of product !!");
			   }
			   
			   
			   CartItems cartitem =CartItemsMapper.toEntity(cidr,cart,product);
			    repository.createCartItems(cartitem);
		
	}


	public List<CartItemDTOResponse> getCartItemByCN(String customerName) {
		List<Object[]> obj = repository.getCartItemByCN(customerName);
		
		// map object to cartItemresponsedto 
		List<CartItemDTOResponse> cart = new ArrayList<>();
		
		for(Object[]  row: obj) {
			cart.add(CartItemsMapper.toResponseObjectArray(row));
		}
		return cart;
		
	}


	public void updateQuantity(int cartItemId, CartItemDTORequest cidr) {
		 
	  CartItems cartitem =	repository.findById(cartItemId);
	           cartitem.setQuantity(cidr.getQuantity());
	           repository.saveCartItems(cartitem);
		
	}


	public void deleteCartItem(int cartItemId) {
	;
	        repository.deleteCartItem(cartItemId);
		
	}


	public List<CartItemDTOResponse> getAll() {
		List<CartItems> cartitem=repository.getAll();
		
		List<CartItemDTOResponse> list = new ArrayList<CartItemDTOResponse> ();
		for( CartItems ci : cartitem) {
			  list.add(CartItemsMapper.toResponse(ci));
		}
		return list;
	
	}

}

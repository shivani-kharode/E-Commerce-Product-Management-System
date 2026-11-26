package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dto.request.WistListsDTORequest;
import com.example.dto.response.WistListsDTOResponse;
import com.example.entity.Product;
import com.example.entity.WishLists;
import com.example.mapper.WishListsMapper;
import com.example.repository.WishListsRepository;
@Service
public class WishListsService {

	 @Autowired 
	 private WishListsRepository repository;
	 
	 @Autowired 
	 private SessionFactory factory;
	 
	public void createWishList(WistListsDTORequest wish) {
		    
		int productId = wish.getProduct_id();
		String cName= wish.getCustomerName();
		
		// prevents duplicate entries 
		if( repository.existsByCustomerNameAndProductId(productId,cName)) {
			throw new RuntimeException("Product already exits in wishlist !!");
		}
		
		// fetch  product and  check product active 
		Session session = factory.openSession();
		
		 Product product= session.get(Product.class,productId);
		 session.close();
//		 
//		 if( product != null ) {
//			 throw new RuntimeException("Product not found ");
//		 }
//		 
		 if(!product.isActive()) {
			 throw new RuntimeException("Only active products are allowed ");
		 }
		 
		  WishLists wishlist  = WishListsMapper.toEntity(wish, product);
		repository.createWishList(wishlist);
		
	}

	public List<WistListsDTOResponse> getAllWishList(String customerName) {
		      
		List<WishLists> wl  =repository.getAllWishList(customerName);
		List<WistListsDTOResponse>    res =  new ArrayList<>();
		for(WishLists  wish : wl) {
			  res.add( WishListsMapper.toResponse(wish));
		}
		return res;
		                 
	}

	public void deleteWishList(int id) {
		repository.deleteWishList(id);
		
	}

}

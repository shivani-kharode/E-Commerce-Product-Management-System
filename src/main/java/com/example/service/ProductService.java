package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.request.ProductDTORequest;
import com.example.dto.response.ProductDTOResponse;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.repository.ProductRepository;
@Service
public class ProductService {
       @Autowired 
       private ProductRepository repository;
       
	public void createProduct(ProductDTORequest pdto) {
		// Mapping of dto to entity
		Product product = ProductMapper.toEntity(pdto);
		
		if(product.getPrice() <= 0) {
			throw new RuntimeException("Product Price must be greater than 0 !!");
		}
		
		
		
	  repository.createProduct(product);
	}

	public List<ProductDTOResponse> getAllProducts() {
		// Mapping of entity
		List<Product>  product = repository.getAllProduct();
		  List<ProductDTOResponse>  products  = new ArrayList<>();
		  
		  for (Product p : product) {
		        // skip soft-deleted products
		      //  if (!product.isActive()) continue;

		        products.add(ProductMapper.toResponse(p));
		    }
				 
		  return products;
		               
		
	}

	public ProductDTOResponse  getSingleProduct(int id) {
	// Mappind of entity --- dto
		Product student = repository.getSingleProduct(id);
		ProductDTOResponse dto= ProductMapper.toResponse(student);
		return dto;
	}
	
	
	public void deleteProduct(int id) {
	    Product product = repository.findById(id);
	    if (product != null && product.isActive()) {
	        product.setActive(false); // soft delete
	        repository.update(product); // just update, do NOT insert
	    }
	}

	public List<ProductDTOResponse> getProductAPI(String name, String category, double minPrice, double maxPrice) {
		             
		
	List<Product> product =repository.getProductAPI(name,category,minPrice,maxPrice);
	  List<ProductDTOResponse>  products  = new ArrayList<>();
		  
		  for (Product p : product) {
		        // skip soft-deleted products
		      //  if (!product.isActive()) continue;

		        products.add(ProductMapper.toResponse(p));
		    }
				 
		  return products;
		
	}

	public ProductDTOResponse updateProduct(int id, ProductDTORequest dto) {
		    // fetching existing product 
	Product product =repository.findById(id);
	
	  if(product == null) {
		  throw new RuntimeException("Product is not found with id "+id);
		  
	  }
		
	  // Map DTO to Entity
	  ProductMapper.updateEntity(product, dto);
	  
	  // update in db 
	  repository.update(product);
		
	  // return Response DTO
	  
		return ProductMapper.toResponse(product);
	}

	public void updateStock(int stock , int id) {
		    if( stock < 0) {
		    	throw new RuntimeException(" Stock Quantity should not less than 0 ");
		    }
		    
		    // fetch product from database by id 
		    
		    Product product= repository.findById(id);
		    
		    // set stock in  db
		   product.setStockQuantity(stock);
		   
		   // auto availability 
		   if( stock == 0) {
			   product.setAvailablitityStatus("OUT OF STOCK");
		   }
		   else {
			   product.setAvailablitityStatus("IN STOCK");
		   }
		   
		   //save the  update 
		    repository.update(product);
		    
		    
		}



}

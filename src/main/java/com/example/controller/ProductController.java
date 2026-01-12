package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.ProductDTORequest;
import com.example.dto.response.ProductDTOResponse;

import com.example.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	   @Autowired
	   private ProductService service;
   
	   //1] create
	   // http://localhost:8080/api/create
	
	   
	   @PostMapping("create")
	   public String createProduct(@RequestBody ProductDTORequest dto){
		          service.createProduct(dto);
		          return "data saved";	  
		          }
	   
	   //2] get 
	   //  // http://localhost:8080/api/products
	    
	   @GetMapping("/products")
	   public List<ProductDTOResponse> getAllProdeucts() {
		   List<ProductDTOResponse> dto=   service.getAllProducts();
		   return dto;
	   }
	   
	   // 3] get a single product
	     // // http://localhost:8080/api/productswithid?id=
	   @GetMapping("/productswithid")
	   public ProductDTOResponse getSingleProduct(@RequestParam(name="id") int id) {
		   ProductDTOResponse product = service.getSingleProduct(id);
		   return product;
		   
		 
	   }
	   
	   // 4] product search api 
	   // http://localhost:8080/api/getproductapi?name=phone&category=electronics&minPrice=10000&maxPrice=50000 
	
	   
	   @GetMapping("getproductapi")
	   public List<ProductDTOResponse> getProductAPI(@RequestParam(name="name") String name,@RequestParam(name="category") String category, @RequestParam(name="minPrice") double minPrice,@RequestParam(name="maxPrice") double maxPrice){
		   {  
			   List<ProductDTOResponse> products = service.getProductAPI(name,category,minPrice,maxPrice);
			   return products;
		   }
	   }
	   

	   // 5] delete a product 
	   // http://localhost:8080/api/deleteproduct?id=
	   //
	    @DeleteMapping("/deleteproduct")
	    public String deleteProduct(@RequestParam(name = "id") int id) {
	        service.deleteProduct(id);
	        return "Product soft deleted";
	    }
	   
	    
	    //6] put /api/products/{productId}/restore 
	    
	    // http://localhost:8080/api/updateproduct?id=
	    
	    @PutMapping("/updateproduct")
	    public  ProductDTOResponse updateProduct(@RequestParam(name="id") int id , @RequestBody ProductDTORequest dto ) {
	    	  ProductDTOResponse pdr   =  service.updateProduct(id,dto);
	    	  return pdr;
	    }

	   // 7]   ⃣Product Stock Update API 
	    
	   //  http://localhost:8080/api/products?stock=?&id=?
	   
	   @PutMapping("/products")
	   public void updateStock(@RequestParam(name="stock") int stock , @RequestParam(name="id") int id) {
		   service.updateStock(stock,id);
		   
	   }

}

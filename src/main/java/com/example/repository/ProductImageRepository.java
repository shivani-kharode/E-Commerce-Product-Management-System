package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.entity.Product;
import com.example.entity.ProductImage;
@Repository
public class ProductImageRepository {
     
	   @Autowired
	   private SessionFactory factory;
	   
	public void createImage(int productId, ProductImage pi) {
		
		    Session session = factory.openSession();
		    Transaction tx = session.beginTransaction();
		    
		    // 1️⃣ Fetch Product
	        Product product = session.get(Product.class, productId);
	        if (product == null) {
	            throw new RuntimeException("Product not found with id: " + productId);
	        }

	        // 2️⃣ Set product to image
	             pi.setPro(product);

	        // 3️⃣ Save image
	        session.save(pi);
		           tx.commit();
		           session.close();
	
	}

	public List<ProductImage> getImageBId(int productId) {
		Session session = factory.openSession();
		String hql = "From ProductImage p Where p.product.productId = :id";
		
		 Query<ProductImage> query  = session.createQuery(hql, ProductImage.class);
		 query.setParameter("id",productId);
		 List<ProductImage> list = query.list();
		 return list;
		
	}

	public void deleteImage(int imageId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		 ProductImage image   =  session.get(ProductImage.class, imageId);
		 if( image != null) {
			 session.delete(image);
		 }
	
		tx.commit();
		session.close();
	}

}

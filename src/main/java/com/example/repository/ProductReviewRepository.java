package com.example.repository;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;
import com.example.entity.ProductReview;

@Repository
public class ProductReviewRepository {
     @Autowired 
     private SessionFactory  factory;

	 public void createReview(ProductReview review , int productId ) {
		      Session session = factory.openSession();
		      Transaction tx = session.beginTransaction();
		      
		      Product product = session.get(Product.class, productId);
		         if( product == null) {
		        	 throw new RuntimeException("Product  is not  found");
		         }
		         
		         review.setProduct(product);
		      
		                session.save(review);
		                tx.commit();
		                session.close();
		
	 }

	 public List<ProductReview>  getReviewProductId(int productId) {
		 Session session = factory.openSession();
		  String hql = "From ProductReview p Where p.product.productId = :id";
		   Query<ProductReview> query =  session.createQuery(hql,ProductReview.class);
		            query.setParameter("id", productId);
		     List<ProductReview>  list =  query.list();
		
		     return list;
	 }

	 public void changeRatingById(int reviewId, int rating) {
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		   ProductReview  review =  session.get(ProductReview.class, reviewId);
		           review.setRating(rating);
		           session.update(review);
		              tx.commit();
		           session.close();
		
	 }

	 public void deleteReview(int reviewId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		 ProductReview pr=session.get(ProductReview.class, reviewId);
		     if( pr != null ) {
		    	 session.delete(pr);
		     }
		          tx.commit();
		     session.close();
	 }
     
     
}

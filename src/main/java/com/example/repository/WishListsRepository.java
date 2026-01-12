package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.entity.WishLists;
@Repository 
public class WishListsRepository {
     @Autowired 
     private SessionFactory  factory;
     
	public void createWishList(WishLists wishlist) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	           session.save(wishlist);
	           tx.commit();
	           session.close();
	}

	public boolean existsByCustomerNameAndProductId(int productId, String cName) {
		
		Session session = factory.openSession();
		String hql = "Select count(w) From WishLists w where w.customerName = :cName and w.product.productId = :id";
		Query<Long> query = session.createQuery(hql,Long.class);
		query.setParameter("cName", cName);
		query.setParameter("id", productId);
		 Long count  = query.uniqueResult();
		
		return  count!= null && count> 0;
	}

	public List<WishLists> getAllWishList(String customerName) {
		Session session = factory.openSession();
		String hql = "From WishLists w Where lower(trim(w.customerName)) = :cName ";
		 Query<WishLists> query=  session.createQuery(hql,WishLists.class);
		 query.setParameter("cName",customerName.toLowerCase());
		  List<WishLists>  wish =  query.list();
		  return wish;
		 
		
		
	}

	public void deleteWishList(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		WishLists wl  = session.get(WishLists.class, id);
		           if(wl != null) {
		        	   session.delete(wl);
		           }
		           
		           tx.commit();
		           session.close();
		
	}

}

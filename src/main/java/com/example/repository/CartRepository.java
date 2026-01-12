package com.example.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.entity.Carts;
@Repository
public class CartRepository {
      @Autowired
      private SessionFactory factory;
	public void createCart(Carts carts) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		            session.save(carts);
		            tx.commit();
		            session.close();
		
	}
	public List<Carts> getAllCart() {
		Session session = factory.openSession();
		 Criteria criteria = session.createCriteria(Carts.class);
		    List<Carts> list    =criteria.list();
		return list;
	}
	
	public Carts findById(int cartId) {
		Session session = factory.openSession();
		Carts cart = session.get(Carts.class, cartId);
		return cart;
	}

}

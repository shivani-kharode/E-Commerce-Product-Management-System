package com.example.repository;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import com.example.entity.Orders;
@Repository
public class OrderRepository {
    
	public void createOrder(Session session, Orders orders) {
		
		session.save(orders);
		
	}

	public Orders findById(Session session, int orderId) {
		
		return session.get(Orders.class,orderId);
	
	}

	public void updateOrderStatus(Session session, Orders orders) {
	       session.update(orders);
		
	}
	
	

	

	
}

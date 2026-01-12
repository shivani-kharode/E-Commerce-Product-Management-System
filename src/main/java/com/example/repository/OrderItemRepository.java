package com.example.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.entity.OrderItem;

@Repository
public class OrderItemRepository {

	public void createOrderItem( Session session, OrderItem oi) {
		 session.save(oi);
		
	}
}

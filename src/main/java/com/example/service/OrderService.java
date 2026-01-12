package com.example.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.request.OrdersDTORequest;
import com.example.dto.response.OrdersDTOResponse;
import com.example.entity.CartItems;
import com.example.entity.OrderItem;
import com.example.entity.Orders;
import com.example.entity.Product;
import com.example.mapper.OrdersMapper;
import com.example.repository.CartItemRepository;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;

@Service
public class OrderService {

    @Autowired
    private SessionFactory factory;

    @Autowired
    private OrderItemRepository oiRepo;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CartItemRepository cartitemRepo;

    public void createOrder(OrdersDTORequest order) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {

            // 1️⃣ fetch cart items
            List<CartItems> cartItems =
                    cartitemRepo.findByCustomerName(session, order.getCustomerName());

            if (cartItems.isEmpty()) {
                throw new RuntimeException("Cart is empty");
            }

            double totalAmount = 0;
        
            // 2️⃣ validate stock + calculate total
            for (CartItems cartItem : cartItems) {
                Product product = cartItem.getPro();

                if (product.getStockQuantity() < cartItem.getQuantity()) {
                    throw new RuntimeException(
                            "Insufficient stock for " + product.getName());
                }
            
                totalAmount += product.getPrice() * cartItem.getQuantity();
              
                product.setStockQuantity(
                        product.getStockQuantity() - cartItem.getQuantity());

                productRepo.updateStock(session, product);
            }

            // 3️⃣ create order
            Orders orders = OrdersMapper.toEntity(order, totalAmount);
            repository.createOrder(session, orders);

            // 4️⃣ create order items
            for (CartItems cartItem : cartItems) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrders(orders);
                orderItem.setProduct(cartItem.getPro());
                orderItem.setPrice(cartItem.getPro().getPrice());
                orderItem.setQuantity(cartItem.getQuantity());

                oiRepo.createOrderItem(session, orderItem);
            }

            // 5️⃣ clear cart
            cartitemRepo.deleteAllByCustomerName(session, order.getCustomerName());

            tx.commit(); // ✅ commit ONLY on success
        } catch (Exception e) {
            tx.rollback(); // ✅ rollback on error
            throw e;
        } finally {
            session.close();
        }
    }

	public OrdersDTOResponse updateOrderStatus(OrdersDTORequest order, int orderId) {
		
		Session session = null;
		Transaction tx= null;
		
		try {
			
			session = factory.openSession();
		  tx = session.beginTransaction();
		  
		   Orders orders  =  repository.findById(session, orderId);
		   
		   if( orders == null) {
			   throw new RuntimeException("Order not found !!");
		   }
		   
		   String orderStatus = orders.getOrderStatus();
		   String newStatus = order.getOrderStatus().toUpperCase();
		   
		   // delivered status cannot be updated
		   if("DELIEVERED".equals(orderStatus)) {
			   throw new RuntimeException("Delievered order cannot  be updated !");
		   }
		   
		   // Invalid transaction 
		   if( !isValidTransaction(orderStatus,newStatus)) {
			   throw new RuntimeException("Invalid status transaction "+orderStatus +"to"+newStatus);
		   }
		   
		   orders.setOrderStatus(newStatus);
		   repository.updateOrderStatus(session,orders);
		   
		   tx.commit();
		   return OrdersMapper.toResponse(orders);
		   
		   
		}
		catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
	}
	public static boolean isValidTransaction(String orderStatus, String newStatus) {
		if("PENDING".equals(orderStatus) && "SHIPPED".equals(newStatus)) return true;
		if("SHIPPED".equals(orderStatus) && "DELIEVERED".equals(newStatus)) return true;
		return false;
	}
}

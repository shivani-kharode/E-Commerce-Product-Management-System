package com.example.repository;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.entity.CartItems;
@Repository
public class CartItemRepository {
      @Autowired
      private SessionFactory  factory;
	public void createCartItems(CartItems cartitem) {
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		 session.save(cartitem);
		 tx.commit();
		 session.close();
		
	}
	public List<Object[]> getCartItemByCN(String customerName) {
		Session session = factory.openSession();
		
		String hql  ="SELECT ci.carts.cartId, ci.product.productId, ci.quantity, ci.price, ci.carts.customerName FROM CartItems ci WHERE ci.carts.customerName = :name";
		 Query<Object[]>   query  = session.createQuery(hql,Object[].class);
		   query.setParameter("name", customerName);
		 List<Object[]> list = query.list();
		 return list;
		
	}
	public  CartItems findById(int cartItemId) {
		Session session = factory.openSession();
		CartItems cartitem = session.get(CartItems.class, cartItemId);
		return cartitem;
		
	}
	public void saveCartItems(CartItems cartitem) {
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		 session.update(cartitem);
		 tx.commit();
		 session.close();
		
	}
	public void deleteCartItem(int cartItemId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		CartItems cartitem =session.get(CartItems.class, cartItemId);
		if( cartitem != null) {
			session.delete(cartitem);
		}
		tx.commit();
		session.close();
		
	}
	public List<CartItems> getAll() {
		
		Session session = factory.openSession();
		Criteria criteria=  session.createCriteria(CartItems.class);
		return criteria.list();
		
		
	}
//	

	public List<CartItems> findByCustomerName(Session session ,String customerName) {
	    
	    List<CartItems> cartItemsList = null; // ✅ local variable to store results

	    try {
	        
	        session = factory.openSession();

	       
	        String hql = "FROM CartItems ci WHERE TRIM(LOWER(ci.carts.customerName)) = :name";

	      
	        cartItemsList = session.createQuery(hql, CartItems.class)
	                .setParameter("name", customerName.trim().toLowerCase())
	                .getResultList();

	    } catch (Exception e) {
	        e.printStackTrace();
	     
	        throw e;
	    } finally {
	      
	        if (session != null) {
	            session.close();
	        }
	    }

	    // 5️⃣ Return the results
	    return cartItemsList;
	}

	

	public void deleteAllByCustomerName(Session session,String customerName) {
	   
	    Transaction tx = null;

	    try {
	        session = factory.openSession();
	        tx = session.beginTransaction();

	        // Step 1: fetch cart items of that customer
	        List<CartItems> cartItems = session.createQuery(
	                "FROM CartItems ci WHERE LOWER(ci.carts.customerName) = :name", CartItems.class)
	                .setParameter("name", customerName.trim().toLowerCase())
	                .getResultList();

	        // Step 2: delete one by one
	        for (CartItems ci : cartItems) {
	            session.delete(ci);
	        }

	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        throw e;
	    } finally {
	        if (session != null) session.close();
	    }
	}


	

}

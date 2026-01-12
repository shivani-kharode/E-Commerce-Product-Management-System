package com.example.repository;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.entity.Product;
@Repository
public class ProductRepository {
        @Autowired
        private SessionFactory factory;
	public void createProduct(Product product) {
		
		Session session = factory.openSession();	
		Transaction tx = session.beginTransaction();
		session.save(product);
		tx.commit();
		session.close();
		
	}
	public List<Product> getAllProduct() {
		 Session session = factory.openSession();
		 Criteria criteria= session.createCriteria(Product.class);
		 List<Product> list  =criteria.list();
		 return list;
	}
	public Product getSingleProduct(int id) {
		Session session = factory.openSession();
		 Product product = session.get(Product.class, id);
		 return product;
	}
	
	 public Product findById(int id) {
	        Session session = factory.openSession();
	        Product product = session.get(Product.class, id);
	        session.close();
	        return product;
	    }
	
	 public void update(Product product) {
		    Session session = factory.openSession();
		    Transaction tx = session.beginTransaction();
		    session.update(product); // 
		    tx.commit();
		    session.close();
		}
	 
	 public List<Product> getProductAPI(String name, String category, double minPrice, double maxPrice) {
	
		    Session session = factory.openSession();

		    String hql = "FROM Product p " +
		                 "WHERE lower(trim(p.name)) LIKE :name " +
		                 "AND lower(trim(p.category)) LIKE :category " +
		                 "AND p.price BETWEEN :min AND :max";

		    Query<Product> query = session.createQuery(hql, Product.class);
		    query.setParameter("name", "%" +name.toLowerCase().trim()+"%");
		    query.setParameter("category", "%" +category.toLowerCase().trim() + "%");
		    query.setParameter("min", minPrice);
		    query.setParameter("max", maxPrice);

		    List<Product> products = query.list();
		    session.close();

		 
		    return products;
	 }
	 public void updateStock(Session session, Product product) {
		session.update(product);
		
	 }

	 
	 
	 
	 


}

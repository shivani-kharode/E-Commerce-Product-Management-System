package com.example.repository;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.entity.User;



@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {

        Session session = sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();

        try {
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public User findByEmail(String email) {

        Session session = sessionFactory.openSession();

        try {
            String hql = "FROM User u WHERE u.email=:email";

            return session.createQuery(hql, User.class)
                    .setParameter("email", email)
                    .uniqueResult();

        } finally {
            session.close();
        }
    }

    public User findById(Long id) {

        Session session = sessionFactory.openSession();

        try {
            return session.get(User.class, id);
        } finally {
            session.close();
        }
    }
    
    public void update(User user){

        Session session =
                sessionFactory.openSession();

        org.hibernate.Transaction tx =
                session.beginTransaction();

        try{

            session.update(user);

            tx.commit();

        }catch(Exception e){

            tx.rollback();

            throw e;

        }finally{

            session.close();
        }
    }
}

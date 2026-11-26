package com.example.repository;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RoleName;
import com.example.entity.Roles;


@Repository
public class RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Roles findByRoleName(RoleName roleName) {

        Session session = sessionFactory.openSession();

        try {
            String hql =
                    "FROM Roles r WHERE r.name=:role";

            return session.createQuery(hql, Roles.class)
                    .setParameter("role", roleName)
                    .uniqueResult();

        } finally {
            session.close();
        }
    }
}

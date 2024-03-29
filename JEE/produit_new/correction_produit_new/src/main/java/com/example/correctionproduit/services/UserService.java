package com.example.correctionproduit.services;


import com.example.correctionproduit.entities.User;
import com.example.correctionproduit.interfaces.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class UserService extends BaseService implements Repository<User> {

    public UserService() {
        super();
    }

    @Override
    public boolean create(User element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();

        }
        return false;
    }

    @Override
    public boolean update(User o) {
        return false;
    }

    @Override
    public boolean delete(User o) {
        return false;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }



    public User getById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            User user = session.get(User.class, id);
            return user;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }



    public boolean getByEmailPassword(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password", User.class);
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            User user1 = query.uniqueResult();
            transaction.commit();;
            if(user1 != null) {
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return false;
    }

}

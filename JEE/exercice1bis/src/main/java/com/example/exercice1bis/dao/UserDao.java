package com.example.exercice1bis.dao;

import com.example.exercice1bis.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

public class UserDao implements interfaces.Repository<User> {

    private SessionFactory sessionFactory;

    public UserDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
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
    public boolean update(Long id, User element) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
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

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<User> getByDate(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<User> getByStock(int stock) {
        return null;
    }

    @Override
    public Double getAveragePrice() {
        return null;
    }

    @Override
    public void close() {

    }


    public User getByEmailPassword(User user) {
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

}

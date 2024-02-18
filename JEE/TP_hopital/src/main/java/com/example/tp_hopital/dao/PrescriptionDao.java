package com.example.tp_hopital.dao;

import com.example.tp_hopital.entities.Prescription;
import com.example.tp_hopital.interfaces.Interface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class PrescriptionDao implements Interface<Prescription> {

    private SessionFactory sessionFactory;

    public PrescriptionDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    @Override
    public boolean create(Prescription element) {
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
    public boolean update(Prescription element) {
        return false;
    }

    @Override
    public boolean delete(Prescription element) {
        return false;
    }

    @Override
    public Prescription findById(Long id) {
        return null;
    }

    @Override
    public List<Prescription> findAll() {
        return null;
    }
}

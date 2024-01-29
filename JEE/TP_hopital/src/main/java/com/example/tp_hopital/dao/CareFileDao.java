package com.example.tp_hopital.dao;

import com.example.tp_hopital.entities.CareFile;
import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class CareFileDao implements Repository<CareFile> {

    private SessionFactory sessionFactory;

    public CareFileDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    @Override
    public boolean create(CareFile element) {
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
    public boolean update(CareFile element) {
        return false;
    }

    @Override
    public boolean delete(CareFile element) {
        return false;
    }

    @Override
    public CareFile findById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            CareFile careFile = (CareFile) session.get(CareFile.class, id);
            return careFile;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<CareFile> findAll() {
        return null;
    }
}

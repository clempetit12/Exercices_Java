package com.example.tp_hopital.dao;

import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PatientDao implements Repository<Patient> {

    private SessionFactory sessionFactory;

    public PatientDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    @Override
    public boolean create(Patient element) {
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
    public boolean update(Patient element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Patient patient = findById(element.getIdPatient());
            if (patient != null) {
                patient.setFirstName(element.getFirstName());
                patient.setLastName(element.getLastName());
                patient.setDateOfBirth(element.getDateOfBirth());
                patient.setImage(element.getImage());;
                session.update(patient);
                session.getTransaction().commit();
            }
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
    public boolean delete(Patient element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Patient patient = findById(element.getIdPatient());
            if (patient != null) {
                session.delete(patient);
            }
            session.getTransaction().commit();
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
    public Patient findById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Patient patient = (Patient) session.get(Patient.class, id);
            return patient;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }


    @Override
    public List<Patient> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Patient> patientList = new ArrayList<>();
            Query<Patient> patientQuery = session.createQuery(" SELECT DISTINCT p FROM Patient p ");
            patientList = patientQuery.list();
            return patientList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    public List<Patient> findByName(String name) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List<Patient> patientList = new ArrayList<>();
            Query<Patient> patientQuery = session.createQuery(" SELECT  p FROM Patient p where lastName like :name%");
            patientList = patientQuery.list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;

    }
}

package com.example.tp_hopital.dao;

import com.example.tp_hopital.entities.Consultation;
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

public class ConsultationDao implements Repository<Consultation> {

    private SessionFactory sessionFactory;

    public ConsultationDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    @Override
    public boolean create(Consultation element) {
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
    public boolean update(Consultation element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Consultation consultation = findById(element.getIdConsultation());
            if (consultation != null) {
                consultation.setDoctorName(element.getDoctorName());
                session.update(consultation);
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
    public boolean delete(Consultation element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Consultation consultation = findById(element.getIdConsultation());
            if (consultation != null) {
                session.delete(consultation);
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
    public Consultation findById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Consultation consultation = (Consultation) session.get(Consultation.class, id);
            return consultation;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Consultation> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Consultation> consultations = new ArrayList<>();
            Query<Consultation> consultationQuery = session.createQuery(" SELECT DISTINCT c FROM Consultation c ");
            consultations = consultationQuery.list();
            return consultations;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    public List<Consultation> findConsultationByIdPatient(Long idPatient) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Consultation> consultationList;
            Query<Consultation> consultationQuery = session.createQuery(" SELECT c FROM Consultation c where c.patient.id =: idPatient ");
            consultationList = consultationQuery.getResultList();
            return consultationList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }
}

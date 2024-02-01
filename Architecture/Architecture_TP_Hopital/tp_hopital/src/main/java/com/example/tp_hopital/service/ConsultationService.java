package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.CareFile;
import com.example.tp_hopital.entity.Consultation;
import com.example.tp_hopital.entity.Prescription;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class ConsultationService {

    Repository<Consultation> consultationRepository;
    SessionFactory sessionFactory;

    public ConsultationService(SessionFactory sessionFactory, Repository<Consultation> consultationRepository) {
        this.consultationRepository = consultationRepository;
        this.sessionFactory = sessionFactory;
    }

    public boolean createConsultation(Consultation consultation) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        consultationRepository.setSession(session);
        try {
            consultationRepository.create(consultation);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        } finally {
            session.close();
        }
        return result;
    }
    public Consultation getConsultationById(Long id) throws RepositoryException {
        Session session = sessionFactory.openSession();
        consultationRepository.setSession(session);
        session.beginTransaction();
        try {
            Consultation consultation = consultationRepository.findById(id);
            session.getTransaction().commit();
            return consultation;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
    }


    public boolean updateConsultation(Consultation consultation) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        consultationRepository.setSession(session);
        session.beginTransaction();
        try {
            consultationRepository.update(consultation);
            session.getTransaction().commit();
            result = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }

        return result;
    }

}

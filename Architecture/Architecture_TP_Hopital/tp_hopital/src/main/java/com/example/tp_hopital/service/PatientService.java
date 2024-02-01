package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.Consultation;
import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PatientService {
    Repository<Patient> patientRepository;

    SessionFactory sessionFactory;
    public PatientService(SessionFactory sessionFactory, Repository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
        this.sessionFactory = sessionFactory;
    }

    public boolean createPatient(Patient patient) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        session.beginTransaction();
        try {
            patientRepository.create(patient);
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

    public List<Patient> getAllPatient() throws RepositoryException {
        Session session = sessionFactory.openSession();
        List<Patient> patientList = null;
        patientRepository.setSession(session);
        session.beginTransaction();
        try {
            patientList =patientRepository.findAll();
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        return patientList;
    }

    public boolean deletePatient(Patient patient) throws RepositoryException {
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        session.beginTransaction();
        try {
            patientRepository.delete(patient);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        
    }

    public Patient getOnePatient(Long id) throws RepositoryException {
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        session.beginTransaction();
        try {
            Patient patient = patientRepository.findById(id);
            patientRepository.delete(patient);
            session.getTransaction().commit();
            return patient;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
 
    }


}

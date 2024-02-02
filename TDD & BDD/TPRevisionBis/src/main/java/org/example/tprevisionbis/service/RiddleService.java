package org.example.tprevisionbis.service;

import org.example.tprevisionbis.entities.Riddle;
import org.example.tprevisionbis.exception.RepositoryException;
import org.example.tprevisionbis.repository.Repository;
import org.example.tprevisionbis.repository.RiddleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class RiddleService {

    Repository<Riddle> riddleRepository;

    SessionFactory sessionFactory;

    public RiddleService(Repository<Riddle> riddleRepository, SessionFactory sessionFactory) {
        this.riddleRepository = riddleRepository;
        this.sessionFactory = sessionFactory;
    }

    public boolean create(Riddle riddle) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        riddleRepository.setSession(session);
        session.beginTransaction();
        try {
            riddleRepository.create(riddle);
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


    public Riddle findRiddle(Long id) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        riddleRepository.setSession(session);
        session.beginTransaction();
        try {
            Riddle riddle = riddleRepository.findById(id);
            session.getTransaction().commit();
            return riddle;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        } finally {
            session.close();
        }

    }

    public boolean checkUserAnswer(String answer, Long id) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        riddleRepository.setSession(session);
        session.beginTransaction();
        try {
            Riddle riddle = riddleRepository.findById(id);
            if (riddle.getExpectedAnswer().equals(answer.toLowerCase())) {
                riddle.setUserAnswer(answer);
                session.getTransaction().commit();
                return true;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        } finally {
            session.close();
        }
        return false;
    }

    public List<Riddle> getAllRiddle() {
        List<Riddle> riddleList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        riddleRepository.setSession(session);
        session.beginTransaction();
        try {
        riddleList = riddleRepository.findAll();
        return riddleList;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        } finally {
            session.close();
        }
    }


}

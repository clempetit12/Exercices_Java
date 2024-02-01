package com.example.tp_hopital.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    protected Session session;

    public Session getSession() {
        return session;
    }

    public Repository() {

    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void create(T elment) {
        this.session.persist(elment);
    }

    public void delete(T element) {
        session.remove(element);
    }

    public void update(T element) {
        session.persist(element);
    }

    public abstract T findById(Long id);

    public abstract List<T> findAll();


}

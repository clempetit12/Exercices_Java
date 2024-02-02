package org.example.tprevisionbis.repository;

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

    public abstract T findById(Long id);

    public abstract List<T> findAll();



}

package org.example.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class BaseEntityRepository<T> {

    protected Session session;

    public Session getSession() {
        return session;
    }

    public BaseEntityRepository() {

    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void create(T element) {
        this.session.persist(element);
    }

    public void delete(T element) {
        this.session.remove(element);
    }

    public void update(T element) {
        this.session.persist(element);
    }

    abstract T findById(Long id);

    abstract List<T> fildAll();


}

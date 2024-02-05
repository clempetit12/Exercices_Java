package com.example.exercice_todo.repository;

import com.example.exercice_todo.entity.Task;
import org.hibernate.Session;

import java.util.List;

public abstract class Repository {

    protected Session session;

    public Repository() {

    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Task create(Task task) {
        this.session.persist(task);
        return task;
    }

    public void delete(Task element) {
        session.remove(element);
    }

    public void update(Task element) {
        session.persist(element);
    }

    public abstract Task findById(Long id);

    public abstract List<Task> findAll();
}

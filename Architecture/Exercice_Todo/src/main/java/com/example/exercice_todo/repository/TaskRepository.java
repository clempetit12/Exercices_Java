package com.example.exercice_todo.repository;

import com.example.exercice_todo.entity.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@ApplicationScoped
public class TaskRepository extends Repository {

    public TaskRepository() {

    }

    @Override
    public Task findById(Long id) {
        return session.get(Task.class,id);
    }

    @Override
    public List<Task> findAll() {
        return session.createQuery("from Task ").list();
    }

}

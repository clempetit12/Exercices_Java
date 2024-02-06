package com.example.exercicetodobis.repository;

import com.example.exercicetodobis.entity.Task;
import jakarta.enterprise.context.ApplicationScoped;

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
        return session.createQuery("from Task ", Task.class).list();
    }

}
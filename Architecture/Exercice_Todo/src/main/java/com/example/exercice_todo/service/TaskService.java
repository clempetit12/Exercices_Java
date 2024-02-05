package com.example.exercice_todo.service;

import com.example.exercice_todo.Exception.RepositoryException;
import com.example.exercice_todo.dto.TaskDto;
import com.example.exercice_todo.entity.Task;
import com.example.exercice_todo.repository.TaskRepository;
import com.example.exercice_todo.utils.HibernateSession;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@ApplicationScoped
public class TaskService {


    private final TaskRepository taskRepository;

    @Inject
    public TaskService(SessionFactory sessionFactory, TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }



    public boolean create(TaskDto taskDto) {
        Task task = taskDto.toEntity();
        boolean result = false;
        Session session = HibernateSession.getSessionFactory().openSession();
        taskRepository.setSession(session);
        session.beginTransaction();
        try {
          taskRepository.create(task);
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


    public boolean delete(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        taskRepository.setSession(session);
        session.beginTransaction();
        try {
            Task task = getById(id);
            taskRepository.delete(task);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
    }


    public Task update(Long id, boolean status) {
        return Task.builder().status(status).build();
    }


    public List<Task> getAll() {
        Session session = HibernateSession.getSessionFactory().openSession();
        List<Task> taskList = null;
        taskRepository.setSession(session);
        session.beginTransaction();
        try {
            taskList =taskRepository.findAll();
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        return taskList;
    }


    public Task getById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        taskRepository.setSession(session);
        session.beginTransaction();
        try {
            Task task = taskRepository.findById(id);
            session.getTransaction().commit();
            return task;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }


    }
}

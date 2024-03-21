package org.example.todospring.service;

import org.example.todospring.model.Task;
import org.example.todospring.model.User;
import org.example.todospring.repository.TaskRepository;
import org.example.todospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TaskServiceImpl implements Service<Task> {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public Task save(Task element) {
        return taskRepository.save(element);
    }

    @Override
    public boolean delete(Task element) {
     taskRepository.delete(element);
     return true;
    }

    @Override
    public Task update(Task element) {
        return taskRepository.save(element);
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksPerUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            List<Task> tasks = taskRepository.findByUserId(id);
            return tasks;
        }
        return null;
    }
}

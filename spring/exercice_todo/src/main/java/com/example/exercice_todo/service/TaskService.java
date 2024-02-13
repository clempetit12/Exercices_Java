package com.example.exercice_todo.service;

import com.example.exercice_todo.entity.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    private ArrayList<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
        Task task1 = Task.builder().id(1).title("course").description("faire les courses de la semaine").done(false).build();
        Task task2 = Task.builder().id(2).title("courir").description("courir le marathon").done(true).build();
        Task task3 = Task.builder().id(3).title("voyager").description("voyager en laponie").done(false).build();
        this.tasks.add(task1);
        this.tasks.add(task2);
        this.tasks.add(task3);
    }

    public  ArrayList<Task> getTasks() {
        return tasks;
    }
}

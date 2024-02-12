package com.example.exercice_todo.controller;

import com.example.exercice_todo.entity.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/base")
public class TaskRestController {

    @GetMapping(value = "task")
    public Task getTask(Task task) {
        Task task4 = Task.builder().id(1).title("course").description("faire les courses de la semaine").done(false).build();
        return task4;
    }

    @GetMapping(value = "tasks")
    public List<Task> getTasks() {
        Task task1 = Task.builder().id(1).title("course").description("faire les courses de la semaine").done(false).build();
        Task task2 = Task.builder().id(2).title("courir").description("courir le marathon").done(false).build();
        Task task3 = Task.builder().id(3).title("voyager").description("voyager en laponie").done(false).build();
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        return taskList;
    }

}

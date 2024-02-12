package com.example.exercice_todo.controller;

import com.example.exercice_todo.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {


    @GetMapping(value = "task")
    public String getOneTask( Model model) {
        Task task = Task.builder().id(1).title("course").description("faire les courses de la semaine").done(false).build();
        model.addAttribute("title", task.getTitle());
        model.addAttribute("description", task.getDescription());
        model.addAttribute("done", task.getDescription());
        return "task";
    }

    @RequestMapping(value = "tasks")
    public String getTasks(Model model) {
        Task task1 = Task.builder().id(1).title("course").description("faire les courses de la semaine").done(false).build();
        Task task2 = Task.builder().id(2).title("courir").description("courir le marathon").done(false).build();
        Task task3 = Task.builder().id(3).title("voyager").description("voyager en laponie").done(false).build();
        List<Task> taskList = List.of(task1,task2,task3);
        model.addAttribute("tasks", taskList);
        return "task-list";


    }

    @GetMapping(value = "home" )
    public String goHome() {
        return "home";
    }
}

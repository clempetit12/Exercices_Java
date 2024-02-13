package com.example.exercice_todo.controller;

import com.example.exercice_todo.entity.Task;
import com.example.exercice_todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/" )
    public String goHome() {
        return "home";
    }
    @GetMapping(value = "task")
    public String getOneTask( Model model) {
        Task task = Task.builder().id(1).title("course").description("faire les courses de la semaine").done(false).build();
        model.addAttribute("title", task.getTitle());
        model.addAttribute("description", task.getDescription());
        model.addAttribute("done", task.isDone() ? "fait" : "à faire" );
        return "task";
    }

    @RequestMapping(value = "tasks")
    public String getTasks(Model model) {
        List<Task> taskList = taskService.getTasks();
        model.addAttribute("tasks", taskList);
        return "task-list";


    }


}

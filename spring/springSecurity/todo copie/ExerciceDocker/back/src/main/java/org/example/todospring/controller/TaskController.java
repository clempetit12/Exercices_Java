package org.example.todospring.controller;

import org.example.todospring.model.Task;
import org.example.todospring.repository.TaskRepository;
import org.example.todospring.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Task taskToDelete = taskService.getById(id);
        if (taskToDelete != null) {
            taskService.delete(taskToDelete);
            return ResponseEntity.ok().build();
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public Task updateProduct(@PathVariable("id") Long id, @RequestBody Task task) {
        Task taskToUpdate = taskService.getById(id);
        taskToUpdate.setName(task.getName());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setPriority(task.getPriority());
        taskToUpdate.setStatus(task.isStatus());
        taskService.update(taskToUpdate);
        return taskToUpdate;
    }

    @GetMapping("/tasks/{userId}")
    public List<Task> getTasksPerUser(@PathVariable("userId") Long id) {
        return taskService.getTasksPerUser(id);
    }


}

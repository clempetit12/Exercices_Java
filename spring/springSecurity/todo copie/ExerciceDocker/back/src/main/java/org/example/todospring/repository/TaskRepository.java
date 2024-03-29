package org.example.todospring.repository;

import org.example.todospring.model.Task;
import org.example.todospring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {

    Optional<Task> findById(Long id);

    List<Task> findByUserId(Long userId);
}

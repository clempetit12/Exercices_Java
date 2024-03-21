package org.example.todospring.repository;

import org.example.todospring.model.Task;
import org.example.todospring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}

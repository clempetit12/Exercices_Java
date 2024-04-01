package org.example.tp_blog.repository;

import org.example.tp_blog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findById(int id);

    Users findByEmail(String email);

    String findByRole();
}

package org.example.tp_blog.repository;

import org.example.tp_blog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findById(int id);
}

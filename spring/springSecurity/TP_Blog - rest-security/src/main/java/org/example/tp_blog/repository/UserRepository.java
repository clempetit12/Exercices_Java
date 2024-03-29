package org.example.tp_blog.repository;

import org.example.tp_blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(int id);
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);


}

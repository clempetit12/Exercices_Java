package org.example.tp_blog.repository;

import org.example.tp_blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, Integer> {

Post findPostById(int id);
}

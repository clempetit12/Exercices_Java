package org.example.tp_blog.repository;

import org.example.tp_blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
   Comment findCommentByIdIs(Integer id);
}

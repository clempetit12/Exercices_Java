
package org.example.tp_blog.service;

import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.repository.CommentRepository;
import org.example.tp_blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ServiceInterface<CommentDto> {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;


    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;

    }

    @Override
    public List<CommentDto> getAll() {
        return commentRepository.findAll().stream().map(comment -> comment.toCommentDto()).collect(Collectors.toList());
    }

    @Override
    public CommentDto getById(Long id) {
        return commentRepository.findCommentByIdIs(id).toCommentDto();
    }

    @Override
    public CommentDto add(CommentDto element) {
        return  commentRepository.save(element.toComment()).toCommentDto();
    }

    @Override
    public boolean delete(Long id) {
        CommentDto commentDto = getById(id);
        commentRepository.delete(commentDto.toComment());
        return true;
    }

    @Override
    public CommentDto update(CommentDto element) {
        return  commentRepository.save(element.toComment()).toCommentDto();
    }
    public boolean addCommentToPost(PostDto postDto, CommentDto commentDto) {
        Comment commentToAdd = commentDto.toComment();
        commentToAdd.setLastName(commentDto.getLastName());
        commentToAdd.setEmail(commentDto.getEmail());
        commentToAdd.setContent(commentDto.getContent());
        commentToAdd.setPost(postDto.toPost());
        commentRepository.save(commentToAdd);
        return true;
    }
}

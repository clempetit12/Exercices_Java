package org.example.tp_blog.service;

import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.mapper.CommentMapper;
import org.example.tp_blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ServiceInterface<CommentDto> {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDto> getAll() {
        return commentRepository.findAll().stream().map(commentMapper::commentToCommentDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getById(int id) {
        return commentMapper.commentToCommentDto(commentRepository.findCommentByIdComment(id));
    }

    @Override
    public CommentDto add(CommentDto element) {
        return  commentMapper.commentToCommentDto(commentRepository.save(commentMapper.commentDtoToComment(element)));
    }

    @Override
    public boolean delete(int id) {
        CommentDto commentDto = getById(id);
        commentRepository.delete(commentMapper.commentDtoToComment(commentDto));
        return true;
    }

    @Override
    public CommentDto update(CommentDto element) {
        return  commentMapper.commentToCommentDto(commentRepository.save(commentMapper.commentDtoToComment(element)));
    }
    public boolean addCommentToPost(PostDto postDto, CommentDto comment) {
        List<CommentDto> comments = postDto.getCommentList().stream().map(commentMapper::commentToCommentDto).collect(Collectors.toList());
        comments.add(comment);
        return true;
    }
}

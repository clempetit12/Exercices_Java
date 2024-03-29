
package org.example.tp_blog.service;

import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.mapper.CommentMapper;
import org.example.tp_blog.repository.CommentRepository;
import org.example.tp_blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ServiceInterface<CommentDto> {

    private final CommentRepository commentRepository;
private final CommentMapper commentMapper;
    private final PostRepository postRepository;


    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postRepository = postRepository;

    }

    @Override
    public List<CommentDto> getAll() {
        return commentRepository.findAll().stream().map(commentMapper::commentToCommentDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getById(int id) {
        return commentMapper.commentToCommentDto(commentRepository.findCommentByIdIs(id));
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
    public boolean addCommentToPost(Post post, CommentDto commentDto)  {
        Comment commentToAdd = commentMapper.commentDtoToComment(commentDto);
        commentToAdd.setLastName(commentDto.getLastName());
        commentToAdd.setEmail(commentDto.getEmail());
        commentToAdd.setContent(commentDto.getContent());
        commentToAdd.setPost(post);
        commentRepository.save(commentToAdd);
        return true;
    }
}

package org.example.tp_blog.service;

import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.mapper.PostMapper;
import org.example.tp_blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements ServiceInterface<PostDto> {

private final PostRepository postRepository;

private final PostMapper postMapper;

@Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }


    @Override
    public List<PostDto> getAll() {
        return postRepository.findAll().stream().map(postMapper::postToPostDto).collect(Collectors.toList());
    }

    @Override
    public PostDto getById(int id) {
        return postMapper.postToPostDto(postRepository.findPostById(id));
    }

    @Override
    public PostDto add(PostDto element) {
        return postMapper.postToPostDto(postRepository.save(postMapper.postDtoToPost(element)));
    }

    @Override
    public boolean delete(int id) {
        PostDto postDto = getById(id);
         postRepository.delete(postMapper.postDtoToPost(postDto));
         return true;
    }

    @Override
    public PostDto update(PostDto element) {
        return postMapper.postToPostDto(postRepository.save(postMapper.postDtoToPost(element)));
    }
}

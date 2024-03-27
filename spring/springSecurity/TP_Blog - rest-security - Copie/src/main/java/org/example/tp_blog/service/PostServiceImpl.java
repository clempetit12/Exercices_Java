package org.example.tp_blog.service;

import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements ServiceInterface<PostDto> {

private final PostRepository postRepository;



@Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public void savePostWithImage(PostDto postDto, MultipartFile imageFile) {
        String imagePath = imageFile.getOriginalFilename().toString();
         postDto.setImageUrl(imagePath);
add(postDto);
    }

    @Override
    public List<PostDto> getAll() {
        return postRepository.findAll().stream().map(post -> post.toPostDto()).toList();
    }

    @Override
    public PostDto getById(Long id) {
        return postRepository.findPostById(id).toPostDto();
    }

    @Override
    public PostDto add(PostDto element) {
        return postRepository.save(element.toPost()).toPostDto();
    }


    @Override
    public boolean delete(Long id) {
        PostDto postDto = getById(id);
         postRepository.delete(postDto.toPost());
         return true;
    }

    @Override
    public PostDto update(PostDto element) {
        return postRepository.save(element.toPost()).toPostDto();
    }

/*    public List<PostDto> getPostByName(String search) {
        List<Post> posts = postRepository.findAllByTitleContaining(search.toLowerCase());
        return posts.stream()
                .map(postMapper::postToPostDto)
                .collect(Collectors.toList());
    }*/

    public void updatePost(Post post) {
    }

    public void addPost(Post post) {
    postRepository.save(post);
    }

    public List<Post> getAllPosts() {
   return postRepository.findAll();
    }
}

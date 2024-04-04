package org.example.tp_blog.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements ServiceInterface<PostDto> {

private final PostRepository postRepository;

    private String location = "upload-dir";



@Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public void savePostWithImage(PostDto postDto, MultipartFile imageFile) {
        String imagePath = imageFile.getOriginalFilename().toString();
         postDto.setImageUrl(imagePath);
         postDto.setDate(LocalDate.now());
add(postDto);
    }

    @Override
    public List<PostDto> getAll() {
        return postRepository.findAll().stream().map(post -> post.toPostDto()).toList();
    }

    @Override
    public PostDto getById(int id) {
        return postRepository.findPostById(id).toPostDto();
    }

    @Override
    public PostDto add(PostDto element) {
        return postRepository.save(element.toPost()).toPostDto();
    }


    @Override
    public boolean delete(int id) {
    Post post = postRepository.findPostById(id);
         postRepository.delete(post);
         return true;
    }

    @Override
    public PostDto update(PostDto element) {
        return postRepository.save(element.toPost()).toPostDto();
    }


    public void updatePost(Post post) {
    }

    public void addPost(Post post) {
    postRepository.save(post);
    }

    public List<Post> getAllPosts() {
   return postRepository.findAll();
    }

    public void updatePostWithImage(PostDto postDto, String url)  {
            Post existingPost = postRepository.findById(postDto.getId()).orElse(null);

            if (existingPost != null) {
                existingPost.setTitle(postDto.getTitle());
                existingPost.setDescription(postDto.getDescription());
                existingPost.setContent(postDto.getContent());
existingPost.setImage(url);

                postRepository.save(existingPost);
            } else {
                throw new EntityNotFoundException("La publication avec l'identifiant " + postDto.getId() + " n'existe pas");
            }
        }

    public List<PostDto> getPostByName(String name) {
    return postRepository.findAllByTitleContainingIgnoreCase(name).stream().map(post -> post.toPostDto()).toList();
    }
}

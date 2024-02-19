package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.service.CommentServiceImpl;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
public class PostRestController {


    private final PostServiceImpl postService;
    private final CommentServiceImpl commentService;

    @GetMapping("/posts") // http://localhost:8080/api/blog/posts
    public List<PostDto> getAllPost(){
        return postService.getAll();
    }

    @GetMapping("/post/{id}") // http://localhost:8080/api/blog/post/x
    public PostDto getPostById(@PathVariable("id") int id){
        return postService.getById(id);
    }

    @PostMapping("/addPost") // http://localhost:8080/api/blog/addPost
    public boolean createPost(@RequestBody PostDto post){
        PostDto postDto =  postService.add(post);
        if(postDto != null) {
            return true;
        }
        return false;
    }

    @PostMapping("/addPost/verif") // http://localhost:8080/api/blog/addPost
    public ResponseEntity<String> createPostValid(@Valid @RequestBody PostDto postDto, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postService.add(postDto);
        return new ResponseEntity<>("Post crée avec l'id : "+postDto.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public void deletePost(@PathVariable int id){
        postService.delete(id);
    }

    @PutMapping("/update")
    public void updatePost(@RequestBody PostDto postDto){
        postService.update(postDto);
    }

    @PutMapping("/update/post/verif/{id}") // http://localhost:8080/api/v1/blog/update/post/x
    public ResponseEntity<String> updatePostValid(@PathVariable int id,@Valid @RequestBody PostDto updatePost,BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postService.update(updatePost);
        return new  ResponseEntity<>("modif post ok", HttpStatus.ACCEPTED);
    }

}

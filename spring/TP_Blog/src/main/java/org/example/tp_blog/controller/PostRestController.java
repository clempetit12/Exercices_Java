package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/blog")
@AllArgsConstructor

public class PostRestController {


    private final PostServiceImpl postService;


    @GetMapping("/posts") // http://localhost:8080/api/blog/posts
    public List<Post> getAllPost(){
        return postService.getAll();
    }

    @GetMapping("/post/{id}") // http://localhost:8080/api/blog/post/x
    public Post getPostById(@PathVariable("id") UUID id){
        return postService.getById(id);
    }

    @PostMapping("/addPost") // http://localhost:8080/api/blog/addPost
    public boolean createPost(@RequestBody Post post){
        return postService.add(post);
    }

    @PostMapping("/addPost") // http://localhost:8080/api/blog/addPost
    public ResponseEntity<String> createPostValid(@Valid @RequestBody Post post, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postService.add(post);
        return new ResponseEntity<>("Post crée avec l'id : "+post.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/addComment/{postId}") // http://localhost:8080/api/blog/addComment/x
    public boolean addComment(@RequestBody Comment comment,@PathVariable("postId") UUID id){
        Post post = postService.getById(id);
        return postService.addCommentToPost(post,comment);
    }
    @PostMapping("/addComment/{postId}") // http://localhost:8080/api/blog/addComment/x
    public ResponseEntity<String> createCommentValid(@Valid @RequestBody Comment comment, BindingResult result,@PathVariable("postId") UUID id){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        Post post = postService.getById(id);
        postService.addCommentToPost(post,comment);
        return new ResponseEntity<>("Commentaire crée avec l'id : "+comment.getId(), HttpStatus.CREATED);
    }
    @DeleteMapping("/post/{id}") // http://localhost:8080/api/blog/post/x
    public void deletePost(@PathVariable UUID id){
        Post post = postService.getById(id);
        postService.deletePost(post);
    }

    @PutMapping("/update/post/{id}") // http://localhost:8080/api/v1/blog/update/post/x
    public Post updatePost(@PathVariable UUID id,@RequestBody Post updatePost){
        return postService.update(id,updatePost);
    }

    @PutMapping("/update/post/{id}") // http://localhost:8080/api/v1/blog/update/post/x
    public ResponseEntity<String> updatePostValid(@PathVariable UUID id,@Valid @RequestBody Post updatePost,BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postService.update(id,updatePost);
        return new  ResponseEntity<>("modif post ok", HttpStatus.ACCEPTED);
    }

}

package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.exception.ConstraintViolationException;
import org.example.tp_blog.exception.FormException;
import org.example.tp_blog.service.CommentServiceImpl;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class PostRestController {


    private final PostServiceImpl postService;
    private final CommentServiceImpl commentService;

    @Autowired
    public PostRestController(PostServiceImpl postService, CommentServiceImpl commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPost(){
        return postService.getAll();
    }

    @GetMapping("/post/{id}")
    public PostDto getPostById(@PathVariable("id") int id){
        return postService.getById(id);
    }

    @PostMapping("/addPost")
    public boolean createPost(@RequestBody PostDto post){
        PostDto postDto =  postService.add(post);
        if(postDto != null) {
            return true;
        }
        return false;
    }

    @PostMapping("/addPost/verif")
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

    @PutMapping("/update/post/verif/{id}")
    public ResponseEntity<String> updatePostValid(@PathVariable int id,@Valid @RequestBody PostDto updatePost,BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        postService.update(updatePost);
        return new  ResponseEntity<>("modif post ok", HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleConstraintViolationException(ConstraintViolationException ex){
        return "Problème formulaire";
    }

    @ExceptionHandler(FormException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleFormException(FormException ex){
        return "Problème ";
    }

}

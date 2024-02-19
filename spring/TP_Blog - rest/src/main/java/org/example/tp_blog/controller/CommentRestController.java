package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.service.CommentServiceImpl;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentRestController {

    private final PostServiceImpl postService;
    private final CommentServiceImpl commentService;
    public CommentRestController(PostServiceImpl postService, CommentServiceImpl commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/comments") 
    public List<CommentDto> getAllComments(){
        return commentService.getAll();
    }

    @PostMapping("/addComment/{postId}")
    public boolean addComment(@RequestBody CommentDto comment, @PathVariable("postId") int id){
        PostDto postDto = postService.getById(id);
        return commentService.addCommentToPost(postDto,comment);
    }
    @PostMapping("/addComment/verif/{postId}") // http://localhost:8080/api/blog/addComment/x
    public ResponseEntity<String> createCommentValid(@Valid @RequestBody CommentDto comment, BindingResult result,@PathVariable("postId") int id){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        PostDto postDto = postService.getById(id);
        commentService.addCommentToPost(postDto,comment);
        return new ResponseEntity<>("Commentaire crée avec l'id : "+comment.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteComment(@PathVariable int id){
        return commentService.delete(id);

    }

    @PutMapping("/update")
    public void updateComment(@RequestBody CommentDto commentDto){
        commentService.update(commentDto);
    }

    @PutMapping("/update/comment/verif/{id}")
    public ResponseEntity<String> updatePostValid(@PathVariable int id,@Valid @RequestBody CommentDto commentDto,BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        commentService.update(commentDto);
        return new  ResponseEntity<>("modif post ok", HttpStatus.ACCEPTED);
    }
}

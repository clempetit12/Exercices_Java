package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;

import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {

    private final PostServiceImpl postService;
/*    private final CommentServiceImpl commentService;*/
    @Autowired
    public CommentRestController(PostServiceImpl postService ){
        this.postService = postService;

    }

 /*   @GetMapping("/comments")
    public List<CommentDto> getAllComments(){
        return commentService.getAll();
    }*/

/*    @PostMapping("/addComment/{postId}")
    public ResponseEntity<String> addComment(@RequestBody CommentDto commentDto, @PathVariable("postId") int id){
        PostDto postDto = postService.getById(id);
        System.out.println(commentDto);
        boolean isCommentAdded = commentService.addCommentToPost(postDto, commentDto);
        if(isCommentAdded) {
            return ResponseEntity.ok("Comment added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add comment");
        }
    }*/
/*    @PostMapping("/addComment/verif/{postId}") // http://localhost:8080/api/blog/addComment/x
    public ResponseEntity<String> createCommentValid(@Valid @RequestBody CommentDto comment, BindingResult result,@PathVariable("postId") int id){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString() + " , "));

            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        PostDto postDto = postService.getById(id);
        commentService.addCommentToPost(postDto,comment);
        return new ResponseEntity<>("Commentaire crée avec l'id : "+comment.getId(), HttpStatus.CREATED);
    }*/

/*    @DeleteMapping("/remove/{id}")
    public boolean deleteComment(@PathVariable int id){
        return commentService.delete(id);

    }*/

/*    @PutMapping("/update")
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
    }*/
}

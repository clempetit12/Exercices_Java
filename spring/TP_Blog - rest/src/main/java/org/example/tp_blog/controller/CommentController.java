package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.repository.PostRepository;
import org.example.tp_blog.service.CommentServiceImpl;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class CommentController {

    private final PostServiceImpl postService;

    @Autowired
    private PostRepository postRepository;
    private final CommentServiceImpl commentService;

    @Autowired
    public CommentController(PostServiceImpl postService, CommentServiceImpl commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }


    @GetMapping("/addComment/{postId}")
    public String showCommentForm(@PathVariable("postId") int postId, Model model) {
        model.addAttribute("comment", new CommentDto());
        model.addAttribute("postId", postId);
        return "commentForm";
    }

   @PostMapping(value = "/addComment/{postId}")
   public String addComment(@Valid @ModelAttribute("comment") CommentDto commentDto, BindingResult bindingResult,
                            @PathVariable("postId") int id
   ) {
        if (bindingResult.hasErrors()) {
            return "commentForm";
        } else {
            Post post = postRepository.findPostById(id);
            if (post != null) {
                System.out.println(commentDto.getLastName());
                commentService.addCommentToPost(post, commentDto);
                return "redirect:/";
            }
            return "commentForm";
        }
    }
}

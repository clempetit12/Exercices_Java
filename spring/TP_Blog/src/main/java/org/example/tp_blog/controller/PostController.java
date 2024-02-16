package org.example.tp_blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PostController {

private final PostServiceImpl postService;


    @GetMapping
    public String home(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }

    @GetMapping(value = "/detail/{postId}")
    public String showDetail(@PathVariable("postId") UUID id, Model model) {
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        return "detail";

    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("post", new Post());
        return "postForm";
    }

    @PostMapping(value = "/add")
    public  String addPost(@Valid @ModelAttribute("post") Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "postForm";
        } else {
            if (post.getId() != null) {
                postService.update(post.getId(), post);
            } else {
                postService.add(post);
            }
            return "redirect:/";
        }
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("postId") UUID id) {
        System.out.println("delete");
        Post post = postService.getById(id);
        System.out.println(post);
        if (post != null) {
            postService.deletePost(post);
            return "redirect:/home";
        }
        return "error";
    }

    @GetMapping("/update/{postId}")
    public String formUpdatePost(@PathVariable("postId") UUID id,Model model){
        Post post = postService.getById(id);
        model.addAttribute("post",post);
        return "postForm";
    }

    @PostMapping(value = "/addComment/{postId}")
    public  String addComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult bindingResult,@PathVariable("postId") UUID id) {
        if (bindingResult.hasErrors()) {
            return "commentForm";
        } else {
            Post post = postService.getById(id);
            if (post != null) {
                postService.addCommentToPost(post, comment);
                return "redirect:/";
            }
return "commentForm";
        }
    }

    @GetMapping("/addComment/{postId}")
    public String formComment(Model model,@PathVariable("postId") UUID id) {
        model.addAttribute("comment", new Comment());
        return "commentForm";
    }


}

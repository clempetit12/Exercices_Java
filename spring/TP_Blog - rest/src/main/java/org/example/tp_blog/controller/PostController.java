package org.example.tp_blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller

public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }


    @GetMapping
    public String home(Model model) {
        List<PostDto> postDtos = postService.getAll();
        model.addAttribute("posts", postDtos);
        return "home";
    }

    @GetMapping(value = "/detail/{postId}")
    public String showDetail(@PathVariable("postId") int id, Model model) {
        PostDto postDto = postService.getById(id);
        model.addAttribute("post", postDto);
        return "detail";

    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("post", new PostDto());
        return "postForm";
    }

    @PostMapping(value = "/add")
    public String addPost(@Valid @ModelAttribute("post") PostDto postDto, BindingResult bindingResult) {
        System.out.println(bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            return "postForm";
        } else {
            if (postDto.getId() != 0) {
                postService.update(postDto);
            } else {
                postService.add(postDto);
            }
            return "redirect:/";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("postId") int id) {
        postService.delete(id);
        return "redirect:";
    }

    @GetMapping("/update/{postId}")
    public String formUpdatePost(@PathVariable("postId") int id, Model model) {
        PostDto postDto = postService.getById(id);
        model.addAttribute("post", postDto);
        return "postForm";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleConstraintViolationException(ConstraintViolationException ex,Model model){
        model.addAttribute("errorMessage",ex.getMessage());
        return "formerror";
    }

    @ExceptionHandler(FormException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleFormException(FormException ex,Model model){
        model.addAttribute("errorMessage",ex.getMessage());
        return "formerror";
    }

    @GetMapping(value = "/search")
    public String searchBlog(@RequestParam(name = "name", required = false) String name,
                                      Model model) {
        List<PostDto> postDtos = postService.getPostByName(name);
        if (!postDtos.isEmpty()) {
            model.addAttribute("posts", postDtos);
            return "home";
        } else {
            return "error";
        }

    }

}

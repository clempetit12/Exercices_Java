package org.example.tp_blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.service.CommentServiceImpl;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("post", new Post());
        return "postForm";
    }

    @PostMapping(value = "/add")
    public String addPost(@Valid @ModelAttribute("post") PostDto postDto, BindingResult bindingResult) {
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



    @GetMapping("/addComment/{postId}")
    public String formComment(Model model, @PathVariable("postId") int id) {
        model.addAttribute("comment", new Comment());
        return "commentForm";
    }


}

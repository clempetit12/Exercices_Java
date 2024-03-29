package org.example.tp_blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.exception.ConstraintViolationException;
import org.example.tp_blog.exception.FormException;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin(origins = "http://example.com", maxAge = 3600)
public class PostController {

    private final PostServiceImpl postService;
    private String location = "upload-dir";

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }


    @GetMapping
    public String home(Model model) {
        List<PostDto> posts = postService.getAll();
        model.addAttribute("posts", posts);
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
    @GetMapping("/files")
    @ResponseBody
    public List<String> getFiles() throws IOException {
        List<String> liste = new ArrayList<>();
        Files.walk(Paths.get(location)).forEach(path -> {
            liste.add(path.getFileName().toString());
        });
        return liste;
    }





    @PostMapping(value = "/add", headers = "accept=Application/json")
    public String addPost(@ModelAttribute("post") @Valid PostDto postDto, BindingResult result, @RequestParam("image") MultipartFile image) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }
        if (postDto.getId() == 0) {
            postDto.setImage(image);
            String imageName = image.getOriginalFilename();
            Path destinationFile = Paths.get(location).resolve(Paths.get(imageName)).toAbsolutePath();
            InputStream stream = image.getInputStream();
            Files.copy(stream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            postService.savePostWithImage(postDto,image);

            return "redirect:/";
        } else {
            String url = postDto.getImageUrl();
            postService.updatePostWithImage(postDto,url);
            return "redirect:/";
        }

    }

  /*      if (!image.isEmpty()) {
            String imageName = image.getOriginalFilename();
            Path destinationFile = Paths.get(location).resolve(Paths.get(imageName)).toAbsolutePath();
            InputStream stream = image.getInputStream();
            Files.copy(stream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            postDto.setImage(imageName);
            postService.add(postDto);
        }

        if (postDto.getId() != 0) {
            postService.update(postDto);
        } else {

        }*/


    @GetMapping("/delete")
    public String delete(@RequestParam("postId") int id){
       postService.delete(id);
        return "redirect:/";
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

   @GetMapping(value = "/search/name")
    public String searchBlog(@RequestParam(name = "name", required = false) String name,
                                      Model model) {
       model.addAttribute( "posts",postService.getPostByName(name));
      return "home";

    }



}

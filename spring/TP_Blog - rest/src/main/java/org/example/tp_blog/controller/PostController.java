package org.example.tp_blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.dto.UsersDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.entity.Users;
import org.example.tp_blog.exception.ConstraintViolationException;
import org.example.tp_blog.exception.FormException;
import org.example.tp_blog.service.PostServiceImpl;
import org.example.tp_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Controller
@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RequestMapping("/")
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    private final UserService userService;
    private String location = "upload-dir";

    @Autowired
    public PostController(PostServiceImpl postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
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



    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UsersDto userDto = new UsersDto();
        model.addAttribute("user",userDto);
        return "register";

    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") UsersDto userDto, BindingResult result,Model model){
        Users existingUser = userService.loadUserByUsername(userDto.getEmail());
        System.out.println(existingUser);
        if(existingUser!=null && existingUser.getEmail()!=null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email",null,"there is already an account existed with this email");
        }

        if(result.hasErrors()){
            model.addAttribute("user",userDto);
            return "/register";
        }

        userService.save(userDto);
        return "redirect:/register?success";

    }


    @GetMapping("/users")
    public String users(Model model){
        List<UsersDto> users = userService.findAllUsers();
        model.addAttribute("users",users);
        return "users";
    }


    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {
        Users existingUser = userService.loadUserByUsername(email);

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(password, existingUser.getPassword())) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(existingUser, null, existingUser.getAuthorities());
                System.out.println(authentication);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return "redirect:/";
            } else {
                redirectAttributes.addAttribute("error", "Invalid email or password");
                return "redirect:/login";
            }
        } else {
            redirectAttributes.addAttribute("error", "User not found");
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
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

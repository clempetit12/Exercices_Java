package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import org.example.tp_blog.dto.BaseResponseDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.dto.UserLoginDto;
import org.example.tp_blog.entity.User;
import org.example.tp_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Controller
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping("/v1/auth/register")
    public String registerUser(@RequestBody User user, Model model){
        if(userService.save(user)){
            model.addAttribute("message", "success");
        } else {
            model.addAttribute("message", "failed");
        }
        return "posts";
    }

    @PostMapping("/v1/auth/login")
    public String loginUser(@RequestBody User user, Model model) {
        boolean userExists = userService.checkUserNameExists(user.getUsername());
        if(userExists) {
            if (userService.verifyUser(user.getUsername(), user.getPassword())) {
                model.addAttribute("message", "success");
            } else {
                model.addAttribute("message", "wrong password");
            }
        } else {
            model.addAttribute("message", "user doesn't exist");
        }
        return "loginResult";
    }
}

package org.example.tp_blog.controller;

import org.example.tp_blog.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {


    @GetMapping("/")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Welcome, User";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome, Admin";
    }

}


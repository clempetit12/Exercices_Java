package org.example.tp_blog.controller;

import org.example.tp_blog.dto.BaseResponseDto;
import org.example.tp_blog.dto.UserLoginDto;
import org.example.tp_blog.entity.User;
import org.example.tp_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("v1/auth")
public class UserController {

    @GetMapping("/403")
    public String notAuthorized(){
        return "403";
    }

    @GetMapping("/auth")
    public String login(){
        return "login";
    }

}

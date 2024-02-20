package org.example.tp_blog.controller;

import org.example.tp_blog.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuthentificationController {

    @GetMapping(value = "/auth")
    public String showFormAuthentification() {
        return "authentification";
    }
}

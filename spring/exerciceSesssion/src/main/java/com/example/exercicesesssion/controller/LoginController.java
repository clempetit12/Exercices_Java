package com.example.exercicesesssion.controller;

import com.example.exercicesesssion.service.AccessService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exercice")
@AllArgsConstructor
public class LoginController {
    private AccessService accessService;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String login, @RequestParam String password) {
        if ((accessService.getSession(login, password))) {
            return "protected";
        }
        return "login";
    }

    @GetMapping("/protected")
    public String protectedPage() {
        if (accessService.isLogged()) {
            return "protected";
        }
        return "redirect:/exercice/login";
    }
}

package org.example.tp_blog.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.tp_blog.dto.BaseResponseDto;
import org.example.tp_blog.dto.UsersDto;
import org.example.tp_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UsersDto userDto = new UsersDto();
        model.addAttribute("user",userDto);
        return "register";

    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") UsersDto userDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("user",userDto);
            return "/register";
        }

        userService.createUser(userDto);

        return "redirect:/register?success";

    }





    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes, HttpServletResponse response, Model model) {
        if(userService.checkUserNameExists(email)) {
            if(userService.verifyUser(email,password)) {
                Map<String, Object> data = new HashMap<>();
                String token = userService.generateToken(email,password);
                redirectAttributes.addFlashAttribute("token", token);
                HttpSession session = request.getSession();
                session.setAttribute("token", token);
                return "redirect:/";
            }else {
                redirectAttributes.addAttribute("error", "Invalid email or password");
                return "redirect:/login";
            }
        } else {
            redirectAttributes.addAttribute("error", "User not found");
            return "redirect:/login";


        }
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }



}

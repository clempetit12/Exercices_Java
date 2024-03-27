package org.example.tp_blog.controller;

import org.example.tp_blog.dto.BaseResponseDto;
import org.example.tp_blog.dto.UserLoginDto;
import org.example.tp_blog.entity.User;
import org.example.tp_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

//
//    @Autowired
//    UserService userService;
//
//
//    @PostMapping("/register")
//    public BaseResponseDto registerUser(@RequestBody User newUser) {
//
//        if (userService.createUser(newUser)) {
//            return new BaseResponseDto("success");
//        } else {
//            return new BaseResponseDto("failed");
//        }
//    }
//
//    @PostMapping("/login")
//    public BaseResponseDto loginUser(@RequestBody UserLoginDto loginDetails) {
//        if (userService.checkUserNameExists(loginDetails.getEmail())) {
//
//            if (userService.verifyUser(loginDetails.getEmail(), loginDetails.getPassword())) {
//
//                Map<String, Object> data = new HashMap<>();
//                data.put("token", userService.generateToken(loginDetails.getEmail(), loginDetails.getPassword()));
//
//                return new BaseResponseDto("success", data);
//            } else {
//
//                return new BaseResponseDto("wrong password");
//            }
//        } else {
//
//            return new BaseResponseDto("user not exist");
//        }
//    }
}

package org.example.todospring.controller;

import org.example.todospring.dto.BaseResponseDto;
import org.example.todospring.dto.UserLoginDto;
import org.example.todospring.model.User;
import org.example.todospring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public BaseResponseDto registerUser(@RequestBody User newUser){
        if(userService.createUser(newUser)){
            return new BaseResponseDto("success");
        }else {
            return new BaseResponseDto("failed");
        }
    }

    @PostMapping("/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto loginDetails){
        if(userService.checkUserNameExists(loginDetails.getEmail())){
            if(userService.verifyUser(loginDetails.getEmail(), loginDetails.getPassword())){
                Map<String, Object> data = new HashMap<>();

                data.put("token", userService.generateToken(loginDetails.getEmail(), loginDetails.getPassword()));
                return new BaseResponseDto("success", data);
            }else {

                return new BaseResponseDto("wrong password");
            }
        }else {

            return new BaseResponseDto("user not exist");
        }
    }
}

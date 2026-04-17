package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // Register API
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody User user){
        try {
            Optional<User> result = service.login(user.getUsername(), user.getPassword());

            if(result.isPresent()){
                return JwtUtil.generateToken(user.getUsername());
            } else {
                return "Invalid Credentials";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
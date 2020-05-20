package com.berry.controller;

import com.berry.model.User;
import com.berry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> users() {
        return userService.findAll();
    }

    @CrossOrigin
    @PostMapping("/auth/login")
    public void login() {
        System.out.println("login");
    }
}

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}

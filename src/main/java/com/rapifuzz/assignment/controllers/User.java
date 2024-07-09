package com.rapifuzz.assignment.controllers;

import com.rapifuzz.assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/user")
public class User {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        this.userService.register(user);
        return user;
    }

}

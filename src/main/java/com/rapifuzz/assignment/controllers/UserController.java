package com.rapifuzz.assignment.controllers;

import com.rapifuzz.assignment.dto.UserLoginRequestDto;
import com.rapifuzz.assignment.dto.UserRequestDto;
import com.rapifuzz.assignment.dto.UserResponseDto;
import com.rapifuzz.assignment.entity.User;
import com.rapifuzz.assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userRequestDto){
        User user = this.userService.register(userRequestDto);
        return new ResponseEntity<>(new UserResponseDto(), HttpStatus.OK);
    }
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        Optional<User> userOptional = this.userService.login(userLoginRequestDto.getEmailAddress(), userLoginRequestDto.getPassword());
        if (userOptional.isPresent()) {
            // User authenticated successfully
            return ResponseEntity.ok("Login successful");
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email address or password");
        }
    }

    @GetMapping("/register")
    public String registerGet(){

        return "Shashi";
    }

}

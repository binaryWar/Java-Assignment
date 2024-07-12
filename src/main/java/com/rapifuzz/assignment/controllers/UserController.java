package com.rapifuzz.assignment.controllers;

import com.rapifuzz.assignment.dto.*;
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
    ResponseEntity<AuthenicationResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        Optional<User> userOptional = this.userService.login(userLoginRequestDto.getEmailAddress(), userLoginRequestDto.getPassword());
        AuthenicationResponseDto authenicationResponseDto = new AuthenicationResponseDto();
        if (userOptional.isPresent()) {
            // User authenticated successfully
            User user = userOptional.get();
            authenicationResponseDto.setEmailAddress(user.getEmailAddress());
            authenicationResponseDto.setId(user.getId());
            authenicationResponseDto.setHttpStatusCode(HttpStatus.OK);
            return new ResponseEntity<>(authenicationResponseDto, HttpStatus.OK);
        } else {
            // Authentication failed
            authenicationResponseDto.setHttpStatusCode(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(authenicationResponseDto,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordUserDto forgotPasswordUserDto) {
        ResetPasswordResponseDto resetPasswordResponseDto = new ResetPasswordResponseDto();
        try{
            Optional<User> userOptional = this.userService.resetPassword(forgotPasswordUserDto.getEmailAddress(),forgotPasswordUserDto.getNewPassword());
            if(userOptional.isPresent()){
                resetPasswordResponseDto.setMessage("Password reset successful");
                return new ResponseEntity<>(resetPasswordResponseDto,HttpStatus.OK);
            }else{
                resetPasswordResponseDto.setMessage("User not found!!!");
                return new ResponseEntity<>(resetPasswordResponseDto,HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

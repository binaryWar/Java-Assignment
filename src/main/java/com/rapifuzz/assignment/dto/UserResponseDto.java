package com.rapifuzz.assignment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponseDto {
    private String message;
    public UserResponseDto(){
        this.message = "hello from the post api";
    }
}

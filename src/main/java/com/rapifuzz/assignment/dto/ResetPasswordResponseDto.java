package com.rapifuzz.assignment.dto;

import lombok.Getter;

@Getter
public class ResetPasswordResponseDto {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

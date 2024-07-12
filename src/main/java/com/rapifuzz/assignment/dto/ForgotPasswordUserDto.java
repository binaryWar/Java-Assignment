package com.rapifuzz.assignment.dto;

import lombok.Getter;

@Getter
public class ForgotPasswordUserDto {
    private String emailAddress;
    private String newPassword;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getNewPassword() {
        return newPassword;
    }


}

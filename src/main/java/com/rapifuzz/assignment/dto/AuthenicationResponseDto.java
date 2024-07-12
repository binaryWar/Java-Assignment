package com.rapifuzz.assignment.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class AuthenicationResponseDto {
    private String emailAddress;
    private Long id;
    private HttpStatusCode httpStatusCode;
}

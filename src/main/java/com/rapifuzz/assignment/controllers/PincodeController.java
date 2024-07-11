package com.rapifuzz.assignment.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class PincodeController {
    private final RestTemplate restTemplate;

    public PincodeController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/pincode/{pincode}")
    public Object getPincodeInfo(@PathVariable String pincode) {
        String url = "http://postalpincode.in/api/pincode/" + pincode;
        return restTemplate.getForObject(url, Object.class);
    }
}

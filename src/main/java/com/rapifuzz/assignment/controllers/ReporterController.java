package com.rapifuzz.assignment.controllers;

import com.rapifuzz.assignment.services.ReporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reporter")
public class ReporterController {
    @Autowired
    private ReporterService reporterService;

    @PostMapping("/create")
    void create(@RequestBody String body) {
        this.reporterService.createReporter(body);
    }

}

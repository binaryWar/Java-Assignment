package com.rapifuzz.assignment.controllers;

import com.rapifuzz.assignment.entity.Reporter;
import com.rapifuzz.assignment.services.ReporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reporter")
public class ReporterController {
    @Autowired
    private ReporterService reporterService;

    @PostMapping("/create")
    void create(@RequestBody String body) {
        this.reporterService.createReporter(body);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Reporter>> getReportersByNamePrefix(@RequestParam String prefix) {
        try{
            List<Reporter> reporters = reporterService.findReportersByNamePrefix(prefix);
            return new ResponseEntity<>(reporters, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

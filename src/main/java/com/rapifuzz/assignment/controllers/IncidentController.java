package com.rapifuzz.assignment.controllers;

import com.rapifuzz.assignment.dto.IncidentRequestDto;
import com.rapifuzz.assignment.entity.Incident;
import com.rapifuzz.assignment.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incident")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestHeader("userId") String userId,
            @RequestBody IncidentRequestDto incidentRequestDto) {
        try{
            Incident incident = this.incidentService.createIncident(incidentRequestDto.getReporterId(), incidentRequestDto.getPriority(), incidentRequestDto.getStatus(), incidentRequestDto.getDescription(), incidentRequestDto.getIncidentIdentity(), incidentRequestDto.getReporterName(), incidentRequestDto.getCreateNewReporter(),userId);
            return ResponseEntity.status(HttpStatus.OK).body(incident);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<Incident>> fetch(@RequestHeader("userId") String userId) {
        try{
            if(userId == null || userId.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            List<Incident> incidents = this.incidentService.fetchIncidentByCreatedBy(userId);
            return new ResponseEntity<>(incidents, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

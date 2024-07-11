package com.rapifuzz.assignment.controllers;

import com.rapifuzz.assignment.dto.IncidentRequestDto;
import com.rapifuzz.assignment.entity.Incident;
import com.rapifuzz.assignment.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/incident")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody IncidentRequestDto incidentRequestDto) {
        try{
            Incident incident = this.incidentService.createIncident(
                    incidentRequestDto.getReporterId(),
                    incidentRequestDto.getPriority(),
                    incidentRequestDto.getStatus(),
                    incidentRequestDto.getDescription(),
                    incidentRequestDto.getIncidentIdentity()
            );
            return ResponseEntity.status(HttpStatus.OK).body(incident);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

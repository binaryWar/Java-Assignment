package com.rapifuzz.assignment.services;

import com.rapifuzz.assignment.entity.Incident;
import com.rapifuzz.assignment.entity.IncidentIdentity;
import com.rapifuzz.assignment.entity.IncidentStatus;
import com.rapifuzz.assignment.entity.Priority;
import com.rapifuzz.assignment.repositories.IncidentRepository;
import com.rapifuzz.assignment.utility.RandoNumberGenerator;
import com.rapifuzz.assignment.utility.SimpleRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    private RandoNumberGenerator generator;
    public Incident createIncident(String reporterId,String priority,String status,String description,String incidentIdentity) {
        Incident incident = new Incident();
        // first check u have to create reporter or not
        // if yes then
        generator = new SimpleRandomNumberGenerator();
        incident.setPriority(Priority.valueOf(priority));
        incident.setStatus(IncidentStatus.valueOf(status));
        incident.setDescription(description);
        incident.setIncidentIdentity(IncidentIdentity.valueOf(incidentIdentity));
        incident.setIncidentNumber(generator.generateNumber());
        Incident newIncident = this.incidentRepository.save(incident);
        return newIncident;
    }
}

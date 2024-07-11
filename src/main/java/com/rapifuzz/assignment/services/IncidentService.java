package com.rapifuzz.assignment.services;

import com.rapifuzz.assignment.entity.*;
import com.rapifuzz.assignment.repositories.IncidentRepository;
import com.rapifuzz.assignment.repositories.ReporterRepository;
import com.rapifuzz.assignment.utility.RandoNumberGenerator;
import com.rapifuzz.assignment.utility.SimpleRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private ReporterRepository reporterRepository;

    private RandoNumberGenerator generator;
    public Incident createIncident(String reporterId,
                                   String priority,
                                   String status,
                                   String description,
                                   String incidentIdentity,
                                   String reporterName,
                                   Boolean createNewReporter,
                                   String userId
                    ) {
        Incident incident = new Incident();
        if(reporterId != null) {
            incident.setReportedId(reporterId);
        }else{
            Reporter reporter = this.createrReporter(reporterName);
            incident.setReportedId(String.valueOf(reporter.getId()));
        }
        generator = new SimpleRandomNumberGenerator();
        incident.setPriority(Priority.valueOf(priority));
        incident.setStatus(IncidentStatus.valueOf(status));
        incident.setDescription(description);
        incident.setIncidentIdentity(IncidentIdentity.valueOf(incidentIdentity));
        incident.setIncidentNumber(generator.generateNumber());
        incident.setCreatedBy(userId);
        Incident newIncident = this.incidentRepository.save(incident);
        return newIncident;
    }
    private Reporter createrReporter(String reporterName){
        Reporter reporter = new Reporter();
        reporter.setName(reporterName);
        return this.reporterRepository.save(reporter);
    }
    public List<Incident> fetchIncidentByCreatedBy(String userId) {
        return this.incidentRepository.findByCreatedBy(userId);
    }
}

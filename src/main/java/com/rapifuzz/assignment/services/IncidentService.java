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

    public Incident createIncident(Long reporterId,
                                   String priority,
                                   String status,
                                   String description,
                                   String incidentIdentity,
                                   String reporterName,
                                   Boolean createNewReporter,
                                   String mobileNo,
                                   String userId
                    ) {
        Incident incident = new Incident();
        if(reporterId != null) {
            incident.setReporter(this.reporterRepository.getReporterById(reporterId));
        }else{
            Reporter reporter = this.createrReporter(reporterName,mobileNo);
            incident.setReporter(reporter);
        }
        generator = new SimpleRandomNumberGenerator();
        incident.setPriority(Priority.valueOf(priority).name());
        incident.setStatus(IncidentStatus.valueOf(status).name());
        incident.setDescription(description);
        incident.setIncidentIdentity(IncidentIdentity.valueOf(incidentIdentity).name());
        incident.setIncidentNumber(generator.generateNumber());
        incident.setCreatedBy(Long.parseLong(userId));
        Incident newIncident = this.incidentRepository.save(incident);
        return newIncident;
    }
    private Reporter createrReporter(String reporterName,String mobileNo){
        Reporter reporter = new Reporter();
        reporter.setName(reporterName);
        reporter.setMobileNo(mobileNo);
        return this.reporterRepository.save(reporter);
    }
    public List<Incident> fetchIncidentByCreatedBy(String userId) {
        return this.incidentRepository.findByCreatedBy(Long.parseLong(userId));
    }

    public Incident updateIncident( String incidentNumber,
                                    Long reporterId,
                                   String priority,
                                   String status,
                                   String description,
                                   String incidentIdentity,
                                   String reporterName,
                                   String userId,
                                   String mobileNo
                                    ) {
        Incident incident = incidentRepository.findByIncidentNumberAndCreatedBy(incidentNumber,Long.parseLong(userId));
        if(reporterId != null) {
            incident.setReporter(this.reporterRepository.getReporterById(reporterId));
        }else{
            Reporter reporter = this.createrReporter(reporterName,mobileNo);
            incident.setReporter(reporter);
        }
        incident.setPriority(Priority.valueOf(priority).name());
        incident.setStatus(IncidentStatus.valueOf(status).name());
        incident.setDescription(description);
        incident.setIncidentIdentity(IncidentIdentity.valueOf(incidentIdentity).name());
        return incidentRepository.save(incident);
    }
}

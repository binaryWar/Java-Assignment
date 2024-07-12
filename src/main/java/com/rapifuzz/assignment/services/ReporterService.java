package com.rapifuzz.assignment.services;

import com.rapifuzz.assignment.entity.Reporter;
import com.rapifuzz.assignment.repositories.ReporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporterService {
    @Autowired
    private ReporterRepository reporterRepository;
    public Reporter createReporter(String name) {
        Reporter newReporter = new Reporter();
        newReporter.setName(name);
        Reporter reporter = this.reporterRepository.save(newReporter);
        newReporter.setId(reporter.getId());
        return newReporter;
    }

    public List<Reporter> findReportersByNamePrefix(String prefix) {
        return reporterRepository.findByNameStartingWith(prefix);
    }
}

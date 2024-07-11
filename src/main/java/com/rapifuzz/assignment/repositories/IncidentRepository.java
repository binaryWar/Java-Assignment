package com.rapifuzz.assignment.repositories;

import com.rapifuzz.assignment.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident,Long> {
    List<Incident> findByCreatedBy(String createdBy);
}

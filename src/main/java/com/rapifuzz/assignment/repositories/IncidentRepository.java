package com.rapifuzz.assignment.repositories;

import com.rapifuzz.assignment.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident,Long> {

}

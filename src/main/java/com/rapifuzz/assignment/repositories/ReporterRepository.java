package com.rapifuzz.assignment.repositories;

import com.rapifuzz.assignment.entity.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporterRepository extends JpaRepository<Reporter,String> {
    List<Reporter> findByNameStartingWith(String prefix);
}

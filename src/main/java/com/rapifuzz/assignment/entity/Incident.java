package com.rapifuzz.assignment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Entity(name="incidents")
@Getter
@Setter
public class Incident {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private IncidentIdentity incidentIdentity;

    @Column(nullable=false,length = 15)
    private String reportedId;

    @Column(nullable=false)
    private Priority priority;

    @Column(nullable=false)
    private IncidentStatus status;

    @Column(length = 50)
    private String description;

    @Column(nullable = false,length = 15,unique = true)
    private String incidentNumber;

    @Column(nullable=false,updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = true)
    private String createdBy;
}

package com.rapifuzz.assignment.entity;

import java.util.Date;

public class Incident {
    private IncidentIdentity incidentIdentity;
    private String reportedId;
    private Date createdAt;
    private String createdBy;
    private Priority priority;
    private IncidentStatus status;
}

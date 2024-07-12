package com.rapifuzz.assignment.dto;

import lombok.Getter;

@Getter
public class IncidentEditDto {
    private Long reporterId;
    private String priority;
    private String status;
    private String description;
    private String incidentIdentity;
    private String reporterName;
    private Boolean createNewReporter;
    private String incidentNumber;
    private String reporterMobileNo;
}

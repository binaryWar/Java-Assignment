package com.rapifuzz.assignment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentRequestDto {
    private Long reporterId;
    private String priority;
    private String status;
    private String description;
    private String incidentIdentity;
    private String reporterName;
    private Boolean createNewReporter;
    private String reporterMobileNo;
}

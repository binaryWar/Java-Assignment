package com.rapifuzz.assignment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentRequestDto {
    private String reporterId;
    private String priority;
    private String status;
    private String description;
    private String incidentIdentity;
}

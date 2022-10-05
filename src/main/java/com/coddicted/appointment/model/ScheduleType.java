package com.coddicted.appointment.model;

import lombok.Getter;

@Getter
public enum ScheduleType {
    WORK("Work Schedule"),
    ;

    private String description;
    ScheduleType(String description){
        this.description = description;
    }
}

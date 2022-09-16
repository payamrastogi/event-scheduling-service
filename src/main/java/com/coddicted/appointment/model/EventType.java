package com.coddicted.appointment.model;

import lombok.Getter;

@Getter
public enum EventType {
    ONE_ON_ONE_MEETING("Let an invitee pick a time to meet with you."),
    GROUP_MEETING("Let multiple invitees meet with you at one time."),
    COLLECTIVE_MEETING("Host an event with another person and let invitees pick a time when you’re all available."),
    ONE_OFF_MEETING("Invite someone to pick a time to meet with you."),
    ;
    private String description;
    EventType(String description){
        this.description = description;
    }
}

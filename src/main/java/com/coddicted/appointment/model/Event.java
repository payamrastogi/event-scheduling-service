package com.coddicted.appointment.model;

import lombok.Data;

import java.util.List;

@Data
public class Event {
    private String id;
    private String name;
    private EventType eventType;
    private String description;
    private String eventLink;
    private int duration;
    private Schedule schedule;
    private List<Question> questionList;
}

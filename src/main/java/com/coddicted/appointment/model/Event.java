package com.coddicted.appointment.model;

import com.coddicted.question.model.Question;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class Event {
    @Id
    private String id;
    private String name;
    private EventType eventType;
    private String description;
    private String eventLink;
    private int duration;
    @DBRef
    private Schedule schedule;
    @DBRef
    private List<Question> questionList;
}

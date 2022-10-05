package com.coddicted.question.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private String value;
    private boolean active;
    private boolean required;
    private Answer answer;
    @DBRef
    private Set<Tag> tagSet;
}

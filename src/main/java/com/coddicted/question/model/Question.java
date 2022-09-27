package com.coddicted.question.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private String value;
    private boolean isActive;
    private boolean isRequired;
    private Answer answer;
    private List<String> tagIdList;
}

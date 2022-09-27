package com.coddicted.question.model;

import lombok.Data;

@Data
public class Question {
    private String id;
    private String value;
    private boolean isActive;
    private boolean isRequired;
    private AnswerType answerType;
    private Answer answer;
}

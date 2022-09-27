package com.coddicted.question.service;

import com.coddicted.question.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions();
    Question createQuestion(Question question);
}

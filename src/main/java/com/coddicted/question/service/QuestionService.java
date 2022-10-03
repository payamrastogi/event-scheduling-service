package com.coddicted.question.service;

import com.coddicted.question.model.Question;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions(Pageable paging);
    Question getQuestion(String id);
    Question createQuestion(Question question);
    List<Question> getQuestionsByTagId(String tagId);
}

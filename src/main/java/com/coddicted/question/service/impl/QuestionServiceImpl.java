package com.coddicted.question.service.impl;

import com.coddicted.question.model.Question;
import com.coddicted.question.repository.QuestionRepository;
import com.coddicted.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
}

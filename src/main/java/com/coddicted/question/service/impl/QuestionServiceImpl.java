package com.coddicted.question.service.impl;

import com.coddicted.question.model.Question;
import com.coddicted.question.repository.QuestionRepository;
import com.coddicted.question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestions(Pageable paging) {
        return questionRepository.findAll(paging).toList();
    }

    @Override
    public Question getQuestion(String id){
        Optional<Question> result = questionRepository.findById(id);
        if(result.isPresent())
            return result.get();
        return null;
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestionsByTagId(String tagId) {
        return questionRepository.findQuestionsByTag(tagId);
    }


}
